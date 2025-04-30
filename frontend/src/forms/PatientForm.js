import React, { useState } from 'react';

function PatientForm() {
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [identityNumber, setIdentityNumber] = useState('');
    const [birthDate, setBirthDate] = useState('');
    const [gender, setGender] = useState('');

    const handleSubmit = (event) => {
        event.preventDefault();
        const patientData = {
            firstName,
            lastName,
            identityNumber,
            birthDate,
            gender,
        };
        console.log('Kaydedilen Hasta:', patientData);
        // Burada backend API'sine gönderme işlemi yapılabilir
    };

    return (
        <div>
            <h2>Yeni Hasta Kaydet</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label htmlFor="firstName">Adı:</label>
                    <input
                        type="text"
                        id="firstName"
                        value={firstName}
                        onChange={(e) => setFirstName(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <label htmlFor="lastName">Soyadı:</label>
                    <input
                        type="text"
                        id="lastName"
                        value={lastName}
                        onChange={(e) => setLastName(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <label htmlFor="identityNumber">TC Kimlik No:</label>
                    <input
                        type="text"
                        id="identityNumber"
                        value={identityNumber}
                        onChange={(e) => setIdentityNumber(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <label htmlFor="birthDate">Doğum Tarihi:</label>
                    <input
                        type="date"
                        id="birthDate"
                        value={birthDate}
                        onChange={(e) => setBirthDate(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <label htmlFor="gender">Cinsiyet:</label>
                    <select id="gender" value={gender} onChange={(e) => setGender(e.target.value)} required>
                        <option value="">Seçiniz</option>
                        <option value="Erkek">Erkek</option>
                        <option value="Kadın">Kadın</option>
                    </select>
                </div>
                <button type="submit">Kaydet</button>
            </form>
        </div>
    );
}

export default PatientForm;