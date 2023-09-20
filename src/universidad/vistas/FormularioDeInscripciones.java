package universidad.vistas;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import universidad.entidades.Alumno;
import universidad.entidades.Inscripcion;
import universidad.entidades.Materia;

/**
 *
 * @author Grupo 61
 */
public class FormularioDeInscripciones extends javax.swing.JInternalFrame {

    private final DefaultTableModel modelo = new DefaultTableModel() {

        @Override
        public boolean isCellEditable(int f, int c) {

            return false;
        }
    };

    public FormularioDeInscripciones() {

        initComponents();
        cargarCB();
        armarTabla();
        jTFNota.setEditable(false);
        jTFNota.setVisible(false);
        jLNota.setVisible(false);
        jBAnular.setEnabled(false);
        jBInscribir.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bG = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jCBAlumnos = new javax.swing.JComboBox<>();
        jBSalir = new javax.swing.JButton();
        jBAnular = new javax.swing.JButton();
        jBInscribir = new javax.swing.JButton();
        jRBNoInscriptas = new javax.swing.JRadioButton();
        jRBInscriptas = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLNota = new javax.swing.JLabel();
        jTFNota = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(500, 500));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Seleccione un alumno:");

        jCBAlumnos.setBackground(new java.awt.Color(51, 51, 51));
        jCBAlumnos.setForeground(new java.awt.Color(255, 255, 255));
        jCBAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBAlumnosActionPerformed(evt);
            }
        });

        jBSalir.setBackground(new java.awt.Color(51, 51, 51));
        jBSalir.setForeground(new java.awt.Color(204, 204, 204));
        jBSalir.setText("Salir");
        jBSalir.setPreferredSize(new java.awt.Dimension(90, 32));
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        jBAnular.setBackground(new java.awt.Color(51, 51, 51));
        jBAnular.setForeground(new java.awt.Color(204, 204, 204));
        jBAnular.setText("Anular Inscripcion");
        jBAnular.setPreferredSize(new java.awt.Dimension(140, 32));
        jBAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAnularActionPerformed(evt);
            }
        });

        jBInscribir.setBackground(new java.awt.Color(51, 51, 51));
        jBInscribir.setForeground(new java.awt.Color(204, 204, 204));
        jBInscribir.setText("Inscribir");
        jBInscribir.setPreferredSize(new java.awt.Dimension(90, 32));
        jBInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBInscribirActionPerformed(evt);
            }
        });

        bG.add(jRBNoInscriptas);
        jRBNoInscriptas.setForeground(new java.awt.Color(204, 204, 204));
        jRBNoInscriptas.setText("Materias NO Inscriptas");
        jRBNoInscriptas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRBNoInscriptasMouseClicked(evt);
            }
        });

        bG.add(jRBInscriptas);
        jRBInscriptas.setForeground(new java.awt.Color(204, 204, 204));
        jRBInscriptas.setText("Materias Inscriptas");
        jRBInscriptas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRBInscriptasMouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLNota.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLNota.setForeground(new java.awt.Color(204, 204, 204));
        jLNota.setText("Ingrese la nota:");

        jTFNota.setBackground(new java.awt.Color(102, 102, 102));
        jTFNota.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Formulario de Inscripciones");

        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Listar materias:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCBAlumnos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRBInscriptas)
                                    .addComponent(jRBNoInscriptas))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jBInscribir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBAnular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLNota)
                        .addGap(18, 18, 18)
                        .addComponent(jTFNota, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBInscriptas)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBNoInscriptas)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNota)
                    .addComponent(jTFNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBAnular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBInscribir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRBInscriptasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRBInscriptasMouseClicked

        limpiarTabla();
        Alumno al = (Alumno) jCBAlumnos.getSelectedItem();
        cargarDatos(al.getId());

        jTFNota.setText("");
        jBInscribir.setEnabled(false);
        jBAnular.setEnabled(true);
        jTFNota.setEditable(false);
        jTFNota.setVisible(false);
        jLNota.setVisible(false);
    }//GEN-LAST:event_jRBInscriptasMouseClicked

    private void jRBNoInscriptasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRBNoInscriptasMouseClicked

        limpiarTabla();
        Alumno al = (Alumno) jCBAlumnos.getSelectedItem();
        cargarDatos(al.getId());

        jBInscribir.setEnabled(true);
        jBAnular.setEnabled(false);
        jTFNota.setEditable(true);
        jTFNota.setVisible(true);
        jLNota.setVisible(true);
    }//GEN-LAST:event_jRBNoInscriptasMouseClicked

    private void jBInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBInscribirActionPerformed

        if (jTFNota.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this, "El casillero Nota no debe estar vacio");
            return;
        } else if (jTable1.getSelectedRow() == -1) {

            JOptionPane.showMessageDialog(this, "Seleccione una materia de la tabla");
            return;
        }

        try {

            Alumno al = (Alumno) jCBAlumnos.getSelectedItem();
            int filaS = jTable1.getSelectedRow();
            String nombre = (String) modelo.getValueAt(filaS, 1);
            Materia mat = Vista.getMD().buscarMateriaPorNombre(nombre);
            double nota = Double.parseDouble(jTFNota.getText());
            Inscripcion insc = new Inscripcion(al, mat, nota);
            int registro = Vista.getID().guardarInscripcion(insc);
            if (registro > 0) {

                JOptionPane.showMessageDialog(this, "La inscripcion se realizo con exito");
            } else {

                JOptionPane.showMessageDialog(this, "La inscripcion ya esta realiza");
            }
            limpiarTabla();
            cargarDatos(al.getId());
        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this, "En el casillero nota solo deben ir numeros");
        }

        jTFNota.setText("");
    }//GEN-LAST:event_jBInscribirActionPerformed

    private void jBAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAnularActionPerformed

        if (jTable1.getSelectedRow() == -1) {

            JOptionPane.showMessageDialog(this, "Seleccione una materia de la tabla");
            return;
        }

        try {

            Alumno al = (Alumno) jCBAlumnos.getSelectedItem();
            int filaS = jTable1.getSelectedRow();
            String nombre = (String) modelo.getValueAt(filaS, 1);
            Materia mat = Vista.getMD().buscarMateriaPorNombre(nombre);
            int registro = Vista.getID().borarInscripcionPorMateriaAlumno(al.getId(), mat.getId());
            if (registro > 0) {

                JOptionPane.showMessageDialog(this, "Se borro la inscripcion con exito");
            } else {

                JOptionPane.showMessageDialog(this, "No se pudo realizar esta operacion");
            }
            limpiarTabla();
            cargarDatos(al.getId());
        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this, "En el casillero nota solo deben ir numeros");
        }
    }//GEN-LAST:event_jBAnularActionPerformed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed

        dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jCBAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBAlumnosActionPerformed

        limpiarTabla();
        Alumno al = (Alumno) jCBAlumnos.getSelectedItem();
        cargarDatos(al.getId());
    }//GEN-LAST:event_jCBAlumnosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bG;
    private javax.swing.JButton jBAnular;
    private javax.swing.JButton jBInscribir;
    private javax.swing.JButton jBSalir;
    private javax.swing.JComboBox<Alumno> jCBAlumnos;
    private javax.swing.JLabel jLNota;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRBInscriptas;
    private javax.swing.JRadioButton jRBNoInscriptas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFNota;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void cargarCB() {
        
        ArrayList<Alumno> Lista = Vista.getAD().listarAlumnos();
        for (Alumno al : Lista) {
            jCBAlumnos.addItem(al);
        }
    }

    private void armarTabla() {
        
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Año");
        jTable1.setModel(modelo);
    }

    private void cargarTabla(Materia mat) {
        
        modelo.addRow(new Object[]{
            mat.getId(),
            mat.getNombre(),
            Integer.toString(mat.getAnioMateria()),});
    }

    private void limpiarTabla() {
        
        int fila = modelo.getRowCount() - 1;
        for (int i = fila; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    private void cargarDatos(int id) {
        
        if (jRBInscriptas.isSelected()) {
            
            ArrayList<Materia> Lista = Vista.getID().listarMateriasCursadas(id);
            for (Materia mat : Lista) {
                cargarTabla(mat);
            }
        } else if (jRBNoInscriptas.isSelected()) {
            
            ArrayList<Materia> Lista = Vista.getID().listarMateriasNoCursadas(id);
            for (Materia mat : Lista) {
                cargarTabla(mat);
            }
        }
    }
}
