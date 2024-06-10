package redComputadoras.modelo;

public abstract class Equipo {
    private String id;
    private String nombre;
    private String ipAdress;
    private String macAdress;
    private boolean status;
    private String ubicacion;

    //Constructors
    protected Equipo() {
    }

    public Equipo(String id, String nombre, String ipAdress, String macAdress, boolean status, String ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.ipAdress = ipAdress;
        this.macAdress = macAdress;
        this.status = status;
        this.ubicacion = ubicacion;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
