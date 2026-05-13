// Единый интерфейс 
public interface ILogger {
    void logInfo(String message);
    void logWarning(String message);
    void logError(String message);
}

// Адаптеры для конкретных систем
public class FileLoggerAdapter implements ILogger {
    // Внутри вызов методов старой библиотеки
    public void logInfo(String msg) { /* ... */ }
    public void logWarning(String msg) { /* ... */ }
    public void logError(String msg) { /* ... */ }
}

public class CloudLoggerAdapter implements ILogger {
    // Внутри вызов методов Cloud SDK
    public void logInfo(String msg) { /* ... */ }
    public void logWarning(String msg) { /* ... */ }
    public void logError(String msg) { /* ... */ }
}

// Фабрика для выбора реализации
public class LoggerFactory {
    public static ILogger getLogger(String type) {
        if ("CLOUD".equalsIgnoreCase(type)) return new CloudLoggerAdapter();
        return new FileLoggerAdapter();
    }
}
