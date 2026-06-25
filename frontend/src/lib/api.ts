const API_BASE = import.meta.env.VITE_API_URL ?? "http://localhost:8080";

export type ShortenResponse = {
  shortenedURL: string;
  expiresAt: string | null;
};

export type AuthResponse = {
  message: string;
  userName: string;
  token: string;
};

async function parseErrorMessage(
  response: Response,
  fallback: string
): Promise<string> {
  const text = await response.text();
  if (!text) return fallback;

  try {
    const json = JSON.parse(text) as {
      message?: string;
      errors?: Array<{ defaultMessage?: string }>;
    };
    if (typeof json.message === "string") return json.message;
    if (Array.isArray(json.errors) && json.errors.length > 0) {
      return json.errors
        .map((e) => e.defaultMessage)
        .filter(Boolean)
        .join(", ");
    }
  } catch {
    return text;
  }

  return text;
}

export async function login(
  identifier: string,
  password: string
): Promise<AuthResponse> {
  const response = await fetch(`${API_BASE}/auth/login`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ identifier, password }),
  });

  if (!response.ok) {
    throw new Error(
      await parseErrorMessage(response, "Could not log in. Please try again.")
    );
  }

  return response.json();
}

export async function signup(
  userName: string,
  email: string,
  password: string
): Promise<AuthResponse> {
  const response = await fetch(`${API_BASE}/auth/signup`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ userName, email, password }),
  });

  if (!response.ok) {
    throw new Error(
      await parseErrorMessage(response, "Could not sign up. Please try again.")
    );
  }

  return response.json();
}

export async function shortenUrl(url: string): Promise<ShortenResponse> {
  const response = await fetch(`${API_BASE}/shorten`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ userURL: url }),
  });
  if (!response.ok) {
    throw new Error(
      await parseErrorMessage(
        response,
        "Could not shorten this link. Please try again."
      )
    );
  }
  return response.json();
}
