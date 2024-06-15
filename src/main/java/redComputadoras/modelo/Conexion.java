package redComputadoras.modelo;

public class Conexion {
    private Equipo equipo1;
    private Equipo equipo2;
    private String tipoDeConexion;
    private int bandwith;
    private int latencia;
    private boolean status;
    private int errorRate;

    //Constructors
    public Conexion() {
    }

    public Conexion(Equipo equipo1, Equipo equipo2, String tipoDeConexion, int bandwith, int latencia, boolean status, int errorRate) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.tipoDeConexion = tipoDeConexion;
        this.bandwith = bandwith;

        //Para evitar que existan arcos negativos (velocidades negativas) para realizar dikstra
        if (latencia < 0)
            this.latencia = 0;
        else
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

    public int getBandwith() {
        return bandwith;
    }

    public void setBandwith(int bandwith) {
        this.bandwith = bandwith;
    }

    public int getLatencia() {
        return latencia;
    }

    public void setLatencia(int latencia) {
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

    @Override
    public String toString() {
        return equipo1 + " -> \n" + equipo2 + "\n**** Bandwith: " + bandwith + ", Tipo: " + tipoDeConexion + ", status: " + status + " ****\n";
    }
}
