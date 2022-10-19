package Threads;

public class MultiThreading03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Brackets bracket=new Brackets();
		Thread thread1=new Thread(new Runnable() {
			
			@Override
			public void run() {
			for (int i = 1; i <= 7; i++) {
				bracket.generateBrackets();
			}
				
			}
		});
		
		thread1.start();
		
//		try {
//			thread1.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
		Thread thread2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 1; i <=7; i++) {
					bracket.generateBrackets();
				}
				
			}
		});
		
		thread2.start();

	}

}


class Brackets{
	synchronized public void generateBrackets() {
		for (int i = 1; i <=10; i++) {
			if(i<=5) {
				System.out.print("[");
			}else {
				System.out.print("]");
			}
		}
		System.out.println("");
	}
}
