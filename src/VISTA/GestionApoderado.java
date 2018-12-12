/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import CONEXION.Conexion;
import DTO.Apoderado;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import DAO.ApoderadoDaoImp;
import static DTO.ValidaRut.validarRut;
import VISTA.CONTROLES.ButtonColumn;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import Atxy2k.CustomTextField.RestrictedTextField;
import java.awt.event.KeyListener;

/**
 *
 * @author Seba
 */
public class GestionApoderado extends javax.swing.JFrame {

    ArrayList<Apoderado> listaApoderados;
    Conexion obj = new Conexion();
    DefaultTableModel modelo;
    int flag;

    /**
     * Creates new form GestionApoderado
     * @param admin
     */
    public GestionApoderado(int admin) {
        Admin(admin);
        initComponents();
        ResetBotones();
        listaApoderados = new ArrayList<>();
        this.setLocationRelativeTo(null);
        MostrarApoderados();
        txtRun.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar()) && e.getKeyChar()!='k' && e.getKeyCode()!=75 && e.getKeyCode() != KeyEvent.VK_LEFT && e.getKeyCode() != KeyEvent.VK_RIGHT && e.getKeyCode() != KeyEvent.VK_DELETE && e.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                } 
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
                if (!Character.isDigit(e.getKeyChar()) && e.getKeyChar()!='k' && e.getKeyCode() != KeyEvent.VK_LEFT && e.getKeyCode() != KeyEvent.VK_RIGHT && e.getKeyCode() != KeyEvent.VK_DELETE && e.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                } else {
                    String texto;
                    texto = txtRun.getText();
                    texto = texto.replace(".", "").replace("-", "");
                    String[] array = texto.split("");
                    String rut = "";
                    switch (texto.length()) {
                        case 8:
                            for (int i = 0; i < array.length; i++) {
                                rut = rut + array[i];
                                if (i == 0 || i == 3) {
                                    rut = rut + ".";
                                }
                                if (i == 6) {
                                    rut = rut + "-";
                                }
                            }
                            texto = rut;
                            break;
                        case 9:
                            for (int i = 0; i < array.length; i++) {
                                rut = rut + array[i];
                                if (i == 1 || i == 4) {
                                    rut = rut + ".";
                                }
                                if(i == 7) {
                                    rut = rut + "-";
                                }
                            }
                            texto = rut;
                            break;
                        default:
                            texto = texto.replace(".", "").replace("-", "").replace("k", "");
                            break;
                    }
                    txtRun.setText(texto);

                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
//                String texto;
                if (!Character.isDigit(e.getKeyChar()) && e.getKeyChar()!='k' && e.getKeyCode()!=75 && e.getKeyCode() != KeyEvent.VK_LEFT && e.getKeyCode() != KeyEvent.VK_RIGHT && e.getKeyCode() != KeyEvent.VK_DELETE && e.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                } 
            }
        });
        RestrictedTextField restricted = new RestrictedTextField(txtRun);
        restricted.setLimit(12);
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
    
    /*ocultar guardar y cancelar, mostrar agregar*/
    public void ResetBotones() {
        btnAgregarApoderado.setVisible(true);
        btnCancelar.setVisible(false);
        btnGuardar.setVisible(false);
    }

    /*metodo nuevo pa limpiar*/
    public void LimpiarFormulario() {
        txtRun.setText(null);
        txtRun.enableInputMethods(true);
        txtUsuario.setText(null);
        txtNombre.setText(null);
        txtApellido.setText(null);
        txtTelefono.setText(null);
        txtCorreo.setText(null);
        chbRepresentante.setSelected(false);
    }

    /* SE AGREGO LA COLUMNA DE EDITAR*/
    public void MostrarApoderados() {
        listaApoderados = new ApoderadoDaoImp().listar();
        modelo = new DefaultTableModel();
        modelo.addColumn("");
        modelo.addColumn("RUN");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("APELLIDO");
        modelo.addColumn("USUARIO");
        modelo.addColumn("CORREO");
        modelo.addColumn("TELEFONO");
        modelo.addColumn("REPRESENTANTE");
        modelo.addColumn("");
        if (listaApoderados.size() > 0) {
            for (Apoderado apoderado : listaApoderados) {
                String rep;
                if (apoderado.getRepresentante() == 0) {
                    rep = "NO";
                } else {
                    rep = "SI";
                }
                modelo.addRow(new Object[]{
                    "EDITAR",
                    apoderado.getRun(),
                    apoderado.getNombre(),
                    apoderado.getApellido(),
                    apoderado.getUser(),
                    apoderado.getCorreo(),
                    apoderado.getTelefono(),
                    rep,
                    "ELIMINAR"}
                );
            }

            tablaApoderados.setModel(modelo);

            /* AGREGA LA ACCION DEL BOTTON ELIMINAR*/
            Action borrar = new AbstractAction() {
                @Override
                /*ESTE ES EL METODO DEL BOTON CUANDO SE PRESIONA*/
                public void actionPerformed(ActionEvent e) {
                    int fila = Integer.valueOf(e.getActionCommand());
                    Apoderado apoderado = new Apoderado();
                    apoderado = listaApoderados.get(fila);
                    new ApoderadoDaoImp().eliminar(apoderado);
                    LimpiarFormulario();
                    tablaApoderados.clearSelection();
                    MostrarApoderados();
                    ResetBotones();
                }

            };
            /*ESTA PARTE ES LA QUE AGREGA EL BOTTON ELIMINAR CON ACCION DECLARADA ANTERIORMENTE*/
            ButtonColumn buttonEliminar = new ButtonColumn(tablaApoderados, borrar, 8);
            buttonEliminar.setMnemonic(KeyEvent.VK_D);

            /* AGREGA LA ACCION AL BOTTON editar*/
            Action editar = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int fila = Integer.valueOf(e.getActionCommand());
                    Apoderado apoderado = new Apoderado();
                    apoderado = listaApoderados.get(fila);
                    txtRun.setText(apoderado.getRun());
                    txtRun.enableInputMethods(false);
                    txtUsuario.setText(apoderado.getUser());
                    txtTelefono.setText(apoderado.getTelefono());
                    txtCorreo.setText(apoderado.getCorreo());
                    txtNombre.setText(apoderado.getNombre());
                    txtApellido.setText(apoderado.getApellido());
                    chbRepresentante.setSelected(apoderado.getRepresentante() > 0);
                    btnAgregarApoderado.setVisible(false);
                    btnCancelar.setVisible(true);
                    btnGuardar.setVisible(true);
                }

            };
            /*AGREGA EL BOTTON EDITAR A LA COLUMNA CON LA ACCION DECLARADA ANTERIORMENTE*/
            ButtonColumn buttonEditar = new ButtonColumn(tablaApoderados, editar, 0);
            buttonEditar.setMnemonic(KeyEvent.VK_D);
        }
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
        PanelTitulo = new javax.swing.JPanel();
        lblAVOT = new javax.swing.JLabel();
        btnInicio = new javax.swing.JButton();
        PanelTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaApoderados = new javax.swing.JTable();
        PanelInsertar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtRun = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        chbRepresentante = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnAgregarApoderado = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

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

        PanelTabla.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista  Apoderados"));

        tablaApoderados.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaApoderados);

        javax.swing.GroupLayout PanelTablaLayout = new javax.swing.GroupLayout(PanelTabla);
        PanelTabla.setLayout(PanelTablaLayout);
        PanelTablaLayout.setHorizontalGroup(
            PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelTablaLayout.setVerticalGroup(
            PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTablaLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanelInsertar.setBorder(javax.swing.BorderFactory.createTitledBorder("Agregar Apoderado"));

        jLabel2.setText("Run");

        jLabel3.setText("Usuario");

        jLabel5.setText("Nombre");

        jLabel1.setText("Apellido");

        jLabel7.setText("Telefono");

        jLabel8.setText("Representante");

        jLabel9.setText("Correo");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAgregarApoderado.setText("Agregar");
        btnAgregarApoderado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarApoderadoActionPerformed(evt);
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
                .addContainerGap()
                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelInsertarLayout.createSequentialGroup()
                        .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9))
                        .addGap(63, 63, 63)
                        .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre)
                            .addComponent(txtRun)
                            .addComponent(txtApellido)
                            .addComponent(txtUsuario)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInsertarLayout.createSequentialGroup()
                        .addGap(0, 209, Short.MAX_VALUE)
                        .addComponent(chbRepresentante)
                        .addGap(51, 51, 51))
                    .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(PanelInsertarLayout.createSequentialGroup()
                            .addComponent(btnCancelar)
                            .addGap(99, 99, 99)
                            .addComponent(btnGuardar))
                        .addGroup(PanelInsertarLayout.createSequentialGroup()
                            .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8))
                            .addGap(28, 28, 28)
                            .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnAgregarApoderado)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        PanelInsertarLayout.setVerticalGroup(
            PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInsertarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtRun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(chbRepresentante))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAgregarApoderado)
                .addGap(18, 18, 18)
                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setVisible(false);
        setVisible(false);

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
                    .addComponent(PanelInsertar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        Admin(flag);
        this.setVisible(false);
        Index x = new Index(flag);
        x.setVisible(true);
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnAgregarApoderadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarApoderadoActionPerformed
        if (validarRut(txtRun.getText().trim()) == false) {
            this.setVisible(true);
            JOptionPane.showMessageDialog(null, "El rut ingresado no es valido o ya esta registrado");
        } else if (txtNombre.getText().trim().isEmpty()) {
            this.setVisible(true);
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un Nombre");
        } else if (txtApellido.getText().trim().isEmpty()) {
            this.setVisible(true);
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un Apellido");
        } else if (txtTelefono.getText().trim().isEmpty()) {
            this.setVisible(true);
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un Telefono");
        } else if (txtUsuario.getText().trim().isEmpty()) {
            this.setVisible(true);
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un Usuario");
        } else if (txtCorreo.getText().trim().isEmpty()) {
            this.setVisible(true);
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un Correo");
        } else {
            Apoderado apoderado = new Apoderado();
            apoderado.setRun(txtRun.getText());
            apoderado.setUser(txtUsuario.getText());
            apoderado.setTelefono(txtTelefono.getText());
            apoderado.setCorreo(txtCorreo.getText());
            apoderado.setNombre(txtNombre.getText());
            apoderado.setApellido(txtApellido.getText());
            if (chbRepresentante.isSelected()) {
                apoderado.setRepresentante(1);
            } else {
                apoderado.setRepresentante(0);
            }
            new ApoderadoDaoImp().insertar(apoderado);
            LimpiarFormulario();
            tablaApoderados.clearSelection();
            MostrarApoderados();
        }
    }//GEN-LAST:event_btnAgregarApoderadoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtNombre.getText().trim().isEmpty()) {
            this.setVisible(true);
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un Nombre");
        } else if (txtApellido.getText().trim().isEmpty()) {
            this.setVisible(true);
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un Apellido");
        } else if (txtTelefono.getText().trim().isEmpty()) {
            this.setVisible(true);
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un Telefono");
        } else if (txtUsuario.getText().trim().isEmpty()) {
            this.setVisible(true);
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un Usuario");
        } else if (txtCorreo.getText().trim().isEmpty()) {
            this.setVisible(true);
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un Correo");
        } else {
            Apoderado apoderado = new Apoderado();
            apoderado.setRun(txtRun.getText());
            apoderado.setUser(txtUsuario.getText());
            apoderado.setTelefono(txtTelefono.getText());
            apoderado.setCorreo(txtCorreo.getText());
            apoderado.setNombre(txtNombre.getText());
            apoderado.setApellido(txtApellido.getText());
            if (chbRepresentante.isSelected()) {
                apoderado.setRepresentante(1);
            } else {
                apoderado.setRepresentante(0);
            }
            new ApoderadoDaoImp().modificar(apoderado);
            LimpiarFormulario();
            tablaApoderados.clearSelection();
            MostrarApoderados();
            ResetBotones();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        LimpiarFormulario();
        ResetBotones();
        MostrarApoderados();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelInsertar;
    private javax.swing.JPanel PanelTabla;
    private javax.swing.JPanel PanelTitulo;
    private javax.swing.JButton btnAgregarApoderado;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnInicio;
    private javax.swing.JCheckBox chbRepresentante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAVOT;
    private javax.swing.JTable tablaApoderados;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRun;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
