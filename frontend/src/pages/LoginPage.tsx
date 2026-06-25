import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { Header } from "@/components/Header";
import { login } from "@/lib/api";
import { saveAuth } from "@/lib/auth";

const inputClassName =
  "w-full rounded-lg border border-zinc-700 bg-zinc-950 px-4 py-2.5 text-zinc-100 placeholder:text-zinc-500 focus:border-zinc-500 focus:outline-none focus:ring-1 focus:ring-zinc-500";

export function LoginPage() {
  const navigate = useNavigate();
  const [identifier, setIdentifier] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState<string | null>(null);
  const [loading, setLoading] = useState(false);

  async function handleSubmit(e: React.FormEvent) {
    e.preventDefault();
    setError(null);

    const trimmedIdentifier = identifier.trim();
    if (!trimmedIdentifier || !password) {
      setError("Username or email and password are required.");
      return;
    }

    setLoading(true);
    try {
      const result = await login(trimmedIdentifier, password);
      saveAuth(result.token, result.userName);
      navigate("/");
    } catch (err) {
      setError(err instanceof Error ? err.message : "Something went wrong.");
    } finally {
      setLoading(false);
    }
  }

  return (
    <>
      <Header />
      <main className="flex flex-1 flex-col items-center justify-center px-6 py-16">
        <div className="w-full max-w-sm">
          <div className="mb-6 text-center">
            <h1 className="text-2xl font-semibold text-zinc-100">Log in</h1>
            <p className="mt-2 text-sm text-zinc-400">
              Welcome back. Sign in to your account.
            </p>
          </div>

          <div className="rounded-xl border border-zinc-800 bg-zinc-900 p-6 shadow-lg shadow-black/20">
            <form onSubmit={handleSubmit} className="flex flex-col gap-3">
              <input
                type="text"
                value={identifier}
                onChange={(e) => setIdentifier(e.target.value)}
                placeholder="Username or email"
                autoComplete="username"
                className={inputClassName}
                disabled={loading}
              />
              <input
                type="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                placeholder="Password"
                autoComplete="current-password"
                className={inputClassName}
                disabled={loading}
              />
              <button
                type="submit"
                disabled={loading}
                className="mt-1 rounded-lg bg-zinc-100 px-5 py-2.5 font-medium text-zinc-900 transition-colors hover:bg-zinc-300 disabled:cursor-not-allowed disabled:opacity-60"
              >
                {loading ? "Logging in…" : "Log in"}
              </button>
            </form>

            {error && (
              <p className="mt-3 text-sm text-red-400" role="alert">
                {error}
              </p>
            )}
          </div>

          <p className="mt-6 text-center text-sm text-zinc-400">
            Don&apos;t have an account?{" "}
            <Link to="/signup" className="text-zinc-100 hover:underline">
              Sign up
            </Link>
          </p>
        </div>
      </main>
    </>
  );
}
