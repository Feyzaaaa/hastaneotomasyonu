package com.hospital.hospital_automation.repository;

import com.hospital.hospital_automation.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
