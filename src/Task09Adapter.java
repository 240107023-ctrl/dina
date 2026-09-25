import java.util.Collections;
import java.util.List;

public class Task09Adapter implements NotificationService {
    private final LegacySmsGateway legacySmsGateway;

    public Task09Adapter(LegacySmsGateway legacySmsGateway) {
        this.legacySmsGateway = legacySmsGateway;
    }

    @Override
    public void sendNotification(String userId, String message, List<String> channels) {
        List<String> activeChannels = channels == null ? Collections.emptyList() : channels;
        if (activeChannels.contains("SMS")) {
            String phoneNumber = UserLookup.getPhoneNumber(userId);
            legacySmsGateway.dispatchSms(phoneNumber, message);
        }
    }
}