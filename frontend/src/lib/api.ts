const API_BASE = import.meta.env.VITE_API_URL ?? "http://localhost:8080";

export type ShortenResponse = {
  shortenedURL: string;
  expiresAt: string | null;
};

export type LinkResponse = {
  shortCode: string;
  userURL: string;
  shortenedURL: string;
  clickCount: number;
  createdAt: string;
  expiresAt: string | null;
};

export async function shortenUrl(url: string): Promise<ShortenResponse> {
  const token = localStorage.getItem("token");

  const response = await fetch(`${API_BASE}/shorten`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      ...(token ? { Authorization: `Bearer ${token}` } : {}),
    },
    body: JSON.stringify({ userURL: url }),
  });

  if (!response.ok) {
    const message =
      (await response.json().catch(() => null))?.message ??
      "Could not shorten this link. Please try again.";
    throw new Error(message);
  }

  return response.json();
}

export async function getAllLinks(): Promise<LinkResponse[]> {
  const token = localStorage.getItem("token");

  const response = await fetch(`${API_BASE}/api/links`, {
    method: "GET",
    headers: {
      Authorization: `Bearer ${token}`,
    },
  });

  if (!response.ok) {
    throw new Error("Could not fetch links.");
  }

  return response.json();
}

export async function deleteLink(shortCode: string): Promise<void> {
  const token = localStorage.getItem("token");

  const response = await fetch(`${API_BASE}/api/delete/${shortCode}`, {
    method: "DELETE",
    headers: {
      Authorization: `Bearer ${token}`,
    },
  });

  if (!response.ok) {
    throw new Error("Could not delete link.");
  }
}