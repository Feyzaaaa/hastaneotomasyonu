package com.hospital.hospital_automation.controller;

import com.hospital.hospital_automation.entity.LabTest;
import com.hospital.hospital_automation.service.ILabTestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lab-tests")
public class LabTestController {

    private final ILabTestService labTestService;

    @Autowired
    public LabTestController(ILabTestService labTestService) {
        this.labTestService = labTestService;
    }

    @GetMapping
    public ResponseEntity<List<LabTest>> getAllLabTests() {
        return ResponseEntity.ok(labTestService.getAllLabTests());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LabTest> getLabTestById(@PathVariable Long id) {
        return labTestService.getLabTestById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LabTest> createLabTest(@Valid @RequestBody LabTest labTest) {
        LabTest created = labTestService.createLabTest(labTest);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LabTest> updateLabTest(@PathVariable Long id, @Valid @RequestBody LabTest labTest) {
        LabTest updated = labTestService.updateLabTest(id, labTest);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLabTest(@PathVariable Long id) {
        labTestService.deleteLabTest(id);
        return ResponseEntity.noContent().build();
    }
}
