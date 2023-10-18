package Algoritmos;

import java.util.ArrayList;
import java.util.Collections;

//Obtenido de: https://www.geeksforgeeks.org/bucket-sort-2/
//MODIFICADO CON ChatGPT

public class BuckertSort {
    public static void bucketSort(int arr[], int n) {
        if (n <= 0)
            return;

        // 1) Encontrar el valor mínimo y máximo en el arreglo
        int minVal = arr[0];
        int maxVal = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] < minVal) {
                minVal = arr[i];
            }
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }

        // 2) Crear buckets (en este caso, usaremos un ArrayList para simplificar)
        int numBuckets = maxVal - minVal + 1;
        ArrayList<Integer>[] buckets = new ArrayList[numBuckets];

        for (int i = 0; i < numBuckets; i++) {
            buckets[i] = new ArrayList<Integer>();
        }

        // 3) Colocar los elementos del arreglo en los diferentes buckets
        for (int i = 0; i < n; i++) {
            buckets[arr[i] - minVal].add(arr[i]);
        }

        // 4) Ordenar los buckets individualmente (en este caso, usando Collections.sort)
        for (int i = 0; i < numBuckets; i++) {
            Collections.sort(buckets[i]);
        }

        // 5) Concatenar todos los buckets en arr[]
        int index = 0;
        for (int i = 0; i < numBuckets; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }
    }

    // Driver code
    public static void main(String args[]) {

        //Leer el arreglo de 10 mil elementos
        //final int[] arr = CrearArreglo.leerArregloDesdeArchivo("Arreglo10k.dat");

        //Leer el arreglo de 20 mil elementos
        //final int[] arr = CrearArreglo.leerArregloDesdeArchivo("Arreglo20k.dat");

        //Leer el arreglo de 50 mil elementos
        //final int[] arr = CrearArreglo.leerArregloDesdeArchivo("Arreglo50k.dat");

        //Leer el arreglo de 100 mil elementos
        final int[] arr = CrearArreglo.leerArregloDesdeArchivo("Arreglo100k.dat");


        // Registra el tiempo actual antes de ejecutar el algoritmo
        long tiempoInicio = System.currentTimeMillis();

        //Ejecución del algoritmo
        int n = arr.length;
        bucketSort(arr, n);

        // Registra el tiempo actual después de que el algoritmo haya terminado
        long tiempoFin = System.currentTimeMillis();

        // Calcula la diferencia de tiempo en milisegundos
        long tiempoTotal = tiempoFin - tiempoInicio;

        System.out.println("Tiempo de Ejecución para el algoritmo Buckert Sort (Milesegundos): "+ tiempoTotal);

    }
}
