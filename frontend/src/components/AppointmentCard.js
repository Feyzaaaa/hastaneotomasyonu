import React from 'react';
import './AppointmentCard.css'; // İsteğe bağlı stil dosyası

function AppointmentCard({ appointment }) {
    return (
        <div className="appointment-card">
            <h3>Randevu Bilgileri</h3>
            <p><strong>Hasta Adı:</strong> {appointment.patientName}</p>
            <p><strong>Doktor Adı:</strong> {appointment.doctorName}</p>
            <p><strong>Tarih:</strong> {new Date(appointment.appointmentDate).toLocaleDateString()}</p>
            <p><strong>Saat:</strong> {appointment.appointmentTime}</p>
            <p><strong>Klinik:</strong> {appointment.clinicName}</p>
            {/* İsteğe bağlı olarak iptal etme butonu veya detaylar linki eklenebilir */}
        </div>
    );
}

export default AppointmentCard;