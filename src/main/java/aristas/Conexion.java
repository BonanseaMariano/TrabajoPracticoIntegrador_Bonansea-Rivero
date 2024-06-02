package aristas;

import nodos.Nodo;

public class Conexion {
    private String tipoDeConexion;
    private double bandwith;
    private double latencia;
    private boolean status;
    private int errorRate;

    //Constructors
    public Conexion() {
    }

    public Conexion(String tipoDeConexion, double bandwith, double latencia, boolean status, int errorRate) {
        this.tipoDeConexion = tipoDeConexion;
        this.bandwith = bandwith;
        this.latencia = latencia;
        this.status = status;
        this.errorRate = errorRate;
    }

    //Getters and Setters


    public String getTipoDeConexion() {
        return tipoDeConexion;
    }

    public void setTipoDeConexion(String tipoDeConexion) {
        this.tipoDeConexion = tipoDeConexion;
    }

    public double getBandwith() {
        return bandwith;
    }

    public void setBandwith(double bandwith) {
        this.bandwith = bandwith;
    }

    public double getLatencia() {
        return latencia;
    }

    public void setLatencia(double latencia) {
        this.latencia = latencia;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getErrorRate() {
        return errorRate;
    }

    public void setErrorRate(int errorRate) {
        this.errorRate = errorRate;
    }
}
