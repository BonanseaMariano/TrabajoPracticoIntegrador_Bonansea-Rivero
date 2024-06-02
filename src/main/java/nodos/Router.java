package nodos;

public class Router extends Nodo {
    private String modelo;
    private String firmware;
    private double throughput;

    //Constructors
    public Router() {
        super();
    }

    public Router(String ubicacion, boolean status, String macAdress, String ipAdress, String id, String modelo, String firmware, double throughput) {
        super(ubicacion, status, macAdress, ipAdress, id);
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
}
