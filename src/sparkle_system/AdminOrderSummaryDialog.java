/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sparkle_system;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class AdminOrderSummaryDialog extends javax.swing.JFrame {
    private String firstName;
    private String lastName;
    private int quantity;
    private double unitPrice;
    private String orderType;
    private double total;
    private int existingCustomerID;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AdminOrderSummaryDialog.class.getName());
    
public AdminOrderSummaryDialog( String firstName, String lastName,
        String contact,
        String address,
        String product,
        int quantity,
        double unitPrice,
        String payment,
        String orderType,
        double subtotal,
        double deliveryFee,
        double total,
        int existingCustomerID){
    initComponents();
    this.existingCustomerID = existingCustomerID;

    this.firstName = firstName;
this.lastName = lastName;
    this.quantity = quantity;
    this.unitPrice = unitPrice;
    this.orderType = orderType;
this.total = total;
    

    jLabelOS1.setText(firstName + " " + lastName); 
    jLabelOS2.setText(contact);
    jLabelOS3.setText(address);
    jLabelOS4.setText(product);
    jLabelOS5.setText(String.valueOf(quantity));
    jLabelOS6.setText("₱" + String.format("%.2f", unitPrice));
    jLabelOS7.setText(payment);
    jLabelOS8.setText(orderType);
    jLabelOSTOTAL.setText("₱" + String.format("%.2f", total));
}

private int addCustomer(Connection conn) throws SQLException {

    String sql = "INSERT INTO customers "
               + "(first_name, last_name, contact, address) "
               + "VALUES (?, ?, ?, ?)";

    PreparedStatement pst = conn.prepareStatement(
            sql, Statement.RETURN_GENERATED_KEYS);

    pst.setString(1, firstName);
    pst.setString(2, lastName);
    pst.setString(3, jLabelOS2.getText());
    pst.setString(4, jLabelOS3.getText());

    pst.executeUpdate();

    ResultSet rs = pst.getGeneratedKeys();
    rs.next();

    int customerID = rs.getInt(1);

rs.close();
pst.close();

return customerID;
}
private void saveOrder() { 

    try (Connection conn = sparklewaterdb_connection.connect()) {

        conn.setAutoCommit(false);

        try {
            int customerID = existingCustomerID > 0
        ? existingCustomerID
        : addCustomer(conn);
            int orderID = addOrder(conn, customerID);
            addOrderDetails(conn, orderID);

            if ("Delivery".equals(orderType)) {
                addDelivery(conn, orderID);
            }

            conn.commit();

            JOptionPane.showMessageDialog(this,
                    "Order confirmed successfully!");
            this.dispose();

        } catch (SQLException e) {
            conn.rollback();
            throw e;
        }

    } catch (SQLException e) {
        jSummaryConfirmOrder.setEnabled(true);
        JOptionPane.showMessageDialog(this,
                "Error confirming order: " + e.getMessage());
    }
}
private int addOrder(Connection conn, int customerID) 
        throws SQLException {

   String sql = "INSERT INTO orders "
           + "(customer_id, order_date, total_amount, payment_type, order_type) "
           + "VALUES (?, NOW(), ?, ?, ?)";

    PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

   
    pst.setInt(1, customerID);
    pst.setDouble(2, total);
    pst.setString(3, jLabelOS7.getText());
    pst.setString(4, orderType);
    pst.executeUpdate();
    ResultSet rs = pst.getGeneratedKeys();
rs.next();

int orderID = rs.getInt(1);

rs.close();
pst.close();

return orderID;
}

private void addOrderDetails(Connection conn, int orderID)
        throws SQLException {

    String sql = "INSERT INTO order_details "
               + "(order_id, product_id, quantity, price, subtotal) "
               + "VALUES (?, 1, ?, ?, ?)";

    PreparedStatement pst = conn.prepareStatement(sql);

    double total = quantity * unitPrice;

    pst.setInt(1, orderID);
    pst.setInt(2, quantity);
    pst.setDouble(3, unitPrice);
    pst.setDouble(4, total);

    pst.executeUpdate();
        pst.close();

}

