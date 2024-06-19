package red.modelo;

public class Computadora extends Equipo {
    //Constructors
    public Computadora() {
        super();
    }

    public Computadora(String id, String nombre, String ipAdress, String macAdress, boolean status, String ubicacion) {
        super(id, nombre, ipAdress, macAdress, status, ubicacion);
    }

    @Override
    public String toString() {
        return "Computadora {" + super.toString() + "}";
    }
}
