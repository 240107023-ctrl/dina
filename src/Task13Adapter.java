public class Task13Adapter implements OrderProcessor {
    private final LegacyFulfillmentApi legacyFulfillmentApi;

    public Task13Adapter(LegacyFulfillmentApi legacyFulfillmentApi) {
        this.legacyFulfillmentApi = legacyFulfillmentApi;
    }

    @Override
    public boolean processOrder(Order order) {
        if (order == null || order.getItems().isEmpty()) {
            return false;
        }
        FulfillmentRequest req = new FulfillmentRequest(order.getId(), order.getCustomerId(), order.getTotalAmount());
        return legacyFulfillmentApi.fulfill(req) == 200;
    }
}