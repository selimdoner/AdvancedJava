package Threads;

import java.util.concurrent.CountDownLatch;

public class CountDownLatch1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//CountDownLatch is used to make sure that a task waits for threads before it starts. 
		//To understand its application, let us think a server where 
		//the main task can only start when all the required services have started.
		
		CountDownLatch latch=new CountDownLatch(4);
		
		WorkerThread first=new WorkerThread(15000, latch,"Worker-1");
		WorkerThread second=new WorkerThread(20000, latch,"Worker-2");
		WorkerThread third=new WorkerThread(30000, latch,"Worker-3");
		WorkerThread fourth=new WorkerThread(40000, latch,"Worker-4");
		
		
		first.start();
		second.start();
		third.start();
		fourth.start();
		
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
        System.out.println(Thread.currentThread().getName()+" has finished");
		
	}

}


class WorkerThread extends Thread {
	private int delay;
	private CountDownLatch latch;
	
	public WorkerThread(int delay, CountDownLatch latch, String name) {
		super(name);
		this.delay = delay;
		this.latch = latch;
	}
	
	
	@Override
	public void run() {
		
		try {
			Thread.sleep(delay);
			//You make something overhere
			latch.countDown();
			
			System.out.println(Thread.currentThread().getName()+" finished");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}