package Algoritmos;

//Obtenido de: https://www.geeksforgeeks.org/iterative-heap-sort/?ref=gcse
public class HeapSort {

    // construir un macheap donde el valor de cada hijo siempre es menor que el de su padre
    static void buildMaxHeap(int arr[], int n){
        for (int i = 1; i < n; i++){
            // si el niño es mayor al padre
            if (arr[i] > arr[(i - 1) / 2]){
                int j = i;

                // intercambia hasta que el hijo sea menor al padre
                while (arr[j] > arr[(j - 1) / 2]){
                    swap(arr, j, (j - 1) / 2);
                    j = (j - 1) / 2;
                }
            }
        }
    }

    // Función principal para ordenar un arreglo utilizando Heap Sort
    public static void heapSort(int arr[], int n){
        buildMaxHeap(arr, n);

        for (int i = n - 1; i > 0; i--){
            //intercambia los valores del primer y último índice
            swap(arr, 0, i);

            int j = 0, index;

            do{
                index = (2 * j + 1);

                // aumenta el indice en uno si es menor a (i-1) y su valor contenido es menor al siguiente (correctitud del algoritmo)
                if (index < (i - 1) && arr[index] < arr[index + 1])
                    index++;

                // si el padre es menor que el hijo y el indice es menor a i se intercambian los valores
                if (index < i && arr[j] < arr[index])
                    swap(arr, j, index);

                //se actualiza el valor de j para que el index crezca y el do-while llegue a su caso de salida
                j = index;

            } while (index < i);
        }
    }

    //metodo para intercambiar dos posiciones en un mismo arreglo
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i]=a[j];
        a[j] = temp;
    }
}
