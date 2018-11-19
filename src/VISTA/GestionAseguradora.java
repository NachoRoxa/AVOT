/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import Atxy2k.CustomTextField.RestrictedTextField;
import CONEXION.Conexion;
import DAO.AseguradoraDaoImp;
import DTO.Aseguradora;
import static DTO.ValidaRut.validarRut;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Seba
 */
public class GestionAseguradora extends javax.swing.JFrame {

    ArrayList<Aseguradora> listaAseguradoras;
    Conexion obj = new Conexion();
    DefaultTableModel modelo;
    int flag;

    /**
     * Creates new form GestionAseguradora
     * @param admin
     */
    public GestionAseguradora(int admin) {
        Admin(admin);
        initComponents();
        this.setLocationRelativeTo(null);
        MostrarAseguradoras();
        RestrictedTextField rtf = new RestrictedTextField(txtRut);
        rtf.setLimit(12);
        RestrictedTextField restricted1 = new RestrictedTextField(txtNombre);
        restricted1.setOnlyText(true);
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

    public void MostrarAseguradoras() {
        listaAseguradoras = new AseguradoraDaoImp().listar();
        modelo = new DefaultTableModel();
        modelo.addColumn("RUN");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("DIRECCION");
        modelo.addColumn("");
        if (listaAseguradoras.size() > 0) {
            for (Aseguradora aseguradora : listaAseguradoras) {
                modelo.addRow(new Object[]{
                    aseguradora.getRut(),
                    aseguradora.getNombre_aseguradora(),
                    aseguradora.getDireccion(),
                    "ELIMINAR"}
                );
            }
            tablaAseguradoras.setModel(modelo);
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
        tablaAseguradoras = new javax.swing.JTable();
        PanelInsertar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtRut = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        btnAgregarAseguradora = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

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

        PanelTabla.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista  Aseguradoras"));

        tablaAseguradoras.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaAseguradoras);

        javax.swing.GroupLayout PanelTablaLayout = new javax.swing.GroupLayout(PanelTabla);
        PanelTabla.setLayout(PanelTablaLayout);
        PanelTablaLayout.setHorizontalGroup(
            PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelTablaLayout.setVerticalGroup(
            PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTablaLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanelInsertar.setBorder(javax.swing.BorderFactory.createTitledBorder("Agregar Aseguradoras"));

        jLabel2.setText("Run");

        jLabel5.setText("Nombre");

        btnAgregarAseguradora.setText("Agregar");
        btnAgregarAseguradora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAseguradoraActionPerformed(evt);
            }
        });

        jLabel1.setText("Direccion");

        javax.swing.GroupLayout PanelInsertarLayout = new javax.swing.GroupLayout(PanelInsertar);
        PanelInsertar.setLayout(PanelInsertarLayout);
        PanelInsertarLayout.setHorizontalGroup(
            PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInsertarLayout.createSequentialGroup()
                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelInsertarLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelInsertarLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelInsertarLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelInsertarLayout.createSequentialGroup()
                                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5))
                                .addGap(50, 50, 50)))))
                .addGap(37, 37, 37))
            .addGroup(PanelInsertarLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(btnAgregarAseguradora)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelInsertarLayout.setVerticalGroup(
            PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInsertarLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(50, 50, 50)
                .addGroup(PanelInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(btnAgregarAseguradora)
                .addGap(37, 37, 37))
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

    private void btnAgregarAseguradoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAseguradoraActionPerformed
        Aseguradora as = new Aseguradora();
        
        
        if(validarRut(txtRut.getText().trim())==false){
            JOptionPane.showMessageDialog(null, "Ingrese un RUT valido");
        }else if (txtRut.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el RUT Valido");
        } else if (txtNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el Nombre de la Aseguradora");
        } else if (txtDireccion.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese la direccion de la Aseguradora");
        } else {
            as.setRut(txtRut.getText());
            as.setNombre_aseguradora(txtNombre.getText());
            as.setDireccion(txtDireccion.getText());
            new AseguradoraDaoImp().insertar(as);
            txtRut.setText(null);
            txtNombre.setText(null);
            txtDireccion.setText(null);
            tablaAseguradoras.clearSelection();
            MostrarAseguradoras();
        }
    }//GEN-LAST:event_btnAgregarAseguradoraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelInsertar;
    private javax.swing.JPanel PanelTabla;
    private javax.swing.JPanel PanelTitulo;
    private javax.swing.JButton btnAgregarAseguradora;
    private javax.swing.JButton btnInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAVOT;
    private javax.swing.JTable tablaAseguradoras;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRut;
    // End of variables declaration//GEN-END:variables
}
