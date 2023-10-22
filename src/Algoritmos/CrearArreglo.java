package Algoritmos;

import java.io.*;
import java.util.Random;

public class CrearArreglo {

    public static void main(String[] args) {
        int tamanio = 2000000;  // Cambia este valor al número de posiciones que necesitas

        int[] miArreglo = new int[tamanio];

        //llena y almacena el arreglo en el directorio actual
        llenarArregloConAleatorios(miArreglo, tamanio);

        //DESCOMENTAR EL QUE SE NECESITE
//        almacenarArregloEnArchivo(miArreglo, "Arreglo2M.dat");
//        int[] arregloLeido = leerArregloDesdeArchivo("Arreglo2M.dat");
//
//        almacenarArregloEnArchivo(miArreglo, "Arreglo1M.dat");
//        int[] arregloLeido = leerArregloDesdeArchivo("Arreglo1M.dat");
//        
//        almacenarArregloEnArchivo(miArreglo, "Arreglo500K.dat");
//        int[] arregloLeido = leerArregloDesdeArchivo("Arreglo500K.dat");
//        
//        almacenarArregloEnArchivo(miArreglo, "Arreglo100K.dat");
//        int[] arregloLeido = leerArregloDesdeArchivo("Arreglo100K.dat");
//        
//        almacenarArregloEnArchivo(miArreglo, "Arreglo60K.dat");
//        int[] arregloLeido = leerArregloDesdeArchivo("Arreglo60K.dat");
//        
//        almacenarArregloEnArchivo(miArreglo, "Arreglo50K.dat");
//        int[] arregloLeido = leerArregloDesdeArchivo("Arreglo50K.dat");
//        
//        almacenarArregloEnArchivo(miArreglo, "Arreglo40K.dat");
//        int[] arregloLeido = leerArregloDesdeArchivo("Arreglo40K.dat");
//        
//        almacenarArregloEnArchivo(miArreglo, "Arreglo30K.dat");
//        int[] arregloLeido = leerArregloDesdeArchivo("Arreglo30K.dat");
//        
//        almacenarArregloEnArchivo(miArreglo, "Arreglo20K.dat");
//        int[] arregloLeido = leerArregloDesdeArchivo("Arreglo20K.dat");
//        
//        almacenarArregloEnArchivo(miArreglo, "Arreglo10K.dat");
//        int[] arregloLeido = leerArregloDesdeArchivo("Arreglo10K.dat");

        //saber dónde se están almacenando los arreglos por si se inicializa mal el directorio de trabajo
        System.out.println("Directorio actual de trabajo: " + System.getProperty("user.dir"));

    }

    public static void llenarArregloConAleatorios(int[] arreglo, int tamanio) {
        Random rand = new Random();
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = rand.nextInt(tamanio);
        }
    }

    // Método para almacenar el arreglo en un archivo
    public static void almacenarArregloEnArchivo(int[] arreglo, String nombreArchivo) {
        try (FileOutputStream fos = new FileOutputStream(nombreArchivo);
             DataOutputStream dos = new DataOutputStream(fos)) {

            for (int i = 0; i < arreglo.length; i++) {
                dos.writeInt(arreglo[i]);
            }

            System.out.println("Arreglo almacenado en el archivo: " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para leer el arreglo desde un archivo
    public static int[] leerArregloDesdeArchivo(String nombreArchivo) {
        try (FileInputStream fis = new FileInputStream(nombreArchivo);
             DataInputStream dis = new DataInputStream(fis)) {

            int tamanio = (int) (new File(nombreArchivo)).length(); // Obtener el tamaño del archivo
            int[] arregloLeido = new int[tamanio / 4]; // Dividido por 4 para obtener el número de enteros (4 bytes cada uno)

            for (int i = 0; i < arregloLeido.length; i++) {
                arregloLeido[i] = dis.readInt();
            }

            return arregloLeido;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
