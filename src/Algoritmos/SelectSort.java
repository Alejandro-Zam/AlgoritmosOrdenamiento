package Algoritmos;

//Obtenido de: https://www.geeksforgeeks.org/stable-selection-sort/?ref=gcse
public class SelectSort {
    public static void stableSelectionSort(int[] a, int n){
        // Iterate through array elements
        for (int i = 0; i < n - 1; i++){

            // Loop invariant : Elements till
            // a[i - 1] are already sorted.

            // Find minimum element from
            // arr[i] to arr[n - 1].
            int min = i;
            for (int j = i + 1; j < n; j++)
                if (a[min] > a[j])
                    min = j;

            // Move minimum element at current i.
            int key = a[min];
            while (min > i){
                a[min] = a[min - 1];
                min--;
            }

            a[i] = key;
        }
    }

    static void printArray(int[] a, int n){
        for (int i = 0; i < n; i++)
            System.out.print(a[i]+ " ");

        System.out.println();
    }
}
