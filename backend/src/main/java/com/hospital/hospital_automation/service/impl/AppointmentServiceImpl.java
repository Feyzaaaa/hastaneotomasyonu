package com.hospital.hospital_automation.service.impl;

import com.hospital.hospital_automation.entity.Appointment;
import com.hospital.hospital_automation.repository.AppointmentRepository;
import com.hospital.hospital_automation.service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements IAppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    @Override
    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment updateAppointment(Long id, Appointment appointment) {
        if (appointmentRepository.existsById(id)) {
            appointment.setId(id); // Doğru setter metodu çağrılıyor
            return appointmentRepository.save(appointment);
        } else {
            throw new IllegalArgumentException("Appointment not found");
        }
    }

    @Override
    public void deleteAppointment(Long id) {
        if (appointmentRepository.existsById(id)) {
            appointmentRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Appointment not found");
        }
    }
}