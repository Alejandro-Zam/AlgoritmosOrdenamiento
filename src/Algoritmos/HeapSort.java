package Algoritmos;

//Obtenido de: https://www.geeksforgeeks.org/iterative-heap-sort/?ref=gcse
public class HeapSort {

    // function build Max Heap where value
    // of each child is always smaller
    // than value of their parent
    static void buildMaxHeap(int arr[], int n)
    {
        for (int i = 1; i < n; i++)
        {
            // if child is bigger than parent
            if (arr[i] > arr[(i - 1) / 2])
            {
                int j = i;

                // swap child and parent until
                // parent is smaller
                while (arr[j] > arr[(j - 1) / 2])
                {
                    swap(arr, j, (j - 1) / 2);
                    j = (j - 1) / 2;
                }
            }
        }
    }

    public static void heapSort(int arr[], int n)
    {
        buildMaxHeap(arr, n);

        for (int i = n - 1; i > 0; i--)
        {
            // swap value of first indexed
            // with last indexed
            swap(arr, 0, i);

            // maintaining heap property
            // after each swapping
            int j = 0, index;

            do
            {
                index = (2 * j + 1);

                // if left child is smaller than
                // right child point index variable
                // to right child
                if (index < (i - 1) && arr[index] < arr[index + 1])
                    index++;

                // if parent is smaller than child
                // then swapping parent with child
                // having higher value
                if (index < i && arr[j] < arr[index])
                    swap(arr, j, index);

                j = index;

            } while (index < i);
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i]=a[j];
        a[j] = temp;
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[])
    {
        //Leer el arreglo de 10 mil elementos
        //final int[] arr = CrearArreglo.leerArregloDesdeArchivo("Arreglo10k.dat");

        //Leer el arreglo de 20 mil elementos
        //final int[] arr = CrearArreglo.leerArregloDesdeArchivo("Arreglo20k.dat");

        //Leer el arreglo de 50 mil elementos
        //final int[] arr = CrearArreglo.leerArregloDesdeArchivo("Arreglo50k.dat");

        //Leer el arreglo de 100 mil elementos
    	String ruta = "C:/Users/Asus/Desktop/Universidad/SemestreVIII/An�lisis de Algoritmos/AlgoritmosOrdenamiento/src/Arreglo100K.dat";
        final int[] arr = CrearArreglo.leerArregloDesdeArchivo(ruta);


        // Registra el tiempo actual antes de ejecutar el algoritmo
        long tiempoInicio = System.currentTimeMillis();

        //Ejecución del algoritmo
        int n = arr.length;
        heapSort(arr, n);

        // Registra el tiempo actual después de que el algoritmo haya terminado
        long tiempoFin = System.currentTimeMillis();

        // Calcula la diferencia de tiempo en milisegundos
        long tiempoTotal = tiempoFin - tiempoInicio;

        System.out.println("Tiempo de Ejecución para el algoritmo Heap Sort (Milesegundos): "+ tiempoTotal);

    }
}
