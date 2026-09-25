import java.util.Map;

public class Task06Adapter implements MetricConverter {
    private final ImperialMeasurer imperialMeasurer;

    public Task06Adapter(ImperialMeasurer imperialMeasurer) {
        this.imperialMeasurer = imperialMeasurer;
    }

    @Override
    public double convertToMeters(Map<String, Object> imperialData) {
        if (imperialData == null) {
            throw new IllegalArgumentException("Imperial data map cannot be null");
        }
        double feet = imperialData.containsKey("feet") ? ((Number) imperialData.get("feet")).doubleValue() : 0.0;
        double inches = imperialData.containsKey("inches") ? ((Number) imperialData.get("inches")).doubleValue() : 0.0;
        double totalInches = (feet * 12.0) + inches;
        return totalInches * 0.0254;
    }
}