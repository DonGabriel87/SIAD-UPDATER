package Classes.Core.Utilities;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class ClipboardUtil {

    /**
     * Copea una cadena de texto al portapapeles del usuario
     * @param text 
     * Cadena de texto que se requiera copiar
     */
    public static void copyTextToClipboard(String text) {
        // Crear un objeto StringSelection con el texto a copiar
        StringSelection stringSelection = new StringSelection(text);
        
        // Obtener el portapapeles del sistema
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        
        // Establecer el contenido del portapapeles con el texto
        clipboard.setContents(stringSelection, null);
    } 
}
