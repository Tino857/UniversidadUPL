package universidad.vistas;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import universidad.accesoADatos.ValidarData;
import universidad.entidades.Alumno;
import universidad.entidades.Inscripcion;
import universidad.entidades.Materia;

/**
 *
 * @author Grupo 61
 */
public class FormularioDeInscripciones extends javax.swing.JInternalFrame {

    //Se crea el modelo que usaremos en la tabla, y se impide que se puedan modificar los valores de las celdas
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
        jCBAlumnos.setSelectedIndex(0);
        jRBInscriptas.setSelected(true);
        cambiarVisibilidad();
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
        ImageIcon icon = new ImageIcon(getClass().getResource("/universidad/imagenes/WindowBackground.png"));
        Image image = icon.getImage();
        jPanel1 = new javax.swing.JPanel(){

            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
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
        jLabel3 = new javax.swing.JLabel();
        jLPCabecera = new javax.swing.JLayeredPane();
        jLMargen = new javax.swing.JLabel();
        jLTitulo = new javax.swing.JLabel();
        jLLogo = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(500, 500));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setForeground(new java.awt.Color(235, 235, 235));
        jLabel2.setText("Seleccione un alumno:");

        jCBAlumnos.setBackground(new java.awt.Color(51, 51, 51));
        jCBAlumnos.setForeground(new java.awt.Color(255, 255, 255));
        jCBAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBAlumnosActionPerformed(evt);
            }
        });

        jBSalir.setBackground(new java.awt.Color(51, 51, 51));
        jBSalir.setForeground(new java.awt.Color(235, 235, 235));
        jBSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidad/imagenes/salir-w.png"))); // NOI18N
        jBSalir.setText("Salir");
        jBSalir.setIconTextGap(10);
        jBSalir.setPreferredSize(new java.awt.Dimension(100, 32));
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        jBAnular.setBackground(new java.awt.Color(51, 51, 51));
        jBAnular.setForeground(new java.awt.Color(235, 235, 235));
        jBAnular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidad/imagenes/cancelar-c.png"))); // NOI18N
        jBAnular.setText("Anular");
        jBAnular.setIconTextGap(10);
        jBAnular.setPreferredSize(new java.awt.Dimension(110, 32));
        jBAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAnularActionPerformed(evt);
            }
        });

        jBInscribir.setBackground(new java.awt.Color(51, 51, 51));
        jBInscribir.setForeground(new java.awt.Color(235, 235, 235));
        jBInscribir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidad/imagenes/aceptar-c.png"))); // NOI18N
        jBInscribir.setText("Inscribir");
        jBInscribir.setIconTextGap(10);
        jBInscribir.setPreferredSize(new java.awt.Dimension(110, 32));
        jBInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBInscribirActionPerformed(evt);
            }
        });

        bG.add(jRBNoInscriptas);
        jRBNoInscriptas.setForeground(new java.awt.Color(235, 235, 235));
        jRBNoInscriptas.setText("Materias NO Inscriptas");
        jRBNoInscriptas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRBNoInscriptasMouseClicked(evt);
            }
        });

        bG.add(jRBInscriptas);
        jRBInscriptas.setForeground(new java.awt.Color(235, 235, 235));
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
        jLNota.setForeground(new java.awt.Color(235, 235, 235));
        jLNota.setText("Ingrese la nota:");

        jTFNota.setBackground(new java.awt.Color(102, 102, 102));
        jTFNota.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setForeground(new java.awt.Color(235, 235, 235));
        jLabel3.setText("Listar materias:");

        jLTitulo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLTitulo.setForeground(new java.awt.Color(235, 235, 235));
        jLTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLTitulo.setText("FORMULARIO DE INSCRIPCIONES");

        jLLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidad/imagenes/LogoULP3-w.png"))); // NOI18N

        jLPCabecera.setLayer(jLMargen, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLPCabecera.setLayer(jLTitulo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLPCabecera.setLayer(jLLogo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLPCabeceraLayout = new javax.swing.GroupLayout(jLPCabecera);
        jLPCabecera.setLayout(jLPCabeceraLayout);
        jLPCabeceraLayout.setHorizontalGroup(
            jLPCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLPCabeceraLayout.createSequentialGroup()
                .addComponent(jLMargen, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLLogo))
        );
        jLPCabeceraLayout.setVerticalGroup(
            jLPCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLPCabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLPCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLMargen, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCBAlumnos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRBInscriptas)
                                    .addComponent(jRBNoInscriptas))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jBAnular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBInscribir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLNota)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFNota, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                        .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLPCabecera))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLPCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLNota))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //RADIOBUTTON MATERIAS INSCRIPTAS
    private void jRBInscriptasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRBInscriptasMouseClicked

        //Captura el click y realiza una rutina
        rutina();
    }//GEN-LAST:event_jRBInscriptasMouseClicked

    //RADIOBUTTON MATERIAS NO INSCRIPTAS
    private void jRBNoInscriptasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRBNoInscriptasMouseClicked

        //Captura el click y realiza una rutina
        rutina();
    }//GEN-LAST:event_jRBNoInscriptasMouseClicked

    //BOTON INSCRIBIR
    private void jBInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBInscribirActionPerformed

        //Se controla que el alumno seleccionado en el CB no se encuentre en el indice 0
        if (jCBAlumnos.getSelectedIndex() == 0) {
            
            JOptionPane.showMessageDialog(this, "Seleccione un alumno de la lista");
            return;
        }

        //Se controla que la nota no esté vacia
        if (jTFNota.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this, "La nota no puede estar vacia.");
            return;
        }

        //Se controla que una materia de la lista este seleccionada
        if (jTable1.getSelectedRow() == -1) {

            JOptionPane.showMessageDialog(this, "Seleccione una materia de la tabla.");
            return;
        }

        try {
            
            //Se intenta parsear la nota y realizar su validacion
            double nota = Double.parseDouble(jTFNota.getText());
            if (ValidarData.validarNota(nota)) {

                JOptionPane.showMessageDialog(this, "La Nota es incorrecta");
                return;
            }

            //Se recupera al alumno seleccionado del CB
            Alumno al = (Alumno) jCBAlumnos.getSelectedItem();
            
            //Se recupera la materia seleccionada de la tabla
            int fila = jTable1.getSelectedRow();
            String nombre = (String) modelo.getValueAt(fila, 1);
            Materia mat = Vista.getMD().buscarMateriaPorNombre(nombre);

            //Se crea una inscripcion que recibe por parametro al alumno, la materia y la nota
            Inscripcion insc = new Inscripcion(al, mat, nota);
            
            //Se crea una variable tipo entero y se usa para almacenar el registro de la ejecucion del metodo guardarInscripcion
            int registro = Vista.getID().guardarInscripcion(insc);
            
            //Dependiendo del valor que tome la variable registro se muestra un mensaje al usuario
            if (registro > 0) {

                JOptionPane.showMessageDialog(this, "La inscripción se realizó con exito");
            } else {

                JOptionPane.showMessageDialog(this, "La inscripción falló");
            }
            
            //Se limpia la tabla y se vuelven a cargar los datos de las materias
            limpiarTabla();
            cargarDatos(al.getId());
        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this, "En el casillero nota solo deben ir numeros");
        }
        
        //Se resetea el campo de nota
        jTFNota.setText("");
    }//GEN-LAST:event_jBInscribirActionPerformed

    //BOTON ANULAR INSCRIPCION
    private void jBAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAnularActionPerformed

        //Se controla que el alumno seleccionado en el CB no se encuentre en el indice 0
        if (jCBAlumnos.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un alumno de la lista");
            return;
        }
        
        //Se controla que una materia de la lista este seleccionada
        if (jTable1.getSelectedRow() == -1) {

            JOptionPane.showMessageDialog(this, "Seleccione una materia de la tabla");
            return;
        }

        try {

            //Se recupera al alumno seleccionado en el CB
            Alumno al = (Alumno) jCBAlumnos.getSelectedItem();
            
            //Se recupera la materia seleccionada de la tabla
            int fila = jTable1.getSelectedRow();
            String nombre = (String) modelo.getValueAt(fila, 1);
            Materia mat = Vista.getMD().buscarMateriaPorNombre(nombre);
            
            //Se crea una variable tipo entero y se usa para almacenar el registro de la ejecucion del metodo borrarInscripcion...
            int registro = Vista.getID().borarInscripcionPorMateriaAlumno(al.getId(), mat.getId());
            
            //Dependiendo del valor que tome la variable registro se muestra un mensaje al usuario
            if (registro > 0) {

                JOptionPane.showMessageDialog(this, "Se borro la inscripción con exito");
            } else {

                JOptionPane.showMessageDialog(this, "No se pudo realizar esta operacion");
            }
            
            //Se limpia la tabla y se vuelven a cargar los datos de las materias
            limpiarTabla();
            cargarDatos(al.getId());
        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this, "En el casillero nota solo deben ir numeros");
        }
    }//GEN-LAST:event_jBAnularActionPerformed

    //BOTON SALIR
    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed

        //Cierra la ventana
        dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    //COMBOBOX AP
    private void jCBAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBAlumnosActionPerformed

        //Captura el cambio de alumno seleccionado en el comboBox y ejecuta la rutina
        rutina();
    }//GEN-LAST:event_jCBAlumnosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bG;
    private javax.swing.JButton jBAnular;
    private javax.swing.JButton jBInscribir;
    private javax.swing.JButton jBSalir;
    private javax.swing.JComboBox<Alumno> jCBAlumnos;
    private javax.swing.JLabel jLLogo;
    private javax.swing.JLabel jLMargen;
    private javax.swing.JLabel jLNota;
    private javax.swing.JLayeredPane jLPCabecera;
    private javax.swing.JLabel jLTitulo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRBInscriptas;
    private javax.swing.JRadioButton jRBNoInscriptas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFNota;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    //Este metodo permite cargar los alumnos activos al comboBox
    private void cargarCB() {

        //Agregamos en el primer lugar un alumno vacio
        Alumno vacio = new Alumno() {
            @Override
            public String toString() {
                return "Seleccione un alumno...";
            }
        };
        jCBAlumnos.addItem(vacio);

        //Se recupera una lista de alumnos
        ArrayList<Alumno> Lista = Vista.getAD().listarAlumnos();
        
        //Se recorre la lista y cada alumno se agrega al CB
        for (Alumno al : Lista) {
            jCBAlumnos.addItem(al);
        }
    }

    //Este metodo permite setear un modelo de tabla personalizado
    private void armarTabla() {

        //Se agregan las columnas con su nombre correspondiente al modelo de tabla creado anteriormente
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Año");
        
        //Se setea el modelo de tabla a la tabla de materias
        jTable1.setModel(modelo);

        //Se recupera el modelo de columnas
        TableColumnModel columnas = jTable1.getColumnModel();
        
        //Se llama al metodo que se encarga de setear el ancho de las columnas
        anchoColumna(columnas, 0, 60);
        anchoColumna(columnas, 2, 60);
    }
    
    //Este metodo se usa para setear el ancho de una columna
    //Recibe por parametro el modelo de columna de la tabla, el indice de la columna a modificar y el ancho deseado
    private void anchoColumna(TableColumnModel modeloTabla, int indice, int ancho) {

        modeloTabla.getColumn(indice).setWidth(ancho);
        modeloTabla.getColumn(indice).setMaxWidth(ancho + 30);
        modeloTabla.getColumn(indice).setMinWidth(ancho - 10);
        modeloTabla.getColumn(indice).setPreferredWidth(ancho);
    }

    //Se cargan las filas en la tabla
    private void cargarDatos(int id) {

        //Dependiendo de que radioButton este seleccionado, se ejecuta alguna carga de datos
        //Ambos funcionan de la misma manera pero llaman a metodos distintos
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
    
    //Este metodo se encarga de recibir una materia y desglosar su informacion en una fila para agregarla a la tabla de materias
    private void cargarTabla(Materia mat) {

        modelo.addRow(new Object[]{
            mat.getId(),
            mat.getNombre(),
            Integer.toString(mat.getAnioMateria())
        });
    }
    
    //Este metodo elimina todas las filas de la tabla
    private void limpiarTabla() {

        int fila = modelo.getRowCount() - 1;
        for (int i = fila; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    //Este metodo cambia la visibilidad de algunos componentes, dependiendo de la condicion que se cumpla
    private void cambiarVisibilidad() {

        jTFNota.setText("");
        
        if (jCBAlumnos.getSelectedIndex() == 0) {
            
            //En caso de ser estar seleccionado el primer item del comboBox, oculta y deshabilita los botones de edicion
            jBInscribir.setEnabled(false);
            jBAnular.setEnabled(false);
            jTFNota.setEditable(false);
            jTFNota.setVisible(false);
            jLNota.setVisible(false);
        } else if (jRBInscriptas.isSelected()) {

            //En caso de estar seleccionado el boton de materias inscriptas, solo se muestra el boton de anular inscripcion
            jBInscribir.setEnabled(false);
            jBAnular.setEnabled(true);
            jTFNota.setEditable(false);
            jTFNota.setVisible(false);
            jLNota.setVisible(false);
        } else {

            //En caso de no cumplirse ninguna de las anteriores, se muestran y habilitan todos los componentes menos el boton de anular inscripcion
            jBInscribir.setEnabled(true);
            jBAnular.setEnabled(false);
            jTFNota.setEditable(true);
            jTFNota.setVisible(true);
            jLNota.setVisible(true);
        }
    }

    //Este metodo sirve para ejecutar una rutina siendo llamado en varios metodos
    private void rutina() {

        //Se llama al metodo cambiarVisibilidad
        cambiarVisibilidad();
        
        //Se limpian los datos de la tabla
        limpiarTabla();
        
        //Si el item seleccionado del comboBox es el primero, se finaliza la ejecucion
        if (jCBAlumnos.getSelectedIndex() == 0) {
            return;
        }
        
        //Si el item seleccionado es otro, se recupera el alumno y se cargan en la tabla los datos correspondientes
        Alumno al = (Alumno) jCBAlumnos.getSelectedItem();
        cargarDatos(al.getId());
    }
}
