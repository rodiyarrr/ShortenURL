import type { LinkResponse } from "@/lib/api";

type Props = {
  link: LinkResponse;
  onDelete: (shortCode: string) => void;
};

export function LinkCard({ link, onDelete }: Props) {
  return (
    <div className="flex flex-col gap-2 rounded-xl border border-zinc-800 bg-zinc-900 p-4">
      <div className="flex items-start justify-between gap-4">
        <div className="flex flex-col gap-1 min-w-0">
            <a
            href={link.shortenedURL}
            target="_blank"
            rel="noopener noreferrer"
            className="text-sm font-medium text-zinc-100 hover:underline truncate"
          >
            {link.shortenedURL}
          </a>
          <p className="text-xs text-zinc-500 truncate">{link.userURL}</p>
        </div>

        <button
          onClick={() => onDelete(link.shortCode)}
          className="shrink-0 rounded-md border border-red-800 px-2.5 py-1 text-xs font-medium text-red-400 transition-colors hover:bg-red-950"
        >
          Delete
        </button>
      </div>

      <div className="flex items-center gap-4 text-xs text-zinc-500">
        <span>{link.clickCount} clicks</span>
        <span>Created {new Date(link.createdAt).toLocaleDateString()}</span>
        {link.expiresAt && (
          <span>Expires {new Date(link.expiresAt).toLocaleDateString()}</span>
        )}
      </div>
    </div>
  );
}