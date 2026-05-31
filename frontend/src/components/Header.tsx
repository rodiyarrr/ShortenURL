import { Link } from "react-router-dom";

export function Header() {
  return (
    <header className="flex w-full items-center justify-between border-b border-zinc-800 px-6 py-4">
      <Link to="/" className="text-lg font-semibold tracking-tight text-zinc-100">
        ShortenURL
      </Link>
      <nav className="flex items-center gap-4 text-sm">
        <Link
          to="/login"
          className="text-zinc-400 transition-colors hover:text-zinc-100"
        >
          Log in
        </Link>
        <Link
          to="/signup"
          className="rounded-md bg-zinc-100 px-3 py-1.5 font-medium text-zinc-900 transition-colors hover:bg-zinc-300"
        >
          Sign up
        </Link>
      </nav>
    </header>
  );
}
