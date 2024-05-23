package aristas;

import nodos.Nodo;

public class Conexion {
    private Nodo sourceNode;
    private Nodo targetNode;
    private String tipoDeConexion;
    private double bandwith;
    private double latencia;
    private boolean status;
    private int errorRate;

    //Constructors
    public Conexion() {
    }

    public Conexion(Nodo sourceNode, Nodo targetNode, String tipoDeConexion, double bandwith, double latencia, boolean status, int errorRate) {
        this.sourceNode = sourceNode;
        this.targetNode = targetNode;
        this.tipoDeConexion = tipoDeConexion;
        this.bandwith = bandwith;
        this.latencia = latencia;
        this.status = status;
        this.errorRate = errorRate;
    }
}
