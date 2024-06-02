package nodos;

public abstract class Nodo {
    private String id;
    private String ipAdress;
    private String macAdress;
    private boolean status;
    private String ubicacion;

    //Constructors
    protected Nodo() {
    }

    protected Nodo(String ubicacion, boolean status, String macAdress, String ipAdress, String id) {
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

    public String getMacAdress() {
        return macAdress;
    }

    public void setMacAdress(String macAdress) {
        this.macAdress = macAdress;
    }

    public String getIpAdress() {
        return ipAdress;
    }

    public void setIpAdress(String ipAdress) {
        this.ipAdress = ipAdress;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
