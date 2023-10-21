package Algoritmos;

//Obtenido de: https://www.geeksforgeeks.org/tree-sort/?ref=gcse
public class TreeSort {
    // Clase que representa un nodo en el árbol
    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    // Raíz del árbol BST
    Node root;

    // Constructor
    public TreeSort() {
        root = null;
    }

    // Método para insertar un elemento en el árbol
    void insert(int key) {
        root = insertRec(root, key);
    }

    // Función recursiva para insertar un nuevo nodo en el árbol
    Node insertRec(Node root, int key) {
        // Si el árbol está vacío, crea un nuevo nodo y lo retorna
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // De lo contrario, recorre el árbol hacia abajo
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        // Retorna la raíz
        return root;
    }

    // Función para realizar el recorrido en orden del árbol
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Función para ordenar un arreglo utilizando TreeSort
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

        //EjecuciÃ³n del algoritmo
        TreeSort tree = new TreeSort();
        tree.treeSort(arr);

        // Registra el tiempo actual despuÃ©s de que el algoritmo haya terminado
        long tiempoFin = System.currentTimeMillis();

        // Calcula la diferencia de tiempo en milisegundos
        long tiempoTotal = tiempoFin - tiempoInicio;

        System.out.println("Tiempo de EjecuciÃ³n para el algoritmo Tree Sort (Milesegundos): "+ tiempoTotal);


        //tree.inorderRec(tree.root);
    }
}
