package com.ubudehe.system.service;

import com.ubudehe.system.model.Citizen;

import java.util.List;

public interface ICitizenService {
    Citizen addCitizen(Citizen citizen);

    List<Citizen> getCitizens();

    Citizen updateCitizen(Citizen citizen, Long id);

    Citizen getCitizenById(Long id);

    void deleteCitizen(Long id);
}
