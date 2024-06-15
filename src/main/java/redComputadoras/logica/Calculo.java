package redComputadoras.logica;

import net.datastructures.*;
import redComputadoras.modelo.Equipo;
import redComputadoras.modelo.Conexion;

import java.util.ArrayList;
import java.util.List;

public class Calculo {

    private Graph<Equipo, Conexion> redComputadoras;
    private TreeMap<String, Vertex<Equipo>> vertices;
    private TreeMap<String, Equipo> ipMap;

    public Calculo(TreeMap<String, Equipo> equipos, List<Conexion> conexiones) {

        redComputadoras = new AdjacencyMapGraph<>(false);

        // Cargar equipos
        vertices = new TreeMap<String, Vertex<Equipo>>();
        //Cargar mapa de ips
        ipMap = new TreeMap<String, Equipo>();

        for (Entry<String, Equipo> equipo : equipos.entrySet()) {
            vertices.put(equipo.getKey(), redComputadoras.insertVertex(equipo.getValue()));
            ipMap.put(equipo.getValue().getIpAdress(), equipo.getValue());
        }


        // Cargar conexiones
        for (Conexion conexion : conexiones)
            redComputadoras.insertEdge(vertices.get(conexion.getEquipo1().getId()), vertices.get(conexion.getEquipo2().getId()), conexion);
    }

    public TreeMap<String, Equipo> getIpMap() {
        return ipMap;
    }

    /**
     * Getter de la red (UNICAMENTE PARA EL TEST)
     *
     * @return el grafo de la red de computadoras creado a partir de los archivos
     */
    public Graph<Equipo, Conexion> getRedComputadoras() {
        return redComputadoras;
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

    /**
     * Calculates the shortest path between two equipment in the network.
     *
     * @param equipo1 the starting equipment
     * @param equipo2 the destination equipment
     * @return a list of connections that form the shortest path
     */
    public List<Equipo> traceroute(Equipo equipo1, Equipo equipo2) {
        // copia grafos
        List<Equipo> equipos = new ArrayList<>();
        Graph<Equipo, Integer> rapido = new AdjacencyMapGraph<>(false);
        Map<Equipo, Vertex<Equipo>> res = new ProbeHashMap<>();
        PositionalList<Vertex<Equipo>> lista;
        copiarGrafo(rapido, res);
        try {
            lista = GraphAlgorithms.shortestPathList(rapido, res.get(equipo1), res.get(equipo2));
        } catch (IllegalArgumentException e) {
            return equipos;
        }
        for (Vertex<Equipo> result : lista) {
            equipos.add(result.getElement());
        }

        return equipos;
    }

    /**
     * Generates the transmission between routers based on the minimum spanning tree of the graph.
     *
     * @return a list of strings representing the transmission between routers
     */
    public List<String> transmisionEntreRouters() {
        // copia grafos
        Graph<Equipo, Integer> copia = new AdjacencyMapGraph<>(false);
        Map<Equipo, Vertex<Equipo>> res = new ProbeHashMap<>();
        copiarGrafo(copia, res);

        PositionalList<Edge<Integer>> lista = GraphAlgorithms.MST(copia);

        List<String> edges = new ArrayList<>();

        for (Edge<Integer> result : lista) {
            Vertex<Equipo> v[] = copia.endVertices(result);
            edges.add(v[0].getElement().getClass().getSimpleName() + ": " + v[0].getElement().getIpAdress() + " <-> " + v[1].getElement().getClass().getSimpleName() + ": " + v[1].getElement().getIpAdress());
        }

        return edges;
    }

    /**
     * Creates a copy of the graph wit the format <Equipo, Integer>
     *
     * @param copia the copy of the graph
     * @param res   the map of vertices asosiated with the copy
     */
    public void copiarGrafo(Graph<Equipo, Integer> copia, Map<Equipo, Vertex<Equipo>> res) {

        for (Vertex<Equipo> result : redComputadoras.vertices()) {
            if (result.getElement().isStatus()) {
                res.put(result.getElement(), copia.insertVertex(result.getElement()));
            }
        }
        Vertex<Equipo>[] vert;

        for (Edge<Conexion> result : redComputadoras.edges()) {
            vert = redComputadoras.endVertices(result);
            if (result.getElement().isStatus() && vert[0].getElement().isStatus() && vert[1].getElement().isStatus()) {
                copia.insertEdge(res.get(vert[0].getElement()), res.get(vert[1].getElement()), result.getElement().getLatencia());
            }
        }
    }

}
