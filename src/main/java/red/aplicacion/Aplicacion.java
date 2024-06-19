package red.aplicacion;

import net.datastructures.TreeMap;
import red.datos.CargarParametros;
import red.datos.Dato;
import red.logica.Calculo;
import red.interfaz.Interfaz;
import red.modelo.Conexion;
import red.modelo.Equipo;

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
            System.err.print("Error al cargar parametros");
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

        // Realizar calculo (Crear el grafo)
        Calculo c = new Calculo(equipos, conexiones);

        // Ingreso datos usuario
        Integer opcion = null;
        do {
            Equipo origen, destino;
            opcion = Interfaz.opcion();
            switch (opcion) {
                case Constante.PING:
                    Equipo equipo = Interfaz.ingresarEquipo(c.getIpMap());
                    if (equipo == null) {
                        break;
                    }
                    if (c.ping(equipo)) {
                        JOptionPane.showMessageDialog(null, "Equipo activo", "Ping", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Equipo inactivo", "Ping", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case Constante.TRACEROUTE:
                    origen = Interfaz.ingresarEquipo(c.getIpMap());
                    if (origen == null) {
                        break;
                    }
                    destino = Interfaz.ingresarEquipo(c.getIpMap());
                    if (destino == null) {
                        break;
                    }
                    List<Equipo> path = c.traceroute(origen, destino);
                    if (path.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay ruta", "Traceroute", JOptionPane.ERROR_MESSAGE);
                    } else {
                        String message = "";
                        for (Equipo e : path) {
                            if (!path.getLast().equals(e)) {
                                message += e + " -> \n";
                            } else {
                                message += e;
                            }

                        }
                        JOptionPane.showMessageDialog(null, message, "Traceroute", JOptionPane.PLAIN_MESSAGE, null);
                    }
                    break;

                case Constante.TRANSMISION_ENTRE_ROUTERS:
                    String message = "";
                    for (String i : c.transmisionEntreRouters()) {
                        message += i + "\n";
                    }
                    JOptionPane.showMessageDialog(null, message, "Transmision entre routers", JOptionPane.PLAIN_MESSAGE, null);
                    break;
            }
        } while (opcion != null && !opcion.equals(Constante.SALIR));
    }
}
