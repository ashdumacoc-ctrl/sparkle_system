/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sparkle_system;

/**
 *
 * @author ADMIN
 */
public class usersession {
    private static int userid;
    private static String username;
    
    public static void setUser(int id, String user) {
        userid = id;
        username = user;
    }
    
    public static int getUserId() {
        return userid;   
    }
    
    public static String getUsername() {
        return username;   
    }
    
    public static void clearSession() {
        userid = 0;
        username = null;
    }
}
