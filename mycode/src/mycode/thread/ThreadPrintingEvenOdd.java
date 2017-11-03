package mycode.thread;

public class ThreadPrintingEvenOdd {

	public static void main(String[] args) {
		ResourceLock lock = new ResourceLock();
		lock.counter = 0;
		ThreadEven even = new ThreadEven(lock);
		ThreadOdd odd = new ThreadOdd(lock);

		even.start();
		odd.start();
	}
}

class ThreadEven extends Thread {

	ResourceLock lock;

	ThreadEven(ResourceLock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {

		try {
			synchronized (lock) {
				for (int i = 0; i < 100; i++) {
					while (lock.counter < 100 && lock.counter%2 != 0) {
						lock.wait();
					}
					System.out.println(Thread.currentThread().getName() + " - "+lock.counter++);
					Thread.sleep(1000);
					lock.notify();
				}
			}
		} catch (Exception e) {
			System.out.println("Exception 1 :" + e.getMessage());
		}

	}

}

class ThreadOdd extends Thread {

	ResourceLock lock;

	ThreadOdd(ResourceLock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {

		try {
			synchronized (lock) {
				for (int i = 0; i < 100; i++) {
					while (lock.counter < 100 && lock.counter%2 == 0) {
						lock.wait();
					}
					System.out.println(Thread.currentThread().getName() + " - "+lock.counter++);
					Thread.sleep(1000);
					lock.notify();
				}
			}
		} catch (Exception e) {
			System.out.println("Exception 2 :" + e.getMessage());
		}

	}
}

