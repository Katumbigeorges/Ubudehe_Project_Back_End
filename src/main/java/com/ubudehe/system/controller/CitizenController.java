package com.ubudehe.system.controller;

import com.ubudehe.system.model.Citizen;
import com.ubudehe.system.service.ICitizenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/citizens")
@RequiredArgsConstructor
public class CitizenController {
    private final ICitizenService citizenService;

    @GetMapping
    public ResponseEntity<List<Citizen>> getCitizens(){
        return new ResponseEntity<>(citizenService.getCitizens(), HttpStatus.FOUND);
    }

    @PostMapping
    public Citizen addCitizen(@RequestBody Citizen citizen){
        return citizenService.addCitizen(citizen);
    }

    @PutMapping("/update/{id}")
    public Citizen updateCitizen(@RequestBody Citizen citizen, @PathVariable Long id){
        return citizenService.updateCitizen(citizen, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCitizen(@PathVariable Long id){
        citizenService.deleteCitizen(id);
    }

    @GetMapping("/citizen/{id}")
    public Citizen getCitizenById(@PathVariable Long id){
        return citizenService.getCitizenById(id);
    }
}
