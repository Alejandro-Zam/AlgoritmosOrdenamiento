package App;

import java.io.IOException;
import java.util.ArrayList;

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
		String ruta = "C:/Users/Asus/Desktop/Universidad/SemestreVIII/An�lisis de Algoritmos/022-Seguimiento/AlgoritmosOrdenamiento/src/Arreglos/"+arregloBuscar+".dat";
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
			tree.treeSort(arr);
			break;
		case 5:
			// Pigeonhole Sort
			PigeonholeSort sort = new PigeonholeSort();
			sort.pigeonhole_sort(arr, arr.length);
			break;
		case 6:
			// BuckertSort
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

	public ArrayList<KeyValue> EjecutarOrden(String arreglo) {
		ArrayList<KeyValue> sorts = new ArrayList<>();
		if(arreglo != "Todos") {
			String ruta = "C:/Users/Asus/Desktop/Universidad/SemestreVIII/An�lisis de Algoritmos/022-Seguimiento/AlgoritmosOrdenamiento/src/Arreglos/"+arreglo+".dat";
			long tiempoInicio, tiempoFin;

			// Tree Sort 0
			int[] arr0 = CrearArreglo.leerArregloDesdeArchivo(ruta);
			tiempoInicio = System.currentTimeMillis();
			TreeSort tree = new TreeSort();
			tree.treeSort(arr0);
			tiempoFin = System.currentTimeMillis();
			sorts.add(new KeyValue("Tree Sort", (tiempoFin - tiempoInicio)));

			// Tim Sort 1
			int[] arr1 = CrearArreglo.leerArregloDesdeArchivo(ruta);
			tiempoInicio = System.currentTimeMillis();
			TimSort.timSort(arr1, arr1.length);
			tiempoFin = System.currentTimeMillis();
			sorts.add(new KeyValue("Tim Sort", (tiempoFin - tiempoInicio)));

			// Comb Sort 2
			int[] arr2 = CrearArreglo.leerArregloDesdeArchivo(ruta);
			tiempoInicio = System.currentTimeMillis();
			CombSort ob = new CombSort();
			ob.sort(arr2);
			tiempoFin = System.currentTimeMillis();
			sorts.add(new KeyValue("Comb Sort", (tiempoFin - tiempoInicio)));

			// Selection Sort 3
			int[] arr3 = CrearArreglo.leerArregloDesdeArchivo(ruta);
			tiempoInicio = System.currentTimeMillis();
			SelectSort.stableSelectionSort(arr3, arr3.length);
			tiempoFin = System.currentTimeMillis();
			sorts.add(new KeyValue("Selection Sort", (tiempoFin - tiempoInicio)));

			// Pigeonhole Sort 4
			int[] arr4 = CrearArreglo.leerArregloDesdeArchivo(ruta);
			tiempoInicio = System.currentTimeMillis();
			PigeonholeSort sort = new PigeonholeSort();
			sort.pigeonhole_sort(arr4, arr4.length);
			tiempoFin = System.currentTimeMillis();
			sorts.add(new KeyValue("Pigeonhole Sort", (tiempoFin - tiempoInicio)));

			// Bucket Sort 5
			int[] arr5 = CrearArreglo.leerArregloDesdeArchivo(ruta);
			tiempoInicio = System.currentTimeMillis();
			BuckertSort.bucketSort(arr5, arr5.length);
			tiempoFin = System.currentTimeMillis();
			sorts.add(new KeyValue("Bucket Sort", (tiempoFin - tiempoInicio)));

			// Quick Sort 6
			int[] arr6 = CrearArreglo.leerArregloDesdeArchivo(ruta);
			tiempoInicio = System.currentTimeMillis();
			QuickSort.quickSortIterative(arr6, 0, arr6.length - 1);
			tiempoFin = System.currentTimeMillis();
			sorts.add(new KeyValue("Quick Sort", (tiempoFin - tiempoInicio)));

			// Heap Sort 7
			int[] arr7 = CrearArreglo.leerArregloDesdeArchivo(ruta);
			tiempoInicio = System.currentTimeMillis();
			HeapSort.heapSort(arr7, arr7.length);
			tiempoFin = System.currentTimeMillis();
			sorts.add(new KeyValue("Heap Sort", (tiempoFin - tiempoInicio)));

			// Bitonic Sort 8
			int[] arr8 = CrearArreglo.leerArregloDesdeArchivo(ruta);
			tiempoInicio = System.currentTimeMillis();
			BitonicSort ob2 = new BitonicSort();
			ob2.sort(arr8, arr8.length,1);
			tiempoFin = System.currentTimeMillis();
			sorts.add(new KeyValue("Bitonic Sort", (tiempoFin - tiempoInicio)));

			// Gnome Sort 9
			int[] arr9 = CrearArreglo.leerArregloDesdeArchivo(ruta);
			tiempoInicio = System.currentTimeMillis();
			GnomeSort.gnomeSort(arr9, arr9.length);
			tiempoFin = System.currentTimeMillis();
			sorts.add(new KeyValue("Gnome Sort", (tiempoFin - tiempoInicio)));

			// Binary Insertion Sort 10
			int[] arr10 = CrearArreglo.leerArregloDesdeArchivo(ruta);
			tiempoInicio = System.currentTimeMillis();
			BinaryInsertionSort.sort(arr10);
			tiempoFin = System.currentTimeMillis();
			sorts.add(new KeyValue("Binary Insertion Sort", (tiempoFin - tiempoInicio)));

			// Radix Sort 11
			int[] arr11 = CrearArreglo.leerArregloDesdeArchivo(ruta);
			tiempoInicio = System.currentTimeMillis();
			RadixSort.radixsort(arr11, arr11.length);
			tiempoFin = System.currentTimeMillis();
			sorts.add(new KeyValue("Radix Sort", (tiempoFin - tiempoInicio)));
		}

		return sorts;
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

	public String ordenarTiempos(long[] tiempos, ArrayList<KeyValue> sorts) {
		String cadena = "";
		//utilizamos el método del ordenamiento de burbuja en doble dirección
		int aux, primero = 1, ultimo = tiempos.length - 1, dir = tiempos.length - 1;
		while ( ultimo >= primero ){
			for( int i = ultimo ; i >= primero ; i--){
				if ( tiempos[i - 1] > tiempos[ i ] ){
					aux = (int) tiempos[i - 1];
					tiempos[i - 1] = tiempos[ i ];
					tiempos[ i ] = aux;
					dir = i;
				}
			}
			primero = dir + 1;
			for( int i = primero ; i <= ultimo; i++ ){
				if ( tiempos[i - 1] > tiempos[ i ] ){
					aux = (int) tiempos[i - 1];
					tiempos[i - 1] = tiempos[ i ];
					tiempos[ i ] = aux;
					dir = i;
				}
			}
			ultimo = dir - 1;
		}

		invertirArreglo(tiempos);

		cadena = generarCadena(tiempos, sorts);
		return cadena;
	}

	/**
	 * Método para invertir el arreglo de mayor a menor
	 * @param tiempos
	 */
	public static void invertirArreglo(long[] tiempos) {
	    int n = tiempos.length;
	    for (int i = 0; i < n / 2; i++) {
	        long temp = tiempos[i];
	        tiempos[i] = tiempos[n - i - 1];
	        tiempos[n - i - 1] = temp;
	    }
	}

	/**
	 * Método para generar la cadena que describe el orden ascendente del tiempo de ejecución de los algoritmos
	 * @param tiempos
	 * @param sorts
	 * @return
	 */
	private String generarCadena(long[] tiempos, ArrayList<KeyValue> sorts) {
		long aux;
		String cadena = "", aux2 = "";
		//for para recorrer por tiempos en orden ascendente
		for(int i = 0; i < tiempos.length; i++) {
			for(int j = 0; j < sorts.size(); j++) { //for para buscar en sorts el tiempo
				aux = sorts.get(j).getValue();
				aux2 = sorts.get(j).getKey();
				if(aux == tiempos[i] && !aux2.equals("SELECCIONADO")) { //se verifica que el tiempo sea el que va en ese orden y que el algoritmo no haya sido añadido a la lista anteriormente
					if(i != (tiempos.length-1)) {
						cadena += sorts.get(j).getKey() + "--> ";
						sorts.get(j).setKey("SELECCIONADO");
					}
					else {
						cadena += sorts.get(j).getKey();
						sorts.get(j).setKey("SELECCIONADO");
					}
					break;
				}
			}
		}
		return cadena;
	}

	/**
	 * Método para obtener la lista de tiempos a partir de la lista de pares algoritmo-tiempo
	 * @param sorts
	 * @return
	 */
	public long[] obtenerTiempos(ArrayList<KeyValue> sorts) {
		long[] tiempos = new long[sorts.size()];
		for(int i = 0; i < sorts.size(); i++) {
			tiempos[i] = sorts.get(i).getValue();
		}
		return tiempos;
	}
}
