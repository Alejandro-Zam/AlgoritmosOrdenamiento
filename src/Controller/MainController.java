package Controller;

import App.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

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
    void onEjecutar(ActionEvent event) {

		String algoritmo = BoxAlgoritmos.getValue();
		String arreglo	 = BoxArreglo.getValue();

		Long tiempo = main.EjecutarAlgoritmo(algoritmo,arreglo);

		labelTime.setText(""+tiempo);

	}

    @FXML
    void initialize() {
    	llenarComboBoxAlgoritmos();
        llenarComboBoxArreglos();
    }

    public void setAplicacion(Main main) {
		this.main = main;
	}

    // Método para llenar el ComboBox de Algoritmos
    private void llenarComboBoxAlgoritmos() {
        ObservableList<String> algoritmos = FXCollections.observableArrayList(
        		"1.TimSort",
        		"2.Comb Sort",
        		"3.Selection Sort",
        		"4.Tree Sort",
        		"5.Pigeonhole Sort",
        		"6.BucketSort",
        		"7.QuickSort",
        		"8.HeapSort",
        		"9.Bitonic Sort",
        		"10.Gnome Sort",
        		"11.Binary Insertion Sort",
        		"12.RadixSort"
        );
        BoxAlgoritmos.setItems(algoritmos);
    }

    // Método para llenar el ComboBox de Arreglos
    private void llenarComboBoxArreglos() {
	//Poner el nombre de los arreglos que vayan a crear
        ObservableList<String> arreglos = FXCollections.observableArrayList(
                "Arreglo10K", "Arreglo20K", "Arreglo50K", "Arreglo100K"
        );
        BoxArreglo.setItems(arreglos);
    }
}
