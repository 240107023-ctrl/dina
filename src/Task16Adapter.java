import java.util.List;

public class Task16Adapter implements SearchEngine {
    private final LegacySearchBackend legacyBackend;

    public Task16Adapter(LegacySearchBackend legacyBackend) {
        this.legacyBackend = legacyBackend;
    }

    @Override
    public List<SearchResult> search(SearchQuery query) {
        String rawQuery = query != null ? query.getFilterString() : "";
        return legacyBackend.executeQuery(rawQuery);
    }
}