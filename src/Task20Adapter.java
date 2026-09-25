public class Task20Adapter implements EventPublisher {
    private final LegacyMessageBroker messageBroker;

    public Task20Adapter(LegacyMessageBroker messageBroker) {
        this.messageBroker = messageBroker;
    }

    @Override
    public void publishEvent(Event event) {
        if (event == null) return;
        messageBroker.send(event.getTopic(), event.getPayload());
    }
}