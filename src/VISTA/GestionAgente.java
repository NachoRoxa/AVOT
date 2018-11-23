/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import CONEXION.Conexion;
import DAO.AgenteDaoImp;
import DTO.Agente;
import static DTO.ValidaRut.validarRut;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Atxy2k.CustomTextField.RestrictedTextField;
import VISTA.CONTROLES.ButtonColumn;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.input.KeyCode;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

/**
 *
 * @author Seba
 */
public class GestionAgente extends javax.swing.JFrame {

    Agente agente = new Agente();
    ArrayList<Agente> listaAgentes;
    Conexion obj = new Conexion();
    DefaultTableModel modelo;
    int flag;

    /**
     * Creates new form GestionarAgente
     *
     * @param admin
     */
    public GestionAgente(int admin) {
        Admin(admin);
        initComponents();
        this.setLocationRelativeTo(null);
        MostrarAgentes();
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
                            texto = texto.replace(".", "").replace("-", "");
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
        RestrictedTextField restricted1 = new RestrictedTextField(txtNombre);
        restricted1.setOnlyText(true);
        RestrictedTextField restricted2 = new RestrictedTextField(txtApellidoP);
        restricted2.setOnlyText(true);
        RestrictedTextField restricted3 = new RestrictedTextField(txtApellidoM);
        restricted3.setOnlyText(true);
        ResetBotones();
    }

    /**
     * *
     * Metodo para ver si el usuario posee perfil de administrador.
     *
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
        btnAgregarAgente.setVisible(true);
        btnCancelar.setVisible(false);
        btnGuardar.setVisible(false);
    }

    public void LimpiarFormulario() {
        txtRun.setText(null);
        txtUsuario.setText(null);
        txtContraseña.setText(null);
        txtNombre.setText(null);
        txtApellidoP.setText(null);
        txtApellidoM.setText(null);
        chbAdministrador.setSelected(false);
        BGrupEstado.clearSelection();
    }

    public void MostrarAgentes() {
        listaAgentes = new AgenteDaoImp().listar();
        modelo = new DefaultTableModel();
        modelo.addColumn("");
        modelo.addColumn("RUN");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("APELLIDO");
        modelo.addColumn("APELLIDO MATERNO");
        modelo.addColumn("USUARIO");
        modelo.addColumn("ADMIN");
        modelo.addColumn("ESTADO");
        modelo.addColumn("");
        if (listaAgentes.size() > 0) {
            for (Agente agente : listaAgentes) {
                String admin;
                String estado;
                if (agente.getAdministrador() == 0) {
                    admin = "NO";
                } else {
                    admin = "SI";
                }
                if (agente.getEstado() == 0) {
                    estado = "INACTIVO";
                } else {
                    estado = "ACTIVO";
                }
                modelo.addRow(new Object[]{
                    "EDITAR",
                    agente.getRun(),
                    agente.getNombre(),
                    agente.getApellido_paterno(),
                    agente.getApellido_materno(),
                    agente.getUser(),
                    admin,
                    estado,
                    "ELIMINAR"}
                );
            }
            tablaAgentes.setModel(modelo);

            /* AGREGA LA ACCION DEL BOTTON ELIMINAR*/
            Action borrar = new AbstractAction() {
                @Override
                /*ESTE ES EL METODO DEL BOTON CUANDO SE PRESIONA*/
                public void actionPerformed(ActionEvent e) {
                    int fila = Integer.valueOf(e.getActionCommand());
                    Agente agente = new Agente();
                    agente = listaAgentes.get(fila);
                    new AgenteDaoImp().eliminar(agente);
                    LimpiarFormulario();
                    tablaAgentes.clearSelection();
                    MostrarAgentes();
                    ResetBotones();
                }
            };
            
            /*ESTA PARTE ES LA QUE AGREGA EL BOTTON ELIMINAR CON ACCION DECLARADA ANTERIORMENTE*/
            ButtonColumn buttonEliminar = new ButtonColumn(tablaAgentes, borrar, 8);
            buttonEliminar.setMnemonic(KeyEvent.VK_D);

