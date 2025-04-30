package com.hospital.hospital_automation.service.impl;

import com.hospital.hospital_automation.entity.Doctor;
import com.hospital.hospital_automation.repository.DoctorRepository;
import com.hospital.hospital_automation.service.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements IDoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    @Override
    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor updateDoctor(Long id, Doctor doctor) {
        if (doctorRepository.existsById(id)) {
            doctor.setId(id); // Mevcut ID'yi set et
            return doctorRepository.save(doctor);
        } else {
            throw new IllegalArgumentException("Doctor not found");
        }
    }

    @Override
    public void deleteDoctor(Long id) {
        if (doctorRepository.existsById(id)) {
            doctorRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Doctor not found");
        }
    }
}
