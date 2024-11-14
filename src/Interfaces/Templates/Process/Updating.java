package Interfaces.Templates.Process;

import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

public class Updating extends javax.swing.JPanel {

    private final MouseListener ml;
    /**
     * Creates new form DirectoryConfiguration
     */
    public Updating(MouseListener ml) {
        initComponents();
        this.ml = ml;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpbProgresoActualizacion = new javax.swing.JProgressBar();
        btnComenzarActualizacion = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lblEstadoProgreso = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(244, 244, 244));

        jpbProgresoActualizacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jpbProgresoActualizacion.setForeground(new java.awt.Color(0, 143, 90));
        jpbProgresoActualizacion.setDoubleBuffered(true);

        btnComenzarActualizacion.setText("Comenzar");
        btnComenzarActualizacion.setDoubleBuffered(true);
        btnComenzarActualizacion.setFocusPainted(false);
        btnComenzarActualizacion.setName("Updating - StartUpdate"); // NOI18N
        btnComenzarActualizacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnComenzarActualizacionMouseClicked(evt);
            }
        });

        lblEstadoProgreso.setEditable(false);
        lblEstadoProgreso.setBackground(new java.awt.Color(244, 244, 244));
        lblEstadoProgreso.setColumns(20);
        lblEstadoProgreso.setLineWrap(true);
        lblEstadoProgreso.setRows(5);
        lblEstadoProgreso.setText("Estado: Listo para iniciar");
        lblEstadoProgreso.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        lblEstadoProgreso.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblEstadoProgreso.setDoubleBuffered(true);
        lblEstadoProgreso.setFocusable(false);
        lblEstadoProgreso.setOpaque(false);
        jScrollPane1.setViewportView(lblEstadoProgreso);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 294, Short.MAX_VALUE)
                        .addComponent(btnComenzarActualizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 294, Short.MAX_VALUE))
                    .addComponent(jpbProgresoActualizacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(167, Short.MAX_VALUE)
                .addComponent(jpbProgresoActualizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(btnComenzarActualizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnComenzarActualizacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnComenzarActualizacionMouseClicked
        if(btnComenzarActualizacion.getText().equals("Comenzar") && JOptionPane.showConfirmDialog(this, "El proceso de actualización está por comenzar, algunas de las opciones\nse desactivarán para llevar acabo el proceso de actualización.\n\n                 ¿estás seguro de querer seguir adelante?", "Comenzando proceso de actualización...", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION){
            ml.mouseClicked(evt);
            update();
        } else if(btnComenzarActualizacion.getText().equals("Terminar")) {
            ml.mouseClicked(evt);
        }
    }//GEN-LAST:event_btnComenzarActualizacionMouseClicked

    private void update(){
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                startUpdate();
                return null;
            }

            @Override
            protected void done() {
                updateProgressBar(0, "Finalizando proceso proceso de actualización");
                btnComenzarActualizacion.setEnabled(true);
                btnComenzarActualizacion.setText("Terminar");
                btnComenzarActualizacion.setName("Updating - EndProcess");
                updateProgressBar(
                        100, 
                        String.format(
                                "Proceso de actualización terminado.\nSe movieron un total de %s archivos", 
                                   String.valueOf(Classes.Core.App.Cache.getTotalMovedFiles())
                ));
                if(Classes.Core.App.Cache.getTotalUnMovedFiles() != 0) {
                    JOptionPane.showMessageDialog(
                            null, 
                            String.format("Hubieron %s que no pudieron ser movidos\nverifique la consola para más información", String.valueOf(Classes.Core.App.Cache.getTotalUnMovedFiles())), 
                        "Operación terminada con erroreres",
                            JOptionPane.WARNING_MESSAGE
                    );
                    System.exit(-1);
                }
            }
        };
        worker.execute();
    }
    
    private void startUpdate() {
        updateProgressBar(0, "Preparando interfaz");
        btnComenzarActualizacion.setText("Actualizando");
        btnComenzarActualizacion.setEnabled(false);
        updateProgressBar(100, "Interfaz actualizada");   
        Classes.Core.IO.Files.moveFiles(jpbProgresoActualizacion, lblEstadoProgreso);
    }
    
    public void updateProgressBar(int num, String message) {
        jpbProgresoActualizacion.setValue(num);
        jpbProgresoActualizacion.setStringPainted(true);
        lblEstadoProgreso.setText(String.format("Estado de actualización: %s", message));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComenzarActualizacion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JProgressBar jpbProgresoActualizacion;
    private javax.swing.JTextArea lblEstadoProgreso;
    // End of variables declaration//GEN-END:variables
}
