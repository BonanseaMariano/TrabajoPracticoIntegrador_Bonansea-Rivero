package red.interfaz;

import net.datastructures.Entry;
import net.datastructures.TreeMap;
import red.modelo.Equipo;

import javax.swing.*;

public class Interfaz {

    /**
     * Menu de opciones principal del programa.
     *
     * @return an integer representing the selected option
     */
    public static Integer opcion() {
        return JOptionPane.showOptionDialog(null, "**** Seleccione una opcion ****", "Menu de opciones", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Ping", "Traceroute", "Transmision entre routers", "Salir"}, null);
    }

    /**
     * Prompts the user to select an IP address from a map of equipments and returns the corresponding equipment.
     *
     * @param equipos a map of equipments, where the keys are the IP addresses and the values are the equipment objects
     * @return the equipment object corresponding to the selected IP address, or null if no IP address is selected
     */
    public static Equipo ingresarEquipo(TreeMap<String, Equipo> equipos) {
        //Pasa los keys del mapa de equipos a un array de string
        String[] equiposArray = new String[equipos.size()];
        int i = 0;
        for (Entry<String, Equipo> entry : equipos.entrySet()) {
            equiposArray[i] = entry.getValue().getClass().getSimpleName() + ": " + entry.getKey();
            i++;
        }

        String ip = (String) JOptionPane.showInputDialog(null, "Seleccione el ip del equipo", "Equipo", JOptionPane.PLAIN_MESSAGE, null, equiposArray, null);
        if (ip == null) {
            return null;
        }
        //Corto el string ip para obtener solo el id del equipo
        String[] aux = ip.split(": ");
        ip = aux[1];

        return equipos.get(ip);
    }
}
