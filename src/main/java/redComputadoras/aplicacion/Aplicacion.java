package redComputadoras.aplicacion;

import net.datastructures.TreeMap;
import redComputadoras.datos.CargarParametros;
import redComputadoras.datos.Dato;
import redComputadoras.interfaz.Interfaz;
import redComputadoras.logica.Calculo;
import redComputadoras.modelo.Conexion;
import redComputadoras.modelo.Equipo;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Aplicacion {

    public static void main(String[] args) {

        // Cargar parametros
        try {
            CargarParametros.parametros();
        } catch (IOException e) {
            System.err.print("Error al cargar parámetros");
            System.exit(-1);
        }

        // Cargar datos
        TreeMap<String, Equipo> equipos = null;
        List<Conexion> conexiones = null;
        try {
            equipos = Dato.cargarEquipos(CargarParametros.getArchivoComputadora(), CargarParametros.getArchivoRouter());

            conexiones = Dato.cargarConexiones(CargarParametros.getArchivoConexion(), equipos);

        } catch (FileNotFoundException e) {
            System.err.print("Error al cargar archivos de datos");
            System.exit(-1);
        }

        // Realizar cálculo (Crear el grafo)
        Calculo c = new Calculo(equipos, conexiones);

        // Ingreso datos usuario
        Integer opcion = null;
        do {
            opcion = Interfaz.opcion();
            switch (opcion) {
                case Constante.PING:
                    Equipo equipo = Interfaz.ingresarEquipo(equipos);
                    if (equipo == null) {
                        break;
                    }
                    if (c.ping(equipo)) {
                        JOptionPane.showMessageDialog(null, "Equipo activo");
                    } else {
                        JOptionPane.showMessageDialog(null, "Equipo inactivo");
                    }
                    break;

                case Constante.TRACEROUTE:
                    Equipo origen = Interfaz.ingresarEquipo(equipos);
                    if (origen == null) {
                        break;
                    }
                    Equipo destino = Interfaz.ingresarEquipo(equipos);
                    if (destino == null) {
                        break;
                    }
                    List<Equipo> path = c.traceroute(origen, destino);
                    if (path.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay ruta", "Traceroute", JOptionPane.ERROR_MESSAGE);
                    } else {
                        String message = "";
                        for (Equipo e : path) {
                            message += e + " -> \n";
                        }
                        JOptionPane.showMessageDialog(null, message, "Traceroute", JOptionPane.PLAIN_MESSAGE, null);
                    }
                    break;

                case Constante.TRANSMISION_ENTRE_ROUTERS:
                    break;
            }
        } while (opcion != null && !opcion.equals(Constante.SALIR));
    }
}
