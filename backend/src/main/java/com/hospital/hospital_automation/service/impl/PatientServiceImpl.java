package com.hospital.hospital_automation.service.impl;

import com.hospital.hospital_automation.entity.Patient;
import com.hospital.hospital_automation.repository.PatientRepository;
import com.hospital.hospital_automation.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements IPatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    @Override
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Long id, Patient patient) {
        if (patientRepository.existsById(id)) {
        	patient.setPatientId(id);// Doğru setter metodu çağrılıyor
            return patientRepository.save(patient);
        } else {
            throw new IllegalArgumentException("Patient not found");
        }
    }

    @Override
    public void deletePatient(Long id) {
        if (patientRepository.existsById(id)) {
            patientRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Patient not found");
        }
    }
}
