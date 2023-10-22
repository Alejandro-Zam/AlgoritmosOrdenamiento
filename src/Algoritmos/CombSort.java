package Algoritmos;

// Obtenido de: https://www.geeksforgeeks.org/comb-sort/?ref=gcse
import java.io.*;
public class CombSort{
    // Encontrar la brecha entre elementos
    int getNextGap(int gap){
        // Reduce la brecha por el factor reductor (aproximar a número áureo)
        gap = (gap*10)/13;
        if (gap < 1)
            return 1;
        return gap;
    }

    public void sort(int arr[]){
        int n = arr.length;
        int gap = n;
        boolean swapped = true;

        // Evalúa si se produjo un intercambio y si la brecha es mayor a 1
        while (gap != 1 || swapped == true){
            //Actualiza la brecha cada iteración
            gap = getNextGap(gap);
            swapped = false;

            for (int i=0; i<n-gap; i++){
                if (arr[i] > arr[i+gap]){ //compara si el elemento actual es mayor al siguiente de la brecha y realiza el intercambio
                    int temp = arr[i];
                    arr[i] = arr[i+gap];
                    arr[i+gap] = temp;

                    //verifica que hubo interambio
                    swapped = true;
                }
            }
        }
    }
}
/* This code is contributed by Rajat Mishra */
