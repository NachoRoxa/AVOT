/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import Atxy2k.CustomTextField.RestrictedTextField;
import CONEXION.Conexion;
import DAO.ColegioDaoImp;
import DTO.Colegio;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import static DTO.ValidaRut.validarRut;
import VISTA.CONTROLES.ButtonColumn;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;

/**
 *
 * @author Seba
 */
public class GestionColegio extends javax.swing.JFrame {

    ArrayList<Colegio> listaColegios;
    Conexion obj = new Conexion();
    DefaultTableModel modelo;
    Colegio col =  new Colegio();
    int flag;

    /**
     * Creates new form GestionColegio
     */
    public GestionColegio() {
        initComponents();
        this.setLocationRelativeTo(null);
        MostrarColegios();
        ResetBotones();
        RestrictedTextField rtfNumber = new RestrictedTextField(txtTelefono);
        RestrictedTextField rtfLetras = new RestrictedTextField(txtNombre);
        RestrictedTextField rtf = new RestrictedTextField(txtRun);
        rtf.setLimit(12);
        rtfNumber.setOnlyNums(rootPaneCheckingEnabled);
        rtfLetras.setOnlyText(rootPaneCheckingEnabled);
        rtfLetras.setAcceptSpace(true);
    }
    
    public GestionColegio(int admin) {
        Admin(admin);
        initComponents();
        this.setLocationRelativeTo(null);
        MostrarColegios();
        ResetBotones();
        RestrictedTextField rtfNumber = new RestrictedTextField(txtTelefono);
        RestrictedTextField rtfLetras = new RestrictedTextField(txtNombre);
        RestrictedTextField rtf = new RestrictedTextField(txtRun);
        rtf.setLimit(12);
        rtfNumber.setOnlyNums(rootPaneCheckingEnabled);
        rtfLetras.setOnlyText(rootPaneCheckingEnabled);
        rtfLetras.setAcceptSpace(true);
    }
    
    /***
     * Metodo para ver si el usuario posee perfil de administrador.
     * @param admin
     * @return 
     */
    public boolean Admin(int admin) {
        this.flag = admin;
        if (admin == 1) {
            flag = 1;
            return true;
        } else {
            flag = 0;
            return false;
        }
    }
    
    public void ResetBotones() {
        btnAgregarColegio.setVisible(true);
        btnCancelar.setVisible(false);
        btnGuardar.setVisible(false);
    }

    public void LimpiarFormulario() {
        txtRun.setText(null);
        txtDireccion.setText(null);
        txtNombre.setText(null);
        txtTelefono.setText(null);
    }

