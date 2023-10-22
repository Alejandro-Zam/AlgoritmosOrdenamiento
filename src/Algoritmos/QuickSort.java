package Algoritmos;

//Obtenido de: https://www.geeksforgeeks.org/iterative-quick-sort/?ref=gcse

public class QuickSort {
    /* This function takes last element as pivot, places the pivot element at its correct
    position in sorted array, and places all smaller (smaller than pivot) to left of
    pivot and all greater elements to right of pivot */
    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];

     // Índice del elemento más pequeño
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
        	//intercambia el elemento actual por el menor si es menor al pivote
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        //intercambia el siguiente valor al más pequeño por el pivot
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // Devuelve el índice donde se coloca el pivot
    }

    public static void quickSortIterative(int arr[], int l, int h) {
        // arreglo del mismo tamaño de arr
        int[] stack = new int[h - l + 1];
        int top = -1;

        stack[++top] = l;
        stack[++top] = h;

        //siempre y cuando haya un elemento en el top
        while (top >= 0) {
        	//extrae h y l de la parte superior de la pila y ajusta la posición de la parte superior al próximo elemento para ambos
            h = stack[top--]; 
            l = stack[top--];

            //reubica el pivot
            int p = partition(arr, l, h);

            // Si hay elementos en el lado izquierdo/derecho del pivot se colocan en sus respectivos lugares en el stack
            if (p - 1 > l) {
                stack[++top] = l;
                stack[++top] = p - 1;
            }

            if (p + 1 < h) {
                stack[++top] = p + 1;
                stack[++top] = h;
            }
        }
    }
}