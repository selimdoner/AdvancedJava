package Threads;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock1 {

	//ReentrantLock has fairness parameter. 
	//it gives a change for long waiting thread to get the lock as first
	private static ReentrantLock lock=new ReentrantLock(true);
	//private static ReentrantLock lock=new ReentrantLock();
	
	private static void get() {
		lock.lock();
	}
	
	private static void put() {
		lock.unlock();
	}
	
	//you can reenter to the lock
	private static void  recursiveCallAccessResource() {
		lock.lock();
		
		if(true) {
			recursiveCallAccessResource();
		}
		
		lock.unlock();
	}
	
	
	private static void accessResource() {
		lock.lock();
		
		System.out.println("Current Thread:"+ Thread.currentThread().getName());
		
		try {
			//access a resource
		//if there is an exception while we are accesing a resource and 
//			we are not cauth this exeption then unlock method will never be called so lock
//			never be unlocked. This will be a big problem. in order to 
//			avoid this please use try finally block
		}finally {
			lock.unlock();
		}
		
		
		//we use lock method multiple times on the same object.
		lock.lock();
		lock.lock();
		
		int number=  lock.getHoldCount();//number of times lock called without calling unlock
		
		lock.unlock();
		lock.unlock();
		
		
		//synchronized (this) { //->lock.lock()
			//access resource 
		//} //lock.unlock();
		
	}
	
	//1-synchronized is implicit but reentrantlock is explicit
	//2- you can use lock and unlock in different scope.
	//3-we can use tryLock in the reentrant
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread thread1=new Thread(()->accessResource());
		thread1.start();
		
		Thread thread2=new Thread(()->accessResource());
		thread2.start();
		
		Thread thread3=new Thread(()->accessResource());
		thread3.start();
		
		Thread thread4=new Thread(()->accessResource());
		thread4.start();

	}

}