            /* AGREGA LA ACCION AL BOTTON editar*/
            Action editar = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int fila = Integer.valueOf(e.getActionCommand());
                    agente = listaAgentes.get(fila);
                    txtRun.setText(agente.getRun());
                    txtRun.enableInputMethods(false);
                    txtNombre.setText(agente.getNombre());
                    txtApellidoP.setText(agente.getApellido_paterno());
                    txtApellidoM.setText(agente.getApellido_materno());
                    txtUsuario.setText(agente.getUser());
                    txtContraseña.setText(agente.getPasswd());
                    chbAdministrador.setSelected(agente.getAdministrador() > 0);
                    RBActivo.setSelected(agente.getEstado() > 0);
                    btnAgregarAgente.setVisible(false);
                    btnCancelar.setVisible(true);
                    btnGuardar.setVisible(true);
                }

            };
            /*AGREGA EL BOTTON EDITAR A LA COLUMNA CON LA ACCION DECLARADA ANTERIORMENTE*/
            ButtonColumn buttonEditar = new ButtonColumn(tablaAgentes, editar, 0);
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

        BGrupEstado = new javax.swing.ButtonGroup();
        PanelTitulo = new javax.swing.JPanel();
        lblAVOT = new javax.swing.JLabel();
        btnInicio = new javax.swing.JButton();
        PanelTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAgentes = new javax.swing.JTable();
        PanelInsertar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtRun = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtApellidoP = new javax.swing.JTextField();
        txtApellidoM = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnAgregarAgente = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        chbAdministrador = new javax.swing.JCheckBox();
        RBActivo = new javax.swing.JRadioButton();
        RBInactivo = new javax.swing.JRadioButton();
        txtContraseña = new javax.swing.JTextField();
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

        PanelTabla.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista  Agentes"));

        tablaAgentes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaAgentes);

        javax.swing.GroupLayout PanelTablaLayout = new javax.swing.GroupLayout(PanelTabla);
        PanelTabla.setLayout(PanelTablaLayout);
        PanelTablaLayout.setHorizontalGroup(
            PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelTablaLayout.setVerticalGroup(
            PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTablaLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanelInsertar.setBorder(javax.swing.BorderFactory.createTitledBorder("Agregar Agente"));

        jLabel2.setText("Run");

        jLabel3.setText("Usuario");

        jLabel4.setText("Contraseña");

        jLabel5.setText("Nombre");

        jLabel6.setText("Estado");

        btnAgregarAgente.setText("Agregar");
        btnAgregarAgente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAgenteActionPerformed(evt);
            }
        });

        jLabel1.setText("Apellido Paterno");

        jLabel7.setText("Apellido Materno");

        jLabel8.setText("Administrador");

        BGrupEstado.add(RBActivo);
        RBActivo.setText("Activo");

        BGrupEstado.add(RBInactivo);
        RBInactivo.setText("Inactivo");

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
                .addGap(25, 25, 25)
                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInsertarLayout.createSequentialGroup()
                        .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelInsertarLayout.createSequentialGroup()
                                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtApellidoP, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtApellidoM, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtUsuario)
                                    .addComponent(txtContraseña)
                                    .addGroup(PanelInsertarLayout.createSequentialGroup()
                                        .addComponent(chbAdministrador)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(PanelInsertarLayout.createSequentialGroup()
                                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2))
                                .addGap(61, 61, 61)
                                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombre)
                                    .addComponent(txtRun)))
                            .addGroup(PanelInsertarLayout.createSequentialGroup()
                                .addComponent(btnCancelar)
                                .addGap(107, 107, 107)
                                .addComponent(btnGuardar)))
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInsertarLayout.createSequentialGroup()
                        .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnAgregarAgente)
                            .addGroup(PanelInsertarLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(63, 63, 63)
                                .addComponent(RBActivo)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RBInactivo)
                        .addGap(45, 45, 45))))
        );
        PanelInsertarLayout.setVerticalGroup(
            PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInsertarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtRun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(20, 20, 20)
                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(20, 20, 20)
                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(chbAdministrador))
                .addGap(13, 13, 13)
                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(RBActivo)
                    .addComponent(RBInactivo))
                .addGap(18, 18, 18)
                .addComponent(btnAgregarAgente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelInsertar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnAgregarAgenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAgenteActionPerformed
        //Crea un nuevo objetoAgente
        Agente agente = new Agente();
        if (validarRut(txtRun.getText().trim()) == false) {
            this.setVisible(true);
            JOptionPane.showMessageDialog(null, "El rut ingresado no es valido o ya esta registrado");
        } else if (txtNombre.getText().trim().isEmpty()) {
            this.setVisible(true);
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un Nombre");
        } else if (txtApellidoP.getText().trim().isEmpty()) {
            this.setVisible(true);
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un Apellido Paterno");
        } else if (txtApellidoM.getText().trim().isEmpty()) {
            this.setVisible(true);
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un Apellido Materno");
        } else if (txtUsuario.getText().trim().isEmpty()) {
            this.setVisible(true);
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un Usuario");
        } else if (txtContraseña.getText().trim().isEmpty()) {
            this.setVisible(true);
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un Pasword");
        } else {

            agente.setRun(txtRun.getText());
            agente.setNombre(txtNombre.getText());
            agente.setApellido_paterno(txtApellidoP.getText());
            agente.setApellido_materno(txtApellidoM.getText());
            agente.setUser(txtUsuario.getText());
            agente.setPasswd(txtContraseña.getText());
            if (chbAdministrador.isSelected()) {
                agente.setAdministrador(1);
            } else {
                agente.setAdministrador(0);
            }
            if (RBActivo.isSelected()) {
                agente.setEstado(1);
            } else {
                agente.setEstado(0);
            }
            try {
                //Agrega un Agente
                new AgenteDaoImp().insertar(agente);
                //Limpia los datos de los txtBox
                LimpiarFormulario();
                //Limpimpia la tabla
                tablaAgentes.clearSelection();
                //Setea nuevamente la tabla
                MostrarAgentes();
            } catch (Exception e) {

            }

        }
    }//GEN-LAST:event_btnAgregarAgenteActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        ResetBotones();
        LimpiarFormulario();
        tablaAgentes.clearSelection();
        MostrarAgentes();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        agente.setRun(txtRun.getText());
        agente.setNombre(txtNombre.getText());
        agente.setApellido_paterno(txtApellidoP.getText());
        agente.setApellido_materno(txtApellidoM.getText());
        agente.setUser(txtUsuario.getText());
        agente.setPasswd(txtContraseña.getText());
        if (chbAdministrador.isSelected()) {
            agente.setAdministrador(1);
        } else {
            agente.setAdministrador(0);
        }
        if (RBActivo.isSelected()) {
            agente.setEstado(1);
        } else {
            agente.setEstado(0);
        }
        new AgenteDaoImp().modificar(agente);
        ResetBotones();
        LimpiarFormulario();
        tablaAgentes.clearSelection();
        MostrarAgentes();
    }//GEN-LAST:event_btnGuardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BGrupEstado;
    private javax.swing.JPanel PanelInsertar;
    private javax.swing.JPanel PanelTabla;
    private javax.swing.JPanel PanelTitulo;
    private javax.swing.JRadioButton RBActivo;
    private javax.swing.JRadioButton RBInactivo;
    private javax.swing.JButton btnAgregarAgente;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnInicio;
    private javax.swing.JCheckBox chbAdministrador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAVOT;
    private javax.swing.JTable tablaAgentes;
    private javax.swing.JTextField txtApellidoM;
    private javax.swing.JTextField txtApellidoP;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRun;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
