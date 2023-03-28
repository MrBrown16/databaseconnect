import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.lang.ClassNotFoundException;

public class Connecting {

    private String database;
    private String user;
    private String pass;
    private Connection connection;
    public Connecting() {
    }
    public Connecting(String database, String user, String pass) {
        this.database = database;
        this.user = user;
        this.pass = pass;
        connection = null;
    }
    
    public void connect(){

        //String connection = "jdbc:mariadb://localhost:3306/DbName"; //java database connection = jdbc : mariadb -> sql type :// domain localhost : 3306 sql port number / DbName database name
        //String url = "jdbc:mariadb://localhost:3306/employee"; 
        String url = "jdbc:mariadb://localhost:3306/"+database;
        
        try {
            // Class.forName("com.mysql.jdbc.Driver"); -MySql
            Class.forName("org.mariadb.jdbc.Driver"); // -mariadb
            connection = (Connection) DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println("hiba a kapcsolódás során");
        } catch(ClassNotFoundException e) {
            System.out.println("Classnotfoundexeption");
        }
    }

    public void close(){
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("hiba a lezárás során");
            }
        }

    }
    public Connection getConnection(){
        return connection;
    }
}
