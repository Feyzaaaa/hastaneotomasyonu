import React from 'react';
import './PatientCard.css'; // İsteğe bağlı stil dosyası

function PatientCard({ patient }) {
    return (
        <div className="patient-card">
            <h3>Hasta Bilgileri</h3>
            <p><strong>Adı Soyadı:</strong> {patient.firstName} {patient.lastName}</p>
            <p><strong>TC Kimlik No:</strong> {patient.identityNumber}</p>
            <p><strong>Doğum Tarihi:</strong> {new Date(patient.birthDate).toLocaleDateString()}</p>
            <p><strong>Cinsiyet:</strong> {patient.gender}</p>
            {/* İsteğe bağlı olarak düzenleme veya silme butonları eklenebilir */}
        </div>
    );
}

export default PatientCard;