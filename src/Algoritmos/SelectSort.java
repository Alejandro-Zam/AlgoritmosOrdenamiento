package Algoritmos;

//Obtenido de: https://www.geeksforgeeks.org/stable-selection-sort/?ref=gcse
public class SelectSort {
    public static void stableSelectionSort(int[] a, int n){
        for (int i = 0; i < n - 1; i++){
        	//Encuentra el índice del mínimo valor en el arreglo a partir de la posición i
            int min = i;
            for (int j = i + 1; j < n; j++)
                if (a[min] > a[j])
                    min = j;

            
            int key = a[min]; //almacena el menor valor
            //corre los elementos delante del mínimo para liberar la posición i
            while (min > i){
                a[min] = a[min - 1]; 
                min--;
            }
            //almacena el mínimo en la posición i
            a[i] = key;
        }
    }

    static void printArray(int[] a, int n){
        for (int i = 0; i < n; i++)
            System.out.print(a[i]+ " ");

        System.out.println();
    }
}
