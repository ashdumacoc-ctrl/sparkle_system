/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sparkle_system;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class AdminOrdersFrame extends javax.swing.JFrame { 
    private AdminOrderManager orderManager = new AdminOrderManager(); 
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AdminOrdersFrame.class.getName());

 
private void addMenuHover(JPanel panel, JLabel label) { 
        java.awt.event.MouseAdapter hover = new java.awt.event.MouseAdapter() { 


        @Override 
        public void mouseEntered(java.awt.event.MouseEvent evt) { 
            panel.setBackground(new java.awt.Color(59, 143, 227));
            label.setForeground(Color.WHITE);
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent evt) {
            java.awt.Point mouse = panel.getMousePosition();
            if (mouse == null) {
                panel.setBackground(new java.awt.Color(33, 120, 209));
                label.setForeground(Color.WHITE);
            }
        }
    };

panel.addMouseListener(hover);
label.addMouseListener(hover);
}
   
public AdminOrdersFrame() { 
        
    initComponents(); 
    loadOrders(); 
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        
      
    addMenuHover(jPanelDashboard, jLabelDashboard);
    addMenuHover(jPanelCustomer, jLabelCustomer);
    addMenuHover(jPanelOrders, jLabelOrders);
    addMenuHover(jPanelDeliveries, jLabelDeliveries);
     addMenuHover(jPanelReports, jLabelReports);
    addMenuHover(jPanelLogout, jLabelLogout);

        
    jTableOrders.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
    jTableOrders.getTableHeader().setForeground(Color.BLACK);
    jTableOrders.getTableHeader().setBackground(new Color(33,120,209));
    }
    
