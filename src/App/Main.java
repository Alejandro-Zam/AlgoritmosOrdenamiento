package App;

import java.io.IOException;

import Algoritmos.*;
import Controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {

	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Aplicacion");
		mostrarVentanaMain();
	}

	public static void main(String[] args) {
		launch(args);
	}

	private void mostrarVentanaMain() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/View/MainView.fxml"));
			AnchorPane rootLayout = (AnchorPane) loader.load();
			MainController mainController = loader.getController();
			mainController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public Long EjecutarAlgoritmo(String nameAlogrito, String arregloBuscar){

		//Cambiar la ruta según donde tengan los arreglos
	String ruta = "C:/Users/Asus/Desktop/Universidad/SemestreVIII/Análisis de Algoritmos/AlgoritmosOrdenamiento/src/Arreglos/"+arregloBuscar+".dat";
        int[] arr = CrearArreglo.leerArregloDesdeArchivo(ruta);

        int numAlgoritmo = obtenerNum(nameAlogrito);

        long tiempoInicio = System.currentTimeMillis();

        switch (numAlgoritmo) {
        case 1:
            // TimSort
        	TimSort.timSort(arr, arr.length);
            break;
        case 2:
            // Comb Sort
        	CombSort ob = new CombSort();
            ob.sort(arr);
        	break;
        case 3:
            // Selection Sort
        	SelectSort.stableSelectionSort(arr, arr.length);
            break;
        case 4:
            // Tree Sort
        	TreeSort tree = new TreeSort();
            tree.treeins(arr);
            break;
        case 5:
            // Pigeonhole Sort
        	PigeonholeSort sort = new PigeonholeSort();
            sort.pigeonhole_sort(arr, arr.length);
            break;
        case 6:
            // BucketSort
        	BuckertSort.bucketSort(arr, arr.length);
            break;
        case 7:
            // QuickSort
        	QuickSort.quickSortIterative(arr, 0, arr.length - 1);
            break;
        case 8:
            // HeapSort
        	HeapSort.heapSort(arr, arr.length);
            break;
        case 9:
            // Bitonic Sort
        	BitonicSort ob2 = new BitonicSort();
            ob2.sort(arr, arr.length,1);
            break;
        case 10:
            // Gnome Sort
        	GnomeSort.gnomeSort(arr, arr.length);
            // Implementa Gnome Sort aquí
            break;
        case 11:
            // Binary Insertion Sort
        	BinaryInsertionSort.sort(arr);
            break;
        case 12:
            // RadixSort
        	RadixSort.radixsort(arr, arr.length);
            break;

        }

        // Registra el tiempo actual despuÃ©s de que el algoritmo haya terminado
        long tiempoFin = System.currentTimeMillis();

        // Calcula la diferencia de tiempo en milisegundos
        long tiempoTotal = tiempoFin - tiempoInicio;


		return tiempoTotal;
	}

	private int obtenerNum(String cadena) {
		// Divide la cadena en puntos como separador y obtén la primera parte.
		String[] partes = cadena.split("\\.");
		if (partes.length > 0) {
	       String numero = partes[0];
	       int num = Integer.parseInt(numero);
           return num;
	    } else {
	   	   return 0;
	    }
	}

}
