package redComputadoras.logica;

import net.datastructures.*;
import redComputadoras.modelo.Equipo;
import redComputadoras.modelo.Conexion;

import java.util.ArrayList;
import java.util.List;

public class Calculo {

    private Graph<Equipo, Conexion> redComputadoras;
    private TreeMap<String, Vertex<Equipo>> vertices;

    public Calculo(TreeMap<String, Equipo> equipos, List<Conexion> conexiones) {

        redComputadoras = new AdjacencyMapGraph<>(false);

        // Cargar equipos
        vertices = new TreeMap<String, Vertex<Equipo>>();
        for (Entry<String, Equipo> equipo : equipos.entrySet())
            vertices.put(equipo.getKey(), redComputadoras.insertVertex(equipo.getValue()));

        // Cargar conexiones
        for (Conexion conexion : conexiones)
            redComputadoras.insertEdge(vertices.get(conexion.getEquipo1().getId()), vertices.get(conexion.getEquipo2().getId()), conexion);
    }

    public boolean graphEmpty() {
        return redComputadoras.numVertices() == 0 && redComputadoras.numEdges() == 0;
    }

    /**
     * Calculates the shortest path between two equipment in the network.
     *
     * @param equipo1 the starting equipment
     * @param equipo2 the destination equipment
     * @return a list of connections that form the shortest path
     */
    public List<Equipo> traceroute(Equipo equipo1, Equipo equipo2) {
        // copia grafos
        Graph<Equipo, Integer> rapido = new AdjacencyMapGraph<>(false);
        Map<Equipo, Vertex<Equipo>> res = new ProbeHashMap<>();

        for (Vertex<Equipo> result : redComputadoras.vertices())
            res.put(result.getElement(), rapido.insertVertex(result.getElement()));

        Vertex<Equipo>[] vert;

        for (Edge<Conexion> result : redComputadoras.edges()) {
            vert = redComputadoras.endVertices(result);
            rapido.insertEdge(res.get(vert[0].getElement()), res.get(vert[1].getElement()), result.getElement().getVelocidad());
        }
        PositionalList<Vertex<Equipo>> lista = GraphAlgorithms.shortestPathList(rapido, res.get(equipo1), res.get(equipo2));

        List<Equipo> equipos = new ArrayList<>();

        for (Vertex<Equipo> result : lista) {
            equipos.add(result.getElement());
        }

        return equipos;
    }

    /**
     * Checks if an equipment is online.
     *
     * @param equipo the equipment to check
     * @return true if the equipment is online, false otherwise
     */
    public boolean ping(Equipo equipo) {
        return equipo.isStatus();
    }
}
