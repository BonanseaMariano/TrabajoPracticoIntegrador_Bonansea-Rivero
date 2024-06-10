package redComputadoras.aplicacion;

import net.datastructures.TreeMap;
import redComputadoras.datos.CargarParametros;
import redComputadoras.datos.Dato;
import redComputadoras.interfaz.Interfaz;
import redComputadoras.logica.Calculo;
import redComputadoras.modelo.Conexion;
import redComputadoras.modelo.Equipo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Aplicacion {

    public static void main(String[] args) {

        // Cargar parametros
        try {
            CargarParametros.parametros();
        } catch (IOException e) {
            System.err.print("Error al cargar par�metros");
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

        // Ingreso datos usuario
        int opcion = Interfaz.opcion();
        Equipo origen = Interfaz.ingresarEquipoOrigen(equipos);
        Equipo destino = Interfaz.ingresarEquipoDestino(equipos);

        // Realizar c�lculo
        Calculo c = new Calculo(equipos, conexiones);

        List<Conexion> recorrido = null;
        if (c.graphEmpty())
            System.out.println("El grafo se encuentra vacio!");
        else if (opcion == Constante.MAS_RAPIDO)
            recorrido = c.rapido(origen, destino);

        // Mostrar resultado
//        Interfaz.resultado(recorrido);

    }

}
