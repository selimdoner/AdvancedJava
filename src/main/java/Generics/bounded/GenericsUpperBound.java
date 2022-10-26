package Generics.bounded;


//we can specify that a method accepts a type an all its subclasess(upper bound)
//Upper Bounded
	//It has to be sub class of the Number class
//Burada Number üst sınırdır
public class GenericsUpperBound <T extends Number> {
	
	T[] numberArray;
	
	
	

	public GenericsUpperBound(T[] numberArray) {
		this.numberArray = numberArray;
	}


	public double getAverage() {
		double sum=0;
		
		for (int i = 0; i < numberArray.length; i++) {
			sum+=numberArray[i].doubleValue();
		}
		
		double avg=sum/numberArray.length;
		return avg;
	}


	public static void main(String[] args) {
		
		Integer [] intArr= {2,5,45,34};
		
		GenericsUpperBound<Integer> gub=new GenericsUpperBound<>(intArr);
		
		System.out.println("Integer Array avg. value:"+gub.getAverage());
		
		
		Double [] doubleArr= {2.45,5.56,45.56,34.56};
		
		GenericsUpperBound<Double> gub2=new GenericsUpperBound<>(doubleArr);
		
		System.out.println("Integer Array avg. value:"+gub2.getAverage());
		
		

	}
	
	

}

