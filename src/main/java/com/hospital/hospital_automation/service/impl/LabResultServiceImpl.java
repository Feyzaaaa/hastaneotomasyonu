package com.hospital.hospital_automation.service.impl;
import com.hospital.hospital_automation.entity.LabResult;
import com.hospital.hospital_automation.repository.LabResultRepository;
import com.hospital.hospital_automation.service.ILabResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LabResultServiceImpl implements ILabResultService {

    private final LabResultRepository labResultRepository;

    @Autowired
    public LabResultServiceImpl(LabResultRepository labResultRepository) {
        this.labResultRepository = labResultRepository;
    }

    @Override
    public List<LabResult> getAllLabResults() {
        return labResultRepository.findAll();
    }

    @Override
    public Optional<LabResult> getLabResultById(Long id) {
        return labResultRepository.findById(id);
    }

    @Override
    public LabResult createLabResult(LabResult labResult) {
        return labResultRepository.save(labResult);
    }

    @Override
    public LabResult updateLabResult(Long id, LabResult labResult) {
        if (labResultRepository.existsById(id)) {
            labResult.setId(id); // LabResult entity'sinde setId metodu olmalı
            return labResultRepository.save(labResult);
        } else {
            throw new IllegalArgumentException("LabResult not found");
        }
    }

    @Override
    public void deleteLabResult(Long id) {
        if (labResultRepository.existsById(id)) {
            labResultRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("LabResult not found");
        }
    }
}