private void loadOrders() { 


    try { 

        DefaultTableModel model = (DefaultTableModel) jTableOrders.getModel();

        orderManager.loadOrders(model);

    } catch (SQLException e) { 

        JOptionPane.showMessageDialog(this,
                "Error loading orders: "
                + e.getMessage());
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanelDashboard = new javax.swing.JPanel();
        jLabelDashboard = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanelCustomer = new javax.swing.JPanel();
        jLabelCustomer = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanelOrders = new javax.swing.JPanel();
        jLabelOrders = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jPanelDeliveries = new javax.swing.JPanel();
        jLabelDeliveries = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jPanelLogout = new javax.swing.JPanel();
        jLabelLogout = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanelReports = new javax.swing.JPanel();
        jLabelReports = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableOrders = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButtondelete = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSearchOrderTextfield = new javax.swing.JTextField();
        jSesrchOrderbutton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLbldate = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(218, 229, 241));

        jPanel2.setBackground(new java.awt.Color(33, 120, 209));
        jPanel2.setPreferredSize(new java.awt.Dimension(350, 559));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOpaque(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SparkleWater");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 255));
        jLabel2.setText("Management");

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\SparkleWater_System\\src\\icon\\Glossy Blue Water Drop Emblem (2).png")); // NOI18N

        jPanelDashboard.setBackground(new java.awt.Color(33, 120, 209));
        jPanelDashboard.setPreferredSize(new java.awt.Dimension(355, 60));

        jLabelDashboard.setFont(new java.awt.Font("Segoe UI Semibold", 1, 22)); // NOI18N
        jLabelDashboard.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDashboard.setText("Dashboard");
        jLabelDashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDashboard.setPreferredSize(new java.awt.Dimension(111, 40));
        jLabelDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDashboardMouseClicked(evt);
            }
        });

        jLabel24.setIcon(new javax.swing.ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\SparkleWater_System\\src\\icon\\Homedashboad.png")); // NOI18N
        jLabel24.setText("jLabel4");

        javax.swing.GroupLayout jPanelDashboardLayout = new javax.swing.GroupLayout(jPanelDashboard);
        jPanelDashboard.setLayout(jPanelDashboardLayout);
        jPanelDashboardLayout.setHorizontalGroup(
            jPanelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDashboardLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        jPanelDashboardLayout.setVerticalGroup(
            jPanelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDashboardLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(jPanelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addContainerGap())
        );

        jPanelCustomer.setBackground(new java.awt.Color(33, 120, 209));
        jPanelCustomer.setPreferredSize(new java.awt.Dimension(355, 60));

        jLabelCustomer.setFont(new java.awt.Font("Segoe UI Semibold", 1, 22)); // NOI18N
        jLabelCustomer.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCustomer.setText("Customer History");
        jLabelCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelCustomer.setPreferredSize(new java.awt.Dimension(111, 40));
        jLabelCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCustomerMouseClicked(evt);
            }
        });

        jLabel31.setIcon(new javax.swing.ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\SparkleWater_System\\src\\icon\\CustomersIcon.png")); // NOI18N
        jLabel31.setText("jLabel4");

        javax.swing.GroupLayout jPanelCustomerLayout = new javax.swing.GroupLayout(jPanelCustomer);
        jPanelCustomer.setLayout(jPanelCustomerLayout);
        jPanelCustomerLayout.setHorizontalGroup(
            jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCustomerLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        jPanelCustomerLayout.setVerticalGroup(
            jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCustomerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addGap(10, 10, 10))
        );

        jPanelOrders.setBackground(new java.awt.Color(33, 120, 209));
        jPanelOrders.setPreferredSize(new java.awt.Dimension(355, 60));

        jLabelOrders.setFont(new java.awt.Font("Segoe UI Semibold", 1, 22)); // NOI18N
        jLabelOrders.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOrders.setText("Orders");
        jLabelOrders.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelOrders.setPreferredSize(new java.awt.Dimension(111, 40));
        jLabelOrders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelOrdersMouseClicked(evt);
            }
        });

        jLabel36.setIcon(new javax.swing.ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\SparkleWater_System\\src\\icon\\OrdersIcon.png")); // NOI18N
        jLabel36.setText("jLabel4");

        javax.swing.GroupLayout jPanelOrdersLayout = new javax.swing.GroupLayout(jPanelOrders);
        jPanelOrders.setLayout(jPanelOrdersLayout);
        jPanelOrdersLayout.setHorizontalGroup(
            jPanelOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelOrdersLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelOrders, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        jPanelOrdersLayout.setVerticalGroup(
            jPanelOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelOrdersLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addGap(10, 10, 10))
        );

        jPanelDeliveries.setBackground(new java.awt.Color(33, 120, 209));
        jPanelDeliveries.setPreferredSize(new java.awt.Dimension(355, 60));

        jLabelDeliveries.setFont(new java.awt.Font("Segoe UI Semibold", 1, 22)); // NOI18N
        jLabelDeliveries.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDeliveries.setText("Deliveries");
        jLabelDeliveries.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDeliveries.setPreferredSize(new java.awt.Dimension(111, 40));
        jLabelDeliveries.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDeliveriesMouseClicked(evt);
            }
        });

        jLabel38.setIcon(new javax.swing.ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\SparkleWater_System\\src\\icon\\DeliveriesIcon.png")); // NOI18N
        jLabel38.setText("jLabel4");

        javax.swing.GroupLayout jPanelDeliveriesLayout = new javax.swing.GroupLayout(jPanelDeliveries);
        jPanelDeliveries.setLayout(jPanelDeliveriesLayout);
        jPanelDeliveriesLayout.setHorizontalGroup(
            jPanelDeliveriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDeliveriesLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelDeliveries, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        jPanelDeliveriesLayout.setVerticalGroup(
            jPanelDeliveriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDeliveriesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelDeliveriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDeliveries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38))
                .addGap(10, 10, 10))
        );

        jPanelLogout.setBackground(new java.awt.Color(33, 120, 209));
        jPanelLogout.setPreferredSize(new java.awt.Dimension(355, 60));

        jLabelLogout.setFont(new java.awt.Font("Segoe UI Semibold", 1, 22)); // NOI18N
        jLabelLogout.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLogout.setText("Log out");
        jLabelLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelLogout.setPreferredSize(new java.awt.Dimension(111, 40));
        jLabelLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLogoutMouseClicked(evt);
            }
        });

        jLabel21.setIcon(new javax.swing.ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\SparkleWater_System\\src\\icon\\LogoutIcon.png")); // NOI18N
        jLabel21.setText("jLabel4");

        javax.swing.GroupLayout jPanelLogoutLayout = new javax.swing.GroupLayout(jPanelLogout);
        jPanelLogout.setLayout(jPanelLogoutLayout);
        jPanelLogoutLayout.setHorizontalGroup(
            jPanelLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLogoutLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelLogoutLayout.setVerticalGroup(
            jPanelLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLogoutLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(10, 10, 10))
        );

        jPanelReports.setBackground(new java.awt.Color(33, 120, 209));
        jPanelReports.setPreferredSize(new java.awt.Dimension(355, 60));

        jLabelReports.setFont(new java.awt.Font("Segoe UI Semibold", 1, 22)); // NOI18N
        jLabelReports.setForeground(new java.awt.Color(255, 255, 255));
        jLabelReports.setText("Daily Sales Reports");
        jLabelReports.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelReports.setPreferredSize(new java.awt.Dimension(111, 40));
        jLabelReports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelReportsMouseClicked(evt);
            }
        });

        jLabel39.setIcon(new javax.swing.ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\SparkleWater_System\\src\\icon\\Document.png")); // NOI18N
        jLabel39.setText("jLabel4");

        javax.swing.GroupLayout jPanelReportsLayout = new javax.swing.GroupLayout(jPanelReports);
        jPanelReports.setLayout(jPanelReportsLayout);
        jPanelReportsLayout.setHorizontalGroup(
            jPanelReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelReportsLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelReports, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jPanelReportsLayout.setVerticalGroup(
            jPanelReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelReportsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelReports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelDashboard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                    .addComponent(jPanelCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                    .addComponent(jPanelOrders, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                    .addComponent(jPanelDeliveries, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                    .addComponent(jPanelReports, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)))
            .addComponent(jPanelLogout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jPanelDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDeliveries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelReports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 269, Short.MAX_VALUE)
                .addComponent(jPanelLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(33, 120, 209)));
        jScrollPane1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jScrollPane1.setPreferredSize(new java.awt.Dimension(375, 502));

        jTableOrders.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(33, 120, 209)));
        jTableOrders.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTableOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Customer", "Quantity", "Date", "Payment Type", "Order Type", "Total", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableOrders.setGridColor(new java.awt.Color(33, 120, 209));
        jTableOrders.setPreferredSize(new java.awt.Dimension(1119, 512));
        jTableOrders.setRowHeight(35);
        jTableOrders.setSelectionBackground(new java.awt.Color(68, 151, 229));
        jTableOrders.setShowGrid(false);
        jTableOrders.setShowVerticalLines(true);
        jScrollPane1.setViewportView(jTableOrders);

        jButton3.setBackground(new java.awt.Color(68, 151, 229));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("View");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(68, 151, 229), new java.awt.Color(68, 151, 229), new java.awt.Color(68, 151, 229), new java.awt.Color(68, 151, 229)));
        jButton3.addActionListener(this::jButton3ActionPerformed);

        jButton4.setBackground(new java.awt.Color(33, 120, 209));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Edit");
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(33, 120, 209), new java.awt.Color(33, 120, 209), new java.awt.Color(33, 120, 209), new java.awt.Color(33, 120, 209)));
        jButton4.addActionListener(this::jButton4ActionPerformed);

        jButtondelete.setBackground(new java.awt.Color(255, 51, 51));
        jButtondelete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtondelete.setForeground(new java.awt.Color(255, 255, 255));
        jButtondelete.setText("Delete");
        jButtondelete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 51, 51), new java.awt.Color(255, 51, 51), new java.awt.Color(255, 51, 51), new java.awt.Color(255, 51, 51)));
        jButtondelete.addActionListener(this::jButtondeleteActionPerformed);

        jPanel3.setBackground(new java.awt.Color(218, 229, 241));
        jPanel3.setPreferredSize(new java.awt.Dimension(1089, 103));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\SparkleWater_System\\src\\icon\\Searchblack.png")); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel7.setText("Search Order:");

        jSearchOrderTextfield.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jSearchOrderTextfield.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(68, 151, 229), new java.awt.Color(68, 151, 229), new java.awt.Color(0, 102, 255), new java.awt.Color(68, 151, 229)));
        jSearchOrderTextfield.addActionListener(this::jSearchOrderTextfieldActionPerformed);

        jSesrchOrderbutton.setBackground(new java.awt.Color(33, 120, 209));
        jSesrchOrderbutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jSesrchOrderbutton.setForeground(new java.awt.Color(255, 255, 255));
        jSesrchOrderbutton.setText("Search");
        jSesrchOrderbutton.addActionListener(this::jSesrchOrderbuttonActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jSearchOrderTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSesrchOrderbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(477, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSearchOrderTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSesrchOrderbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jButton2.setBackground(new java.awt.Color(68, 151, 229));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("+ New Order");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1119, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jButtondelete, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtondelete, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel6.setText("Order and Sales");

        jLbldate.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLbldate.setText("Manage and Monitor customer orders.");

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\SparkleWater_System\\src\\icon\\Shopping Cartblackbig.png")); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(33, 120, 209));
        jLabel5.setText("Admin ");

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\SparkleWater_System\\src\\icon\\bb.png")); // NOI18N
        jLabel10.setText("jLabel10");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLbldate)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel5)
                                .addGap(23, 23, 23))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 14, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 888, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel6)
                        .addGap(11, 11, 11)
                        .addComponent(jLbldate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

           
    private void jSesrchOrderbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSesrchOrderbuttonActionPerformed
  try {

        String search =jSearchOrderTextfield.getText().trim(); 

        DefaultTableModel model = (DefaultTableModel) jTableOrders.getModel();
        orderManager.searchOrders(model, search); 

    } catch (SQLException e) { 

        JOptionPane.showMessageDialog(this,
                "Error searching orders: "
                + e.getMessage());
    }

    }//GEN-LAST:event_jSesrchOrderbuttonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
    int row = jTableOrders.getSelectedRow();

    AdminAddNewOrderDialog neworder = new AdminAddNewOrderDialog();

    if (row != -1) {
        int orderID = Integer.parseInt(
            jTableOrders.getValueAt(row, 0).toString()
        );

       neworder.loadExistingCustomer(orderID);
    }

    neworder.setLocationRelativeTo(this);
    neworder.setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int selectedRow = jTableOrders.getSelectedRow(); 

        if (selectedRow == -1) { 
            JOptionPane.showMessageDialog(this,"Please select an order first.");
            return;
        }
        
        String orderID = jTableOrders.getValueAt(selectedRow, 0).toString();
       
        String customer = jTableOrders.getValueAt(selectedRow, 1).toString();
      String contact = ""; 

