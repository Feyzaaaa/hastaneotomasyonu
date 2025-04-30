import React from 'react';
import { Routes, Route, Link } from 'react-router-dom';
import HomePage from './pages/HomePage';
import AppointmentListPage from './pages/AppointmentListPage';
import PatientListPage from './pages/PatientListPage';
import DoctorListPage from './pages/DoctorListPage';
import LabResultsPage from './pages/LabResultsPage';
import LoginPage from './pages/LoginPage';
import RegisterPage from './pages/RegisterPage';
import './App.css'; // App'e özel stilleri import et

function App() {
  return (
      <div className="app-container">
        <nav className="app-nav">
          <ul>
            <li>
              <Link to="/">Anasayfa</Link>
            </li>
            <li>
              <Link to="/appointments">Randevular</Link>
            </li>
            <li>
              <Link to="/patients">Hastalar</Link>
            </li>
            <li>
              <Link to="/doctors">Doktorlar</Link>
            </li>
            <li>
              <Link to="/lab-results">Laboratuvar Sonuçları</Link>
            </li>
            <li>
              <Link to="/login">Giriş</Link>
            </li>
            <li>
              <Link to="/register">Kayıt</Link>
            </li>
          </ul>
        </nav>

        <div className="content">
          <Routes>
            <Route path="/" element={<HomePage />} />
            <Route path="/appointments" element={<AppointmentListPage />} />
            <Route path="/patients" element={<PatientListPage />} />
            <Route path="/doctors" element={<DoctorListPage />} />
            <Route path="/lab-results" element={<LabResultsPage />} />
            <Route path="/login" element={<LoginPage />} />
            <Route path="/register" element={<RegisterPage />} />
          </Routes>
        </div>
      </div>
  );
}

export default App;