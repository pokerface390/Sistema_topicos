/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import ClasesStaticas.Usuario;
import Conexion.MySQLConnection;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.sql.ResultSet;
import javax.swing.JTable;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author chiri
 */
public class Principal2 extends javax.swing.JFrame {

    private Timer timer;
    private Usuario usuario;

    public Principal2() {

    }

    public Principal2(Usuario usuario) {
        this.usuario = usuario;
        initComponents();
        mostrarDatosUsuario();
        ajustarVisibilidadSegunRol();
        ((CardLayout) jPanel4.getLayout()).show(jPanel4, "card6");
        jDateChooser1.setDate(new java.util.Date());
        jDateChooser1.setEnabled(false);
        cargarDatosVenta();
        cargarDatosEnTabla();
    }

    private void cargarDatosEnTabla() {
        DefaultTableModel model = (DefaultTableModel) Altas.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos

        try (Connection conn = MySQLConnection.getConnection()) {
            String query = "SELECT RFC_empleado, nombre, apellido, puesto, correo, contraseña, idestacionT FROM gasolinera_mia.empleado";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String RFC_empleado = rs.getString("RFC_empleado");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String puesto = rs.getString("puesto");
                String correo = rs.getString("correo");
                String contraseña = rs.getString("contraseña");
                String idestacionT = rs.getString("idestacionT");

                model.addRow(new Object[]{RFC_empleado, nombre, apellido, puesto, correo, contraseña, idestacionT});
            }

            // Agregar una fila vacía al final
            model.addRow(new Object[]{"", "", "", "", "", "", ""});

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los datos de la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarDatosVenta() {
        DefaultTableModel model = (DefaultTableModel) TVenta.getModel();
        model.setRowCount(0);

        String query = "SELECT id_venta, tipo_gasolina, tipo_pago, precio_total, fecha, RFC_empleado, RFC_Cliente, litros FROM venta";

        try (Connection conn = MySQLConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int idVenta = rs.getInt("id_venta");
                String tipoGasolina = rs.getString("tipo_gasolina");
                String tipoPago = rs.getString("tipo_pago");
                double precioTotal = rs.getDouble("precio_total");
                java.sql.Date fecha = rs.getDate("fecha");
                String rfcEmpleado = rs.getString("RFC_empleado");
                String rfcCliente = rs.getString("RFC_Cliente");
                double litros = rs.getDouble("litros");

                model.addRow(new Object[]{idVenta, tipoGasolina, tipoPago, precioTotal, fecha, rfcEmpleado, rfcCliente, litros});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los datos de ventas.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void ajustarVisibilidadSegunRol() {
        if ("Despachador".equals(usuario.getPuesto())) {
            AltaCliente.setVisible(false);
            Facturar.setVisible(false);
        } else {
            AltaCliente.setVisible(true);
            Facturar.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Facturar = new javax.swing.JLabel();
        AltaCliente = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblSucursal = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        GasolinaTipo = new javax.swing.JComboBox<>();
        jTextField2 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        Pago = new javax.swing.JComboBox<>();
        Quitar = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Carga = new javax.swing.JProgressBar();
        Vender = new javax.swing.JButton();
        btonLimpiar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TVenta = new javax.swing.JTable();
        BuscarPorID = new javax.swing.JButton();
        buscar = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Cliente = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        RFC = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Aceptar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Altas = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/sell_3319.png"))); // NOI18N
        jLabel1.setText("VENTA");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        Facturar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Facturar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Facturar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bank_bill_finance_invoice_money_payment_receipt_icon_123239.png"))); // NOI18N
        Facturar.setText("FACTURAR");
        Facturar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Facturar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FacturarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FacturarMouseEntered(evt);
            }
        });

        AltaCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AltaCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AltaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/register_login_signup_icon_219991 (1).png"))); // NOI18N
        AltaCliente.setText("ALTA EMPLEADO");
        AltaCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        AltaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AltaClienteMouseClicked(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/income_money_earnings_wallet_coins_euros_icon_144634.png"))); // NOI18N
        jLabel19.setText("REPORTE DE VENTAS");
        jLabel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Facturar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(AltaCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Facturar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AltaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 200, 400));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Elephant", 1, 36)); // NOI18N
        jLabel2.setText("GAS MAX");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/gas2.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/gas2.png"))); // NOI18N

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/artboard_123063.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Sistema De Gas Max");

        lblUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUsuario.setText("Usuario:");

        lblSucursal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSucursal.setText("Sucursal:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel9))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSucursal, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))))
                .addGap(146, 146, 146)
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addComponent(jLabel4)
                .addContainerGap(172, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblUsuario)
                                .addGap(8, 8, 8)
                                .addComponent(lblSucursal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 90));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.CardLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Litros de Gasolina");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 34, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Tipos de gasolina");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Precio Total");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Fecha");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Tipo de Pago");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel5.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 65, 156, -1));

