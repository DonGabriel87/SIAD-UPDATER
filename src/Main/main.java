package Main;

import Interfaces.Frames.MainFrame;
import java.io.OutputStream;
import java.io.PrintStream;
import static java.lang.System.setErr;
import java.util.prefs.Preferences;
import static java.util.prefs.Preferences.systemRoot;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class main {

    /**
     * Método principal para validar el arranque de la aplicación
     *
     * @param args
     *
     */
    public static void main(String[] args) {
        if (!isUserMachineWindows()) {
            JOptionPane.showMessageDialog(
                    null, 
                    "SIAD-UPDATER no está disponible para otros sistemas operativos diferentes a Windows.", 
                    "SIAD-UPDATER - Sin compatibilidad", 
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Comentar en caso de que se hagan validaciones de la herramienta en casos de pruebas.
        if (!isProgramRunningWithAdminPrivileges()) {
            JOptionPane.showMessageDialog(
                    null,
                    "En orden de poder hacer modificación cerca del nivel raíz del disco\n"
                    + "son necesarios permisos de administrador, si requiere usar este sofware\n"
                    + "ejecute esta herramienta como administrador.",
                    "Privilegios insuficientes",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Windows".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            // O usa otra opción como Nimbus
//    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }

    /**
     * Valida si la aplicación está corriendo dentro de una máquina windows
     *
     * @return
     */
    private static boolean isUserMachineWindows() {
        String os = System.getProperty("os.name").toLowerCase();
        return os.contains("win");
    }

    /**
     * Valida si el proceso actual esta corriendo intentando escribir una preferencia llamada
     * foo con una cadena dentro de la raíz del sistema y verifica si hay permisos de edición.
     *
     * @return Devuelve el resultado boleano de la operación
     */
    private static boolean isProgramRunningWithAdminPrivileges() {
        Preferences preferences = systemRoot();

        synchronized (System.err) {
            setErr(new PrintStream(new OutputStream() {
                @Override
                public void write(int b) {
                }
            }));

            try {
                preferences.put("foo", "bar"); // SecurityException on Windows
                preferences.remove("foo");
                preferences.flush(); // BackingStoreException on Linux
                return true;
            } catch (Exception exception) {
                return false;
            } finally {
                setErr(System.err);
            }
        }
    }

}
