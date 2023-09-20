package universidad.vistas;

import java.sql.Date;
import java.time.ZoneId;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
import universidad.entidades.Alumno;

/**
 *
 * @author Grupo 61
 */
public class EdicionDeAlumno extends javax.swing.JInternalFrame {

    private final DefaultTableModel modelo = new DefaultTableModel() {

        @Override
        public boolean isCellEditable(int f, int c) {

            return false;
        }
    };

    public EdicionDeAlumno() {

        initComponents();
        armarTabla();
        cargarDatos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JBEditar = new javax.swing.JButton();
        jTFDni = new javax.swing.JTextField();
        jTFApellido = new javax.swing.JTextField();
        jTFNombre = new javax.swing.JTextField();
        jDCCalendario = new com.toedter.calendar.JDateChooser();
        jBSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(500, 500));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Documento:");

        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Apellido:");

        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Nombre:");

        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Fecha de Nac:");

        JBEditar.setBackground(new java.awt.Color(51, 51, 51));
        JBEditar.setForeground(new java.awt.Color(204, 204, 204));
        JBEditar.setText("Editar");
        JBEditar.setPreferredSize(new java.awt.Dimension(90, 32));
        JBEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEditarActionPerformed(evt);
            }
        });

        jTFDni.setBackground(new java.awt.Color(102, 102, 102));
        jTFDni.setForeground(new java.awt.Color(255, 255, 255));

        jTFApellido.setBackground(new java.awt.Color(102, 102, 102));
        jTFApellido.setForeground(new java.awt.Color(255, 255, 255));

        jTFNombre.setBackground(new java.awt.Color(102, 102, 102));
        jTFNombre.setForeground(new java.awt.Color(255, 255, 255));

        jDCCalendario.setBackground(new java.awt.Color(51, 51, 51));
        jDCCalendario.setForeground(new java.awt.Color(0, 0, 0));

        jBSalir.setBackground(new java.awt.Color(51, 51, 51));
        jBSalir.setForeground(new java.awt.Color(204, 204, 204));
        jBSalir.setText("Salir");
        jBSalir.setPreferredSize(new java.awt.Dimension(90, 32));
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Edición de Alumno");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 20, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(JBEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFDni, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTFApellido)
                            .addComponent(jTFNombre)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jDCCalendario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(108, 108, 108)))))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTFDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTFApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDCCalendario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed

        dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        if (jTable1.getSelectedRow() == -1) {

            JOptionPane.showMessageDialog(this, "Seleccione un contacto que quiera editar");
            return;
        }

        int filaSelec = jTable1.getSelectedRow();
        String dni = (String) modelo.getValueAt(filaSelec, 1);
        String apellido = (String) modelo.getValueAt(filaSelec, 2);
        String nombre = (String) modelo.getValueAt(filaSelec, 3);
        String FN = (String) modelo.getValueAt(filaSelec, 4);
        jTFDni.setText(dni);
        jTFApellido.setText(apellido);
        jTFNombre.setText(nombre);
        jDCCalendario.setDate(Date.valueOf(FN));
    }//GEN-LAST:event_jTable1MouseClicked


    private void JBEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEditarActionPerformed

        if (jTFNombre.getText().isEmpty() || jTFApellido.getText().isEmpty() || jTFDni.getText().isEmpty() || jDCCalendario.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Ningun casillero debe estar vacio");
            return;
        }

        if (jTable1.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un contacto que quiera editar");
            return;
        }

        try {
            
            int filaSelec = jTable1.getSelectedRow();
            Alumno al = Vista.getAD().buscarAlumnoPorDni(Integer.parseInt((String) modelo.getValueAt(filaSelec, 1)));
            al.setDni(Integer.parseInt(jTFDni.getText()));
            al.setApellido(jTFApellido.getText());
            al.setNombre(jTFNombre.getText());
            al.setfN(jDCCalendario.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            int registro = Vista.getAD().editarAlumno(al);
            if (registro > 0) {
                
                JOptionPane.showMessageDialog(this, "Datos actualizados");
            } else {
                
                JOptionPane.showMessageDialog(this, "No se pudo actualizar los datos. \nEl dni está en uso");
            }

            limpiarTabla();
            cargarDatos();
        } catch (NumberFormatException e) {
            
            JOptionPane.showMessageDialog(this, "En la casilla de Dni solo deben ir numeros");
        }
        limpiar();
    }//GEN-LAST:event_JBEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBEditar;
    private javax.swing.JButton jBSalir;
    private com.toedter.calendar.JDateChooser jDCCalendario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFApellido;
    private javax.swing.JTextField jTFDni;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    
    private void armarTabla() {
        
        modelo.addColumn("ID");
        modelo.addColumn("DNI");
        modelo.addColumn("Apellido");
        modelo.addColumn("Nombre");
        modelo.addColumn("Fecha de Nacimiento");
        jTable1.setModel(modelo);
    }

    private void cargarDatos() {
        
        ArrayList<Alumno> ListaDeAlumnos = Vista.getAD().listarAlumnos();
        for (Alumno next : ListaDeAlumnos) {
            cargarTabla(next);
        }
    }

    private void cargarTabla(Alumno al) {

        modelo.addRow(new Object[]{
            al.getId(),
            Integer.toString(al.getDni()),
            al.getApellido(),
            al.getNombre(),
            al.getfN().toString()
        });
    }

    public void limpiar() {
        
        jTFDni.setText("");
        jTFApellido.setText("");
        jTFNombre.setText("");
        jDCCalendario.setDate(null);
    }

    private void limpiarTabla() {
        
        int filas = modelo.getRowCount() - 1;
        for (int i = filas; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }
}
