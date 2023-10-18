package Algoritmos;

//Obtenido de: https://www.geeksforgeeks.org/tree-sort/?ref=gcse
public class TreeSort {
    // Class containing left and
    // right child of current
    // node and key value
    class Node
    {
        int key;
        Node left, right;

        public Node(int item)
        {
            key = item;
            left = right = null;
        }
    }

    // Root of BST
    Node root;

    // Constructor
    public TreeSort()
    {
        root = null;
    }

    // This method mainly
    // calls insertRec()
    void insert(int key)
    {
        root = insertRec(root, key);
    }

    /* A recursive function to
    insert a new key in BST */
    Node insertRec(Node root, int key)
    {

        /* If the tree is empty,
        return a new node */
        if (root == null)
        {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur
        down the tree */
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        /* return the root */
        return root;
    }

    // A function to do
    // inorder traversal of BST
    void inorderRec(Node root)
    {
        if (root != null)
        {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }
    public void treeins(int arr[])
    {
        for(int i = 0; i < arr.length; i++)
        {
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
        tree.treeins(arr);

        // Registra el tiempo actual después de que el algoritmo haya terminado
        long tiempoFin = System.currentTimeMillis();

        // Calcula la diferencia de tiempo en milisegundos
        long tiempoTotal = tiempoFin - tiempoInicio;

        System.out.println("Tiempo de Ejecución para el algoritmo Tree Sort (Milesegundos): "+ tiempoTotal);


        //tree.inorderRec(tree.root);
    }
}
