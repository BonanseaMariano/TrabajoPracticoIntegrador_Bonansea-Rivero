package redComputadoras.datos;

import net.datastructures.TreeMap;
import redComputadoras.modelo.Computadora;
import redComputadoras.modelo.Router;
import redComputadoras.modelo.Equipo;
import redComputadoras.modelo.Conexion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dato {

    /**
     * Loads equipment data from the specified files and returns them as a TreeMap.
     *
     * @param fileNameComputadoras the name of the file containing computer data
     * @param fileNameRouters      the name of the file containing router data
     * @return a TreeMap containing the loaded equipment data
     * @throws FileNotFoundException if either file cannot be found
     */
    public static TreeMap<String, Equipo> cargarEquipos(String fileNameComputadoras, String fileNameRouters) throws FileNotFoundException {
        TreeMap<String, Equipo> equipos = new TreeMap<>();
        cargarComputadoras(equipos, fileNameComputadoras);
        cargarRouters(equipos, fileNameRouters);
        if (equipos.isEmpty()) {
            throw new FileNotFoundException();
        }
        return equipos;
    }

    /**
     * Loads computer data from the specified file into a TreeMap of Equipo objects.
     *
     * @param equipos  the TreeMap to store the loaded computer data
     * @param fileName the name of the file containing the computer data
     * @throws FileNotFoundException if the file cannot be found
     */
    private static void cargarComputadoras(TreeMap<String, Equipo> equipos, String fileName) throws FileNotFoundException {
        Scanner read;

        read = new Scanner(new File(fileName));
        read.useDelimiter("\\s*;\\s*");

        String id, nombre, ipAdress, macAdress, ubicacion;
        boolean status;

        while (read.hasNext()) {
            id = read.next();
            nombre = read.next();
            ipAdress = read.next();
            macAdress = read.next();
            status = read.nextBoolean();
            ubicacion = read.next();
            equipos.put(id, new Computadora(id, nombre, ipAdress, macAdress, status, ubicacion));
        }
        read.close();
    }

    /**
     * Loads router data from the specified file into a TreeMap of Equipo objects.
     *
     * @param equipos  the TreeMap to store the loaded router data
     * @param fileName the name of the file containing the router data
     * @throws FileNotFoundException if the file cannot be found
     */
    private static void cargarRouters(TreeMap<String, Equipo> equipos, String fileName) throws FileNotFoundException {
        Scanner read;

        read = new Scanner(new File(fileName));
        read.useDelimiter("\\s*;\\s*");

        String id, nombre, ipAdress, macAdress, ubicacion, modelo, firmware;
        boolean status;
        double throughput;

        while (read.hasNext()) {
            id = read.next();
            nombre = read.next();
            ipAdress = read.next();
            macAdress = read.next();
            status = read.nextBoolean();
            ubicacion = read.next();
            modelo = read.next();
            firmware = read.next();
            throughput = read.nextDouble();
            equipos.put(id, new Router(id, nombre, ipAdress, macAdress, status, ubicacion, modelo, firmware, throughput));
        }
        read.close();
    }

    /**
     * Loads connections data from the specified file into a List of Conexion objects.
     *
     * @param fileName the name of the file containing the connection data
     * @param equipos  the TreeMap containing the Equipos to establish connections
     * @return the list of Conexion objects representing the loaded connections
     */
    public static List<Conexion> cargarConexiones(String fileName, TreeMap<String, Equipo> equipos) throws FileNotFoundException {
        Scanner read;
        List<Conexion> conexiones = new ArrayList<>();
        read = new Scanner(new File(fileName));
        read.useDelimiter("\\s*;\\s*");

        Equipo v1, v2;
        String tipoDeConexion;
        boolean status;
        int bandwith, errorRate, latencia;

        while (read.hasNext()) {
            v1 = equipos.get(read.next());
            v2 = equipos.get(read.next());
            tipoDeConexion = read.next();
            bandwith = read.nextInt();
            latencia = read.nextInt();
            status = read.nextBoolean();
            errorRate = read.nextInt();
            conexiones.add(0, new Conexion(v1, v2, tipoDeConexion, bandwith, latencia, status, errorRate));
        }
        read.close();

        return conexiones;
    }

}
