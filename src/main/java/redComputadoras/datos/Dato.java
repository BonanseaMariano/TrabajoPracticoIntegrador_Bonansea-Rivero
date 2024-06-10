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

    public static TreeMap<String, Equipo> cargarEquipos(String fileNameComputadoras, String fileNameRouters) throws FileNotFoundException {
        TreeMap<String, Equipo> equipos = new TreeMap<>();
        cargarComputadoras(equipos, fileNameComputadoras);
        cargarRouters(equipos, fileNameRouters);
        return equipos;
    }

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

    public static List<Conexion> cargarConexiones(String fileName, TreeMap<String, Equipo> equipos) throws FileNotFoundException {
        Scanner read;
        List<Conexion> conexiones = new ArrayList<Conexion>();
        read = new Scanner(new File(fileName));
        read.useDelimiter("\\s*;\\s*");

        Equipo v1, v2;
        String tipoDeConexion;
        double bandwith, latencia;
        boolean status;
        int errorRate;

        while (read.hasNext()) {
            v1 = equipos.get(read.next());
            v2 = equipos.get(read.next());
            tipoDeConexion = read.next();
            bandwith = read.nextDouble();
            latencia = read.nextDouble();
            status = read.nextBoolean();
            errorRate = read.nextInt();
            conexiones.add(0, new Conexion(v1, v2, tipoDeConexion, bandwith, latencia, status, errorRate));
        }
        read.close();

        return conexiones;
    }

}
