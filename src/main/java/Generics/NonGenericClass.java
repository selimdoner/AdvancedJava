package Generics;

public class NonGenericClass {
	
	private Object t;
	


	public Object getT() {
		return t;
	}



	public void setT(Object t) {
		this.t = t;
	}



	public static void main(String[] args) {
		
		NonGenericClass obj=new NonGenericClass();
		NonGenericClass obj1=new NonGenericClass();
		obj.setT("John");
		obj1.setT(65);
		
		//String str= (String) obj1.getT(); it gives the run time 
		
		//System.out.println("Name of Object:"+str);

	}

}
