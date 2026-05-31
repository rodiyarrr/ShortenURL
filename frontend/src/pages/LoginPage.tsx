import { Link } from "react-router-dom";
import { Header } from "@/components/Header";

export function LoginPage() {
  return (
    <>
      <Header />
      <main className="flex flex-1 flex-col items-center justify-center px-6 py-16">
        <div className="w-full max-w-sm text-center">
          <h1 className="text-2xl font-semibold text-zinc-100">Log in</h1>
          <p className="mt-2 text-sm text-zinc-400">
            Connect this page to your Spring Boot auth endpoints when ready.
          </p>
          <Link
            to="/"
            className="mt-6 inline-block text-sm text-zinc-400 hover:text-zinc-100"
          >
            ← Back to home
          </Link>
        </div>
      </main>
    </>
  );
}
