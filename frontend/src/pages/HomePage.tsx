import { Header } from "@/components/Header";
import { ShortenForm } from "@/components/ShortenForm";

export function HomePage() {
  return (
    <>
      <Header />
      <main className="flex flex-1 flex-col items-center justify-center px-6 py-16">
        <section className="flex w-full max-w-2xl flex-col items-center gap-6 text-center">
          <div className="space-y-2">
            <h1 className="text-3xl font-semibold tracking-tight text-zinc-100 sm:text-4xl">
              Shorten links in seconds
            </h1>
            <p className="text-zinc-400">
              Paste a URL below — no account required.
            </p>
          </div>
          <ShortenForm />
        </section>
      </main>
    </>
  );
}
