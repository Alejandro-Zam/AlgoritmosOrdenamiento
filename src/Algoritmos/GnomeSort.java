package Algoritmos;

import java.util.Arrays;

//Obtenido de: https://www.geeksforgeeks.org/gnome-sort-a-stupid-one/?ref=gcse
public class GnomeSort {

    public static void gnomeSort(int arr[], int n){
        int index = 0;

        while (index < n) {
            if (index == 0)
                index++;
            //aumenta el indice si el elemento actual es >= al anterior (para organizar de mayor a menor)
            if (arr[index] >= arr[index - 1]) 
                index++;
            else { //si es menor al anterior intercambia el menor hacia atrás y se decrementa el index
                int temp = 0;
                temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }
        return;
    }
}
