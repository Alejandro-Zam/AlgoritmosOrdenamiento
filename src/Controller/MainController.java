package Controller;

import java.util.ArrayList;

import Algoritmos.KeyValue;
import App.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

public class MainController {

	Main main;

	@FXML
    private ComboBox<String> BoxAlgoritmos;

	@FXML
    private ComboBox<String> BoxArreglo;

	@FXML
    private Button BtnEjecutar;

	@FXML
    private Label labelTime;

    @FXML
    private ComboBox<String> BoxArreglo2;

    @FXML
    private Button BtnCalcular;

    @FXML
    private Label LblOrden;

    @FXML
    private TextArea txtAreaResultado;

    @FXML
    private TextField txtBinaryInsertionSort;

    @FXML
    private TextField txtBitonicSort;

    @FXML
    private TextField txtBucketSort;

    @FXML
    private TextField txtCombSort;

    @FXML
    private TextField txtGnomeSort;

    @FXML
    private TextField txtHeapSort;

    @FXML
    private TextField txtPigeonholeSort;

    @FXML
    private TextField txtQuickSort;

    @FXML
    private TextField txtRadixSort;

    @FXML
    private TextField txtSelectionSort;

    @FXML
    private TextField txtTimSort;

    @FXML
    private TextField txtTreeSort;

    /**
     * Calcular el tiempo de ejecución de un algoritmo individual
     * @param event
     */
	@FXML
    void onEjecutar(ActionEvent event) {

		String algoritmo = BoxAlgoritmos.getValue();
		String arreglo	 = BoxArreglo.getValue();

		Long tiempo = main.EjecutarAlgoritmo(algoritmo,arreglo);

		labelTime.setText(""+tiempo);

	}

	/**
     * Calcular el tiempo de ejecución de todos los algoritmos al tiempo y ordenarlos
     * @param event
     */
	@FXML
    void onEjecutarOrden(ActionEvent event) {
		String arreglo	 = BoxArreglo2.getValue();

		ArrayList<KeyValue> sorts = main.EjecutarOrden(arreglo);

		long[] tiempos = new long[12];
		tiempos = main.obtenerTiempos(sorts);

		//settea los campos con el tiempo de ejecución en ms que se demoraron dado el tamaño del arreglo
		txtTreeSort.setText(""+tiempos[0]);
		txtTimSort.setText(""+tiempos[1]);
		txtCombSort.setText(""+tiempos[2]);
		txtSelectionSort.setText(""+tiempos[3]);
		txtPigeonholeSort.setText(""+tiempos[4]);
		txtBucketSort.setText(""+tiempos[5]);
		txtQuickSort.setText(""+tiempos[6]);
		txtHeapSort.setText(""+tiempos[7]);
		txtBitonicSort.setText(""+tiempos[8]);
		txtGnomeSort.setText(""+tiempos[9]);
		txtBinaryInsertionSort.setText(""+tiempos[10]);
		txtRadixSort.setText(""+tiempos[11]);

		String orden = main.ordenarTiempos(tiempos, sorts);
		txtAreaResultado.setText(orden);

		System.out.println(orden);
    }

    @FXML
    void initialize() {
    	llenarComboBoxAlgoritmos();
        llenarComboBoxArreglos();
    }

    public void setAplicacion(Main main) {
		this.main = main;
	}

    /**
     * Método para llenar el ComboBox de Algoritmos
     */
    private void llenarComboBoxAlgoritmos() {
        ObservableList<String> algoritmos = FXCollections.observableArrayList(
        		"1. TimSort",
        		"2. Comb Sort",
        		"3. Selection Sort",
        		"4. Tree Sort",
        		"5. Pigeonhole Sort",
        		"6. BucketSort",
        		"7. QuickSort",
        		"8. HeapSort",
        		"9. Bitonic Sort",
        		"10. Gnome Sort",
        		"11. Binary Insertion Sort",
        		"12. RadixSort"
        );
        BoxAlgoritmos.setItems(algoritmos);
    }

    /**
     * Método para llenar los ComboBox de Arreglos
     */
    private void llenarComboBoxArreglos() {
	//Poner el nombre de los arreglos que vayan a crear
        ObservableList<String> arreglos = FXCollections.observableArrayList(
                "Arreglo10K", "Arreglo20K", "Arreglo30K", "Arreglo40K", "Arreglo50K", "Arreglo60K", "Arreglo100K", "Arreglo500K", "Arreglo1M", "Arreglo2M"
        );
        BoxArreglo.setItems(arreglos);

        ObservableList<String> arreglos2 = FXCollections.observableArrayList(
                "Arreglo10K", "Arreglo20K", "Arreglo30K", "Arreglo40K", "Arreglo50K", "Arreglo60K", "Arreglo100K", "Arreglo500K", "Arreglo1M", "Arreglo2M"
        );
        BoxArreglo2.setItems(arreglos2);
    }
}
