package com.hospital.hospital_automation.service;

import java.util.List;
import java.util.Optional;

import com.hospital.hospital_automation.entity.LabResult;
import com.hospital.hospital_automation.entity.LabTest;

public interface ILabTestService {
    List<LabTest> getAllLabTests();
    Optional<LabTest> getLabTestById(Long id);
    LabTest createLabTest(LabTest labTest);
    LabTest updateLabTest(Long id, LabTest labTest);
    void deleteLabTest(Long id);
}