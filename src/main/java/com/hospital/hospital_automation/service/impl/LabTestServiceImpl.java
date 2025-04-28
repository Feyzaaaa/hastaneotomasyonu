package com.hospital.hospital_automation.service.impl;

import com.hospital.hospital_automation.entity.LabTest;
import com.hospital.hospital_automation.repository.LabTestRepository;
import com.hospital.hospital_automation.service.ILabTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LabTestServiceImpl implements ILabTestService {

    private final LabTestRepository labTestRepository;

    @Autowired
    public LabTestServiceImpl(LabTestRepository labTestRepository) {
        this.labTestRepository = labTestRepository;
    }

    @Override
    public List<LabTest> getAllLabTests() {
        return labTestRepository.findAll();
    }

    @Override
    public Optional<LabTest> getLabTestById(Long id) {
        return labTestRepository.findById(id);
    }

    @Override
    public LabTest createLabTest(LabTest labTest) {
        return labTestRepository.save(labTest);
    }

    @Override
    public LabTest updateLabTest(Long id, LabTest labTest) {
        if (labTestRepository.existsById(id)) {
            labTest.setId(id); // LabTest entity'sinde setId metodu olmalı (Lombok ile sağlanır)
            return labTestRepository.save(labTest);
        } else {
            throw new IllegalArgumentException("LabTest not found");
        }
    }

    @Override
    public void deleteLabTest(Long id) {
        if (labTestRepository.existsById(id)) {
            labTestRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("LabTest not found");
        }
    }
}