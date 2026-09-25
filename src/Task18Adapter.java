public class Task18Adapter implements InventoryTracker {
    private final LegacyWarehouseDb warehouseDb;

    public Task18Adapter(LegacyWarehouseDb warehouseDb) {
        this.warehouseDb = warehouseDb;
    }

    @Override
    public int getAvailableStock(String sku) {
        Integer stock = warehouseDb.lookupStock(sku);
        return stock != null ? stock : 0;
    }
}