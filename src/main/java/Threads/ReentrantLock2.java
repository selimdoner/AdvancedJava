package Threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock2 {

	private static ReentrantLock lock=new ReentrantLock(); 
	
	
	private static void accessResource() throws InterruptedException {
		//boolean lockAcquired=lock.tryLock();
		boolean lockAcquired=lock.tryLock(5,TimeUnit.SECONDS);
		if(lockAcquired) {
			try {
				//access resource
			}finally {
				lock.unlock();
			}
		}else {
			//you can do alternate something
		}
		
	}
	
	//1-synchronized is implicit but reentrantlock is explicit
	//2- you can use lock and unlock in different scope.
	//3-we can use tryLock in the reentrant
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Thread thread1=new Thread(()->accessResource());
//		thread1.start();
//		
//		Thread thread2=new Thread(()->accessResource());
//		thread2.start();
//		
//		Thread thread3=new Thread(()->accessResource());
//		thread3.start();
//		
//		Thread thread4=new Thread(()->accessResource());
//		thread4.start();

	}

}
