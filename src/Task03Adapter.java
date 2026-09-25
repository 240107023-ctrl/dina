import java.util.Objects;

public class Task03Adapter implements ModernLogger {
    private final OldLogger oldLogger;

    public Task03Adapter(OldLogger oldLogger) {
        this.oldLogger = oldLogger;
    }

    @Override
    public void log(LogLevel level, String message) {
        Objects.requireNonNull(level, "LogLevel cannot be null");
        String formattedMessage = String.format("[%s] %s", level.name(), message == null ? "" : message);
        oldLogger.writeLog(formattedMessage);
    }
}