private void addDelivery(Connection conn, int orderID)
        throws SQLException {

    String sql = "INSERT INTO deliveries "
               + "(order_id, rider_id, delivery_status) "
               + "VALUES (?, 2, 'Pending')";

    PreparedStatement pst = conn.prepareStatement(sql);

    pst.setInt(1, orderID);
    pst.executeUpdate();
        pst.close();

}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTableSummary1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLbldate = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabelOSTOTAL = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSummaryConfirmOrder = new javax.swing.JButton();
        jSummaryCancel = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelOS1 = new javax.swing.JLabel();
        jLabelOS2 = new javax.swing.JLabel();
        jLabelOS3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabelOS7 = new javax.swing.JLabel();
        jLabelOS6 = new javax.swing.JLabel();
        jLabelOS5 = new javax.swing.JLabel();
        jLabelOS4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabelOS8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        jTableSummary1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(68, 151, 229)));
        jTableSummary1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTableSummary1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Quantity(Gallon)", "Price/Gallon", "Subtotal"
            }
        ));
        jTableSummary1.setRowHeight(25);
        jTableSummary1.setSelectionBackground(new java.awt.Color(68, 151, 229));
        jTableSummary1.setSelectionForeground(new java.awt.Color(255, 255, 255));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(33, 120, 209));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ORDER SUMMARY");

        jLabel20.setIcon(new javax.swing.ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\SparkleWater_System\\src\\icon\\Overview.png")); // NOI18N
        jLabel20.setText("jLabel1");

        jLbldate.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLbldate.setForeground(new java.awt.Color(255, 255, 255));
        jLbldate.setText("Review order before confirming.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLbldate))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(jLbldate)
                .addGap(17, 17, 17))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel20)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(33, 120, 209));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(145, 35));

        jLabelOSTOTAL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelOSTOTAL.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOSTOTAL.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("TOTAL AMOUNT");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelOSTOTAL, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabelOSTOTAL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jSummaryConfirmOrder.setBackground(new java.awt.Color(33, 120, 209));
        jSummaryConfirmOrder.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jSummaryConfirmOrder.setForeground(new java.awt.Color(255, 255, 255));
        jSummaryConfirmOrder.setText("Confirm Order");
        jSummaryConfirmOrder.addActionListener(this::jSummaryConfirmOrderActionPerformed);

        jSummaryCancel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jSummaryCancel.setText("Back");
        jSummaryCancel.addActionListener(this::jSummaryCancelActionPerformed);

        jPanel4.setBackground(new java.awt.Color(218, 229, 241));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Customer Name");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Contact Number");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Address");

        jLabelOS1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabelOS2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabelOS3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelOS1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelOS2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelOS3, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelOS1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelOS2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel6))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelOS3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(218, 229, 241));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Product");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Quantity");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Unit Price");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Order Type");

        jLabelOS7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabelOS6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabelOS5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabelOS4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Payment Type:");

        jLabelOS8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelOS7, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelOS6, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelOS4, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelOS5, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelOS8, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelOS4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabelOS5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 6, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabelOS6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelOS8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabelOS7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(33, 120, 209));
        jLabel12.setText("Customer Information");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(33, 120, 209));
        jLabel11.setText("Order Details");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSummaryCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSummaryConfirmOrder)
                .addGap(41, 41, 41))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSummaryConfirmOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSummaryCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jSummaryConfirmOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSummaryConfirmOrderActionPerformed
         jSummaryConfirmOrder.setEnabled(false);
saveOrder();
    }//GEN-LAST:event_jSummaryConfirmOrderActionPerformed
    private void jSummaryCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSummaryCancelActionPerformed
       AdminAddNewOrderDialog order = new AdminAddNewOrderDialog();
        order.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jSummaryCancelActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelOS1;
    private javax.swing.JLabel jLabelOS2;
    private javax.swing.JLabel jLabelOS3;
    private javax.swing.JLabel jLabelOS4;
    private javax.swing.JLabel jLabelOS5;
    private javax.swing.JLabel jLabelOS6;
    private javax.swing.JLabel jLabelOS7;
    private javax.swing.JLabel jLabelOS8;
    private javax.swing.JLabel jLabelOSTOTAL;
    private javax.swing.JLabel jLbldate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton jSummaryCancel;
    private javax.swing.JButton jSummaryConfirmOrder;
    private javax.swing.JTable jTableSummary1;
    // End of variables declaration//GEN-END:variables
}
