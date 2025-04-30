import React, { useState, useEffect } from 'react';
import AppointmentCard from '../components/AppointmentCard';
import * as appointmentService from '../services/AppointmentService'; // Servis dosyasını import et

function AppointmentListPage() {
    const [appointments, setAppointments] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        appointmentService.getAppointments()
            .then(data => {
                setAppointments(data);
                setLoading(false);
            })
            .catch(error => {
                setError(error);
                setLoading(false);
                console.error("Randevular yüklenirken bir hata oluştu:", error);
            });
    }, []);

    if (loading) {
        return <div>Randevular yükleniyor...</div>;
    }

    if (error) {
        return <div>Randevular yüklenirken bir hata oluştu: {error.message}</div>;
    }

    return (
        <div>
            <h2>Randevu Listesi</h2>
            {appointments.length > 0 ? (
                appointments.map(appointment => (
                    <AppointmentCard key={appointment.id} appointment={appointment} />
                ))
            ) : (
                <p>Henüz kayıtlı randevu bulunmamaktadır.</p>
            )}
        </div>
    );
}

export default AppointmentListPage;