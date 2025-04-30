const API_BASE_URL = process.env.REACT_APP_API_URL;
export const getPatients = async () => {
    try {
        const response = await fetch(`${API_BASE_URL}/patients`);
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        return await response.json();
    } catch (error) {
        console.error("Hastalar yüklenirken bir hata oluştu:", error);
        throw error;
    }
};

// İleride diğer hasta işlemleri için fonksiyonlar eklenebilir (oluşturma, güncelleme, silme vb.)