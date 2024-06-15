package test;
/*
 * JUNIT Test donde se visualiza la diferencia entre la red original y la red copiada generadas por la logica del programa
 * La red original es la que se obtiene al cargar los archivos de datos y no tiene en cuenta status (formato: Graph<Equipo, Conexion>),
 * mientras que la copia se genera al realizar los calculos y si tiene en cuenta status (formato: Graph<Equipo, Integer>)
 */

import net.datastructures.*;
import redComputadoras.datos.CargarParametros;
import redComputadoras.datos.Dato;
import redComputadoras.logica.Calculo;
import redComputadoras.modelo.Conexion;
import redComputadoras.modelo.Equipo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


class CalculoTest {
    Calculo c;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
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
        c = new Calculo(equipos, conexiones);
    }

    @org.junit.jupiter.api.Test
    void impresionGrafoOriginal() {
        System.out.println("\t\t---- IMPRESION GRAFO ORIGINAL ----");
        System.out.println("\t-- VERTICES --");
        for (Vertex<Equipo> e : c.getRedComputadoras().vertices()) {
            System.out.println(e.getElement().getIpAdress() + " | STATUS: " + e.getElement().isStatus());
        }
        System.out.println("\n\t-- ARCOS --");
        for (Edge<Conexion> e : c.getRedComputadoras().edges()) {
            System.out.println(e.getElement().getEquipo1().getIpAdress() + " <-> " + e.getElement().getEquipo2().getIpAdress() + " | PESO(LATENCIA): " + e.getElement().getLatencia() + " | STATUS: " + e.getElement().isStatus());
        }
    }

    @org.junit.jupiter.api.Test
    void impresionGrafoCopia() {
        Graph<Equipo, Integer> copia = new AdjacencyMapGraph<>(false);
        c.copiarGrafo(copia, new ProbeHashMap<>());

        System.out.println("\n\t\t---- IMPRESION GRAFO COPIA ----");
        System.out.println("\t-- VERTICES --");
        for (Vertex<Equipo> e : copia.vertices()) {
            System.out.println(e.getElement().getIpAdress() + " | STATUS: " + e.getElement().isStatus());
        }
        System.out.println("\n\t-- ARCOS --");
        for (Edge<Integer> e : copia.edges()) {
            Vertex<Equipo> v[] = copia.endVertices(e);
            System.out.println(v[0].getElement().getIpAdress() + " <-> " + v[1].getElement().getIpAdress() + " | PESO(LATENCIA): " + e.getElement());
        }
    }
}