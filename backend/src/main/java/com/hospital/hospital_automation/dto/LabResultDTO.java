package com.hospital.hospital_automation.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class LabResultDTO {
    private Long id;
    private Long patientId;
    private String testName;
    private String result;
    private LocalDateTime testDate;
}

