import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import * as authService from '../services/AuthService'; // AuthService'i import edin

function RegisterForm() {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [confirmPassword, setConfirmPassword] = useState('');
    const [error, setError] = useState('');
    const navigate = useNavigate();

    const handleSubmit = async (event) => {
        event.preventDefault();
        setError('');
        if (password !== confirmPassword) {
            setError('Şifreler eşleşmiyor.');
            return;
        }
        try {
            await authService.register(username, password);
            navigate('/login'); // Başarılı kayıt sonrası giriş sayfasına yönlendir
        } catch (err) {
            setError('Kayıt sırasında bir hata oluştu.');
            console.error('Kayıt hatası:', err);
        }
    };

    return (
        <div>
            <h2>Kayıt Ol</h2>
            {error && <p style={{ color: 'red' }}>{error}</p>}
            <form onSubmit={handleSubmit}>
                <div>
                    <label htmlFor="username">Kullanıcı Adı:</label>
                    <input
                        type="text"
                        id="username"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <label htmlFor="password">Şifre:</label>
                    <input
                        type="password"
                        id="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <label htmlFor="confirmPassword">Şifre Tekrar:</label>
                    <input
                        type="password"
                        id="confirmPassword"
                        value={confirmPassword}
                        onChange={(e) => setConfirmPassword(e.target.value)}
                        required
                    />
                </div>
                <button type="submit">Kayıt Ol</button>
            </form>
        </div>
    );
}

export default RegisterForm;