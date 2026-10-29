/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sparkle_system;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/*Nag-create ta og separate class nga gitawag og OrderManager para diri nato ibutang ang mga database operations related sa orders.
Instead nga tanan code naa sa atong ORDERS JFrame, gi-separate nato ang logic para mas organized ug dali i-maintain.*/
//OOP Concept: Encapsulation
public class AdminOrderManager {
    
 //Ang model mao ang nag-manage sa table rows, while ang rs mao ang nagdala sa results gikan sa database.   
private void addRows(DefaultTableModel model, ResultSet rs) //kani nga method is for adding data sa table
        throws SQLException { 

    while (rs.next()) { //while naay mga records mag padayon ang loop

        model.addRow(new Object[]{ //ga add ug row sa table
            //Ang kada result gikan sa database, ato siyang i-add as one row sa JTable.
            rs.getInt("order_id"), // dapat kung unsay sequence sa table column mao pud dri
            rs.getString("customer_name"),
            rs.getString("quantity"),
            rs.getTimestamp("order_date"),
            rs.getString("payment_type"),
            rs.getString("order_type"), 
            rs.getDouble("total_amount"),
            rs.getString("delivery_status")
        });
    }
}

//kani nga method mag load sa mga data nga gikan sa database padulong sa gui table

public void loadOrders(DefaultTableModel model) throws SQLException {

    model.setRowCount(0); //i remove niya tanan existing row sa table

    String sql = "SELECT o.order_id, " //magkuha tag order_id sa order table
            + "CONCAT(c.first_name, ' ', c.last_name) AS customer_name, " //gi combine nato ang 1st and last name sa customer tas gi butngan ug temporary name
            + "od.quantity, " //kuha ug quantity sa order details table
            + "o.order_date, "// order date sa orders table
            + "o.payment_type, " //payment type sa orders table
            + "o.order_type, " //order type sa table
            + "o.total_amount, " //total amount sa order table
            + "COALESCE(d.delivery_status, 'N/A') AS delivery_status " // delivery status sa deliveries table then is n/a ang naa sa table then meaning ato walk in ang order  type
            + "FROM orders o " //ORDERS TABLE ANG MAIN TABLE NGA GA KUHAAN NATO UG DATA
            //Gi-connect nato ang four tables para makuha ang complete information sa order bisan lain-lain nga tables ang source sa data.
            + "INNER JOIN customers c ON o.customer_id = c.customer_id "
            + "INNER JOIN order_details od ON o.order_id = od.order_id "
            + "LEFT JOIN deliveries d ON o.order_id = d.order_id "
            + "ORDER BY o.order_id DESC"; //Ang bag-o nga Order ID maoy unang makita sa JTable.

    Connection conn = sparklewaterdb_connection.connect(); //connection sa database
    PreparedStatement pst = conn.prepareStatement(sql); //gi prepare ang sql query
    ResultSet rs = pst.executeQuery(); //gi execute tappos nag return ug result gikan sa database

    addRows(model, rs);// Instead nga isulat nato balik ang while (rs.next()) ug model.addRow() sa loadOrders(), gitawag na lang nato ang addRows() method.

    rs.close(); //gi close para walay resource leak
    pst.close();
    conn.close();
}

/*Kani nga method gamiton nato kung mag-search ang admin og specific order.
For example, pwede siya mag-search gamit ang customer name, Order ID, contact
number, payment type, order type, or delivery status.*/
public void searchOrders(DefaultTableModel model, String search) throws SQLException {

    // Numbers are not allowed
    if (search.matches(".*\\d.*")) {
        JOptionPane.showMessageDialog(null,
                "Please search by customer name only.");
        return;
    }

    model.setRowCount(0);

    String sql = "SELECT o.order_id, "
            + "CONCAT(c.first_name, ' ', c.last_name) AS customer_name, "
            + "od.quantity, "
            + "o.order_date, "
            + "o.payment_type, "
            + "o.order_type, "
            + "o.total_amount, "
            + "COALESCE(d.delivery_status, 'N/A') AS delivery_status "
            + "FROM orders o "
            + "INNER JOIN customers c ON o.customer_id = c.customer_id "
            + "INNER JOIN order_details od ON o.order_id = od.order_id "
            + "LEFT JOIN deliveries d ON o.order_id = d.order_id "
            + "WHERE CONCAT(c.first_name, ' ', c.last_name) LIKE ? "
            + "ORDER BY o.order_id DESC";

    Connection conn = sparklewaterdb_connection.connect();
    PreparedStatement pst = conn.prepareStatement(sql);

    pst.setString(1, "%" + search.trim() + "%");

    ResultSet rs = pst.executeQuery();
    addRows(model, rs);

    rs.close();
    pst.close();
    conn.close();
}
    //Kani nga method mao ang responsable sa pag-delete sa selected order ug sa iyang related records.
    public void deleteOrder(int orderID) throws SQLException {

        //Mag-connect ta sa database, ug automatic ma-close ang connection after mahuman
    try (Connection conn = sparklewaterdb_connection.connect()) {

        conn.setAutoCommit(false); //Gi-disable nato ang automatic saving para ang three DELETE statements atong ma-control as one transaction.

        try {
            String[] sql = { //mao ning delete query
                "DELETE FROM deliveries WHERE order_id=?",
                "DELETE FROM order_details WHERE order_id=?",
                "DELETE FROM orders WHERE order_id=?"
            };

            for (String query : sql) { //Kani nga loop kay iyang i-execute ang three DELETE queries usa-usa, in order.
                try (PreparedStatement pst = conn.prepareStatement(query)) {
                    pst.setInt(1, orderID);
                    pst.executeUpdate(); //Gigamit nato ang executeUpdate() kay nag-delete man ta og records, dili lang nag-retrieve og data.
                }
            }

            conn.commit(); //Kung successful tanan DELETE statements, ato nang i-confirm ang changes sa database gamit ang commit().

        } catch (SQLException e) {
            conn.rollback();//Kung naay error while nag-delete ta, ibalik nato ang database sa iyang previous state before the transaction's changes.
            throw e;
        }
        
    }
    }
}


