const API_BASE_URL = process.env.REACT_APP_API_URL;

export const getLabResults = async () => {
    try {
        const response = await fetch(`${API_BASE_URL}/lab-results`);
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        return await response.json();
    } catch (error) {
        console.error("Laboratuvar sonuçları yüklenirken bir hata oluştu:", error);
        throw error;
    }
};

// İleride diğer laboratuvar sonuçları işlemleri için fonksiyonlar eklenebilir