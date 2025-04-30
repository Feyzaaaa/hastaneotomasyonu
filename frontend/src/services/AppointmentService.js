// AppointmentService.js

const API_BASE_URL = process.env.REACT_APP_API_URL; // .env dosyasındaki değeri çeker

export const getAppointments = async () => {
    try {
        const response = await fetch(`${API_BASE_URL}/appointments`);
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        return await response.json();
    } catch (error) {
        console.error("Randevular yüklenirken bir hata oluştu:", error);
        throw error;
    }
};
