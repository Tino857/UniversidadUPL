package universidad.vistas;

import java.awt.Graphics;
import java.awt.Image;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import universidad.accesoADatos.ValidarData;
import universidad.entidades.Alumno;

/**
 *
 * @author Grupo 61
 */
public class EdicionDeAlumno extends javax.swing.JInternalFrame {

    //Se crea el modelo que usaremos en la tabla, y se impide que se puedan modificar los valores de las celdas
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

        ImageIcon icon = new ImageIcon(getClass().getResource("/universidad/imagenes/Fondito.png"));
        Image image = icon.getImage();
        jPBackground = new javax.swing.JPanel(){

            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        jLDocumento = new javax.swing.JLabel();
        jLApellido = new javax.swing.JLabel();
        jLNombre = new javax.swing.JLabel();
        jLFecha = new javax.swing.JLabel();
        JBEditar = new javax.swing.JButton();
        jTFDni = new javax.swing.JTextField();
        jTFApellido = new javax.swing.JTextField();
        jTFNombre = new javax.swing.JTextField();
        jDCCalendario = new com.toedter.calendar.JDateChooser();
        jBSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLPCabecera = new javax.swing.JLayeredPane();
        jLMargen = new javax.swing.JLabel();
        jLTitulo = new javax.swing.JLabel();
        jLLogo = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(500, 500));

        jPBackground.setBackground(new java.awt.Color(51, 51, 51));

        jLDocumento.setForeground(new java.awt.Color(235, 235, 235));
        jLDocumento.setText("DNI:");

        jLApellido.setForeground(new java.awt.Color(235, 235, 235));
        jLApellido.setText("Apellido:");

        jLNombre.setForeground(new java.awt.Color(235, 235, 235));
        jLNombre.setText("Nombre:");

        jLFecha.setForeground(new java.awt.Color(235, 235, 235));
        jLFecha.setText("Fecha de Nac:");

        JBEditar.setBackground(new java.awt.Color(51, 51, 51));
        JBEditar.setForeground(new java.awt.Color(235, 235, 235));
        JBEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidad/imagenes/editar-w.png"))); // NOI18N
        JBEditar.setText("Editar");
        JBEditar.setIconTextGap(10);
        JBEditar.setPreferredSize(new java.awt.Dimension(100, 32));
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
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLTitulo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLTitulo.setForeground(new java.awt.Color(235, 235, 235));
        jLTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLTitulo.setText("EDICIÓN DE ALUMNO");

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

