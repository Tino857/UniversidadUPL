/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.vistas;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import universidad.entidades.Alumno;
import universidad.entidades.Inscripcion;
/**
 *
 * @author user
 */
public class ManejoDeNotas extends javax.swing.JInternalFrame {
    

    private DefaultTableModel modelo = new DefaultTableModel(){
    
        @Override
        public boolean isCellEditable (int f, int c){
            return false;
        }
    };
    
    public ManejoDeNotas() {
        initComponents();
        cargarCB();
        armarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLNota = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTFNota = new javax.swing.JTextField();
        jCBAlumnos = new javax.swing.JComboBox<>();
        jBSalir = new javax.swing.JButton();
        jBGuardar = new javax.swing.JButton();

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

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Manipulacion de notas");

        jLNota.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLNota.setText("Ingrese la nueva nota");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Seleccione un alumno:");

        jCBAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBAlumnosActionPerformed(evt);
            }
        });

        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jCBAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jBGuardar)
                        .addGap(172, 172, 172)
                        .addComponent(jBSalir)
                        .addGap(78, 78, 78))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLNota)
                        .addGap(18, 18, 18)
                        .addComponent(jTFNota, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCBAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNota)
                    .addComponent(jTFNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBGuardar)
                    .addComponent(jBSalir))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCBAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBAlumnosActionPerformed
        limpiarTabla();
        Alumno al = (Alumno) jCBAlumnos.getSelectedItem();
        cargarDatos(al.getId());
    }//GEN-LAST:event_jCBAlumnosActionPerformed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        if (jTFNota.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "La casilla Nota no puede estar vacia");
            return;
        }
        if (jCBAlumnos.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una materia");
            return;
        }if (jTable1.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una materia en la que quiera actualizar la nota.");
            return; 
        }
        try {
            Alumno alu = (Alumno)jCBAlumnos.getSelectedItem();
            int fila = jTable1.getSelectedRow();
            int idMateria =Integer.parseInt((String)modelo.getValueAt(fila , 0));
            double nota = Double.parseDouble(jTFNota.getText());
            int registro = Vista.getID().actualizarNota(alu.getId(), idMateria, nota);
            
            if (registro > 0) {
                JOptionPane.showMessageDialog(this, "La nota se cargo correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo cargar la nota");
            }
            
            limpiarTabla();
            cargarDatos(alu.getId());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El campo nota solo admite números");
        }
    }//GEN-LAST:event_jBGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBSalir;
    private javax.swing.JComboBox<Alumno> jCBAlumnos;
    private javax.swing.JLabel jLNota;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFNota;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
   
    private void cargarCB() {
        ArrayList<Alumno> Lista = Vista.getAD().listarAlumnos();
        for (Iterator<Alumno> iterator = Lista.iterator(); iterator.hasNext();) {
            Alumno al = iterator.next();
            jCBAlumnos.addItem(al);
        }
    }
    private void armarTabla() {
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Nota");
        jTable1.setModel(modelo);
    }
    
    private void cargarTabla(Inscripcion insc) {
        modelo.addRow(new Object[]{
            insc.getIdMateria()+"",
            insc.getMateria().getNombre(),
            Double.toString(insc.getNota())
        });   
    }
    
    private void limpiarTabla(){
        int fila=modelo.getRowCount()-1;
        for (int i = fila; i >=0; i--) {
            modelo.removeRow(i);
        }
    }
    
    private void cargarDatos(int id){
        ArrayList <Inscripcion> lista = Vista.getID().listarInscripcionesPorAlumno(id);
        for (Inscripcion inscripcion : lista) {
            cargarTabla(inscripcion);
        } 
    }

}
