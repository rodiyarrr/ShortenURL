const TOKEN_KEY = "shortenurl_token";
const USERNAME_KEY = "shortenurl_username";

export function saveAuth(token: string, userName: string) {
  localStorage.setItem(TOKEN_KEY, token);
  localStorage.setItem(USERNAME_KEY, userName);
}

export function clearAuth() {
  localStorage.removeItem(TOKEN_KEY);
  localStorage.removeItem(USERNAME_KEY);
}

export function getAuthToken(): string | null {
  return localStorage.getItem(TOKEN_KEY);
}

export function getAuthUserName(): string | null {
  return localStorage.getItem(USERNAME_KEY);
}

export function isAuthenticated(): boolean {
  return getAuthToken() !== null;
}
