package redComputadoras.modelo;

public class Conexion {
    private Equipo equipo1;
    private Equipo equipo2;
    private String tipoDeConexion;
    private double bandwith;
    private double latencia;
    private boolean status;
    private int errorRate;
    private int velocidad;

    //Constructors
    public Conexion() {
    }

    public Conexion(Equipo equipo1, Equipo equipo2, String tipoDeConexion, double bandwith, double latencia, boolean status, int errorRate) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.tipoDeConexion = tipoDeConexion;
        this.bandwith = bandwith;
        this.latencia = latencia;
        this.status = status;
        this.errorRate = errorRate;
        velocidad = calcularVelocidad(bandwith, latencia, errorRate);
    }

    /**
     * Formula hipotetica para calcular la velocidad de una conexion.
     *
     * @param B the bandwidth of the connection
     * @param L the latency of the connection
     * @param E the error rate of the connection
     * @return the calculated velocity of the connection rounded to the nearest integer
     */
    private int calcularVelocidad(double B, double L, int E) {
        double velocidad = B / ((1 + L) * (1 + E));
        return (int) Math.round(velocidad);
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

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
}
