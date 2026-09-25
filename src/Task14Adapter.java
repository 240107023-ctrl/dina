public class Task14Adapter implements GeoLocationService {
    private final LegacyCoordinateTracker tracker;

    public Task14Adapter(LegacyCoordinateTracker tracker) {
        this.tracker = tracker;
    }

    @Override
    public Location getCurrentLocation(String deviceId) {
        double[] coords = tracker.getCoordinates(deviceId);
        if (coords == null || coords.length < 2) {
            return new Location(0.0, 0.0);
        }
        return new Location(coords[0], coords[1]);
    }
}