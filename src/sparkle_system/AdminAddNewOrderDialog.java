/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sparkle_system;
import javax.swing.JOptionPane;

public class AdminAddNewOrderDialog extends javax.swing.JFrame {
    private int existingCustomerID = 0;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AdminAddNewOrderDialog.class.getName());

    public AdminAddNewOrderDialog() {
        initComponents();
        jComboBoxOrderTypeActionPerformed(null);
        calculateTotal();
    }
    public void loadExistingCustomer(int orderID) {

    String sql = "SELECT c.customer_id, c.first_name, c.last_name, "
               + "c.contact, c.address "
               + "FROM customers c "
               + "JOIN orders o ON c.customer_id = o.customer_id "
               + "WHERE o.order_id = ?";

    try (java.sql.Connection conn = sparklewaterdb_connection.connect();
         java.sql.PreparedStatement pst = conn.prepareStatement(sql)) {

        pst.setInt(1, orderID);

        try (java.sql.ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                existingCustomerID = rs.getInt("customer_id");
                jNOFirstname.setText(rs.getString("first_name"));
                jNOLastName.setText(rs.getString("last_name"));
                jNOContact.setText(rs.getString("contact"));
                jNOAddress.setText(rs.getString("address"));

                jNOFirstname.setEditable(false);
                jNOLastName.setEditable(false);
                jNOContact.setEditable(false);
                jNOAddress.setEditable(false);
            }
        }

    } catch (java.sql.SQLException e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
}
    
    
    
    private void calculateTotal() {

    
    int quantity = (int) jNOQuantity.getValue();
    double unitPrice = 25.00;

    String orderType = jComboBoxOrderType.getSelectedItem().toString();

    double subtotal = quantity * unitPrice;
    double deliveryFee = 0;

    if (orderType.equals("Delivery") && quantity < 5) {
        deliveryFee = quantity * 5;
    }

    double total = subtotal + deliveryFee;

    jLabelSUBTOTAL.setText("₱ " + subtotal);

    if (orderType.equals("Delivery") && quantity >= 5) {
        jLabelDF.setText("FREE");
    } else {
        jLabelDF.setText("₱ " + deliveryFee);
    }

    jLabelTOTAL.setText("₱ " + total);
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel18 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanelNewOrder = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jNOClearbutton = new javax.swing.JButton();
        jNOContact = new javax.swing.JTextField();
        jNOAddress = new javax.swing.JTextField();
        jPaymentComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jNOFirstname = new javax.swing.JTextField();
        jShowSummarybutton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLbldate = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabelProduct = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabelUnitPrice = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jNOQuantity = new javax.swing.JSpinner();
        jComboBoxOrderType = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabelSUBTOTAL = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabelDF = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabelTOTAL = new javax.swing.JLabel();
        jNOLastName = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel18.setText("Customer Information");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelNewOrder.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Quantity");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Unit Price");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Payment Type:");

        jNOClearbutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jNOClearbutton.setText("Clear");
        jNOClearbutton.addActionListener(this::jNOClearbuttonActionPerformed);

        jNOContact.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jNOContact.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(33, 120, 209)));

        jNOAddress.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jNOAddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(33, 120, 209)));

        jPaymentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash on Delivery", "G-cash", " " }));
        jPaymentComboBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(33, 120, 209)));
        jPaymentComboBox.addActionListener(this::jPaymentComboBoxActionPerformed);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("First Name");

        jNOFirstname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jNOFirstname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(33, 120, 209)));
        jNOFirstname.addActionListener(this::jNOFirstnameActionPerformed);

        jShowSummarybutton.setBackground(new java.awt.Color(33, 120, 209));
        jShowSummarybutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jShowSummarybutton.setForeground(new java.awt.Color(255, 255, 255));
        jShowSummarybutton.setText("Review Order");
        jShowSummarybutton.addActionListener(this::jShowSummarybuttonActionPerformed);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Address");

        jPanel2.setBackground(new java.awt.Color(33, 120, 209));
        jPanel2.setForeground(new java.awt.Color(33, 120, 209));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\SparkleWater_System\\src\\icon\\addneworders.png")); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ADD NEW ORDER");

        jLbldate.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLbldate.setForeground(new java.awt.Color(255, 255, 255));
        jLbldate.setText("Create a new customer order");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLbldate)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLbldate))
                        .addGap(15, 15, 15))))
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Contact Number");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(33, 120, 209));
        jLabel11.setText("Order Details");

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(33, 120, 209));
        jLabel12.setText("Customer Information");

        jPanel1.setBackground(new java.awt.Color(218, 229, 241));

        jLabelProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelProduct.setText("Mineral Water");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(149, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(218, 229, 241));

        jLabelUnitPrice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelUnitPrice.setText("₱ 25.00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(149, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabelUnitPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Cancel");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jNOQuantity.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));
        jNOQuantity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(33, 120, 209)));

        jComboBoxOrderType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Walk-in", "Delivery" }));
        jComboBoxOrderType.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(33, 120, 209)));
        jComboBoxOrderType.addActionListener(this::jComboBoxOrderTypeActionPerformed);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Order Type");

        jPanel4.setBackground(new java.awt.Color(218, 229, 241));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("SUBTOTAL");

        jLabelSUBTOTAL.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelSUBTOTAL.setForeground(new java.awt.Color(33, 120, 209));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelSUBTOTAL, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabelSUBTOTAL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(218, 229, 241));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("DELIVERY FEE");

        jLabelDF.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelDF.setForeground(new java.awt.Color(33, 120, 209));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelDF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(jLabelDF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(218, 229, 241));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("TOTAL");

        jLabelTOTAL.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelTOTAL.setForeground(new java.awt.Color(33, 120, 209));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTOTAL, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTOTAL, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jNOLastName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jNOLastName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(33, 120, 209)));
        jNOLastName.addActionListener(this::jNOLastNameActionPerformed);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Last Name");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Product");

        javax.swing.GroupLayout jPanelNewOrderLayout = new javax.swing.GroupLayout(jPanelNewOrder);
        jPanelNewOrder.setLayout(jPanelNewOrderLayout);
        jPanelNewOrderLayout.setHorizontalGroup(
            jPanelNewOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNewOrderLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanelNewOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jNOFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jNOContact, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanelNewOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel4)
                    .addComponent(jNOAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNOLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelNewOrderLayout.createSequentialGroup()
                .addGroup(jPanelNewOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelNewOrderLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel12))
                    .addGroup(jPanelNewOrderLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanelNewOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelNewOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanelNewOrderLayout.createSequentialGroup()
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jNOClearbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jShowSummarybutton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelNewOrderLayout.createSequentialGroup()
                                    .addGroup(jPanelNewOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel9)
                                        .addGroup(jPanelNewOrderLayout.createSequentialGroup()
                                            .addGap(126, 126, 126)
                                            .addGroup(jPanelNewOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel10)
                                                .addComponent(jComboBoxOrderType, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jLabel6)
                                        .addComponent(jNOQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(40, 40, 40)
                                    .addGroup(jPanelNewOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8)
                                        .addComponent(jPaymentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(0, 28, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelNewOrderLayout.setVerticalGroup(
            jPanelNewOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNewOrderLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel12)
                .addGap(20, 20, 20)
                .addGroup(jPanelNewOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelNewOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNOFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNOLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelNewOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGap(8, 8, 8)
                .addGroup(jPanelNewOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNOContact, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNOAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(jPanelNewOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelNewOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelNewOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelNewOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jNOQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelNewOrderLayout.createSequentialGroup()
                        .addGroup(jPanelNewOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxOrderType, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                            .addComponent(jPaymentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)))
                .addGap(25, 25, 25)
                .addGroup(jPanelNewOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanelNewOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jShowSummarybutton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNOClearbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(92, 92, 92))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNewOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNewOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(690, 763));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jShowSummarybuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jShowSummarybuttonActionPerformed
 try {

    String firstName = jNOFirstname.getText().trim();
    String lastName = jNOLastName.getText().trim();
    String customer = firstName + " " + lastName;

    if (firstName.isEmpty() || lastName.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter first and last name.");
        return;
    }
    String contact = jNOContact.getText().trim();
    String address = jNOAddress.getText().trim();
    if (contact.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Please enter contact number.");
    return;
}

    if (!contact.matches("09\\d{9}")) {
    JOptionPane.showMessageDialog(this,
            "Enter a valid 11-digit mobile number starting with 09.");
    return;
}
    
if (jComboBoxOrderType.getSelectedItem().toString().equals("Delivery")
        && address.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Please enter delivery address.");
    return;
}
    String product = jLabelProduct.getText();

    int quantity = (int) jNOQuantity.getValue();
if (quantity <= 0) {
    JOptionPane.showMessageDialog(this,
            "Quantity must be at least 1.");
    return;
}
    double unitPrice = Double.parseDouble(
            jLabelUnitPrice.getText().replace("₱", "").trim()
    );

    String payment = jPaymentComboBox.getSelectedItem().toString();
    String orderType = jComboBoxOrderType.getSelectedItem().toString();

    double subtotal = quantity * unitPrice;

    double deliveryFee = 0;

if (orderType.equals("Delivery") && quantity < 5) {
    deliveryFee = quantity * 5;
}

    double total = subtotal + deliveryFee;

    AdminOrderSummaryDialog summary = new AdminOrderSummaryDialog (
            firstName,
            lastName,
            contact,
            address,
            product,
            quantity,
            unitPrice,
            payment,
            orderType,
            subtotal,
            deliveryFee,
            total,
            existingCustomerID

    );

    summary.setLocationRelativeTo(this);
    summary.setVisible(true);

    this.dispose();

} catch (Exception e) {
    JOptionPane.showMessageDialog(
            this,
            "Please complete the order details.",
            "Invalid Input",
            JOptionPane.ERROR_MESSAGE
    );
}
    }//GEN-LAST:event_jShowSummarybuttonActionPerformed

    private void jPaymentComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPaymentComboBoxActionPerformed
         calculateTotal();
         
         
         
         jPaymentComboBox.removeAllItems();

if (jComboBoxOrderType.getSelectedItem().equals("Walk-in")) {
    jPaymentComboBox.addItem("Cash");
} else {
    jPaymentComboBox.addItem("Cash on Delivery");
    jPaymentComboBox.addItem("GCash");
}
    }//GEN-LAST:event_jPaymentComboBoxActionPerformed

    private void jNOClearbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNOClearbuttonActionPerformed
        jNOFirstname.setText("");
        jNOLastName.setText("");
jNOContact.setText("");
jNOAddress.setText("");

jNOQuantity.setValue(1);
jPaymentComboBox.setSelectedIndex(0);
jComboBoxOrderType.setSelectedIndex(0);

calculateTotal();
    }//GEN-LAST:event_jNOClearbuttonActionPerformed

    private void jComboBoxOrderTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxOrderTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxOrderTypeActionPerformed

    private void jNOFirstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNOFirstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNOFirstnameActionPerformed

    private void jNOLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNOLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNOLastNameActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBoxOrderType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelDF;
    private javax.swing.JLabel jLabelProduct;
    private javax.swing.JLabel jLabelSUBTOTAL;
    private javax.swing.JLabel jLabelTOTAL;
    private javax.swing.JLabel jLabelUnitPrice;
    private javax.swing.JLabel jLbldate;
    private javax.swing.JTextField jNOAddress;
    private javax.swing.JButton jNOClearbutton;
    private javax.swing.JTextField jNOContact;
    private javax.swing.JTextField jNOFirstname;
    private javax.swing.JTextField jNOLastName;
    private javax.swing.JSpinner jNOQuantity;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelNewOrder;
    private javax.swing.JComboBox<String> jPaymentComboBox;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton jShowSummarybutton;
    // End of variables declaration//GEN-END:variables
}
