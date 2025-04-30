import React, { useState } from 'react';

function AppointmentForm() {
    const [patientName, setPatientName] = useState('');
    const [doctorName, setDoctorName] = useState('');
    const [appointmentDate, setAppointmentDate] = useState('');
    const [appointmentTime, setAppointmentTime] = useState('');
    const [clinicName, setClinicName] = useState('');

    const handleSubmit = (event) => {
        event.preventDefault();
        const appointmentData = {
            patientName,
            doctorName,
            appointmentDate,
            appointmentTime,
            clinicName,
        };
        console.log('Oluşturulan Randevu:', appointmentData);
        // Burada backend API'sine gönderme işlemi yapılabilir
    };

    return (
        <div>
            <h2>Yeni Randevu Oluştur</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label htmlFor="patientName">Hasta Adı:</label>
                    <input
                        type="text"
                        id="patientName"
                        value={patientName}
                        onChange={(e) => setPatientName(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <label htmlFor="doctorName">Doktor Adı:</label>
                    <input
                        type="text"
                        id="doctorName"
                        value={doctorName}
                        onChange={(e) => setDoctorName(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <label htmlFor="appointmentDate">Tarih:</label>
                    <input
                        type="date"
                        id="appointmentDate"
                        value={appointmentDate}
                        onChange={(e) => setAppointmentDate(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <label htmlFor="appointmentTime">Saat:</label>
                    <input
                        type="time"
                        id="appointmentTime"
                        value={appointmentTime}
                        onChange={(e) => setAppointmentTime(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <label htmlFor="clinicName">Klinik:</label>
                    <input
                        type="text"
                        id="clinicName"
                        value={clinicName}
                        onChange={(e) => setClinicName(e.target.value)}
                        required
                    />
                </div>
                <button type="submit">Randevu Oluştur</button>
            </form>
        </div>
    );
}

export default AppointmentForm;