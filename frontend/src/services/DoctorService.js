const API_BASE_URL = process.env.REACT_APP_API_URL;

export const getDoctors = async () => {
    try {
        const response = await fetch(`${API_BASE_URL}/doctors`);
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        return await response.json();
    } catch (error) {
        console.error("Doktorlar yüklenirken bir hata oluştu:", error);
        throw error;
    }
};

// İleride diğer doktor işlemleri için fonksiyonlar eklenebilir (detay getirme, oluşturma vb.)