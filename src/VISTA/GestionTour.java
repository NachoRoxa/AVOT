/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import Atxy2k.CustomTextField.RestrictedTextField;
import CONEXION.Conexion;
import DAO.AgenteDaoImp;
import DAO.TourDaoImp;
import DTO.Agente;
import DTO.Tour;
import VISTA.CONTROLES.ButtonColumn;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.stream.IntStream;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Seba
 */
public class GestionTour extends javax.swing.JFrame {
    ArrayList<Tour> listaTour;
    ArrayList<Agente> listaAgente;
    Agente agente;
    Conexion obj = new Conexion();
    DefaultTableModel modelo;
    int flag;
    Tour tour;
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    KeyListener key = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar()) && e.getKeyCode() != KeyEvent.VK_LEFT && e.getKeyCode() != KeyEvent.VK_RIGHT && e.getKeyCode() != KeyEvent.VK_DELETE && e.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar()) && e.getKeyCode() != KeyEvent.VK_LEFT && e.getKeyCode() != KeyEvent.VK_RIGHT && e.getKeyCode() != KeyEvent.VK_DELETE && e.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                } else {
                    int[] mesesUp = {1,3,5,7,8,10,12};
                    int[] mesesDn = {4,6,9,11};
                    String texto;
                    texto = ((JTextField)(e.getSource())).getText();
                    texto = texto.replace("/", "");
                    String dia;
                    String mes;
                    String ano;
                    int anoInt;
                    int mesInt;
                    boolean bisiesto = false;
                    GregorianCalendar calendar = new GregorianCalendar();
                    switch (texto.length()) {
                        case 8:
                            String[] array = texto.split("");
                            dia = array[0] + array[1];
                            mes = array[2] + array[3];
                            ano = array[4] + array[5] + array[6] + array[7];
                            anoInt = Integer.parseInt(ano);
                            if (calendar.isLeapYear(anoInt)) {
                                bisiesto = true;
                            }
                            if (Integer.parseInt(mes) > 12) {
                                mes = "12";
                               
                            } else if (Integer.parseInt(mes) < 1) {
                                mes = "01";
                                
                            }
                            mesInt = Integer.parseInt(mes);
                            if (Integer.parseInt(mes) == 2) {
                                if (bisiesto && Integer.parseInt(dia) > 29) {
                                    dia = "29";
                                } else if (Integer.parseInt(dia) > 28) {
                                    dia = "28";
                                }

                            } else if (IntStream.of(mesesUp).anyMatch(x -> x == mesInt) && Integer.parseInt(dia)>31 ) {
                                dia = "31"; 
                            } else if (IntStream.of(mesesDn).anyMatch(x -> x == mesInt) && Integer.parseInt(dia)>30 ) {
                                dia = "30";
                            } else if (Integer.parseInt(dia)<1 ) {
                                dia = "01"; 
                            } 
                            ((JTextField)(e.getSource())).setText(dia+"/"+mes+"/"+ano);
                            
                        default:
                            texto = texto.replace("/", "");
                            
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar()) && e.getKeyCode() != KeyEvent.VK_LEFT && e.getKeyCode() != KeyEvent.VK_RIGHT && e.getKeyCode() != KeyEvent.VK_DELETE && e.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                }else{
                {
                    int[] mesesUp = {1,3,5,7,8,10,12};
                    int[] mesesDn = {4,6,9,11};
                    String texto;
                    texto = ((JTextField)(e.getSource())).getText();
                    texto = texto.replace("/", "");
                    String dia;
                    String mes;
                    String ano;
                    int anoInt;
                    int mesInt;
                    boolean bisiesto = false;
                    GregorianCalendar calendar = new GregorianCalendar();
                    switch (texto.length()) {
                        case 8:
                            String[] array = texto.split("");
                            dia = array[0] + array[1];
                            mes = array[2] + array[3];
                            ano = array[4] + array[5] + array[6] + array[7];
                            anoInt = Integer.parseInt(ano);
                            if (calendar.isLeapYear(anoInt)) {
                                bisiesto = true;
                            }
                            if (Integer.parseInt(mes) > 12) {
                                mes = "12";
                               
                            } else if (Integer.parseInt(mes) < 1) {
                                mes = "01";
                                
                            }
                            mesInt = Integer.parseInt(mes);
                            if (Integer.parseInt(mes) == 2) {
                                if (bisiesto && Integer.parseInt(dia) > 29) {
                                    dia = "29";
                                } else if (Integer.parseInt(dia) > 28) {
                                    dia = "28";
                                }
                            } else if (IntStream.of(mesesUp).anyMatch(x -> x == mesInt) && Integer.parseInt(dia)>31 ) {
                                dia = "31"; 
                            } else if (IntStream.of(mesesDn).anyMatch(x -> x == mesInt) && Integer.parseInt(dia)>30 ) {
                                dia = "30";
                            } else if (Integer.parseInt(dia)<1 ) {
                                dia = "01"; 
                            } 
                            ((JTextField)(e.getSource())).setText(dia+"/"+mes+"/"+ano);
                            
                        default:
                            texto = texto.replace("/", "");
                            
                    }
                }
                }
            }
        };
    /**
     * Creates new form GestionTour
     * @param admin
     */
    public GestionTour(int admin)
    {
        Admin(admin);
        initComponents();
        this.setLocationRelativeTo(null);
        MostrarTours();
        datosComboBox();
        ResetBotones();
        RestrictedTextField restrictedInit = new RestrictedTextField(txtFechaInicio);
        restrictedInit.setLimit(10);
        RestrictedTextField restrictedTer = new RestrictedTextField(txtFechaTermino);
        restrictedTer.setLimit(10);
        txtFechaInicio.addKeyListener(key);
        txtFechaTermino.addKeyListener(key);
    }
    
    public void LimpiarFormulario()
    {
        //txtCosto.setText(null);        
        txtDescripcion.setText(null);
        cbAgente.setSelectedIndex(0);
        txtFechaInicio.setText(null);
        txtFechaTermino.setText(null);
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
    
    public void ResetBotones()
    {
        btnAgregarActividad.setVisible(true);
        btnCancelar.setVisible(false);
        btnGuardar.setVisible(false);
    }
    
    public void MostrarTours(){
        boolean vacio = false;
        listaTour = new TourDaoImp().listar();
        modelo = new DefaultTableModel();
        modelo.addColumn("");
        modelo.addColumn("ID");
        modelo.addColumn("VALOR");
        modelo.addColumn("DESCRIPCION");
        modelo.addColumn("NUMERO CONTRATO");
        modelo.addColumn("NOMBRE AGENTE");
        modelo.addColumn("APELLIDO P");
        modelo.addColumn("CREACION");
        modelo.addColumn("INICIO");
        modelo.addColumn("TERMINO");
        modelo.addColumn("");
        if (listaTour.size() > 0) {
            for (Tour tour : listaTour) {
                modelo.addRow(new Object[]{
                    "EDITAR",
                    tour.getId_tour(),
                    tour.getValor_total(),
                    tour.getDescripcion(),
                    tour.getNumero_contrato(),
                    tour.getAgente().getNombre(),
                    tour.getAgente().getApellido_paterno(),
                    tour.getFecha_creacion(),
                    tour.getFecha_inicio(),
                    tour.getFechaTermino(),
                    "ELIMINAR"}
                );
            }
            tablaTours.setModel(modelo);
            
            Action borrar = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int fila = Integer.valueOf(e.getActionCommand());
                    tour = new Tour();
                    tour = listaTour.get(fila);
                    new TourDaoImp().eliminar(tour);
                    LimpiarFormulario();
                    MostrarTours();                    
                }
            };
            
            ButtonColumn buttonEliminar = new ButtonColumn(tablaTours, borrar, 10);            
            buttonEliminar.setMnemonic(KeyEvent.VK_D);
            
                    
            Action editar = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int fila = Integer.valueOf(e.getActionCommand());
                    tour = listaTour.get(fila);
                    txtDescripcion.setText(tour.getDescripcion());
                    cbAgente.setSelectedItem(tour.getAgente());
                    txtFechaInicio.setText(formato.format(tour.getFecha_inicio()));
                    txtFechaTermino.setText(formato.format(tour.getFechaTermino()));
                    btnAgregarActividad.setVisible(false);
                    btnCancelar.setVisible(true);
                    btnGuardar.setVisible(true);
                }
            };
            
            ButtonColumn buttonEditar = new ButtonColumn(tablaTours, editar, 0);
            buttonEditar.setMnemonic(KeyEvent.VK_D);
        }
    }

    public void datosComboBox()
    {
        listaAgente = new AgenteDaoImp().listar();
        for(Agente agente:listaAgente)
        {
            cbAgente.addItem(agente.getNombre()+" "+agente.getApellido_paterno());
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

        PanelTitulo = new javax.swing.JPanel();
        lblAVOT = new javax.swing.JLabel();
        btnInicio = new javax.swing.JButton();
        PanelTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTours = new javax.swing.JTable();
        PanelInsertar = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnAgregarActividad = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        cbAgente = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        txtFechaInicio = new javax.swing.JTextField();
        txtFechaTermino = new javax.swing.JTextField();

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

        PanelTabla.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista Tours"));

        tablaTours.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaTours);

        javax.swing.GroupLayout PanelTablaLayout = new javax.swing.GroupLayout(PanelTabla);
        PanelTabla.setLayout(PanelTablaLayout);
        PanelTablaLayout.setHorizontalGroup(
            PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE))
        );
        PanelTablaLayout.setVerticalGroup(
            PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTablaLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanelInsertar.setBorder(javax.swing.BorderFactory.createTitledBorder("Agregar Tour"));

        jLabel5.setText("Descripcion");

        jLabel6.setText("Fecha Inicio");

        btnAgregarActividad.setText("Agregar");
        btnAgregarActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActividadActionPerformed(evt);
            }
        });

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        jLabel1.setText("Agente");

        cbAgente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Agente" }));

        jLabel2.setText("Fecha Termino");

        btnCancelar.setText("Cancelar");

        btnGuardar.setText("Guardar");

        javax.swing.GroupLayout PanelInsertarLayout = new javax.swing.GroupLayout(PanelInsertar);
        PanelInsertar.setLayout(PanelInsertarLayout);
        PanelInsertarLayout.setHorizontalGroup(
            PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInsertarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelInsertarLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar)
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInsertarLayout.createSequentialGroup()
                        .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelInsertarLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInsertarLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2)))
                        .addGap(18, 18, 18)
                        .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbAgente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechaTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
            .addGroup(PanelInsertarLayout.createSequentialGroup()
                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelInsertarLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(btnAgregarActividad))
                    .addGroup(PanelInsertarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(PanelInsertarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelInsertarLayout.setVerticalGroup(
            PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInsertarLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAgente))
                .addGap(30, 30, 30)
                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechaTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(btnAgregarActividad)
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

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt)
    {
        
    }
    
    private void buttonEliminarActionPerformed(java.awt.event.ActionEvent evt)
    {
        
    }
    private void btnAgregarActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActividadActionPerformed
        Tour tour = new Tour();
        if(txtDescripcion.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Por favor ingrese una descripcion del tour");
        }else if(cbAgente.getSelectedIndex()==0)
        {
            JOptionPane.showMessageDialog(null, "Por favor seleccione un Agente");
        }else
        {
            agente = new Agente();
            agente = listaAgente.get(cbAgente.getSelectedIndex()-1);
            //tour.setValor_total(Integer.parseInt(txtCosto.getText()));
            tour.setDescripcion(txtDescripcion.getText());
            tour.setAgente(agente);
            try{
            tour.setFecha_inicio(formato.parse(txtFechaInicio.getText()));
            tour.setFechaTermino(formato.parse(txtFechaTermino.getText()));
                new TourDaoImp().insertar(tour);
                LimpiarFormulario();
                tablaTours.clearSelection();
                MostrarTours();
            }catch(Exception ex){
                 JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        
    }//GEN-LAST:event_btnAgregarActividadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelInsertar;
    private javax.swing.JPanel PanelTabla;
    private javax.swing.JPanel PanelTitulo;
    private javax.swing.JButton btnAgregarActividad;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnInicio;
    private javax.swing.JComboBox<String> cbAgente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAVOT;
    private javax.swing.JTable tablaTours;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtFechaInicio;
    private javax.swing.JTextField txtFechaTermino;
    // End of variables declaration//GEN-END:variables
}
