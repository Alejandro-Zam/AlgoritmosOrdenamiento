package Algoritmos;

/* Java program for Bitonic Sort. Note that this program
works only when size of input is a power of 2. */
//Obtenido de: https://www.geeksforgeeks.org/bitonic-sort/?ref=gcse
public class BitonicSort
{
    /* The parameter dir indicates the sorting direction,
    ASCENDING or DESCENDING; if (a[i] > a[j]) agrees
    with the direction, then a[i] and a[j] are
    interchanged. */
    void compAndSwap(int a[], int i, int j, int dir)
    {
        if ( (a[i] > a[j] && dir == 1) ||
                (a[i] < a[j] && dir == 0))
        {
            // Swapping elements
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    /* It recursively sorts a bitonic sequence in ascending
    order, if dir = 1, and in descending order otherwise
    (means dir=0). The sequence to be sorted starts at
    index position low, the parameter cnt is the number
    of elements to be sorted.*/
    void bitonicMerge(int a[], int low, int cnt, int dir)
    {
        if (cnt>1)
        {
            int k = cnt/2;
            for (int i=low; i<low+k; i++)
                compAndSwap(a,i, i+k, dir);
            bitonicMerge(a,low, k, dir);
            bitonicMerge(a,low+k, k, dir);
        }
    }

    /* This function first produces a bitonic sequence by
    recursively sorting its two halves in opposite sorting
    orders, and then calls bitonicMerge to make them in
    the same order */
    void bitonicSort(int a[], int low, int cnt, int dir)
    {
        if (cnt>1)
        {
            int k = cnt/2;

            // sort in ascending order since dir here is 1
            bitonicSort(a, low, k, 1);

            // sort in descending order since dir here is 0
            bitonicSort(a,low+k, k, 0);

            // Will merge whole sequence in ascending order
            // since dir=1.
            bitonicMerge(a, low, cnt, dir);
        }
    }

    /*Caller of bitonicSort for sorting the entire array
    of length N in ASCENDING order */
    public void sort(int a[], int N, int up)
    {
        bitonicSort(a, 0, N, up);
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method
    public static void main(String args[])
    {
        //Leer el arreglo de 10 mil elementos
        //final int[] arr = CrearArreglo.leerArregloDesdeArchivo("Arreglo10k.dat");

        //Leer el arreglo de 20 mil elementos
        //final int[] arr = CrearArreglo.leerArregloDesdeArchivo("Arreglo20k.dat");

        //Leer el arreglo de 50 mil elementos
        //final int[] arr = CrearArreglo.leerArregloDesdeArchivo("Arreglo50k.dat");

        //Leer el arreglo de 100 mil elementos
    	String ruta = "C:/Users/Asus/Desktop/Universidad/SemestreVIII/Análisis de Algoritmos/AlgoritmosOrdenamiento/src/Arreglo100K.dat";
        final int[] arr = CrearArreglo.leerArregloDesdeArchivo(ruta);

        // Registra el tiempo actual antes de ejecutar el algoritmo
        long tiempoInicio = System.currentTimeMillis();

        //EjecuciÃ³n del algoritmo
        int up = 1;
        BitonicSort ob = new BitonicSort();
        ob.sort(arr, arr.length,up);


        // Registra el tiempo actual despuÃ©s de que el algoritmo haya terminado
        long tiempoFin = System.currentTimeMillis();

        // Calcula la diferencia de tiempo en milisegundos
        long tiempoTotal = tiempoFin - tiempoInicio;

        System.out.println("Tiempo de Ejecución para el algoritmo Bitonic Sort (Milesegundos): "+ tiempoTotal);

    }
}

