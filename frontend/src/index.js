import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import { BrowserRouter } from 'react-router-dom';
import { AuthProvider } from './context/AuthContext'; // AuthProvider'ı import edin
import './index.css';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <React.StrictMode>
        <BrowserRouter>
            <AuthProvider> {/* App'i AuthProvider ile sarın */}
                <App />
            </AuthProvider>
        </BrowserRouter>
    </React.StrictMode>
);