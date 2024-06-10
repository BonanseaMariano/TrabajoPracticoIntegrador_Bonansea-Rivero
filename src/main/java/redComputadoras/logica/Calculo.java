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
    public List<Conexion> rapido(Equipo equipo1, Equipo equipo2) {
        // copia grafo
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

        List<Conexion> conexiones = new ArrayList<Conexion>();

        Vertex<Equipo> v1, v2;
        Position<Vertex<Equipo>> aux = lista.first();
        while (lista.after(aux) != null) {
            v1 = aux.getElement();
            aux = lista.after(aux);
            v2 = aux.getElement();
            conexiones.add(redComputadoras.getEdge(vertices.get(v1.getElement().getId()), vertices.get(v2.getElement().getId())).getElement());
        }
        return conexiones;
    }


    public boolean ping(Equipo equipo) {
        try {
            return equipo.isStatus();
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
