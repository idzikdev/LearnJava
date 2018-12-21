package persystencja;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AppH2 {

    private static String h2Driver="org.h2.Driver";
    private static String h2Address="jdbc:h2:mem:test_mem;DB_CLOSE_DELAY=-1";
    //domyślne wartości dla bazy danych w pamięci
    private static String user="";
    private static String password="";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection=null;
        Class.forName(h2Driver);
        connection=DriverManager.getConnection(h2Address,user,password);
        return connection;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection=getConnection();
        if (connection!=null){
            System.out.println("SUKCES");
        }
    }
}
