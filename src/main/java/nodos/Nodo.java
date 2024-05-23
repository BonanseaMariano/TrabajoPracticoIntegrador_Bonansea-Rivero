package nodos;

public abstract class Nodo {
    private String id;
    private int ipAdress;
    private int macAdress;
    private boolean status;
    private String ubicacion;

    //Constructors
    protected Nodo() {
    }

    protected Nodo(String ubicacion, boolean status, int macAdress, int ipAdress, String id) {
        this.ubicacion = ubicacion;
        this.status = status;
        this.macAdress = macAdress;
        this.ipAdress = ipAdress;
        this.id = id;
    }

    //Getters and Setters
    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getMacAdress() {
        return macAdress;
    }

    public void setMacAdress(int macAdress) {
        this.macAdress = macAdress;
    }

    public int getIpAdress() {
        return ipAdress;
    }

    public void setIpAdress(int ipAdress) {
        this.ipAdress = ipAdress;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
