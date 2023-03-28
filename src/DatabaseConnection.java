import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;
    public static void main(String[] args) {
        //String connection = "jdbc:mariadb://localhost:3306/DbName"; //java database connection = jdbc : mariadb -> sql type :// domain localhost : 3306 sql port number / DbName database name
        Connecting connecting = new Connecting("employee", "root", "");
        connecting.connect();
        connection = connecting.getConnection();
        getData();
        // if (connection != null) {
        //     System.out.println("jó");
        // }

    }

    private static void getData(){
        String sql = "SELECT name FROM workers WHERE workers.age=41;";
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);

            while( rs.next()){
                System.out.println(rs.getString("name"));
                // System.out.print(rs.getInt(1)+", "); //coloumn number (from 1)
                // System.out.print(rs.getString("name")+", "); // coloumn name 
                // System.out.print(rs.getInt(3)+"\n");

            }

        } catch (SQLException e) {
            System.out.println("hiba a lekérdezés során getData");
        }
    }
}
