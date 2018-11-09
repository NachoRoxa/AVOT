package CONEXION;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {  
//    public static Connection getConexion() {
//        Connection connection = null;
//        try {
//           String driverClassName = "oracle.jdbc.driver.OracleDriver";
//           String driverUrl="jdbc:oracle:thin:@localhost:1521:XE";
//           Class.forName(driverClassName);
//           connection = DriverManager.getConnection(
//                   driverUrl, "AVOT","paso");
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//        return connection;
//    }
    
    Connection cn;
    
    public Connection getConnection(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","AVOT","paso");
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getNextException());
        }
        return cn;
    }
}
