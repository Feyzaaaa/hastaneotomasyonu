const API_BASE_URL = process.env.REACT_APP_API_URL;

export const login = async (username, password) => {
    try {
        const response = await fetch(`${API_BASE_URL}/login`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ username, password }),
        });
        if (!response.ok) {
            const errorData = await response.json();
            throw new Error(errorData.message || 'Giriş başarısız.');
        }
        return await response.json(); // Token veya kullanıcı bilgisini dönebilir
    } catch (error) {
        console.error("Giriş sırasında bir hata oluştu:", error);
        throw error;
    }
};

export const register = async (username, password) => {
    try {
        const response = await fetch(`${API_BASE_URL}/register`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ username, password }),
        });
        if (!response.ok) {
            const errorData = await response.json();
            throw new Error(errorData.message || 'Kayıt başarısız.');
        }
        return await response.json(); // Başarılı kayıt mesajı dönebilir
    } catch (error) {
        console.error("Kayıt sırasında bir hata oluştu:", error);
        throw error;
    }
};