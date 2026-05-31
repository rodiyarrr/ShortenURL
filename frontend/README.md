# ShortenURL Frontend (React)

Same UI as the Next.js version, built with **React + Vite + React Router + Tailwind CSS**.

## Run locally

```bash
npm install
npm run dev
```

Open [http://localhost:5173](http://localhost:5173).

## Backend connection

Copy `.env.example` to `.env` and set your API base URL:

```
VITE_API_URL=http://localhost:8080
```

The landing page calls:

**`POST /api/shorten`**

Request body:

```json
{ "url": "https://example.com/very/long/path" }
```

Expected response:

```json
{ "shortUrl": "http://localhost:8080/abc123", "shortCode": "abc123" }
```

On error, return a JSON body with a `message` field (e.g. `{ "message": "Invalid URL" }`).

Enable CORS on your Spring Boot app for `http://localhost:5173` while developing.

## Pages

| Route     | Purpose                          |
| --------- | -------------------------------- |
| `/`       | Landing + anonymous shorten form |
| `/login`  | Placeholder for auth             |
| `/signup` | Placeholder for auth             |
