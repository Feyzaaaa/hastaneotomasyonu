package com.hospital.hospital_automation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

import com.hospital.hospital_automation.entity.LabResult;

@Entity
@Table(name = "lab_tests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LabTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String testName;

    private String description;

    @OneToMany(mappedBy = "labTest", fetch = FetchType.LAZY)
    private List<LabResult> labResults;

	public void setId(Long id2) {
		// TODO Auto-generated method stub

	}
}

