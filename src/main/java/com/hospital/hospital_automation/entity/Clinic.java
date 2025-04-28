package com.hospital.hospital_automation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

import com.hospital.hospital_automation.entity.Appointment;

@Entity
@Table(name = "clinics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Clinic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String clinicName;

    @OneToMany(mappedBy = "clinic", fetch = FetchType.LAZY)
    private List<Doctor> doctors;

    @OneToMany(mappedBy = "clinic", fetch = FetchType.LAZY)
    private List<Appointment> appointments;

	public void setId(Long id2) {
		// TODO Auto-generated method stub

	}
}
