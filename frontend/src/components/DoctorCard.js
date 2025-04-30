import React from 'react';
import './DoctorCard.css'; // İsteğe bağlı stil dosyası

function DoctorCard({ doctor }) {
    return (
        <div className="doctor-card">
            <h3>Doktor Bilgileri</h3>
            <p><strong>Adı Soyadı:</strong> {doctor.firstName} {doctor.lastName}</p>
            <p><strong>Branş:</strong> {doctor.specialization}</p>
            <p><strong>Telefon:</strong> {doctor.phoneNumber}</p>
            <p><strong>E-posta:</strong> {doctor.email}</p>
            {/* İsteğe bağlı olarak detaylar linki eklenebilir */}
        </div>
    );
}

export default DoctorCard;