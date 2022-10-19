package Threads;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockQueue {
	
	static public int counter=0;

	public static void main(String[] args) {
		
		ArrayBlockingQueue<Integer> queue=new ArrayBlockingQueue<>(10);
		
		Producer producer=new Producer(queue);
		Thread producerThread=new Thread(producer);
		producerThread.start();
		
		Consumer consumer =new Consumer(queue);
		Thread consumerThread=new Thread(consumer);
		consumerThread.start();
	}

}

class Producer implements Runnable{
	private ArrayBlockingQueue<Integer> queue;
	
	public Producer(ArrayBlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(3000);
				queue.put(BlockQueue.counter);
				BlockQueue.counter++;
				System.out.println("Counter value is put to queue: "+BlockQueue.counter);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}

class Consumer implements Runnable{
	private ArrayBlockingQueue<Integer> queue;
	
	public Consumer(ArrayBlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(4000);
				queue.take();
				BlockQueue.counter--;
				System.out.println("Counter value is taken from queue: "+BlockQueue.counter);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}