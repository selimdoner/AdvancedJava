package Generics;

//you can use mor types 
//public class GenericClassTwoParams<K,V,M,N,O>
public class GenericClassTwoParams<K,V> {
	
	private K key;
	private V value;
	
	

	public GenericClassTwoParams(K key, V value) {
		this.key = key;
		this.value = value;
	}

	
	public K getKey() {
		return key;
	}


	public void setKey(K key) {
		this.key = key;
	}


	public V getValue() {
		return value;
	}


	public void setValue(V value) {
		this.value = value;
	}


	public static void main(String[] args) {
		
		GenericClassTwoParams<Integer, String> myObject=new GenericClassTwoParams<>(1,"John");
	

	}

}
