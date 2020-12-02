/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorRector;
import ec.edu.ups.modelo.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dutan2000
 */
public class RegistrarDocente extends javax.swing.JInternalFrame {

    private ControladorRector controladorR;
    private Docente docente;
    private Rector rector=new Rector();

    public RegistrarDocente(ControladorRector controladorRector) {
        initComponents();
        controladorR = controladorRector;
    }

    public void limpiar() {
        txtCedula.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtCorreo.setText("");
        txtContrasenia.setText("");
        cmbxCurso.setSelectedIndex(0);
        cmbxTipo.setSelectedIndex(0);
    }

    public void actualizarVista(List<Docente> docentes) {

        DefaultTableModel modelo = (DefaultTableModel) tablaDatos.getModel();
        modelo.setRowCount(0);
        for (Docente docente : docentes) {
            Object[] fila = new Object[3];
            fila[0] = docente.getNombre();
            fila[1] = docente.getApellido();
            fila[2] = docente.getCurso();
            modelo.addRow(fila);
        }
        tablaDatos.setModel(modelo);
    }
    
    public void LimpiarVista() {

        DefaultTableModel modelo = (DefaultTableModel) tablaDatos.getModel();
        modelo.setRowCount(0);
        tablaDatos.setModel(modelo);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        lblApellido1 = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        txtContrasenia = new javax.swing.JTextField();
        lblCedula = new javax.swing.JLabel();
        cmbxTipo = new javax.swing.JComboBox<>();
        lblCorreo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbxCurso = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();
        btnAgregarALista = new javax.swing.JToggleButton();
        btncrearDocente = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        jLabel1.setText("REGISTRAR A DOCENTE-ASIGNACION");

        lblNombre.setText("NOMBRE:");

        lblApellido1.setText("TIPO:");

        lblApellido.setText("APELLIDO:");

        lblCedula.setText("CEDULA:");

        cmbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--SELECIONE UNA OPCION--", "DOCENTE" }));

        lblCorreo.setText("CORREO:");

        jLabel2.setText("CURSO ASIGNADO:");

        cmbxCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--SELECIONE CURSO--", "BASICA 1", "BASICA 2", "BASICA 3", "BASICA 4", "BASICA 5", "BASICA 6", "BASICA 7" }));

        tablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE", "APELLIDO", "CURSO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaDatos);

        btnAgregarALista.setText("ASIGNAR DOCENTE");
        btnAgregarALista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAListaActionPerformed(evt);
            }
        });

        btncrearDocente.setText("CONFIRMACION");
        btncrearDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncrearDocenteActionPerformed(evt);
            }
        });

        jLabel3.setText("CONTRASEÑA:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblCedula)
                                                .addComponent(lblApellido1))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cmbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cmbxCurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblCorreo)
                                        .addComponent(lblApellido)
                                        .addComponent(lblNombre))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(238, 238, 238)
                                    .addComponent(btnAgregarALista)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(btncrearDocente))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jLabel1)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblApellido)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCedula)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(lblApellido1))
                            .addComponent(cmbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCorreo)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAgregarALista)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btncrearDocente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarAListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAListaActionPerformed
        if (!txtCedula.getText().isEmpty() && !txtNombre.getText().isEmpty() && !txtApellido.getText().isEmpty()
                && !txtCorreo.getText().isEmpty() && !txtContrasenia.getText().isEmpty() && cmbxCurso.getSelectedIndex() != 0
                && cmbxTipo.getSelectedIndex() != 0) {

            String cedula = txtCedula.getText();
            for (int i = cedula.length(); i < 10; i++) {
                cedula += " ";
            }
            cedula = cedula.substring(0, 10);

            String nombre = txtNombre.getText();
            for (int i = nombre.length(); i < 25; i++) {
                nombre += " ";
            }
            nombre = nombre.substring(0, 25);

            String apellido = txtApellido.getText();
            for (int i = apellido.length(); i < 25; i++) {
                apellido += " ";
            }
            apellido = apellido.substring(0, 25);

            String tipo = String.valueOf(cmbxTipo.getSelectedItem());
            for (int i = tipo.length(); i < 25; i++) {
                tipo += " ";
            }
            tipo = tipo.substring(0, 25);

            String correo = txtCorreo.getText();
            for (int i = correo.length(); i < 30; i++) {
                correo += " ";
            }
            correo = correo.substring(0, 30);

            String contrasenia = txtContrasenia.getText();
            for (int i = contrasenia.length(); i < 10; i++) {
                contrasenia += " ";
            }
            contrasenia = contrasenia.substring(0, 10);
            
            String curso = String.valueOf(cmbxCurso.getSelectedItem());
            for (int i = curso.length(); i < 50; i++) {
                curso += " ";
            }
            curso = curso.substring(0, 50);
            docente=new Docente(curso, correo, contrasenia, cedula, nombre, apellido, tipo);
            rector.createDocente(docente);
            actualizarVista(rector.findAll());   
            JOptionPane.showMessageDialog(null, "DOCENTE AGREGADO A LA LISTA");
            limpiar();
        }else{
                JOptionPane.showMessageDialog(null, "EXISTEN CAMPOS VACIOS");
        }
    }//GEN-LAST:event_btnAgregarAListaActionPerformed

    private void btncrearDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncrearDocenteActionPerformed
                            Object[] opcionesJPanel = {"SI", "NO"};
                            int confirmar=JOptionPane.showOptionDialog(null, "ESTA SEGURO QUE DESEA GUARDAR ESTOS DATOS ", "REGISTRAR DOCENTES", JOptionPane.YES_NO_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE,null, opcionesJPanel, null);
                            
                            if(JOptionPane.OK_OPTION==confirmar){
                                controladorR.createDocente(rector.findAll());
                                JOptionPane.showMessageDialog(null, "DOCENTES CREADOS CON EXITO");
                                LimpiarVista();
                            }else{
                                System.out.println("hacer nada");
                            }
    }//GEN-LAST:event_btncrearDocenteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnAgregarALista;
    private javax.swing.JToggleButton btncrearDocente;
    private javax.swing.JComboBox<String> cmbxCurso;
    private javax.swing.JComboBox<String> cmbxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblApellido1;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTable tablaDatos;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtContrasenia;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
