import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { Header } from "@/components/Header";
import { LinkCard } from "@/components/LinkCard";
import { getAllLinks, deleteLink } from "@/lib/api";
import type { LinkResponse } from "@/lib/api";

export function DashboardPage() {
  const [links, setLinks] = useState<LinkResponse[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);
  const navigate = useNavigate();

  useEffect(() => {
    const token = localStorage.getItem("token");
    if (!token) {
      navigate("/login");
      return;
    }
    fetchLinks();
  }, []);

  async function fetchLinks() {
    try {
      const data = await getAllLinks();
      setLinks(data);
    } catch (err) {
      setError("Could not fetch links.");
    } finally {
      setLoading(false);
    }
  }

  async function handleDelete(shortCode: string) {
    try {
      await deleteLink(shortCode);
      setLinks((prev) => prev.filter((l) => l.shortCode !== shortCode));
    } catch (err) {
      setError("Could not delete link.");
    }
  }

  return (
    <>
      <Header />
      <main className="flex flex-1 flex-col items-center px-6 py-12">
        <div className="w-full max-w-2xl">
          <h1 className="text-2xl font-semibold text-zinc-100">My Links</h1>
          <p className="mt-1 text-sm text-zinc-400">
            All links you have shortened
          </p>

          <div className="mt-6 flex flex-col gap-3">
            {loading && (
              <p className="text-sm text-zinc-400">Loading...</p>
            )}
            {error && (
              <p className="text-sm text-red-400">{error}</p>
            )}
            {!loading && links.length === 0 && (
              <p className="text-sm text-zinc-400">No links yet — go shorten something!</p>
            )}
            {links.map((link) => (
              <LinkCard
                key={link.shortCode}
                link={link}
                onDelete={handleDelete}
              />
            ))}
          </div>
        </div>
      </main>
    </>
  );
}