package mycode.thread;

public class ThreadCounter {

	public static void main(String[] args) {
		ResourceLock lock = new ResourceLock();
		lock.counter = 1;
		Thread t1 = new MyThread1(lock);
		Thread t2 = new MyThread2(lock);
		Thread t3 = new MyThread3(lock);

		t1.setName("Thread1");
		t2.setName("Thread2");
		t3.setName("Thread3");
		t1.start();
		t2.start();
		t3.start();
	}
}

class MyThread1 extends Thread {
	ResourceLock lock;
	MyThread1(ResourceLock lock) {		
		this.lock = lock;
	}

	@Override
	public void run() {
		try {
			synchronized (lock) {
				for (int i = 0; i < 100; i++) {
					while (lock.flag != 1) {
						lock.wait();
					}
					System.out.println(Thread.currentThread().getName() + " - "+lock.counter++);
					lock.flag=2;
					Thread.sleep(1000);
					lock.notifyAll();
				}
			}
		} catch (Exception e) {
			System.out.println("Exception 1 :" + e.getMessage());
		}
	}
}

class MyThread2 extends Thread {
	ResourceLock lock;
	MyThread2(ResourceLock lock) {		
		this.lock = lock;
	}

	@Override
	public void run() {
		try {
			synchronized (lock) {
				for (int i = 0; i < 100; i++) {
					while (lock.flag != 2) {
						lock.wait();
					}
					System.out.println(Thread.currentThread().getName() + " - "+lock.counter++);
					lock.flag=3;
					Thread.sleep(1000);
					lock.notifyAll();
				}
			}
		} catch (Exception e) {
			System.out.println("Exception 1 :" + e.getMessage());
		}
	}
}

class MyThread3 extends Thread {
	ResourceLock lock;
	MyThread3(ResourceLock lock) {		
		this.lock = lock;
	}

	@Override
	public void run() {
		try {
			synchronized (lock) {
				for (int i = 0; i < 100; i++) {
					while (lock.flag != 3) {
						lock.wait();
					}						
					System.out.println(Thread.currentThread().getName() + " - "+lock.counter++);
					lock.flag=1;
					Thread.sleep(1000);
					lock.notifyAll();
				}
			}
		} catch (Exception e) {
			System.out.println("Exception 1 :" + e.getMessage());
		}
	}
}
