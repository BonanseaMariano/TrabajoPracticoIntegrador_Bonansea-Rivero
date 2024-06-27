package red.aplicacion;

import net.datastructures.TreeMap;
import red.datos.CargarParametros;
import red.datos.Database;
import red.interfaz.Dashboard;
import red.logica.Calculo;
import red.modelo.Conexion;
import red.modelo.Equipo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Aplicacion {
    
    public static void main(String[] args) {

        // Cargar parametros
        try {
            CargarParametros.parametros();
        } catch (IOException e) {
            System.err.print("Error al cargar parametros");
            System.exit(-1);
        }

        // Cargar datos
        TreeMap<String, Equipo> equipos = null;
        List<Conexion> conexiones = null;
        try {
            
            equipos = Database.cargarEquiposDB();
            
            conexiones = Database.cargarConexionesDB(equipos);
            
        } catch (SQLException e) {
            System.err.print("Error al cargar base de datos");
            System.exit(-1);
        }

        Calculo.CreateInstance(equipos, conexiones);
        Dashboard d = new Dashboard();
        d.setVisible(true);
    }
}
