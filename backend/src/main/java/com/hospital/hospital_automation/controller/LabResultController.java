package com.hospital.hospital_automation.controller;

import com.hospital.hospital_automation.entity.LabResult;
import com.hospital.hospital_automation.service.ILabResultService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lab-results")
public class LabResultController {

    private final ILabResultService labResultService;

    @Autowired
    public LabResultController(ILabResultService labResultService) {
        this.labResultService = labResultService;
    }

    @GetMapping
    public ResponseEntity<List<LabResult>> getAllLabResults() {
        return ResponseEntity.ok(labResultService.getAllLabResults());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LabResult> getLabResultById(@PathVariable Long id) {
        return labResultService.getLabResultById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LabResult> createLabResult(@Valid @RequestBody LabResult labResult) {
        LabResult created = labResultService.createLabResult(labResult);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LabResult> updateLabResult(@PathVariable Long id, @Valid @RequestBody LabResult labResult) {
        LabResult updated = labResultService.updateLabResult(id, labResult);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLabResult(@PathVariable Long id) {
        labResultService.deleteLabResult(id);
        return ResponseEntity.noContent().build();
    }
}
