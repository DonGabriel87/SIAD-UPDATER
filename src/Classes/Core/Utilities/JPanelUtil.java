package Classes.Core.Utilities;

import java.awt.BorderLayout;
import javax.swing.JPanel;

public abstract class JPanelUtil {
    /**
     * Añade un JPanel dentro de otro
     * @param parentPanel
     * Recibe como parámetro la instancia del JPanel para mostrarla dentro del panel contenedor
     * @param childPanel 
     * Recibe como parámetro la instancia del JPanel hijo para colocarla dentro del panel padre
     * 
     */
    public static void openJPanelOnPanel(JPanel parentPanel, JPanel childPanel) {
        if (parentPanel.getName().equals(childPanel.getName())) {
            return;
        }
        //Coloca las propiedades antes de poder mostrarlo
        childPanel.setSize(parentPanel.getWidth(), parentPanel.getHeight());
        childPanel.setPreferredSize(parentPanel.getPreferredSize());
        childPanel.setLocation(0, 0);
        childPanel.setDoubleBuffered(true);
        JPanel jpanelChild = childPanel;

        //Quita los controles anteriores en caso de que haya alguno
        parentPanel.removeAll();
        parentPanel.add(jpanelChild, BorderLayout.CENTER);
        parentPanel.setName(childPanel.getName());
        parentPanel.revalidate();
        parentPanel.repaint();
    }
}
