import java.util.HashMap;
import java.util.Map;

public class Task12Adapter implements ModernCacheService {
    private final LegacyKeyValueStore legacyStore;

    public Task12Adapter(LegacyKeyValueStore legacyStore) {
        this.legacyStore = legacyStore;
    }

    @Override
    public void put(String key, Object value, long ttlSeconds) {
        legacyStore.saveKey(key, value, (int) ttlSeconds);
    }

    @Override
    public Object get(String key) {
        return legacyStore.retrieveKey(key);
    }
}