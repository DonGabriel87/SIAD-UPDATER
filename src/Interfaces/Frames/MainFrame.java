package Interfaces.Frames;

import Classes.UI.Java2D.JGlassPanelPopUp.DefaultOption;
import Classes.UI.Java2D.JGlassPanelPopUp.JGlassPanePopup;
import Interfaces.Templates.InfoTemplate;
import Interfaces.Templates.StartUpTemplate;
import Interfaces.Templates.WorkFlowTemplate;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainFrame extends javax.swing.JFrame implements MouseListener {

    public MainFrame() {
        initComponents();
        JGlassPanePopup.install(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContenedor = new javax.swing.JPanel();
        panelInferior = new javax.swing.JPanel();
        pbImagen = new Classes.UI.Java2D.JPictureBox.JPictureBox();
        lblNombrePrograma = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIAD-UPDATER V 0.8.1");
        setBackground(new java.awt.Color(204, 132, 217));
        setMinimumSize(new java.awt.Dimension(616, 411));
        setName("MainFrame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1014, 524));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panelContenedor.setBackground(new java.awt.Color(0, 0, 0));
        panelContenedor.setName("Empty"); // NOI18N
        panelContenedor.setLayout(new java.awt.BorderLayout());
        getContentPane().add(panelContenedor, java.awt.BorderLayout.CENTER);

        panelInferior.setBackground(new java.awt.Color(255, 255, 255));
        panelInferior.setPreferredSize(new java.awt.Dimension(843, 65));
        panelInferior.setLayout(new java.awt.BorderLayout());

        pbImagen.setImage(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/icono-cfe.png"))); // NOI18N
        pbImagen.setMode(Classes.UI.Java2D.JPictureBox.JPictureBox.JPictureBoxSizeMode.AUTO);
        pbImagen.setPreferredSize(new java.awt.Dimension(100, 50));
        panelInferior.add(pbImagen, java.awt.BorderLayout.WEST);

        lblNombrePrograma.setFont(new java.awt.Font("Eras Demi ITC", 0, 24)); // NOI18N
        lblNombrePrograma.setForeground(new java.awt.Color(80, 80, 80));
        lblNombrePrograma.setText("SIAD-UPDATER V 0.8.1");
        panelInferior.add(lblNombrePrograma, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelInferior, java.awt.BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Classes.Core.Utilities.JPanelUtilities.openJPanelOnPanel(panelContenedor, new StartUpTemplate(this));
    }//GEN-LAST:event_formWindowOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblNombrePrograma;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelInferior;
    private Classes.UI.Java2D.JPictureBox.JPictureBox pbImagen;
    // End of variables declaration//GEN-END:variables

    // Código de la clase MouseListener

    /**
     *
     * @param me
     */
    @Override
    public void mouseClicked(MouseEvent me) {
        switch (me.getComponent().getName()) {
            case "StartUpTemplate - Comenzar":
                Classes.Core.App.Cache.disposeData();
                JGlassPanePopup.showPopup(new WorkFlowTemplate(), new DefaultOption() {
                    @Override
                    public boolean closeWhenClickOutside() {
                        return false;
                    }
                }, "WorkFlow");
                break;
            case "StartUpTemplate - Info":
                JGlassPanePopup.showPopup(new InfoTemplate(), "Info");
                break;
            default:
                throw new AssertionError();
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        // Unused code
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        // Unused code
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        // Unused code
    }

    @Override
    public void mouseExited(MouseEvent me) {
        // Unused code
    }
}
