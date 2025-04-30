import React, { useState, useEffect } from 'react';
import DoctorCard from '../components/DoctorCard';
import * as doctorService from '../services/DoctorService'; // Servis dosyasını import et

function DoctorListPage() {
    const [doctors, setDoctors] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        doctorService.getDoctors()
            .then(data => {
                setDoctors(data);
                setLoading(false);
            })
            .catch(error => {
                setError(error);
                setLoading(false);
                console.error("Doktorlar yüklenirken bir hata oluştu:", error);
            });
    }, []);

    if (loading) {
        return <div>Doktorlar yükleniyor...</div>;
    }

    if (error) {
        return <div>Doktorlar yüklenirken bir hata oluştu: {error.message}</div>;
    }

    return (
        <div>
            <h2>Doktor Listesi</h2>
            {doctors.length > 0 ? (
                doctors.map(doctor => (
                    <DoctorCard key={doctor.id} doctor={doctor} />
                ))
            ) : (
                <p>Henüz kayıtlı doktor bulunmamaktadır.</p>
            )}
        </div>
    );
}

export default DoctorListPage;