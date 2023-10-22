package Algoritmos;

import java.util.Arrays;

//Obtenido de: https://www.geeksforgeeks.org/binary-insertion-sort/?ref=gcse
public class BinaryInsertionSort {

    public static void sort(int array[]){
    	//recorre el array desde la segunda posicion hasta la última
        for (int i = 1; i < array.length; i++){
            int x = array[i];

            //busca en el array desde la posición 0 hasta la actual del i el valor x 
            //devuelve el índice donde se debe insertar el valor  
            int j = Math.abs(Arrays.binarySearch(array, 0, i, x) + 1);

            //mueve los valores a la derecha del índice j en el array para reubicar x
            System.arraycopy(array, j, array, j + 1, i - j);

            array[j] = x;
        }
    }
}
