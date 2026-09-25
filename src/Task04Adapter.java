import java.util.ArrayList;
import java.util.List;

public class Task04Adapter implements ModernUserDataProvider {
    private final LegacyUserDatabase legacyUserDatabase;

    public Task04Adapter(LegacyUserDatabase legacyUserDatabase) {
        this.legacyUserDatabase = legacyUserDatabase;
    }

    @Override
    public List<UserProfile> fetchAllUsers() {
        List<LegacyUserRecord> legacyRecords = legacyUserDatabase.getRawUserRecords();
        List<UserProfile> profiles = new ArrayList<>();
        if (legacyRecords != null) {
            for (LegacyUserRecord record : legacyRecords) {
                if (record != null) {
                    profiles.add(new UserProfile(record.getId(), record.getFullName(), record.getEmailAddress()));
                }
            }
        }
        return profiles;
    }
}