package com.ubudehe.system.repository;

import com.ubudehe.system.model.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CitizenRepository extends JpaRepository<Citizen, Long> {
    Optional<Citizen> findByEmail(String email);
}
