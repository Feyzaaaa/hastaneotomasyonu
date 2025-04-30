package com.hospital.hospital_automation.controller;

import com.hospital.hospital_automation.entity.Clinic;
import com.hospital.hospital_automation.service.IClinicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clinics")
public class ClinicController {

    private final IClinicService clinicService;

    @Autowired
    public ClinicController(IClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @GetMapping
    public ResponseEntity<List<Clinic>> getAllClinics() {
        return ResponseEntity.ok(clinicService.getAllClinics());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clinic> getClinicById(@PathVariable Long id) {
        return clinicService.getClinicById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Clinic> createClinic(@Valid @RequestBody Clinic clinic) {
        Clinic created = clinicService.createClinic(clinic);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clinic> updateClinic(@PathVariable Long id, @Valid @RequestBody Clinic clinic) {
        Clinic updated = clinicService.updateClinic(id, clinic);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClinic(@PathVariable Long id) {
        clinicService.deleteClinic(id);
        return ResponseEntity.noContent().build();
    }
}

