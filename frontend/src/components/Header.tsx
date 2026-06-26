import { Link, useNavigate } from "react-router-dom";

export function Header() {
  const navigate = useNavigate();
  const userName = localStorage.getItem("userName");

  function handleLogout() {
    localStorage.removeItem("token");
    localStorage.removeItem("userName");
    navigate("/");
  }

  return (
    <header className="flex w-full items-center justify-between border-b border-zinc-800 px-6 py-4">
      <Link to="/" className="text-lg font-semibold tracking-tight text-zinc-100">
        ShortenURL
      </Link>

      <nav className="flex items-center gap-4 text-sm">
        {userName ? (
          <>
            <Link
              to="/dashboard"
              className="text-zinc-400 transition-colors hover:text-zinc-100"
            >
              My Links
            </Link>
            <span className="text-zinc-500">|</span>
            <span className="text-zinc-400">{userName}</span>
            <button
              onClick={handleLogout}
              className="rounded-md border border-zinc-700 px-3 py-1.5 text-sm font-medium text-zinc-400 transition-colors hover:border-zinc-500 hover:text-zinc-100"
            >
              Logout
            </button>
          </>
        ) : (
          <>
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
          </>
        )}
      </nav>
    </header>
  );
}