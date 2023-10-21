package Algoritmos;

//Obtenido de: https://www.geeksforgeeks.org/tree-sort/?ref=gcse
public class TreeSort {
    // Clase que representa un nodo en el �rbol
    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    // Ra�z del �rbol BST
    Node root;

    // Constructor
    public TreeSort() {
        root = null;
    }

    // M�todo para insertar un elemento en el �rbol
    void insert(int key) {
        root = insertRec(root, key);
    }

    // Funci�n recursiva para insertar un nuevo nodo en el �rbol
    Node insertRec(Node root, int key) {
        // Si el �rbol est� vac�o, crea un nuevo nodo y lo retorna
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // De lo contrario, recorre el �rbol hacia abajo
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        // Retorna la ra�z
        return root;
    }

    // Funci�n para realizar el recorrido en orden del �rbol
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Funci�n para ordenar un arreglo utilizando TreeSort
    public void treeSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
    }
    // Driver Code
    public static void main(String[] args)
    {
        //Leer el arreglo de 10 mil elementos
        //final int[] arr = CrearArreglo.leerArregloDesdeArchivo("Arreglo10k.dat");

        //Leer el arreglo de 20 mil elementos
        //final int[] arr = CrearArreglo.leerArregloDesdeArchivo("Arreglo20k.dat");

        //Leer el arreglo de 50 mil elementos
        //final int[] arr = CrearArreglo.leerArregloDesdeArchivo("Arreglo50k.dat");

        //Leer el arreglo de 100 mil elementos
        final int[] arr = CrearArreglo.leerArregloDesdeArchivo("Arreglo100k.dat");

        // Registra el tiempo actual antes de ejecutar el algoritmo
        long tiempoInicio = System.currentTimeMillis();

        //Ejecución del algoritmo
        TreeSort tree = new TreeSort();
        tree.treeSort(arr);

        // Registra el tiempo actual después de que el algoritmo haya terminado
        long tiempoFin = System.currentTimeMillis();

        // Calcula la diferencia de tiempo en milisegundos
        long tiempoTotal = tiempoFin - tiempoInicio;

        System.out.println("Tiempo de Ejecución para el algoritmo Tree Sort (Milesegundos): "+ tiempoTotal);


        //tree.inorderRec(tree.root);
    }
}
