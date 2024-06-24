package red.datos;

import net.datastructures.TreeMap;
import red.modelo.Computadora;
import red.modelo.Conexion;
import red.modelo.Equipo;
import red.modelo.Router;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.sql.DriverManager.getConnection;


public class Database {

    private static final String DB_URL = "jdbc:mysql://localhost/red_computadoras";

    public static TreeMap<String, Equipo> cargarEquiposDB() throws SQLException {
        TreeMap<String, Equipo> equipos = new TreeMap<>();
        cargarComputadorasDB(equipos);
        cargarRoutersDB(equipos);
        return equipos;
    }

    private static void cargarComputadorasDB(TreeMap<String, Equipo> equipos) throws SQLException {
        try (Connection connection = getConnection(DB_URL, "root", "");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM computadoras")) {

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String nombre = resultSet.getString("nombre");
                String ipAdress = resultSet.getString("ipAdress");
                String macAdress = resultSet.getString("macAdress");
                String ubicacion = resultSet.getString("ubicacion");
                boolean status = resultSet.getBoolean("status");

                Computadora computadora = new Computadora(id, nombre, ipAdress, macAdress, status, ubicacion);
                equipos.put(id, computadora);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void cargarRoutersDB(TreeMap<String, Equipo> equipos) throws SQLException {
        try (Connection connection = getConnection(DB_URL, "root", "");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM routers")) {

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String nombre = resultSet.getString("nombre");
                String ipAdress = resultSet.getString("ipAdress");
                String macAdress = resultSet.getString("macAdress");
                String ubicacion = resultSet.getString("ubicacion");
                String modelo = resultSet.getString("modelo");
                String firmware = resultSet.getString("firmware");
                boolean status = resultSet.getBoolean("status");
                double throughput = resultSet.getDouble("troughput");

                Router router = new Router(id, nombre, ipAdress, macAdress, status, ubicacion, modelo, firmware, throughput);
                equipos.put(id, router);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<Conexion> cargarConexionesDB(TreeMap<String, Equipo> equipos) {
        List<Conexion> conexiones = new ArrayList<>();

        try (Connection connection = getConnection(DB_URL, "root", "");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM conexiones")) {
            while (resultSet.next()) {
                String v1 = resultSet.getString("equipo1");
                String v2 = resultSet.getString("equipo2");
                String tipoDeConexion = resultSet.getString("tipoConexion");
                int bandwith = resultSet.getInt("bandwith");
                int latencia = resultSet.getInt("latencia");
                boolean status = resultSet.getBoolean("status");
                int errorRate = resultSet.getInt("errorRate");

                conexiones.add(0, new Conexion(equipos.get(v1), equipos.get(v2), tipoDeConexion, bandwith, latencia, status, errorRate));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conexiones;
    }
}