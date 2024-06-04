package redComputadoras.datos;

import redComputadoras.modelo.Conexion;
import net.datastructures.Edge;
import net.datastructures.Graph;
import net.datastructures.Vertex;
import redComputadoras.modelo.Computadora;
import redComputadoras.modelo.Router;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Archivos {

    /**
     * Reads a file at the given path and parses its contents to create a list of Computadora objects.
     *
     * @param ruta the path of the file to be read
     * @return a list of Computadora objects parsed from the file
     */
    public static List<Computadora> leerComputadoras(String ruta) {
        List<Computadora> list = new ArrayList<>();

        Scanner read = null;
        try {
            read = new Scanner(new File(ruta));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("No se encontro el archivo", e);
        }
        read.useDelimiter("\\s*;\\s*");
        String ubicacion, macAdress, ipAdress, id;
        boolean status;

        while (read.hasNext()) {
            ubicacion = read.next();
            status = read.nextBoolean();
            macAdress = read.next();
            ipAdress = read.next();
            id = read.next();
            list.add(new Computadora(ubicacion, status, macAdress, ipAdress, id));
        }
        read.close();
        return list;
    }

    public static void guardarComputadoras(List<Computadora> list, String ruta) {
        try (FileWriter fw = new FileWriter(ruta)) {
            for (Computadora computadora : list) {
                fw.write(computadora.getUbicacion() + ";");
                fw.write(computadora.isStatus() + ";");
                fw.write(computadora.getMacAdress() + ";");
                fw.write(computadora.getIpAdress() + ";");
                fw.write(computadora.getId() + ";");
                fw.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("No se pudo escribir el archivo", e);
        }
    }


    public static List<Router> leerRouters(String ruta) {
        List<Router> list = new ArrayList<>();

        Scanner read = null;
        try {
            read = new Scanner(new File(ruta));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("No se encontro el archivo", e);
        }
        read.useDelimiter("\\s*;\\s*");
        String ubicacion, macAdress, ipAdress, id, modelo, framware;
        boolean status;
        double throughput;

        while (read.hasNext()) {
            ubicacion = read.next();
            status = read.nextBoolean();
            macAdress = read.next();
            ipAdress = read.next();
            id = read.next();
            modelo = read.next();
            framware = read.next();
            throughput = read.nextDouble();
            list.add(new Router(ubicacion, status, macAdress, ipAdress, id, modelo, framware, throughput));
        }
        read.close();
        return list;
    }

    public static void guardarRouters(List<Router> list, String ruta) {
        try (FileWriter fw = new FileWriter(ruta)) {
            for (Router router : list) {
                fw.write(router.getUbicacion() + ";");
                fw.write(router.isStatus() + ";");
                fw.write(router.getMacAdress() + ";");
                fw.write(router.getIpAdress() + ";");
                fw.write(router.getId() + ";");
                fw.write(router.getModelo() + ";");
                fw.write(router.getFirmware() + ";");
                fw.write(router.getThroughput() + ";");
                fw.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("No se pudo escribir el archivo", e);
        }
    }

    public static List<Conexion> leerConexiones(String ruta) {
        List<Conexion> list = new ArrayList<>();

        Scanner read = null;
        try {
            read = new Scanner(new File(ruta));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("No se encontro el archivo", e);
        }
        read.useDelimiter("\\s*;\\s*");
        String tipoDeConexion;
        boolean status;
        double bandwith, latencia;
        int errorRate;

        while (read.hasNext()) {
            tipoDeConexion = read.next();
            bandwith = read.nextDouble();
            latencia = read.nextDouble();
            status = read.nextBoolean();
            errorRate = read.nextInt();
            list.add(new Conexion(tipoDeConexion, bandwith, latencia, status, errorRate));
        }
        read.close();
        return list;
    }


    public static <V, E> void guardarConexiones(Graph<V, E> grafo, String ruta) {
        try (FileWriter fw = new FileWriter(ruta)) {
            for (Edge<E> e : grafo.edges()) {
                Vertex<V>[] paresVert = grafo.endVertices(e);
                fw.write(paresVert[0].getElement() + ";");
                fw.write(paresVert[1].getElement() + ";");
                fw.write(((Conexion) e.getElement()).getTipoDeConexion() + ";");
                fw.write(((Conexion) e.getElement()).getBandwith() + ";");
                fw.write(((Conexion) e.getElement()).getLatencia() + ";");
                fw.write(((Conexion) e.getElement()).isStatus() + ";");
                fw.write(((Conexion) e.getElement()).getErrorRate() + ";");
                fw.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("No se pudo escribir el archivo", e);
        }
    }

}
