package conexiones;

import java.sql.SQLException;

public class Connection {

    private java.sql.Connection conexion = null;

    public Connection() {

    }

    public java.sql.Connection getConnection() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conexion = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/macaco_project", "root", "1234");
        }
        catch (ClassNotFoundException e){
            System.out.println("Error con el driver MySQL.");
        }
        catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        }
        return conexion;
    }
}