        GasolinaTipo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        GasolinaTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Diesel", "Magna", "Premium" }));
        jPanel5.add(GasolinaTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 128, 156, -1));

        jTextField2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel5.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 147, -1));
        jPanel5.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 306, 153, -1));

        Pago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Tarjeta", "Efectivo" }));
        jPanel5.add(Pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 186, 156, -1));

        Quitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/car_wash_icon_135814_1.png"))); // NOI18N
        jPanel5.add(Quitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/4213872-ecology-electric-energy-fuel-fuel-station-petrol-power_115441.png"))); // NOI18N
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, -1, -1));
        jPanel5.add(Carga, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 220, 20));

        Vender.setBackground(new java.awt.Color(204, 204, 255));
        Vender.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Vender.setText("VENDER");
        Vender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VenderActionPerformed(evt);
            }
        });
        jPanel5.add(Vender, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, 140, -1));

        btonLimpiar.setBackground(new java.awt.Color(204, 204, 255));
        btonLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btonLimpiar.setText("NUEVA VENTA");
        btonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btonLimpiarActionPerformed(evt);
            }
        });
        jPanel5.add(btonLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, -1, -1));

        jPanel4.add(jPanel5, "card2");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        TVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id_venta", " tipo_gasolina", "tipo_pago", "precio_total", "fecha", "RFC_empleado", "RFC_Cliente", "litros"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TVenta);

        BuscarPorID.setBackground(new java.awt.Color(204, 204, 255));
        BuscarPorID.setText("Buscar");
        BuscarPorID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarPorIDActionPerformed(evt);
            }
        });

        jLabel10.setText("Buscar por ID venta");

        Cliente.setBackground(new java.awt.Color(204, 204, 255));
        Cliente.setText("Buscar");
        Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClienteActionPerformed(evt);
            }
        });

        jLabel15.setText("Buscar al cliente por nombre");

        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });

        RFC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel13.setText("Si quieres Cambiar el RFC por el encontrado Seleccionada en la tabla buscando por ID Venta y pon el Boton aceptar");

        Aceptar.setBackground(new java.awt.Color(204, 204, 255));
        Aceptar.setText("Aceptar");
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 204, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Registrar Cliente ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Si El cliente no se encuentra Registrado por favor Registrarlo ahora");

        jButton4.setBackground(new java.awt.Color(204, 204, 255));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton4.setText("GENERAR FACTURA");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BuscarPorID)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Cliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RFC, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Aceptar))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(jLabel16)))
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BuscarPorID))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Cliente)
                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(RFC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(Aceptar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jLabel16)))
                .addContainerGap())
        );

        jPanel4.add(jPanel7, "card4");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        Altas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "RFC_empleado", "nombre", "apellido", "puesto", "correo", "contraseña", "idestacionT"
            }
        ));
        jScrollPane2.setViewportView(Altas);

        jButton3.setBackground(new java.awt.Color(204, 204, 255));
        jButton3.setText("DAR DE ALTA A UN CLIENTE ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel18.setText("INGRESA LOS DATOS DIRECTAMENTE EN LA TABLA ");

        jButton5.setBackground(new java.awt.Color(204, 204, 255));
        jButton5.setText("ELIMINAR REGISTRO DEL EMPLEADO");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(204, 204, 255));
        jButton6.setText("MODIFICAR REGISTRO EMPLEADO");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(jLabel18))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jButton3)
                        .addGap(29, 29, 29)
                        .addComponent(jButton5)
                        .addGap(34, 34, 34)
                        .addComponent(jButton6)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel18)
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel6, "card3");

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jDateChooser2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jDateChooser2AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jDateChooser2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDateChooser2MouseClicked(evt);
            }
        });

        jLabel20.setText("Selecciona el dia que quieres verlas ventas por dia");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "precio_total", "tipo_gasolina", "fecha"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        jButton7.setBackground(new java.awt.Color(204, 204, 255));
        jButton7.setText("Buscar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(204, 204, 255));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton8.setText("GENERAR PDF DE VENTA DEL DIA");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel20)
                        .addGap(26, 26, 26)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jButton8)))
                .addContainerGap(162, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton8)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel8, "card5");

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel9, "card6");

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 108, 770, 450));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("¿Tiene cuanta el Ciente?    Registra al cliente ahora ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 500, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 204));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/4213459-common-door-exit-logout-out-signout_115411.png"))); // NOI18N
        jButton1.setText("Cerrar Sesion");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 510, 200, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 999, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        ((CardLayout) jPanel4.getLayout()).show(jPanel4, "card2");
    }//GEN-LAST:event_jLabel1MouseClicked

    private void mostrarDatosUsuario() {
        lblUsuario.setText("Usuario: " + usuario.getNombre());
        lblSucursal.setText("Sucursal: Estacion central");
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void FacturarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FacturarMouseClicked
        ((CardLayout) jPanel4.getLayout()).show(jPanel4, "card4");
    }//GEN-LAST:event_FacturarMouseClicked

    private void VenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VenderActionPerformed
        String litrosGasolina = jTextField1.getText();
        String tipoGasolina = (String) GasolinaTipo.getSelectedItem();
        String tipoPago = (String) Pago.getSelectedItem();
        String precioTotal = jTextField2.getText();
        java.util.Date fecha = jDateChooser1.getDate();
        String rfcCliente = "1";
        if (litrosGasolina.isEmpty() || tipoGasolina.isEmpty() || tipoPago.isEmpty() || precioTotal.isEmpty() || fecha == null) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        java.sql.Date sqlFecha = new java.sql.Date(fecha.getTime());
        try (Connection con = MySQLConnection.getConnection()) {
            con.setAutoCommit(false);
            String insertVentaQuery = "INSERT INTO venta (litros, tipo_gasolina, tipo_pago, precio_total, fecha, RFC_empleado, RFC_Cliente) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pst = con.prepareStatement(insertVentaQuery)) {
                pst.setString(1, litrosGasolina);
                pst.setString(2, tipoGasolina);
                pst.setString(3, tipoPago);
                pst.setString(4, precioTotal);
                pst.setDate(5, sqlFecha);
                pst.setString(6, usuario.getRfcEmpleado());
                pst.setString(7, rfcCliente);

                int rowsInserted = pst.executeUpdate();
                if (rowsInserted > 0) {
                    int max = 100;
                    Carga.setMaximum(max);
                    Carga.setValue(0);
                    Carga.setVisible(true);

                    Timer timer = new Timer(50, new ActionListener() {
                        int value = 0;

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (value < max) {
                                value++;
                                Carga.setValue(value);
                            } else {
                                Quitar.setVisible(false);
                                ((Timer) e.getSource()).stop();
                                JOptionPane.showMessageDialog(null, "Venta registrada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    });
                    timer.start();
                } else {
                    throw new SQLException("Error al registrar la venta.");
                }
            }
            String updateEmpleadosQuery = "UPDATE empleado SET puesto = 'Despachador'";
            try (PreparedStatement pst = con.prepareStatement(updateEmpleadosQuery)) {
                int rowsUpdated = pst.executeUpdate();
                if (rowsUpdated == 0) {
                    throw new SQLException("Error al actualizar los puestos de los empleados.");
                }
            }

            con.commit();
        } catch (SQLException e) {
            try (Connection con = MySQLConnection.getConnection()) {
                con.rollback();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al hacer rollback: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            JOptionPane.showMessageDialog(this, "Error de conexión a la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_VenderActionPerformed

    private void btonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btonLimpiarActionPerformed
        jTextField1.setText("");
        jTextField2.setText("");
        GasolinaTipo.setSelectedIndex(0);
        Pago.setSelectedIndex(0);
        java.util.Date today = new java.util.Date();
        jDateChooser1.setDate(today);
        Quitar.setVisible(true);
        Carga.setValue(0);
    }//GEN-LAST:event_btonLimpiarActionPerformed

    private void AltaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AltaClienteMouseClicked
        ((CardLayout) jPanel4.getLayout()).show(jPanel4, "card3");
    }//GEN-LAST:event_AltaClienteMouseClicked

    private void BuscarPorIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarPorIDActionPerformed
        String idVentaStr = buscar.getText();

        if (idVentaStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un ID de venta.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int idVenta;
        try {
            idVenta = Integer.parseInt(idVentaStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID de venta inválido. Por favor, ingrese un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String query = "SELECT id_venta, tipo_gasolina, tipo_pago, precio_total, fecha, RFC_empleado, RFC_Cliente, litros FROM venta WHERE id_venta = ?";

        try (Connection conn = MySQLConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idVenta);
            try (ResultSet rs = stmt.executeQuery()) {
                DefaultTableModel model = (DefaultTableModel) TVenta.getModel();
                model.setRowCount(0);

                if (rs.next()) {
                    String tipoGasolina = rs.getString("tipo_gasolina");
                    String tipoPago = rs.getString("tipo_pago");
                    double precioTotal = rs.getDouble("precio_total");
                    java.sql.Date fecha = rs.getDate("fecha");
                    String rfcEmpleado = rs.getString("RFC_empleado");
                    String rfcCliente = rs.getString("RFC_Cliente");
                    double litros = rs.getDouble("litros");

                    model.addRow(new Object[]{idVenta, tipoGasolina, tipoPago, precioTotal, fecha, rfcEmpleado, rfcCliente, litros});
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró ninguna venta con el ID especificado.", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al buscar la venta por ID.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BuscarPorIDActionPerformed

    private void FacturarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FacturarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_FacturarMouseEntered

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed

    private void ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClienteActionPerformed
        String nombreCompleto = nombre.getText().trim();  // Obtén el nombre completo del JTextField

        if (nombreCompleto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un nombre completo.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String query = "SELECT RFC_Cliente FROM cliente WHERE CONCAT(TRIM(nombre), ' ', TRIM(apellido)) = ?";

        try (Connection conn = MySQLConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, nombreCompleto);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String rfcCliente = rs.getString("RFC_Cliente");
                RFC.setText(rfcCliente);
            } else {
                RFC.setText("No RFC");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al buscar el RFC.", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_ClienteActionPerformed

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\chiri\\Desktop\\Factura.pdf"));
            document.open();

            document.add(new Paragraph("Nombre de la Empresa: Tu Empresa S.A."));
            document.add(new Paragraph("Dirección: Calle Ejemplo, 123, Ciudad, País"));
            document.add(new Paragraph("Teléfono: +123456789"));
            document.add(new Paragraph("Email: contacto@tuempresa.com"));
            document.add(new Paragraph(" "));

            String RFC = usuario.getRfcEmpleado();
            String userName = getUserName(RFC);
            document.add(new Paragraph("RFC de Usuario: " + RFC));
            document.add(new Paragraph("Nombre de Usuario: " + userName));
            document.add(new Paragraph(" "));

            JTable table = TVenta;
            TableModel model = table.getModel();

            document.add(new Paragraph("Factura Digital"));
            document.add(new Paragraph(" "));
            for (int row = 0; row < model.getRowCount(); row++) {
                for (int col = 0; col < model.getColumnCount(); col++) {
                    document.add(new Paragraph(model.getValueAt(row, col).toString() + " "));
                }
                document.add(new Paragraph(" "));
            }

            document.close();

            JOptionPane.showMessageDialog(this, "Factura generada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al generar la factura.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_AceptarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Registrarse r = new Registrarse();
        r.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private String getUserName(String RFC) {
        String nombre = "Desconocido";
        String query = "SELECT nombre, apellido FROM empleado WHERE RFC_empleado = ?";

        try (Connection conn = MySQLConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, RFC);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                nombre = rs.getString("nombre") + " " + rs.getString("apellido");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nombre;
    }

    private String getClienteInfo(String RFC) {
        String info = "Cliente no encontrado";
        String query = "SELECT nombre, apellido, correo FROM cliente WHERE RFC_Cliente = ?";

        try (Connection conn = MySQLConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, RFC);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                info = "Nombre: " + rs.getString("nombre") + " " + rs.getString("apellido") + "\n";
                info += "Correo: " + rs.getString("correo");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return info;
    }

    private int findColumn(TableModel model, String columnName) {
        for (int i = 0; i < model.getColumnCount(); i++) {
            if (model.getColumnName(i).equals(columnName)) {
                return i;
            }
        }
        return -1;
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            // Crear el documento PDF
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\chiri\\Desktop\\Factura.pdf"));
            document.open();

            // Añadir logo
            try {
                Image logo = Image.getInstance(new URL("https://th.bing.com/th/id/R.3a220483b53f157016c3da6ede2f8127?rik=mqP%2fWPGpRrbLXg&riu=http%3a%2f%2fwww.caratulasylogos.com%2fwp-content%2fuploads%2frepsol-640x480.jpg&ehk=poxDkjx4f8KUQqLXtFgc6CLKaRkFXoGmoDAvg1sCiko%3d&risl=&pid=ImgRaw&r=0")); // Cambia la URL por la del logo de tu empresa
                logo.scaleToFit(100, 50);
                logo.setAlignment(Element.ALIGN_CENTER);
                document.add(logo);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Información de la empresa
            document.add(new Paragraph("Nombre de la Empresa: Gas Max S.A.", new Font(Font.TIMES_ROMAN, 14, Font.BOLD)));
            document.add(new Paragraph("Dirección: Calle Ejemplo, 123, Ciudad, País", new Font(Font.TIMES_ROMAN, 12, Font.NORMAL)));
            document.add(new Paragraph("Teléfono: +123456789", new Font(Font.TIMES_ROMAN, 12, Font.NORMAL)));
            document.add(new Paragraph("Email: contacto@gasmax.com", new Font(Font.TIMES_ROMAN, 12, Font.NORMAL)));
            document.add(new Paragraph(" "));

            // Información del usuario
            String RFCUsuario = lblUsuario.getText(); // Suponiendo que lblUsuario contiene el RFC del usuario
            String userName = getUserName(RFCUsuario);
            document.add(new Paragraph("RFC de Usuario: " + RFCUsuario, new Font(Font.TIMES_ROMAN, 12, Font.NORMAL)));
            document.add(new Paragraph("Nombre de Usuario: " + userName, new Font(Font.TIMES_ROMAN, 12, Font.NORMAL)));
            document.add(new Paragraph(" "));
            JTable table = TVenta;
            TableModel model = table.getModel();
            int[] selectedRows = table.getSelectedRows();
            if (selectedRows.length == 0) {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona al menos una fila de la tabla.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }
            int rfcClienteColumnIndex = findColumn(model, "RFC_Cliente");
            if (rfcClienteColumnIndex == -1) {
                JOptionPane.showMessageDialog(this, "No se encontró la columna 'RFC_Cliente' en la tabla.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String RFCCliente = model.getValueAt(selectedRows[0], rfcClienteColumnIndex).toString();
            document.add(new Paragraph("Factura Digital", new Font(Font.TIMES_ROMAN, 18, Font.BOLD)));
            document.add(new Paragraph(" ")); // Espacio en blanco
            PdfPTable pdfTable = new PdfPTable(model.getColumnCount());
            pdfTable.setWidthPercentage(100);
            for (int col = 0; col < model.getColumnCount(); col++) {
                PdfPCell cell = new PdfPCell(new Phrase(model.getColumnName(col)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setPadding(5);
                pdfTable.addCell(cell);
            }
            for (int row : selectedRows) {
                for (int col = 0; col < model.getColumnCount(); col++) {
                    PdfPCell cell = new PdfPCell(new Phrase(model.getValueAt(row, col).toString()));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setPadding(5);
                    pdfTable.addCell(cell);
                }
            }

            document.add(pdfTable);
            document.add(new Paragraph(" "));
            String clienteInfo = getClienteInfo(RFCCliente);
            document.add(new Paragraph("Información del Cliente:", new Font(Font.TIMES_ROMAN, 14, Font.BOLD)));
            document.add(new Paragraph(clienteInfo, new Font(Font.TIMES_ROMAN, 12, Font.NORMAL)));

            document.close();

            JOptionPane.showMessageDialog(this, "Factura generada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            if (Desktop.isDesktopSupported()) {
                try {
                    File pdfFile = new File("C:\\Users\\chiri\\Desktop\\Factura.pdf");
                    Desktop.getDesktop().open(pdfFile);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al generar la factura.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Cerrar c = new Cerrar();
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DefaultTableModel model = (DefaultTableModel) Altas.getModel();
        int lastRowIndex = model.getRowCount() - 1;
        String RFC_empleado = model.getValueAt(lastRowIndex, 0).toString().trim();
        String nombre = model.getValueAt(lastRowIndex, 1).toString().trim();
        String apellido = model.getValueAt(lastRowIndex, 2).toString().trim();
        String puesto = model.getValueAt(lastRowIndex, 3).toString().trim();
        String correo = model.getValueAt(lastRowIndex, 4).toString().trim();
        String contraseña = model.getValueAt(lastRowIndex, 5).toString().trim();
        String idestacionT = model.getValueAt(lastRowIndex, 6).toString().trim();

        if (RFC_empleado.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || puesto.isEmpty() || correo.isEmpty() || contraseña.isEmpty() || idestacionT.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos antes de agregar un nuevo registro.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try (Connection conn = MySQLConnection.getConnection()) {
            String query = "INSERT INTO gasolinera_mia.empleado (RFC_empleado, nombre, apellido, puesto, correo, contraseña, idestacionT) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, RFC_empleado);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setString(4, puesto);
            ps.setString(5, correo);
            ps.setString(6, contraseña);
            ps.setString(7, idestacionT);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                model.addRow(new Object[]{"", "", "", "", "", "", ""});
                JOptionPane.showMessageDialog(this, "Nuevo registro agregado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo agregar el nuevo registro.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al agregar el nuevo registro a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int selectedRow = Altas.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un registro para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        DefaultTableModel model = (DefaultTableModel) Altas.getModel();
        String RFC_empleado = model.getValueAt(selectedRow, 0).toString();

        int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar el registro?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        try (Connection conn = MySQLConnection.getConnection()) {
            String query = "DELETE FROM gasolinera_mia.empleado WHERE RFC_empleado = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, RFC_empleado);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                model.removeRow(selectedRow);
                JOptionPane.showMessageDialog(this, "Registro eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo eliminar el registro.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al eliminar el registro de la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int selectedRow = Altas.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un registro para actualizar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        DefaultTableModel model = (DefaultTableModel) Altas.getModel();

        String RFC_empleado = model.getValueAt(selectedRow, 0).toString().trim();
        String nombre = model.getValueAt(selectedRow, 1).toString().trim();
        String apellido = model.getValueAt(selectedRow, 2).toString().trim();
        String puesto = model.getValueAt(selectedRow, 3).toString().trim();
        String correo = model.getValueAt(selectedRow, 4).toString().trim();
        String contraseña = model.getValueAt(selectedRow, 5).toString().trim();
        String idestacionT = model.getValueAt(selectedRow, 6).toString().trim();

        if (RFC_empleado.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || puesto.isEmpty() || correo.isEmpty() || contraseña.isEmpty() || idestacionT.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos deben estar completos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try (Connection conn = MySQLConnection.getConnection()) {
            String query = "UPDATE gasolinera_mia.empleado SET nombre = ?, apellido = ?, puesto = ?, correo = ?, contraseña = ?, idestacionT = ? WHERE RFC_empleado = ?";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setString(1, nombre);
                ps.setString(2, apellido);
                ps.setString(3, puesto);
                ps.setString(4, correo);
                ps.setString(5, contraseña);
                ps.setInt(6, Integer.parseInt(idestacionT));  // Asegúrate de que idestacionT es un entero
                ps.setString(7, RFC_empleado);

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Registro actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo actualizar el registro.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "El valor de 'idestacionT' debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al actualizar el registro en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        ((CardLayout) jPanel4.getLayout()).show(jPanel4, "card5");
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jDateChooser2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jDateChooser2AncestorAdded

    }//GEN-LAST:event_jDateChooser2AncestorAdded

    private void jDateChooser2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser2MouseClicked

    }//GEN-LAST:event_jDateChooser2MouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Date selectedDate = jDateChooser2.getDate();
        if (selectedDate != null) {
            try (Connection connection = MySQLConnection.getConnection()) {
                String query = "SELECT DATE(fecha) as dia, precio_total, tipo_gasolina "
                        + "FROM venta "
                        + "WHERE DATE(fecha) = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setDate(1, new java.sql.Date(selectedDate.getTime()));
                ResultSet resultSet = preparedStatement.executeQuery();
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);

                while (resultSet.next()) {
                    String dia = resultSet.getDate("dia").toString();
                    double precioTotal = resultSet.getDouble("precio_total");
                    String tipoGasolina = resultSet.getString("tipo_gasolina");

                    Object[] row = {dia, precioTotal, tipoGasolina};
                    model.addRow(row);
                }

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al obtener los datos de ventas.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor seleccione una fecha.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try {
            Date selectedDate = jDateChooser2.getDate();
            if (selectedDate == null) {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona una fecha.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dateStr = dateFormat.format(selectedDate);

            try (Connection connection = MySQLConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT fecha, precio_total, tipo_gasolina FROM venta WHERE DATE(fecha) = ?")) {
                preparedStatement.setString(1, dateStr);
                ResultSet resultSet = preparedStatement.executeQuery();

                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);

                double totalVentas = 0;
                while (resultSet.next()) {
                    String fecha = resultSet.getString("fecha");
                    double precioTotal = resultSet.getDouble("precio_total");
                    String tipoGasolina = resultSet.getString("tipo_gasolina");
                    model.addRow(new Object[]{precioTotal, tipoGasolina, fecha});
                    totalVentas += precioTotal;
                }

                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\chiri\\Desktop\\Factura.pdf"));
                document.open();

                try {
                    Image logo = Image.getInstance(new URL("https://th.bing.com/th/id/R.3a220483b53f157016c3da6ede2f8127?rik=mqP%2fWPGpRrbLXg&riu=http%3a%2f%2fwww.caratulasylogos.com%2fwp-content%2fuploads%2frepsol-640x480.jpg&ehk=poxDkjx4f8KUQqLXtFgc6CLKaRkFXoGmoDAvg1sCiko%3d&risl=&pid=ImgRaw&r=0"));
                    logo.scaleToFit(100, 50);
                    logo.setAlignment(Element.ALIGN_CENTER);
                    document.add(logo);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                document.add(new Paragraph("Nombre de la Empresa: Gas Max S.A.", new Font(Font.TIMES_ROMAN, 14, Font.BOLD)));
                document.add(new Paragraph("Dirección: Calle Ejemplo, 123, Ciudad, País", new Font(Font.TIMES_ROMAN, 12, Font.NORMAL)));
                document.add(new Paragraph("Teléfono: +123456789", new Font(Font.TIMES_ROMAN, 12, Font.NORMAL)));
                document.add(new Paragraph("Email: contacto@gasmax.com", new Font(Font.TIMES_ROMAN, 12, Font.NORMAL)));
                document.add(new Paragraph(" "));

                String RFCUsuario = lblUsuario.getText();
                String userName = getUserName(RFCUsuario);
                document.add(new Paragraph("RFC de Usuario: " + RFCUsuario, new Font(Font.TIMES_ROMAN, 12, Font.NORMAL)));
                document.add(new Paragraph("Nombre de Usuario: " + userName, new Font(Font.TIMES_ROMAN, 12, Font.NORMAL)));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("Factura Digital", new Font(Font.TIMES_ROMAN, 18, Font.BOLD)));
                document.add(new Paragraph("Reporte de Ventas del Día: " + dateStr, new Font(Font.TIMES_ROMAN, 18, Font.BOLD)));
                document.add(new Paragraph(" "));

                PdfPTable pdfTable = new PdfPTable(model.getColumnCount());
                pdfTable.setWidthPercentage(100);
                for (int col = 0; col < model.getColumnCount(); col++) {
                    PdfPCell cell = new PdfPCell(new Phrase(model.getColumnName(col)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setPadding(5);
                    pdfTable.addCell(cell);
                }
                for (int row = 0; row < model.getRowCount(); row++) {
                    for (int col = 0; col < model.getColumnCount(); col++) {
                        PdfPCell cell = new PdfPCell(new Phrase(model.getValueAt(row, col).toString()));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setPadding(5);
                        pdfTable.addCell(cell);
                    }
                }

                document.add(pdfTable);
                document.add(new Paragraph(" "));

                document.add(new Paragraph("Total de Ventas del Día: $" + totalVentas, new Font(Font.TIMES_ROMAN, 12, Font.BOLD)));

                document.close();

                JOptionPane.showMessageDialog(this, "Factura generada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                if (Desktop.isDesktopSupported()) {
                    try {
                        File pdfFile = new File("C:\\Users\\chiri\\Desktop\\Factura.pdf");
                        Desktop.getDesktop().open(pdfFile);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al generar la factura.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al generar la factura.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void initializeTableListener() {
        Altas.getModel().addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                int column = e.getColumn();
                TableModel model = (TableModel) e.getSource();

                String RFC_empleado = model.getValueAt(row, 0).toString();
                String nombre = model.getValueAt(row, 1).toString();
                String apellido = model.getValueAt(row, 2).toString();
                String puesto = model.getValueAt(row, 3).toString();
                String correo = model.getValueAt(row, 4).toString();
                String contraseña = model.getValueAt(row, 5).toString();
                int idestacionT = Integer.parseInt(model.getValueAt(row, 6).toString());

                // Actualizar la base de datos
                try (Connection conn = MySQLConnection.getConnection()) {
                    String query = "UPDATE gasolinera_mia.empleado SET nombre = ?, apellido = ?, puesto = ?, correo = ?, contraseña = ?, idestacionT = ? WHERE RFC_empleado = ?";
                    PreparedStatement ps = conn.prepareStatement(query);
                    ps.setString(1, nombre);
                    ps.setString(2, apellido);
                    ps.setString(3, puesto);
                    ps.setString(4, correo);
                    ps.setString(5, contraseña);
                    ps.setInt(6, idestacionT);
                    ps.setString(7, RFC_empleado);
                    ps.executeUpdate();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error al actualizar el empleado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

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
            java.util.logging.Logger.getLogger(Principal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal2().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JLabel AltaCliente;
    private javax.swing.JTable Altas;
    private javax.swing.JButton BuscarPorID;
    private javax.swing.JProgressBar Carga;
    private javax.swing.JButton Cliente;
    private javax.swing.JLabel Facturar;
    private javax.swing.JComboBox<String> GasolinaTipo;
    private javax.swing.JComboBox<String> Pago;
    private javax.swing.JLabel Quitar;
    private javax.swing.JLabel RFC;
    private javax.swing.JTable TVenta;
    private javax.swing.JButton Vender;
    private javax.swing.JButton btonLimpiar;
    private javax.swing.JTextField buscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblSucursal;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTextField nombre;
    // End of variables declaration//GEN-END:variables
}
