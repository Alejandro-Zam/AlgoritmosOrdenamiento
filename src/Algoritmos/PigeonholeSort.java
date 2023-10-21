package Algoritmos;

import java.util.Arrays;

//Obtenido de: https://www.geeksforgeeks.org/pigeonhole-sort/?ref=gcse
public class PigeonholeSort {
    public void pigeonhole_sort(int arr[],int n){
        int min = arr[0];
        int max = arr[0];
        int range, i, j, index;

        //recorre el arreglo hallando el valor mínimo y máximo en él
        for(int a=0; a<n; a++){
            if(arr[a] > max) max = arr[a];
            if(arr[a] < min) min = arr[a];
        }

        //determina el rango de valores posibles en el arreglo original
        range = max - min + 1;
        //declara un nuevo arreglo y lo llena de ceros
        int[] phole = new int[range];
        Arrays.fill(phole, 0);

        //recorre el tamaño del arreglo original reajustando los índices
        for(i = 0; i<n; i++) phole[arr[i] - min]++;

        index = 0;

        for(j = 0; j<range; j++)
            while(phole[j]-->0)
                arr[index++]=j+min;

    }
}
