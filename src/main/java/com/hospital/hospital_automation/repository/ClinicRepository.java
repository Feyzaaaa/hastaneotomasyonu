package com.hospital.hospital_automation.repository;
import com.hospital.hospital_automation.entity.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicRepository extends JpaRepository<Clinic, Long> {
}
