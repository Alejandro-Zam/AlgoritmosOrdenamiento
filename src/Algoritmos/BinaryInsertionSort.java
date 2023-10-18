package Algoritmos;

import java.util.Arrays;

//Obtenido de: https://www.geeksforgeeks.org/binary-insertion-sort/?ref=gcse
public class BinaryInsertionSort {

    public static void main(String[] args)
    {
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
        new BinaryInsertionSort().sort(arr);

        // Registra el tiempo actual después de que el algoritmo haya terminado
        long tiempoFin = System.currentTimeMillis();

        // Calcula la diferencia de tiempo en milisegundos
        long tiempoTotal = tiempoFin - tiempoInicio;

        System.out.println("Tiempo de Ejecución para el algoritmo Binary Insertion (Milesegundos): "+ tiempoTotal);
       /* for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");*/
    }

    // Driver Code
    public static void sort(int array[])
    {
        for (int i = 1; i < array.length; i++)
        {
            int x = array[i];

            // Find location to insert
            // using binary search
            int j = Math.abs(Arrays.binarySearch(array, 0, i, x) + 1);

            // Shifting array to one
            // location right
            System.arraycopy(array, j,
                    array, j + 1, i - j);

            // Placing element at its
            // correct location
            array[j] = x;
        }
    }
}
