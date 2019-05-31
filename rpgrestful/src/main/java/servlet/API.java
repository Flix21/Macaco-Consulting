package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Ranking;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


@WebServlet("/API")
public class API extends HttpServlet {

    private java.sql.Connection conexion = null;
    public static final ObjectMapper mapper = new ObjectMapper();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conexion = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/macaco_project", "root", "1234");
            Statement s = conexion.createStatement();

            //Recibe el JSON (a traves del header) y lo convierte en un objeto Ranking para crear la sentencia SQL
            String json = request.getHeader("valores");
            Ranking r = mapper.readValue(json, Ranking.class);
            String query = "INSERT INTO ranking_jugadores (nombre, avance_partida, fecha_partida, tiempo_jugado, monstruo_vencedor, ataque, defensa, velocidad, vida) VALUES (\""
                    + r.nombre + "\", " + r.av_partida + ", \'" + r.fecha.toString() + "\', " + r.tiempo
                    + ", \"" + r.monstruo + "\", " + r.ataque + ", " + r.defensa + ", " + r.velocidad
                    + ", " + r.vida + ")";

            int res = s.executeUpdate(query);

            conexion.close();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conexion = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/macaco_project", "root", "1234");
            Statement s = conexion.createStatement();

            PrintWriter mesage = response.getWriter();
            ResultSet query = s.executeQuery("SELECT * FROM ranking_jugadores");


            if(query.next()) {
                //Crear un objecto Ranking y popularlo
                Ranking r = new Ranking(query.getString(2),
                        query.getString(3), query.getString(4),
                        query.getString(5), query.getString(6),
                        query.getString(7), query.getString(8),
                        query.getString(9), query.getString(10));

                //Crear un JSON con la info del ranking
                String json = mapper.writeValueAsString(r);

                PrintWriter out = response.getWriter();
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                out.print(json);
                out.flush();
            }
            else {
                mesage.println("No hay registros en el ranking.");
            }
            conexion.close();
        }
        catch (ClassNotFoundException e){
            System.out.println("Error con el driver MySQL.");
        }
        catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        }
    }
}
