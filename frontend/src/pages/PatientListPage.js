import React, { useState, useEffect } from 'react';
import PatientCard from '../components/PatientCard';
import * as patientService from '../services/PatientService'; // Servis dosyasını import et

function PatientListPage() {
    const [patients, setPatients] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        patientService.getPatients()
            .then(data => {
                setPatients(data);
                setLoading(false);
            })
            .catch(error => {
                setError(error);
                setLoading(false);
                console.error("Hastalar yüklenirken bir hata oluştu:", error);
            });
    }, []);

    if (loading) {
        return <div>Hastalar yükleniyor...</div>;
    }

    if (error) {
        return <div>Hastalar yüklenirken bir hata oluştu: {error.message}</div>;
    }

    return (
        <div>
            <h2>Hasta Listesi</h2>
            {patients.length > 0 ? (
                patients.map(patient => (
                    <PatientCard key={patient.id} patient={patient} />
                ))
            ) : (
                <p>Henüz kayıtlı hasta bulunmamaktadır.</p>
            )}
        </div>
    );
}

export default PatientListPage;