        javax.swing.GroupLayout jPBackgroundLayout = new javax.swing.GroupLayout(jPBackground);
        jPBackground.setLayout(jPBackgroundLayout);
        jPBackgroundLayout.setHorizontalGroup(
            jPBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBackgroundLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPBackgroundLayout.createSequentialGroup()
                        .addComponent(jLNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFNombre))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPBackgroundLayout.createSequentialGroup()
                        .addGroup(jPBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLDocumento)
                            .addComponent(jLApellido))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPBackgroundLayout.createSequentialGroup()
                                .addComponent(jTFDni, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLFecha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDCCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTFApellido)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPBackgroundLayout.createSequentialGroup()
                        .addComponent(JBEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLPCabecera)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        jPBackgroundLayout.setVerticalGroup(
            jPBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBackgroundLayout.createSequentialGroup()
                .addComponent(jLPCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLDocumento)
                        .addComponent(jTFDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDCCalendario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLApellido)
                    .addComponent(jTFApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNombre)
                    .addComponent(jTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPBackground, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPBackground, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //BOTON SALIR
    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        
        //Cierra la ventana
        dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    //ACCION CLICK EN TABLA
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        //Se captura el evento de click en una fila de la tabla y se recupera el indice de la misma
        int filaSelec = jTable1.getSelectedRow();
        
        //Se obtienen los datos del alumno almacenado en la fila seleccionada
        String dni = (String) modelo.getValueAt(filaSelec, 1);
        String apellido = (String) modelo.getValueAt(filaSelec, 2);
        String nombre = (String) modelo.getValueAt(filaSelec, 3);
        String FN = (String) modelo.getValueAt(filaSelec, 4);
        
        //Se setean los valores recuperados anteriormente en los campos correspondientes
        jTFDni.setText(dni);
        jTFApellido.setText(apellido);
        jTFNombre.setText(nombre);
        jDCCalendario.setDate(Date.valueOf(FN));
    }//GEN-LAST:event_jTable1MouseClicked

    //BOTON EDITAR
    private void JBEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEditarActionPerformed

        //Se controla que no hayan campos vacios
        if (jTFNombre.getText().isEmpty() || jTFApellido.getText().isEmpty() || jTFDni.getText().isEmpty() || jDCCalendario.getDate() == null) {
            JOptionPane.showMessageDialog(this, "No pude haber campos vacíos.");
            return;
        }
        
        //Se controla que un alumno de la tabla esté seleccionado
        if (jTable1.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un alumno de la lista.");
            return;
        }
        
        try {
            
            //Se recupera la fila seleccionada
            int filaSelec = jTable1.getSelectedRow();
            
            //Se intenta parsear el nuevo dni a guardar en el alumno y se realiza su validacion
            int dni = Integer.parseInt(jTFDni.getText());
            if (ValidarData.validarDNI(dni)) {
                
                JOptionPane.showMessageDialog(this, "En casilla DNI debe ir un dato valido.");
                return;
            }
            
            //Se valida si los campos de nombre y apellido no contienen caracteres especiales
            String nombre = jTFNombre.getText();
            String apellido = jTFApellido.getText();
            if (ValidarData.caracteresEspeciales(nombre) || ValidarData.caracteresEspeciales(apellido)) {
                JOptionPane.showMessageDialog(this, "No se permiten caracteres especiales o numeros");
                return;
            }
            
            //Se valida si los campos de nombre y apellido cumplen con un largo determinado
            if (ValidarData.largoCadena(nombre) || ValidarData.largoCadena(apellido)) {
                
                JOptionPane.showMessageDialog(this, "El nombre o apellido es incorrecto");
                return;
            }
            
            //Se valida si la fecha es correcta
            LocalDate fecha = jDCCalendario.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (ValidarData.validarFecha(fecha)){
                
                JOptionPane.showMessageDialog(this, "La fecha es incorrecta");
                return;
            }
            
            //Llegado el punto en que todos los valores son correctos, se crea un alumno
            //En este alumno guardamos el resultado de la busqueda por medio del dni que figura en la tabla
            Alumno al = Vista.getAD().buscarAlumnoPorDni(Integer.parseInt((String) modelo.getValueAt(filaSelec, 1)));
            
            //Seteamos al alumno con la informacion nueva
            al.setDni(dni);
            al.setApellido(apellido);
            al.setNombre(nombre);
            al.setfN(fecha);
            
            //Se crea una variable tipo entero y se usa para almacenar el registro de la ejecucion del metodo editarAlumno
            int registro = Vista.getAD().editarAlumno(al);
            
            //Dependiendo del valor que tome la variable registro se muestra un mensaje al usuario
            if (registro > 0) {

                JOptionPane.showMessageDialog(this, "Datos actualizados");
            } else {

                JOptionPane.showMessageDialog(this, "No se pudo actualizar los datos. \nEl dni está en uso");
            }

            //Se limpia la tabla y se vuelven a cargar los datos de los alumnos
            limpiarTabla();
            cargarDatos();
        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this, "En la casilla de Dni solo deben ir numeros");
        }
        //Se limpian los textfields
        limpiar();
    }//GEN-LAST:event_JBEditarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBEditar;
    private javax.swing.JButton jBSalir;
    private com.toedter.calendar.JDateChooser jDCCalendario;
    private javax.swing.JLabel jLApellido;
    private javax.swing.JLabel jLDocumento;
    private javax.swing.JLabel jLFecha;
    private javax.swing.JLabel jLLogo;
    private javax.swing.JLabel jLMargen;
    private javax.swing.JLabel jLNombre;
    private javax.swing.JLayeredPane jLPCabecera;
    private javax.swing.JLabel jLTitulo;
    private javax.swing.JPanel jPBackground;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFApellido;
    private javax.swing.JTextField jTFDni;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    //Este metodo permite setear un modelo de tabla personalizado
    private void armarTabla() {

        //Se agregan las columnas con su nombre correspondiente al modelo de tabla creado anteriormente
        modelo.addColumn("ID");
        modelo.addColumn("DNI");
        modelo.addColumn("Apellido");
        modelo.addColumn("Nombre");
        modelo.addColumn("Fecha de Nacimiento");
        
        //Se setea el modelo de tabla a la tabla de alumnos
        jTable1.setModel(modelo);
        
        //Se recupera el modelo de columnas
        TableColumnModel columnas = jTable1.getColumnModel();
        
        //Se llama al metodo que se encarga de setear el ancho de las columnas
        anchoColumna(columnas, 0, 40);
        anchoColumna(columnas, 1, 80);
        anchoColumna(columnas, 4, 90);
    }
    
    //Este metodo se usa para setear el ancho de una columna
    //Recibe por parametro el modelo de columna de la tabla, el indice de la columna a modificar y el ancho deseado
    private void anchoColumna(TableColumnModel modeloTabla, int indice, int ancho){
        
        modeloTabla.getColumn(indice).setWidth(ancho);
        modeloTabla.getColumn(indice).setMaxWidth(ancho+30);
        modeloTabla.getColumn(indice).setMinWidth(ancho-10);
        modeloTabla.getColumn(indice).setPreferredWidth(ancho);
    }

    //Se cargan las filas en la tabla
    private void cargarDatos() {
        
        //Se recupera una lista de alumnos
        ArrayList<Alumno> ListaDeAlumnos = Vista.getAD().listarAlumnos();
        
        //Se recorre la lista y por cada alumno, se llama al metodo correspondiente para agregar la fila, enviando por parametro dicho alumno
        for (Alumno next : ListaDeAlumnos) {
            cargarTabla(next);
        }
    }

    //Este metodo se encarga de recibir un alumno y desglosar su informacion en una fila para agregarla a la tabla de alumnos
    private void cargarTabla(Alumno al) {

        modelo.addRow(new Object[]{
            al.getId(),
            Integer.toString(al.getDni()),
            al.getApellido(),
            al.getNombre(),
            al.getfN().toString()
        });
    }

    //Este metodo limpia los textfields y resetea los campos de estado y fecha
    public void limpiar() {

        jTFDni.setText("");
        jTFApellido.setText("");
        jTFNombre.setText("");
        jDCCalendario.setDate(null);
    }

    //Este metodo elimina todas las filas de la tabla
    private void limpiarTabla() {

        int filas = modelo.getRowCount() - 1;
        for (int i = filas; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }
}
