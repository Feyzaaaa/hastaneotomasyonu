package com.hospital.hospital_automation.service;

import com.hospital.hospital_automation.entity.Patient;
import java.util.List;
import java.util.Optional;

public interface IPatientService {

    List<Patient> getAllPatients(); // Tüm hastaları al

    Optional<Patient> getPatientById(Long id); // ID ile hasta al

    Patient createPatient(Patient patient); // Yeni hasta oluştur

    Patient updatePatient(Long id, Patient patient); // Hasta bilgilerini güncelle

    void deletePatient(Long id); // Hastayı sil
}
