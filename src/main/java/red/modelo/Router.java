package red.modelo;

public class Router extends Equipo {
    private String modelo;
    private String firmware;
    private double throughput;

    //Constructors
    public Router() {
        super();
    }

    public Router(String id, String nombre, String ipAdress, String macAdress, boolean status, String ubicacion, String modelo, String firmware, double throughput) {
        super(id, nombre, ipAdress, macAdress, status, ubicacion);
        this.modelo = modelo;
        this.firmware = firmware;
        this.throughput = throughput;
    }

    //Getters and Setters
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFirmware() {
        return firmware;
    }

    public void setFirmware(String firmware) {
        this.firmware = firmware;
    }

    public double getThroughput() {
        return throughput;
    }

    public void setThroughput(double throughput) {
        this.throughput = throughput;
    }

    @Override
    public String toString() {
        return "Router{ " + super.toString() + "}";
    }
}
