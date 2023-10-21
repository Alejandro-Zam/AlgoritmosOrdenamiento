package Algoritmos;

public class KeyValue {
	private String key;
    private long value;
    
    public KeyValue(String key, long value) {
        this.key = key;
        this.value = value;
    }

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

