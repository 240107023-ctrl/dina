public class Task02Adapter implements ITemperatureSensor {
    private final LegacyFahrenheitSensor legacySensor;

    public Task02Adapter(LegacyFahrenheitSensor legacySensor) {
        this.legacySensor = legacySensor;
    }

    @Override
    public double getTemperatureInCelsius() {
        double fahrenheit = legacySensor.readFahrenheit();
        return (fahrenheit - 32.0) * 5.0 / 9.0;
    }
}