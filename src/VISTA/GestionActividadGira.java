/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package VISTA;

import CONEXION.Conexion;
import DAO.ActividadGiraDaoImp;
import DTO.ActividadGira;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Atxy2k.CustomTextField.RestrictedTextField;

/**
 *
 * @author Seba
 */
public class GestionActividadGira extends javax.swing.JFrame {
    ArrayList<ActividadGira> listaActiviadGira;
    Conexion obj = new Conexion();
    DefaultTableModel modelo;
    
    /** Creates new form GestionarActividad */
    public GestionActividadGira() {
        initComponents();
        this.setLocationRelativeTo(null);
        MostrarActividadGira();
        RestrictedTextField restricted = new RestrictedTextField(txtCosto);
        restricted.setOnlyNums(rootPaneCheckingEnabled);
    }
    
    public void MostrarActividadGira(){
        listaActiviadGira = new ActividadGiraDaoImp().listar();
        modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("TIPO");
        modelo.addColumn("COSTO");
        modelo.addColumn("DESCRIPCION");
        modelo.addColumn("ESTADO");
        modelo.addColumn("");
        if (listaActiviadGira.size() > 0) {
            for (ActividadGira actividadGira : listaActiviadGira) {
                String rep;
                if (actividadGira.getEstado() == 0) {
                    rep = "INACTIVO";
                } else {
                    rep = "ACTIVO";
                }
                modelo.addRow(new Object[]{
                    actividadGira.getId_actividad(),
                    actividadGira.getTipo_actividad(),
                    actividadGira.getCosto(),
                    actividadGira.getDescripcion(),
                    rep,
                    "ELIMINAR"}
                );
            }
            tablaActividadesGira.setModel(modelo);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
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
        tablaActividadesGira = new javax.swing.JTable();
        PanelInsertar = new javax.swing.JPanel();
        txtActividad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnAgregarActividad = new javax.swing.JButton();
        RBActivo = new javax.swing.JRadioButton();
        RBInactivo = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("A.V.O.T. Local");
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
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(PanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAVOT)
                    .addComponent(btnInicio))
                .addContainerGap())
        );

        PanelTabla.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista  Actividades Gira"));

        tablaActividadesGira.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaActividadesGira);

        javax.swing.GroupLayout PanelTablaLayout = new javax.swing.GroupLayout(PanelTabla);
        PanelTabla.setLayout(PanelTablaLayout);
        PanelTablaLayout.setHorizontalGroup(
            PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelTablaLayout.setVerticalGroup(
            PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTablaLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanelInsertar.setBorder(javax.swing.BorderFactory.createTitledBorder("Agregar Actividad Gira"));

        jLabel3.setText("Tipo Actividad");

        jLabel4.setText("Costo");

        jLabel5.setText("Descripcion");

        jLabel6.setText("Estado");

        btnAgregarActividad.setText("Agregar");
        btnAgregarActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActividadActionPerformed(evt);
            }
        });

        BGrupEstado.add(RBActivo);
        RBActivo.setText("Activo");

        BGrupEstado.add(RBInactivo);
        RBInactivo.setText("Inactivo");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        javax.swing.GroupLayout PanelInsertarLayout = new javax.swing.GroupLayout(PanelInsertar);
        PanelInsertar.setLayout(PanelInsertarLayout);
        PanelInsertarLayout.setHorizontalGroup(
            PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInsertarLayout.createSequentialGroup()
                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelInsertarLayout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(btnAgregarActividad))
                    .addGroup(PanelInsertarLayout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                            .addGroup(PanelInsertarLayout.createSequentialGroup()
                                .addComponent(RBActivo)
                                .addGap(18, 18, 18)
                                .addComponent(RBInactivo))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInsertarLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(104, 104, 104)
                        .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(56, 56, 56))
        );
        PanelInsertarLayout.setVerticalGroup(
            PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInsertarLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtActividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelInsertarLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel5))
                    .addGroup(PanelInsertarLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(RBActivo)
                    .addComponent(RBInactivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(btnAgregarActividad)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PanelInsertar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        this.setVisible(false);
        Index x = new Index();
        x.setVisible(true);
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnAgregarActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActividadActionPerformed
        ActividadGira actividad = new ActividadGira();
        if(txtActividad.getText().trim().isEmpty()){
            this.setVisible(true);
            JOptionPane.showMessageDialog(null, "Por favor, ingrese una Actividad");
        }else if(txtCosto.getText().trim().isEmpty()){
            this.setVisible(true);
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un Costo");
        }else if(txtDescripcion.getText().trim().isEmpty()){
            this.setVisible(true);
            JOptionPane.showMessageDialog(null, "Por favor, ingrese una Descripcion");
        }else{
            actividad.setTipo_actividad(txtActividad.getText());
            actividad.setCosto(Integer.valueOf(txtCosto.getText()));
            actividad.setDescripcion(txtDescripcion.getText());
            if(RBActivo.isSelected()){
                actividad.setEstado(1);
            }else{
                actividad.setEstado(0);
            }
                new ActividadGiraDaoImp().insertar(actividad);
                txtActividad.setText(null);
                txtCosto.setText(null);
                txtDescripcion.setText(null);
                BGrupEstado.clearSelection();
                //Limpimpia la tabla
                tablaActividadesGira.clearSelection();
                //Setea nuevamente la tabla
                MostrarActividadGira();
        }
    }//GEN-LAST:event_btnAgregarActividadActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BGrupEstado;
    private javax.swing.JPanel PanelInsertar;
    private javax.swing.JPanel PanelTabla;
    private javax.swing.JPanel PanelTitulo;
    private javax.swing.JRadioButton RBActivo;
    private javax.swing.JRadioButton RBInactivo;
    private javax.swing.JButton btnAgregarActividad;
    private javax.swing.JButton btnInicio;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAVOT;
    private javax.swing.JTable tablaActividadesGira;
    private javax.swing.JTextField txtActividad;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextArea txtDescripcion;
    // End of variables declaration//GEN-END:variables

}
