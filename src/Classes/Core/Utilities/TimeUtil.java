package Classes.Core.Utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class TimeUtil {
    /**
     * Obtiene el tiempo actual del siguiente modo: dd-MM-yyyy HH:mm:ss.SSS
     * @return 
     * Una cadena con el tiempo
     */
    public static String getCurrentTime() {
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss.SSS");
        return fechaHoraActual.format(formato);
    }
}