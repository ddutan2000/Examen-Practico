/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.*;
import ec.edu.ups.modelo.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dutan2000
 */
public class MenuDocente extends javax.swing.JInternalFrame {

    private ControladorDocente controladorD;
    private Docente docente;
    private Materias materia;
    private Alumno alumno;
    private ControladorRegex controladorRegex = new ControladorRegex();

    public MenuDocente(ControladorDocente controladorDocente) {
        initComponents();
        controladorD = controladorDocente;
    }

    public void actualizarVista(List<Alumno> alumnos) {

        DefaultTableModel modelo = (DefaultTableModel) tablaAlumnos.getModel();
        modelo.setRowCount(0);
        for (Alumno alumno : alumnos) {
            Object[] fila = new Object[4];
            fila[0] = alumno.getCedula().trim();
            fila[1] = alumno.getNombre().trim();
            fila[2] = alumno.getApellido().trim();
            fila[3] = alumno.getDocente().getNombre().trim();
            modelo.addRow(fila);
        }
        tablaAlumnos.setModel(modelo);
    }

    public void limpiar() {
        txtCedula.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        cmbxTipo.setSelectedIndex(0);
    }

    public void limpiarBusqueda() {
        txtBusqueda.setText("");
        txtLink.setText("");
    }

    public void actualizarVistaLinks(Set<Materias> materias) {

        DefaultTableModel modelo = (DefaultTableModel) tablaLinks.getModel();
        modelo.setRowCount(0);
        for (Materias materia : materias) {
            Object[] fila = new Object[2];
            fila[0] = materia.getLink();
            fila[1] = null;
            modelo.addRow(fila);
        }
        tablaLinks.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblApellido1 = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();
        cmbxTipo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnCrearAlumno = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlumnos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaLinks = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtLink = new javax.swing.JTextField();
        btnCrearTema = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable3);

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        jLabel1.setText("MENU DE DOCENTE");

        lblNombre.setText("NOMBRE:");

        lblApellido1.setText("TIPO:");

        lblApellido.setText("APELLIDO:");

        lblCedula.setText("CEDULA:");

        cmbxTipo.setEditable(true);
        cmbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--SELECIONE UNA OPCION--", "ALUMNO" }));

        jLabel2.setText("DATOS DE ALUMNO:");

