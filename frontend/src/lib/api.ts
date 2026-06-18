const API_BASE = import.meta.env.VITE_API_URL ?? "http://localhost:8080";

export type ShortenResponse = {
  shortenedURL: string;
  expiresAt: string | null;
};

export async function shortenUrl(url: string): Promise<ShortenResponse> {
  const response = await fetch(`${API_BASE}/shorten`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
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
