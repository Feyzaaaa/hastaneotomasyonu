package com.hospital.hospital_automation.controller;

import com.hospital.hospital_automation.dto.DoctorDTO;
import com.hospital.hospital_automation.exception.ResourceNotFoundException;
import com.hospital.hospital_automation.entity.Doctor;
import com.hospital.hospital_automation.service.IDoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final IDoctorService doctorService;
    private final ModelMapper modelMapper;

    @Autowired
    public DoctorController(IDoctorService doctorService, ModelMapper modelMapper) {
        this.doctorService = doctorService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<DoctorDTO> createDoctor(@RequestBody DoctorDTO doctorDTO) {
        Doctor doctor = modelMapper.map(doctorDTO, Doctor.class);
        Doctor savedDoctor = doctorService.createDoctor(doctor);
        DoctorDTO savedDoctorDTO = modelMapper.map(savedDoctor, DoctorDTO.class);
        return ResponseEntity.ok(savedDoctorDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDTO> getDoctorById(@PathVariable Long id) {
        Doctor doctor = doctorService.getDoctorById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id: " + id));
        DoctorDTO doctorDTO = modelMapper.map(doctor, DoctorDTO.class);
        return ResponseEntity.ok(doctorDTO);
    }

    @GetMapping
    public ResponseEntity<List<DoctorDTO>> getAllDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        List<DoctorDTO> doctorDTOs = doctors.stream()
                .map(doctor -> modelMapper.map(doctor, DoctorDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(doctorDTOs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorDTO> updateDoctor(@PathVariable Long id, @RequestBody DoctorDTO doctorDTO) {
        Doctor existingDoctor = doctorService.getDoctorById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id: " + id));

        // Mevcut doktoru güncelle
        modelMapper.map(doctorDTO, existingDoctor);
        Doctor updatedDoctor = doctorService.createDoctor(existingDoctor);

        DoctorDTO updatedDoctorDTO = modelMapper.map(updatedDoctor, DoctorDTO.class);
        return ResponseEntity.ok(updatedDoctorDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        Doctor doctor = doctorService.getDoctorById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id: " + id));
        doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }
}

