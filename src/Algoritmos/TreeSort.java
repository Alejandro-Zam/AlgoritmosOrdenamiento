package Algoritmos;

//Obtenido de: https://www.geeksforgeeks.org/tree-sort/?ref=gcse
public class TreeSort {
    // Clase que declara la llave y los nodos izquierdo y derecho
    class Node{
        int key;
        Node left, right;

        public Node(int item){
            key = item;
            left = right = null;
        }
    }

    // Raíz del arbol binario de busqueda
    Node root;

    // Constructor
    public TreeSort(){
        root = null;
    }

    void insert(int key){
        root = insertRec(root, key);
    }

    //función para ingresar un nuevo valor en el arbol binario
    Node insertRec(Node root, int key){
        if (root == null){ //si es el primer valor en el arbol se crea como el valor de la raíz
            root = new Node(key);
            return root;
        }
        //si el valor es menor al de la raíz va a la izquierda, si es mayor a la derecha
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        //retorna la raíz
        return root;
    }

    //funcion para imprimir el arbol binario
    void inorderRec(Node root){
        if (root != null){
            inorderRec(root.left); //devuelve primero los menores y luego los mayores
            System.out.print(root.key + " ");
            inorderRec(root.right); 
        }
    }
    
 	//función que se llama en el main
    public void treeSort(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
    }
    
    public void treeins(int arr[]){
        for(int i = 0; i < arr.length; i++){
            insert(arr[i]);
        }

    }
}
