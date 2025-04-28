package com.hospital.hospital_automation.service;

import java.util.List;
import java.util.Optional;

import com.hospital.hospital_automation.entity.LabResult;

public interface ILabResultService {
    List<LabResult> getAllLabResults();
    Optional<LabResult> getLabResultById(Long id);
    LabResult createLabResult(LabResult labResult);
    LabResult updateLabResult(Long id, LabResult labResult);
    void deleteLabResult(Long id);
}
