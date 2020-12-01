/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.*;

/**
 *
 * @author Dutan2000
 */
public class MenuPrincipal extends javax.swing.JFrame {

    //controladores
    private ControladorRector controladorR;
    private ControladorAlumno controladorA;
    private ControladorMateria controladorM;
    private ControladorDocente controladorD;
    
    //vistas
    
    private InicioSession inicioSession;
    private ListaDeDocente listaDeDocente;
    private MenuDocente menuDocenteV;
    private RegistrarDocente registrarDocente;
    private RegistrarRector registrarRector;
    private VisuaizarADocente visualizarDocente;
    
    public MenuPrincipal() {
        initComponents();
        
        controladorA=new ControladorAlumno();
        controladorD=new ControladorDocente(controladorA);
        controladorM=new ControladorMateria();
        controladorR=new ControladorRector(controladorD);
        
        inicioSession=new InicioSession();
        listaDeDocente=new ListaDeDocente();
        menuDocenteV=new MenuDocente();
        registrarDocente=new RegistrarDocente();
        registrarRector=new RegistrarRector();
        visualizarDocente=new VisuaizarADocente();
        
        desktopPane.add(inicioSession);
        desktopPane.add(listaDeDocente);
        desktopPane.add(menuDocenteV);
        desktopPane.add(registrarDocente);
        desktopPane.add(registrarRector);
        desktopPane.add(visualizarDocente);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        menuInicio = new javax.swing.JMenu();
        tabInicioSession = new javax.swing.JMenuItem();
        tabRegistrarRector = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        menuRector = new javax.swing.JMenu();
        tabRegistrarDocente = new javax.swing.JMenuItem();
        tabVerActividadD = new javax.swing.JMenuItem();
        menuDocente = new javax.swing.JMenu();
        tabMenuDocente = new javax.swing.JMenuItem();
        tabListarDocente = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktopPane.setLayout(null);

        menuInicio.setMnemonic('f');
        menuInicio.setText("INICIO");

        tabInicioSession.setMnemonic('o');
        tabInicioSession.setText("INICIO SESSION");
        tabInicioSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tabInicioSessionActionPerformed(evt);
            }
        });
        menuInicio.add(tabInicioSession);

        tabRegistrarRector.setMnemonic('s');
        tabRegistrarRector.setText("R. RECTOR");
        tabRegistrarRector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tabRegistrarRectorActionPerformed(evt);
            }
        });
        menuInicio.add(tabRegistrarRector);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        menuInicio.add(exitMenuItem);

        menuBar.add(menuInicio);

        menuRector.setMnemonic('e');
        menuRector.setText("RECTOR");

        tabRegistrarDocente.setMnemonic('t');
        tabRegistrarDocente.setText("R. DOCENTE");
        tabRegistrarDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tabRegistrarDocenteActionPerformed(evt);
            }
        });
        menuRector.add(tabRegistrarDocente);

        tabVerActividadD.setMnemonic('y');
        tabVerActividadD.setText("V. DOCENTE");
        tabVerActividadD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tabVerActividadDActionPerformed(evt);
            }
        });
        menuRector.add(tabVerActividadD);

        menuBar.add(menuRector);

        menuDocente.setMnemonic('h');
        menuDocente.setText("DOCENTE");

        tabMenuDocente.setMnemonic('c');
        tabMenuDocente.setText("M. DOCENTE");
        tabMenuDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tabMenuDocenteActionPerformed(evt);
            }
        });
        menuDocente.add(tabMenuDocente);

        tabListarDocente.setMnemonic('a');
        tabListarDocente.setText("LISTAR");
        tabListarDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tabListarDocenteActionPerformed(evt);
            }
        });
        menuDocente.add(tabListarDocente);

        menuBar.add(menuDocente);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void tabRegistrarRectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tabRegistrarRectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tabRegistrarRectorActionPerformed

    private void tabVerActividadDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tabVerActividadDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tabVerActividadDActionPerformed

    private void tabMenuDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tabMenuDocenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tabMenuDocenteActionPerformed

    private void tabListarDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tabListarDocenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tabListarDocenteActionPerformed

    private void tabInicioSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tabInicioSessionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tabInicioSessionActionPerformed

    private void tabRegistrarDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tabRegistrarDocenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tabRegistrarDocenteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuDocente;
    private javax.swing.JMenu menuInicio;
    private javax.swing.JMenu menuRector;
    private javax.swing.JMenuItem tabInicioSession;
    private javax.swing.JMenuItem tabListarDocente;
    private javax.swing.JMenuItem tabMenuDocente;
    private javax.swing.JMenuItem tabRegistrarDocente;
    private javax.swing.JMenuItem tabRegistrarRector;
    private javax.swing.JMenuItem tabVerActividadD;
    // End of variables declaration//GEN-END:variables

}
