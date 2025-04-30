package com.hospital.hospital_automation.service.impl;

import com.hospital.hospital_automation.entity.Clinic; // Doğru import eklendi
import com.hospital.hospital_automation.repository.ClinicRepository;
import com.hospital.hospital_automation.service.IClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicServiceImpl implements IClinicService {

    private final ClinicRepository clinicRepository;

    @Autowired
    public ClinicServiceImpl(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    @Override
    public List<Clinic> getAllClinics() {
        return clinicRepository.findAll();
    }

    @Override
    public Optional<Clinic> getClinicById(Long id) {
        return clinicRepository.findById(id);
    }

    @Override
    public Clinic createClinic(Clinic clinic) {
        return clinicRepository.save(clinic);
    }

    @Override
    public Clinic updateClinic(Long id, Clinic clinic) {
        if (clinicRepository.existsById(id)) {
            clinic.setId(id);  // Clinic nesnesinin ID'sini güncelliyoruz.
            return clinicRepository.save(clinic);
        } else {
            throw new IllegalArgumentException("Clinic not found");
        }
    }

    @Override
    public void deleteClinic(Long id) {
        if (clinicRepository.existsById(id)) {
            clinicRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Clinic not found");
        }
    }
}
