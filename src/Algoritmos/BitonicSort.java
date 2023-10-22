package Algoritmos;

/* Java program for Bitonic Sort. Note that this program
works only when size of input is a power of 2. */
//Obtenido de: https://www.geeksforgeeks.org/bitonic-sort/?ref=gcse
public class BitonicSort{
    void compAndSwap(int a[], int i, int j, int dir){
    	//si las posiciones están al contrario de lo que indica dir las intercambia
        if ( (a[i] > a[j] && dir == 1) || (a[i] < a[j] && dir == 0)){
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    //orden asc si dir es 1 y desc si dir es 0
    //cnt es el numero de elementos a organizar y low desde dónde empieza
    void bitonicMerge(int a[], int low, int cnt, int dir){
        if (cnt>1){
            int k = cnt/2; //salto para comparar
            for (int i=low; i<low+k; i++) //va en el rango de low a (low+k)
                compAndSwap(a,i, i+k, dir);
            //se llama recursivamente para ordenar hacia delante y hacia atrás
            bitonicMerge(a,low, k, dir);
            bitonicMerge(a,low+k, k, dir);
        }
    }

    //ordena recursivamente en dos ordenes opuestos y luego llama a bitonicmerge para hacerlos en el orden dado
    void bitonicSort(int a[], int low, int cnt, int dir){
        if (cnt>1){
            int k = cnt/2;

            //ordena ascendientemente y descendientemente
            bitonicSort(a, low, k, 1);
            bitonicSort(a,low+k, k, 0);

            //combina los ordenamientos y los organiza en el orden pedido
            bitonicMerge(a, low, cnt, dir);
        }
    }

    public void sort(int a[], int N, int up){
        bitonicSort(a, 0, N, up);
    }
}

