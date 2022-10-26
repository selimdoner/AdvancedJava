package Generics.bounded;

import java.util.ArrayList;
import java.util.List;

public class GenericsLowerBoundAndWildCard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Object> ol=new ArrayList<>();
		addNumber(ol);
		
		ol.forEach(o->System.out.println(o));
		
		List<Number> ln=new ArrayList<>();
		addNumber(ln);
		
		ln.forEach(o->System.out.println(o));
		
		
		List<Integer> li=new ArrayList<>();
		addNumber(li);
		
		li.forEach(o->System.out.println(o));
		
		
		//You can't because it accept the jut List<Object>
		//addNumber3(li);
		
		printElements(new ArrayList<String>());
		
		//printObjects(new ArrayList<String>()); compile time error
	}
	
	//Lower Bounded
	//It has to be super of the Integer 
	//Alt Sınırlı burada Integer alt sınırdır.
	public static void addNumber(List<? super Integer> list) {
		for (int i = 1; i <=10; i++) {
			list.add(i);
		}
	}

	//unbounded
	public static void addNumber2(List<?> myList) {
		//myList.add("Java");//it gives compile time error
		//myList.add(1);
		myList.add(null);
		
	}
	
	
	public static void addNumber3(List<Object> myList) {
		myList.add(10);
		myList.add("test");
		
	}
	
	public static void printElements(List<?> unknown) {
		//unknown.add("Java");//it gives compile time error
		for (Object object : unknown) {
			System.out.println(object);
		}
	}
	
	public static void printObjects(List<Object> listOfObject) {
		listOfObject.add("Java");//OK
		for (Object object : listOfObject) {
			System.out.println(object);
		}
	}
	
	/*
	 * the real differnece between List<?> and List<Object> 
	 * comes depending upon what you are trying to do with them. 
	 * If you are just reading objects, 
	 * I mean printing elmeents from a list using enhanced for loop then both are ok, 
	 * but if you want to add elements then you should use List<Object>. 

Similarly, if you are writing a generic method that should work with any 
type of list then you should be using wildcards like List<?> as method arguments. 

	 */
	
}
