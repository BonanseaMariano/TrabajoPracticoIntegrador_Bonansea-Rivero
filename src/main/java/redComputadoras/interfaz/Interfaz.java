package redComputadoras.interfaz;

import net.datastructures.TreeMap;
import redComputadoras.aplicacion.Constante;
import redComputadoras.modelo.Equipo;


import javax.swing.*;
import java.util.List;

public class Interfaz {

    /**
     * Menu de opciones principal del programa.
     *
     * @return an integer representing the selected option
     */
    public static Integer opcion() {
        return JOptionPane.showOptionDialog(null, "**** Seleccione una opcion ****", "Menu de opciones", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Camino Mas Rapido", "Opcion 2", "Opcion 3", "Salir"}, null);
    }

    // Usuario ingresa estacion origen
    public static Equipo ingresarEquipoOrigen(TreeMap<String, Equipo> equipos) {
        return equipos.get("111");
    }

    // Usuario ingresa equipo destino
    public static Equipo ingresarEquipoDestino(TreeMap<String, Equipo> equipos) {
        return equipos.get("222");
    }

//    public static void resultado(List<Tramo> recorrido) {
//        int tiempoTotal = 0;
//        int tiempoSubte = 0;
//        int tiempoCaminando = 0;
//        for (Tramo t : recorrido) {
//            System.out.println(t.getEstacion1().getLinea().getCodigo() + "-"
//                    + t.getEstacion1().getNombre() + " > "
//                    + t.getEstacion2().getLinea().getCodigo() + "-"
//                    + t.getEstacion2().getNombre() + " :" + t.getTiempo());
//            tiempoTotal += t.getTiempo();
//            if (t.getEstacion1().getLinea().equals(t.getEstacion2().getLinea()))
//                tiempoSubte += t.getTiempo();
//            else
//                tiempoCaminando += t.getTiempo();
//        }
//        System.out.println("Tiempo Total: " + tiempoTotal);
//        System.out.println("Tiempo Subte: " + tiempoSubte);
//        System.out.println("Tiempo Caminando: " + tiempoCaminando);
//    }

}
