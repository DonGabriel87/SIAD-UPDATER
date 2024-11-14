package Classes.Core.Utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Time {
    public static String getCurrentTime() {
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss.SSS");
        return fechaHoraActual.format(formato);
    }
}