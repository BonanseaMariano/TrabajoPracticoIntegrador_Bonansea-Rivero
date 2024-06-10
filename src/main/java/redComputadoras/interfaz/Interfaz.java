package redComputadoras.interfaz;

import net.datastructures.TreeMap;
import redComputadoras.aplicacion.Constante;
import redComputadoras.modelo.Equipo;


import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class Interfaz {

    /**
     * Menu de opciones principal del programa.
     *
     * @return an integer representing the selected option
     */
    public static Integer opcion() {
        return JOptionPane.showOptionDialog(null, "**** Seleccione una opcion ****", "Menu de opciones", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Ping", "Traceroute", "Transmision entre routers", "Salir"}, null);
    }

    // Usuario ingresa equipo
    public static Equipo ingresarEquipo(TreeMap<String, Equipo> equipos) {
        //Pasa los keys del mapa de equipos a un array de string
        String[] equiposArray = new String[equipos.size()];
        int i = 0;
        for (String key : equipos.keySet()) {
            equiposArray[i] = key;
            i++;
        }

        String ip = (String) JOptionPane.showInputDialog(null, "Seleccione el ip del equipo", "Equipo", JOptionPane.PLAIN_MESSAGE, null, equiposArray, null);
        if (ip == null) {
            return null;
        }
        return equipos.get(ip);
    }
}
