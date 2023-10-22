package Algoritmos;

//CLASE NODO DEL ARRAYLIST DE PARES CLAVE (ALGORITMO) - VALOR (TIEMPO DE EJECUCIÓN)
public class KeyValue {
	private String key;
    private long value;
    
    public KeyValue(String key, long value) {
        this.key = key;
        this.value = value;
    }

    //GETTERS Y SETTERS
    public String getKey() {
        return key;
    }

    public long getValue() {
        return value;
    }

	public void setKey(String key) {
		this.key = key;
	}

	public void setValue(long value) {
		this.value = value;
	}
}

