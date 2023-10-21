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
}
