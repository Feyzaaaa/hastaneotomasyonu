package com.hospital.hospital_automation.service;


import com.hospital.hospital_automation.entity.Appointment;
import java.util.List;
import java.util.Optional;

public interface IAppointmentService {

    List<Appointment> getAllAppointments(); // Tüm randevuları al

    Optional<Appointment> getAppointmentById(Long id); // ID ile randevu al

    Appointment createAppointment(Appointment appointment); // Yeni randevu oluştur

    Appointment updateAppointment(Long id, Appointment appointment); // Randevu bilgilerini güncelle

    void deleteAppointment(Long id); // Randevuyu sil
}
