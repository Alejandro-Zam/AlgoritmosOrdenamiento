package Algoritmos;

import java.util.Arrays;

public class RadixSort {
    // función para obtener el valor más grande dentro de un arreglo
    static int getMax(int arr[], int n){
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    static void countSort(int arr[], int n, int exp) {
        int output[] = new int[n]; //array resultante
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);

        // Almacena el recuento de ocurrencias en count[]
        for (i = 0; i < n; i++)
            count[ (arr[i]/exp)%10 ]++;

        //Almacena las ocurrencias en las posiciones que son
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Construye el array de salida
        for (i = n - 1; i >= 0; i--){
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }

        //copia el arreglo de salida al original
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    public static void radixsort(int arr[], int n){
        // Encuentra el máximo valor en el arreglo
        int m = getMax(arr, n);

        //calcula el exp y llama a la función para reorganizar el arreglo
        //hasta que exp sea menor o igual que 0
        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }
}
