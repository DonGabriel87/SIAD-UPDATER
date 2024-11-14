package Interfaces.Templates;

import Classes.Core.App.Cache;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import Classes.UI.Java2D.JGlassPanelPopUp.JGlassPanePopup;
import Interfaces.Templates.Process.Home;
import Interfaces.Templates.Process.DirectorySelection;
import Interfaces.Templates.Process.DirectoryOverview;
import Interfaces.Templates.Process.Updating;
import Interfaces.Templates.Process.End;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class WorkFlowTemplate extends javax.swing.JPanel implements MouseListener {

    private final Component[] components;

    /**
     * Creates new form WorkFlowTemplate
     */
    public WorkFlowTemplate() {
        initComponents();
        indicadorAvance.setProgress(0);
        this.components = new Component[]{new Home(), new DirectorySelection(), new DirectoryOverview(), new Updating(this), new End()};
        panelContenedor.setSliderComponent(components);
        indicadorAvance.initSlider(panelContenedor);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics.create();
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setColor(getBackground());
        graphics2D.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 10, 10));
        graphics2D.dispose();
        super.paintComponent(graphics);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSuperior = new javax.swing.JPanel();
        indicadorAvance = new Classes.UI.Java2D.JProgressIndicator.JProgressIndicator();
        panelIzquierda = new javax.swing.JPanel();
        panelDerecha = new javax.swing.JPanel();
        panelInferior = new javax.swing.JPanel();
        btnSiguiente = new Classes.UI.Java2D.JCustomButtom.JCustomButton();
        btnAtras = new Classes.UI.Java2D.JCustomButtom.JCustomButton();
        btnCancelar = new Classes.UI.Java2D.JCustomButtom.JCustomButton();
        panelContenedor = new Classes.UI.Java2D.JPanelSlider.JPanelSlider();

        setBackground(new java.awt.Color(244, 244, 244));
        setMinimumSize(new java.awt.Dimension(980, 454));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(980, 454));
        setLayout(new java.awt.BorderLayout());

        panelSuperior.setBackground(new java.awt.Color(244, 244, 244));
        panelSuperior.setPreferredSize(new java.awt.Dimension(972, 100));

        indicadorAvance.setDoubleBuffered(true);
        indicadorAvance.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Inicio", "Selección de directorios", "Vista directorios", "Actualizando", "Fin" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        indicadorAvance.setOpaque(false);
        indicadorAvance.setProgressColor(new java.awt.Color(51, 51, 51));
        indicadorAvance.setProgressColorGradient(new java.awt.Color(0, 143, 90));
        indicadorAvance.setProgressFill(true);
        indicadorAvance.setProgressFont(new java.awt.Font("Eras Demi ITC", 1, 17)); // NOI18N

        javax.swing.GroupLayout panelSuperiorLayout = new javax.swing.GroupLayout(panelSuperior);
        panelSuperior.setLayout(panelSuperiorLayout);
        panelSuperiorLayout.setHorizontalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSuperiorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(indicadorAvance, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        panelSuperiorLayout.setVerticalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSuperiorLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(indicadorAvance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        add(panelSuperior, java.awt.BorderLayout.NORTH);

        panelIzquierda.setBackground(new java.awt.Color(244, 244, 244));
        panelIzquierda.setPreferredSize(new java.awt.Dimension(20, 567));

        javax.swing.GroupLayout panelIzquierdaLayout = new javax.swing.GroupLayout(panelIzquierda);
        panelIzquierda.setLayout(panelIzquierdaLayout);
        panelIzquierdaLayout.setHorizontalGroup(
            panelIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        panelIzquierdaLayout.setVerticalGroup(
            panelIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        add(panelIzquierda, java.awt.BorderLayout.WEST);

        panelDerecha.setBackground(new java.awt.Color(244, 244, 244));
        panelDerecha.setPreferredSize(new java.awt.Dimension(20, 567));

        javax.swing.GroupLayout panelDerechaLayout = new javax.swing.GroupLayout(panelDerecha);
        panelDerecha.setLayout(panelDerechaLayout);
        panelDerechaLayout.setHorizontalGroup(
            panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        panelDerechaLayout.setVerticalGroup(
            panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        add(panelDerecha, java.awt.BorderLayout.EAST);

        panelInferior.setBackground(new java.awt.Color(244, 244, 244));
        panelInferior.setPreferredSize(new java.awt.Dimension(20, 75));

        btnSiguiente.setBackground(new java.awt.Color(0, 143, 90));
        btnSiguiente.setForeground(new java.awt.Color(250, 250, 250));
        btnSiguiente.setText("Siguiente");
        btnSiguiente.setFocusPainted(false);
        btnSiguiente.setFont(new java.awt.Font("Eras Demi ITC", 0, 16)); // NOI18N
        btnSiguiente.setRippleColor(new java.awt.Color(0, 66, 41));
        btnSiguiente.setShadowColor(new java.awt.Color(0, 143, 90));
        btnSiguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSiguienteMouseClicked(evt);
            }
        });

        btnAtras.setText("Atrás");
        btnAtras.setFocusPainted(false);
        btnAtras.setFont(new java.awt.Font("Eras Demi ITC", 0, 16)); // NOI18N
        btnAtras.setRippleColor(new java.awt.Color(153, 153, 153));
        btnAtras.setShadowColor(new java.awt.Color(0, 0, 0));
        btnAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtrasMouseClicked(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(204, 204, 204));
        btnCancelar.setText("Cancelar");
        btnCancelar.setFocusPainted(false);
        btnCancelar.setFont(new java.awt.Font("Eras Demi ITC", 0, 16)); // NOI18N
        btnCancelar.setRippleColor(new java.awt.Color(51, 51, 51));
        btnCancelar.setShadowColor(new java.awt.Color(0, 0, 0));
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelInferiorLayout = new javax.swing.GroupLayout(panelInferior);
        panelInferior.setLayout(panelInferiorLayout);
        panelInferiorLayout.setHorizontalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInferiorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 574, Short.MAX_VALUE)
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        panelInferiorLayout.setVerticalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInferiorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        add(panelInferior, java.awt.BorderLayout.SOUTH);

        panelContenedor.setBackground(new java.awt.Color(244, 244, 244));
        add(panelContenedor, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        JGlassPanePopup.closePopup("WorkFlow");
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseClicked
        indicadorAvance.previous();
        if(btnSiguiente.getBackground() != new Color(0,143,90)) {
            btnSiguiente.setBackground(new Color(0, 143, 90));
            btnSiguiente.setShadowColor(new Color(0,143,90));
            btnSiguiente.setRippleColor(new Color(0,66,41));
        }
    }//GEN-LAST:event_btnAtrasMouseClicked

    private void btnSiguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSiguienteMouseClicked
        switch (indicadorAvance.getProgressIndex()) {
            case 1:
                validatePathsDirectorySelection();
                break;
            case 2:
                btnSiguiente.setBackground(new Color(51, 51, 51));
                btnSiguiente.setShadowColor(Color.BLACK);
                btnSiguiente.setRippleColor(new Color(51,51,51));
                indicadorAvance.next();
                break;
            case 3:
                break;
            default:
                indicadorAvance.next();
        }
    }//GEN-LAST:event_btnSiguienteMouseClicked

    private void validatePathsDirectorySelection() {
        if (Cache.getOripath() == null || Cache.getDespath() == null) {
            JOptionPane.showMessageDialog(
                    this, 
                       "Es necesario que rellenes todos los campos que se te piden",
                       "Tareas pendientes",
                       JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }
        if(!Classes.Core.IO.Files.isValidDestination(Cache.getOripath(), Cache.getDespath())) {
            JOptionPane.showMessageDialog(
                    this, 
                       "No es posible mover archivos entre directorios que tengan relación directa o que sean subdirectorios uno del otro",
                       "Delimitación de directorios no controlada",
                       JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        indicadorAvance.next();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Classes.UI.Java2D.JCustomButtom.JCustomButton btnAtras;
    private Classes.UI.Java2D.JCustomButtom.JCustomButton btnCancelar;
    private Classes.UI.Java2D.JCustomButtom.JCustomButton btnSiguiente;
    private Classes.UI.Java2D.JProgressIndicator.JProgressIndicator indicadorAvance;
    private Classes.UI.Java2D.JPanelSlider.JPanelSlider panelContenedor;
    private javax.swing.JPanel panelDerecha;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JPanel panelIzquierda;
    private javax.swing.JPanel panelSuperior;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent me) {
        switch (me.getComponent().getName()) {
            case "Updating - StartUpdate":
                panelInferior.setVisible(false);
                break;
            case "Updating - EndProcess":
                indicadorAvance.next();
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
