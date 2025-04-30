package com.hospital.hospital_automation.repository;

import com.hospital.hospital_automation.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
