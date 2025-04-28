package com.hospital.hospital_automation.service;

import java.util.List;
import java.util.Optional;

import com.hospital.hospital_automation.entity.Clinic;

public interface IClinicService {

    List<Clinic> getAllClinics();

    Optional<Clinic> getClinicById(Long id);

    Clinic createClinic(Clinic clinic);

    Clinic updateClinic(Long id, Clinic clinic);

    void deleteClinic(Long id);
}