try (Connection conn = sparklewaterdb_connection.connect()) { 

    String sql = "SELECT c.contact FROM customers c " 
               + "JOIN orders o ON c.customer_id = o.customer_id " 
               + "WHERE o.order_id = ?"; 

    try (PreparedStatement pst = conn.prepareStatement(sql)) { 
        pst.setInt(1, Integer.parseInt(orderID));

        try (ResultSet rs = pst.executeQuery()) { 
            if (rs.next()) { 
                contact = rs.getString("contact");
            }
        }
    }

} catch (SQLException e) { 
    JOptionPane.showMessageDialog(this, e.getMessage());
    return;
}


        String date = jTableOrders.getValueAt(selectedRow, 3).toString();
        String payment = jTableOrders.getValueAt(selectedRow, 4).toString();
        String orderType = jTableOrders.getValueAt(selectedRow, 5).toString();
        String total = jTableOrders.getValueAt(selectedRow, 6).toString();
        String status = jTableOrders.getValueAt(selectedRow, 7).toString();

        
        
        AdminViewOrderDialog dialog = new AdminViewOrderDialog(this, true, orderID, customer, contact, date, payment, orderType, total, status);
          
        dialog.setLocationRelativeTo(this); 
        dialog.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       int selectedRow = jTableOrders.getSelectedRow();

    if (selectedRow == -1) { 
        JOptionPane.showMessageDialog(this,
                "Please select an order first.");
        return;
    }

    String orderID = jTableOrders.getValueAt(selectedRow, 0).toString(); 
    String customer = jTableOrders.getValueAt(selectedRow, 1).toString(); 
    String contact = ""; 

