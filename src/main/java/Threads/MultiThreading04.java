package Threads;

public class MultiThreading04 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		long startTime = System.currentTimeMillis();

		Brackets1 bracket = new Brackets1();
		Thread thread1 = new Thread(new Runnable() {

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

		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 1; i <= 7; i++) {
					bracket.generateBrackets();
				}

			}
		});

		thread2.start();

		thread1.join();
		thread2.join();

		long endTime = System.currentTimeMillis();

//		System.out.println("Duration of synchronized method:" + (endTime - startTime));//4343
		System.out.println("Duration of synchronized block:" + (endTime - startTime));//2185

	}

}

class Brackets1 {
	public void generateBrackets() {

		synchronized (this) {

			for (int i = 1; i <= 10; i++) {
				if (i <= 5) {
					System.out.print("[");
				} else {
					System.out.print("]");
				}
			}
			System.out.println("");
		}

		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
