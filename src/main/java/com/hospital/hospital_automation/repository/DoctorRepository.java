package com.hospital.hospital_automation.repository;


import com.hospital.hospital_automation.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
