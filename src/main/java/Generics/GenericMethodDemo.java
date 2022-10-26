package Generics;

import java.awt.Point;

/*Any method in the generic class can use the type parameter of the 
 * class so that way methods in a generic class are generic. 
 * Apart from that keep in mind the following points.

Generic methods can add more parameters of their own.
There can be generic methods even in a non-generic class.
When you are writing a generic method after the access modifier 
you need to declare the type parameters then the return type. 
		For example if you are writing 
		a public method that uses one 
		type parameter and doesn’t return anything then it will be written as-*/


public class GenericMethodDemo {  
	  public static void main(String[] args) {
	    GenericMethodDemo gm = new GenericMethodDemo();
	    Integer[] intArray = {1, 2, 3, 4, 5, 6, 7};
	    Double[] doubleArray = {3.4, 5.6, 7.8, 1.2, 4.5};
	    
	    Point [] poinsts= {new Point(10,10),new Point(5,6),new Point(44,44)};
	    // integer array
	    gm.printElements(intArray);
	    System.out.println();
	    gm.printElements(doubleArray);
	    System.out.println();
	    gm.printElements(poinsts);
	  }
	    
	  public <T> void printElements(T[] arr){
	    // showing elements
	    for(int i = 0; i < arr.length; i++){
	      System.out.print(" " + arr[i]);
	    }
	 
	  }
	}