try (Connection conn = sparklewaterdb_connection.connect()) { 

    String sql = "SELECT c.contact FROM customers c " 
               + "JOIN orders o ON c.customer_id = o.customer_id " 
               + "WHERE o.order_id = ?"; 

    PreparedStatement pst = conn.prepareStatement(sql); 
    pst.setInt(1, Integer.parseInt(orderID)); 

    ResultSet rs = pst.executeQuery(); 

    if (rs.next()) { 
        contact = rs.getString("contact"); 
    }

    rs.close();
    pst.close();

} catch (SQLException e) { 
    JOptionPane.showMessageDialog(this, e.getMessage());
    return;
}


    String date = jTableOrders.getValueAt(selectedRow, 3).toString();
    String payment = jTableOrders.getValueAt(selectedRow, 4).toString();
    String orderType = jTableOrders.getValueAt(selectedRow, 5).toString();
    String total = jTableOrders.getValueAt(selectedRow, 6).toString();



    AdminEditOrderDialog edit = new AdminEditOrderDialog(
        this,
        true,
        orderID,
        customer,
        contact,
        date,
        payment,
        orderType,
        total
);

edit.setLocationRelativeTo(this); 
edit.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButtondeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtondeleteActionPerformed

        int selectedRow = jTableOrders.getSelectedRow();

    if (selectedRow == -1) { 
        JOptionPane.showMessageDialog(this,
                "Please select an order first.");
        return;
    }

    int orderID = Integer.parseInt( 
            jTableOrders.getValueAt(selectedRow, 0).toString() 
    );

    int confirm = JOptionPane.showConfirmDialog( 
            this,
            "Are you sure you want to delete this order?",
            "Delete Order",
            JOptionPane.YES_NO_OPTION
    );

    if (confirm != JOptionPane.YES_OPTION) { 
        return;
    }

    try {

        orderManager.deleteOrder(orderID); 

        JOptionPane.showMessageDialog(this, 
                "Order deleted successfully!");

        loadOrders(); 

    } catch (SQLException e) { 

        JOptionPane.showMessageDialog(this,
                "Error deleting order: "
                + e.getMessage());
    }

    }//GEN-LAST:event_jButtondeleteActionPerformed

    private void jLabelDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDashboardMouseClicked
        AdminDashboardFrame admin = new AdminDashboardFrame();
        admin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabelDashboardMouseClicked

    private void jLabelCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCustomerMouseClicked
        AdminCustomerFrame customer = new AdminCustomerFrame();
        customer.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabelCustomerMouseClicked

    private void jLabelOrdersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelOrdersMouseClicked
        AdminOrdersFrame order = new AdminOrdersFrame();
        order.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabelOrdersMouseClicked

    private void jLabelDeliveriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeliveriesMouseClicked
        AdminDeliveryFrame delivery = new AdminDeliveryFrame();
        delivery.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabelDeliveriesMouseClicked

    private void jLabelLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLogoutMouseClicked
        int confirm = JOptionPane.showConfirmDialog(
            this,"Are you sure you Log out?","Confirm Log out",JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            new LoginFrame().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jLabelLogoutMouseClicked

    private void jSearchOrderTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSearchOrderTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jSearchOrderTextfieldActionPerformed

    private void jLabelReportsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelReportsMouseClicked
        AdminReportsFrame report = new AdminReportsFrame();
        report.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabelReportsMouseClicked

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new AdminOrdersFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtondelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCustomer;
    private javax.swing.JLabel jLabelDashboard;
    private javax.swing.JLabel jLabelDeliveries;
    private javax.swing.JLabel jLabelLogout;
    private javax.swing.JLabel jLabelOrders;
    private javax.swing.JLabel jLabelReports;
    private javax.swing.JLabel jLbldate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanelCustomer;
    private javax.swing.JPanel jPanelDashboard;
    private javax.swing.JPanel jPanelDeliveries;
    private javax.swing.JPanel jPanelLogout;
    private javax.swing.JPanel jPanelOrders;
    private javax.swing.JPanel jPanelReports;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jSearchOrderTextfield;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jSesrchOrderbutton;
    private javax.swing.JTable jTableOrders;
    // End of variables declaration//GEN-END:variables
}