        btnCrearAlumno.setText("INGRESAR ALUMNO");
        btnCrearAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearAlumnoActionPerformed(evt);
            }
        });

        tablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CEDULA", "NOMBRE", "APELLIDO", "DOCENTE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaAlumnos);

        jLabel3.setText("BUSQUEDA DE TEMAS:");

        tablaLinks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "LINK"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaLinks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaLinksMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablaLinks);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel4.setText("LINK:");

        txtLink.setEditable(false);

        btnCrearTema.setText("AÑADIR TEMA");
        btnCrearTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearTemaActionPerformed(evt);
            }
        });

        btnConfirmar.setText("CONFIRMAR");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblCedula)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblNombre)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNombre)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblApellido1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblApellido)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtApellido))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnBuscar))
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtLink, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addComponent(btnCrearTema)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(btnCrearAlumno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConfirmar)
                .addGap(92, 92, 92))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApellido1)
                    .addComponent(cmbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApellido)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearAlumno)
                    .addComponent(btnConfirmar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCrearTema))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearAlumnoActionPerformed
        if (!txtCedula.getText().isEmpty() && !txtNombre.getText().isEmpty() && !txtApellido.getText().isEmpty()) {
            String cedula = txtCedula.getText();

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

            docente = controladorD.verDocente();
            alumno = new Alumno(docente, cedula, nombre, apellido, tipo);
            docente.createAlumno(alumno);
            actualizarVista(docente.findAllAlumnos());
            limpiar();
            JOptionPane.showMessageDialog(null, "ESTUDIANTE AGREGADO A LA LISTA");
        } else {
            JOptionPane.showMessageDialog(null, "EXISTEN CAMPOS VACIOS");
        }

    }//GEN-LAST:event_btnCrearAlumnoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (!txtBusqueda.getText().isEmpty()) {
            controladorRegex.ingreseRegex("<a href=\\\"\\/store\\/apps\\/details\\?id=((\\w)+\\.?)+");
            StringBuilder stringBuilder = new StringBuilder();
            String textBusqueda = txtBusqueda.getText();
            try {
                URL urlObject = new URL("https://play.google.com/store/search?q=" + textBusqueda.replaceAll("\\s", "%20") + "&c=apps");
                URLConnection urlConnection = urlObject.openConnection();
                urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
                String inputLine;
                while ((inputLine = bufferedReader.readLine()) != null) {
                    stringBuilder.append(inputLine);
                }
            } catch (FileNotFoundException ex) {
                System.out.println("Error de lectura");
                System.out.println(ex);
            } catch (IOException ex) {
                System.out.println("Error de lectura");
                System.out.println(ex);
            }
            docente = controladorD.verDocente();
            Set<Materias> resulatado = controladorRegex.obtenerURLGoogle(stringBuilder.toString(), docente);
            /*
            controladorRegex.ingreseRegex("\"title\\\">(\\\\w+\\\\s?:?\\\\s?)+\"");
            for (Materias materias : resulatado) {
                //String textBusquedaTitulo = materias.getLink();
                try {
    
                    URL urlObject = new URL(materias.getLink());
                    URLConnection urlConnection = urlObject.openConnection();
                    urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
                    String inputLine;
                    while ((inputLine = bufferedReader.readLine()) != null) {
                        stringBuilder.append(inputLine);
                    }
                } catch (FileNotFoundException ex) {
                    System.out.println("Error de lectura");
                    System.out.println(ex);
                } catch (IOException ex) {
                    System.out.println("Error de lectura");
                    System.out.println(ex);
                }
                materias.setNombreDeAplicacion(controladorRegex.obtenerTitulo(stringBuilder.toString()));
                System.out.println(materias.getNombreDeAplicacion());
            }*/
            docente.createLink(resulatado);
            actualizarVistaLinks(docente.findAllMaterias());
        }


    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tablaLinksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaLinksMouseClicked

        int posicion = tablaLinks.getSelectedRow();
        String link = String.valueOf(tablaLinks.getValueAt(posicion, 0));
        //String nombre = String.valueOf(tablaLinks.getValueAt(posicion, 1));

        txtLink.setText(link);
        //txtNombreLink.setText(nombre);

    }//GEN-LAST:event_tablaLinksMouseClicked

    private void btnCrearTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearTemaActionPerformed
        Object[] opcionesJPanel = {"SI", "NO"};
        int confirmar = JOptionPane.showOptionDialog(null, "ESTA SEGURO QUE DESEA GUARDAR ESTOS DATOS ", "REGISTRAR DOCENTES", JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, opcionesJPanel, null);
        if (JOptionPane.OK_OPTION == confirmar) {
            docente = controladorD.verDocente();
            String link = txtLink.getText();
            for (int i = link.length(); i < 100; i++) {
                link+=" ";
            }
            link=link.substring(0, 100);
            //String nombre = txtNombreLink.getText();
            materia = new Materias(link, docente);
            controladorD.creatLink(materia);
            JOptionPane.showMessageDialog(null, "MATERIA CREADA EXITOSAMENTE");
            limpiarBusqueda();
        } else {
            System.out.println("hacer nada");
        }

    }//GEN-LAST:event_btnCrearTemaActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        Object[] opcionesJPanel = {"SI", "NO"};
        int confirmar = JOptionPane.showOptionDialog(null, "ESTA SEGURO QUE DESEA GUARDAR ESTOS DATOS ", "REGISTRAR DOCENTES", JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, opcionesJPanel, null);
        if (JOptionPane.OK_OPTION == confirmar) {
            controladorD.creatAlumno(docente.findAllAlumnos());
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnCrearAlumno;
    private javax.swing.JButton btnCrearTema;
    private javax.swing.JComboBox<String> cmbxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblApellido1;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTable tablaAlumnos;
    private javax.swing.JTable tablaLinks;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtLink;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
