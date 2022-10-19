package Threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

	public static void main(String[] args) {

		Lock lock=new ReentrantLock();
		
		MyRunnable2 myRunnable2=new MyRunnable2(lock);
		
		Thread thread1=new Thread(myRunnable2,"Passenger-1 Thread");
		thread1.start();
		
		
		Thread thread2=new Thread(myRunnable2,"Passenger-2 Thread");
		thread2.start();
	}

}

class MyRunnable2 implements Runnable {

	int ticketsAvailable = 2;
	Lock lock;

	public MyRunnable2(Lock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {

		System.out.println("Waiting to book ticket for: " + Thread.currentThread().getName());

		lock.lock();

		try {
			if (ticketsAvailable > 0) {
				System.out.println("Booking ticket for :" + Thread.currentThread().getName());
				ticketsAvailable--;
				System.out.println("Ticket BOOKED for: " + Thread.currentThread().getName());
				System.out.println("Currently AvailableTicket: " + ticketsAvailable);
			} else {
				System.out.println("Ticket NOT BOOKED for: " + Thread.currentThread().getName());
			}
		} finally {
			lock.unlock();
		}

	}
}
