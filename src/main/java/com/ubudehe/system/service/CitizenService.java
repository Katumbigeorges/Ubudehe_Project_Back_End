package com.ubudehe.system.service;

import com.ubudehe.system.exception.CitizenAlreadyExistsException;
import com.ubudehe.system.exception.CitizenNotFoundException;
import com.ubudehe.system.model.Citizen;
import com.ubudehe.system.repository.CitizenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CitizenService implements ICitizenService{

    private final CitizenRepository citizenRepository;

    @Override
    public List<Citizen> getCitizens() {
        return citizenRepository.findAll();
    }


    @Override
    public Citizen addCitizen(Citizen citizen) {

        if (citizenAlreadyExists(citizen.getEmail())){
            throw new CitizenAlreadyExistsException(citizen.getEmail()+"already exists!");
        }
        return citizenRepository.save(citizen);
    }


    @Override
    public Citizen updateCitizen(Citizen citizen, Long id) {
        return citizenRepository.findById(id).map(st -> {
            st.setFirstName(citizen.getFirstName());
            st.setLastName(citizen.getLastName());
            st.setEmail(citizen.getEmail());
            st.setPhoneNumber(citizen.getPhoneNumber());
            return citizenRepository.save(st);
        }).orElseThrow(()-> new CitizenNotFoundException("This Citizen Is not Found!!"));
    }

    @Override
    public Citizen getCitizenById(Long id) {
        return citizenRepository.findById(id)
                .orElseThrow(()-> new CitizenNotFoundException("No Citizen Found with this Id:"+id));
    }

    @Override
    public void deleteCitizen(Long id) {
        if (!citizenRepository.existsById(id)){
            throw new CitizenNotFoundException("This Citizen Is Not Found");
        }
        citizenRepository.deleteById(id);
    }

    private boolean citizenAlreadyExists(String email){

        return citizenRepository.findByEmail(email).isPresent();
    }
}