    public void MostrarColegios() {
        listaColegios = new ColegioDaoImp().listar();
        modelo = new DefaultTableModel();
        modelo.addColumn("");
        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("DIRECCION");
        modelo.addColumn("RUT");
        modelo.addColumn("TELEFONO");
        modelo.addColumn("");
        if (listaColegios.size() > 0) {
            for (Colegio colegio : listaColegios) {
                modelo.addRow(new Object[]{
                    "EDITAR",
                    colegio.getId_colegio(),
                    colegio.getNombre(),
                    colegio.getDireccion(),
                    colegio.getRut(),
                    colegio.getTelefono(),
                    "ELIMINAR"}
                );
            }
            tablaColegios.setModel(modelo);
        }

        /* AGREGA LA ACCION DEL BOTTON ELIMINAR*/
        Action borrar = new AbstractAction() {
            @Override
            /*ESTE ES EL METODO DEL BOTON CUANDO SE PRESIONA*/
            public void actionPerformed(ActionEvent e) {
                int fila = Integer.valueOf(e.getActionCommand());
                col = new Colegio();
                col = listaColegios.get(fila);
                new ColegioDaoImp().eliminar(col);
                col = new Colegio();
                LimpiarFormulario();
                tablaColegios.clearSelection();
                ResetBotones();
                MostrarColegios();

            }

        };
        /*ESTA PARTE ES LA QUE AGREGA EL BOTTON ELIMINAR CON ACCION DECLARADA ANTERIORMENTE*/
        ButtonColumn buttonEliminar = new ButtonColumn(tablaColegios, borrar, 6);
        buttonEliminar.setMnemonic(KeyEvent.VK_D);

        /* AGREGA LA ACCION AL BOTTON EDITAR*/
        Action editar = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int fila = Integer.valueOf(e.getActionCommand());
                col = new Colegio();
                col = listaColegios.get(fila);
                txtRun.setText(col.getRut());
                txtRun.enableInputMethods(false);
                txtNombre.setText(col.getNombre());
                txtDireccion.setText(col.getDireccion());
                txtTelefono.setText(col.getTelefono());
                btnAgregarColegio.setVisible(false);
                btnCancelar.setVisible(true);
                btnGuardar.setVisible(true);
            }

        };
        /*AGREGA EL BOTTON EDITAR A LA COLUMNA CON LA ACCION DECLARADA ANTERIORMENTE*/
        ButtonColumn buttonEditar = new ButtonColumn(tablaColegios, editar, 0);
        buttonEditar.setMnemonic(KeyEvent.VK_D);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelTitulo = new javax.swing.JPanel();
        lblAVOT = new javax.swing.JLabel();
        btnInicio = new javax.swing.JButton();
        PanelTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaColegios = new javax.swing.JTable();
        PanelInsertar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtRun = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        btnAgregarColegio = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        PanelTitulo.setBackground(new java.awt.Color(30, 160, 250));

        lblAVOT.setBackground(new java.awt.Color(255, 255, 255));
        lblAVOT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblAVOT.setForeground(new java.awt.Color(255, 255, 255));
        lblAVOT.setText("A.V.O.T.");

        btnInicio.setText("Inicio");
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelTituloLayout = new javax.swing.GroupLayout(PanelTitulo);
        PanelTitulo.setLayout(PanelTituloLayout);
        PanelTituloLayout.setHorizontalGroup(
            PanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAVOT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInicio)
                .addContainerGap())
        );
        PanelTituloLayout.setVerticalGroup(
            PanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAVOT)
                    .addComponent(btnInicio))
                .addContainerGap())
        );

        PanelTabla.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista  Colegio"));

        tablaColegios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaColegios);

        javax.swing.GroupLayout PanelTablaLayout = new javax.swing.GroupLayout(PanelTabla);
        PanelTabla.setLayout(PanelTablaLayout);
        PanelTablaLayout.setHorizontalGroup(
            PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelTablaLayout.setVerticalGroup(
            PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTablaLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanelInsertar.setBorder(javax.swing.BorderFactory.createTitledBorder("Agregar Colegio"));

        jLabel2.setText("RUT");

        jLabel3.setText("Direccion");

        jLabel5.setText("Nombre");

        btnAgregarColegio.setText("Agregar");
        btnAgregarColegio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarColegioActionPerformed(evt);
            }
        });

        jLabel9.setText("Telefono");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelInsertarLayout = new javax.swing.GroupLayout(PanelInsertar);
        PanelInsertar.setLayout(PanelInsertarLayout);
        PanelInsertarLayout.setHorizontalGroup(
            PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInsertarLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelInsertarLayout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInsertarLayout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnAgregarColegio)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(PanelInsertarLayout.createSequentialGroup()
                            .addComponent(btnCancelar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGuardar)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelInsertarLayout.createSequentialGroup()
                        .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(47, 47, 47)
                        .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRun, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        PanelInsertarLayout.setVerticalGroup(
            PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInsertarLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(28, 28, 28)
                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(31, 31, 31)
                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(40, 40, 40)
                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(btnAgregarColegio)
                .addGap(40, 40, 40)
                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelInsertar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        Admin(flag);
        this.setVisible(false);
        Index x = new Index(flag);
        x.setVisible(true);
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnAgregarColegioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarColegioActionPerformed
        if (validarRut(txtRun.getText().trim()) == false) {
            JOptionPane.showMessageDialog(null, "El rut ingresado no es valido o ya esta registrado");
        } else if (txtRun.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un RUT");
        } else if (txtNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un Nombre");
        } else if (txtDireccion.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese una Direccion");
        } else if (txtTelefono.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un Telefono");
        } else {
            Colegio colegio = new Colegio();
            colegio.setRut(txtRun.getText());
            colegio.setNombre(txtNombre.getText());
            colegio.setDireccion(txtDireccion.getText());
            colegio.setTelefono(txtTelefono.getText());
            new ColegioDaoImp().insertar(colegio);
            LimpiarFormulario();
            tablaColegios.clearSelection();
            ResetBotones();
            MostrarColegios();
        }
    }//GEN-LAST:event_btnAgregarColegioActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        LimpiarFormulario();
        tablaColegios.clearSelection();
        ResetBotones();
        MostrarColegios();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtRun.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un RUT");
        } else if (txtNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un Nombre");
        } else if (txtDireccion.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese una Direccion");
        } else if (txtTelefono.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un Telefono");
        } else {
            col.setRut(txtRun.getText());
            col.setNombre(txtNombre.getText());
            col.setDireccion(txtDireccion.getText());
            col.setTelefono(txtTelefono.getText());
            new ColegioDaoImp().modificar(col);
            LimpiarFormulario();
            tablaColegios.clearSelection();
            ResetBotones();
            MostrarColegios();
            col = new Colegio();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelInsertar;
    private javax.swing.JPanel PanelTabla;
    private javax.swing.JPanel PanelTitulo;
    private javax.swing.JButton btnAgregarColegio;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnInicio;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAVOT;
    private javax.swing.JTable tablaColegios;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRun;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
