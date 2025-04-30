package com.hospital.hospital_automation.service;

import com.hospital.hospital_automation.entity.Doctor;
import java.util.List;
import java.util.Optional;

public interface IDoctorService {

    List<Doctor> getAllDoctors();  // Tüm doktorları al

    Optional<Doctor> getDoctorById(Long id); // ID ile doktor al

    Doctor createDoctor(Doctor doctor); // Yeni doktor oluştur

    Doctor updateDoctor(Long id, Doctor doctor); // Doktor bilgilerini güncelle

    void deleteDoctor(Long id); // Doktoru sil
}
