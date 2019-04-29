package mycode.thread;

public class ThreadRunningInSequence {

	public static void main(String[] args) {
		ResourceLock lock = new ResourceLock();

		ThreadA a = new ThreadA(lock);
		ThreadB b = new ThreadB(lock);
		ThreadC c = new ThreadC(lock);

		a.start();
		b.start();
		c.start();
	}
}

class ResourceLock {
	public volatile int flag = 1;
	public volatile int counter = 1;
}

class ThreadA extends Thread {

	ResourceLock lock;

	ThreadA(ResourceLock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {

		try {
			synchronized (lock) {

				for (int i = 0; i < 10; i++) {

					while (lock.counter != 1) {
						lock.wait();
					}

					System.out.println("A "+ i);
					Thread.sleep(1000);
					lock.counter = 2;
					lock.notifyAll();
				}

			}
		} catch (Exception e) {
			System.out.println("Exception 1 :" + e.getMessage());
		}

	}

}

class ThreadB extends Thread {

	ResourceLock lock;

	ThreadB(ResourceLock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {

		try {
			synchronized (lock) {

				for (int i = 0; i < 10; i++) {

					while (lock.counter != 2) {
						lock.wait();
					}

					System.out.println("B "+i);
					Thread.sleep(1000);
					lock.counter = 3;
					lock.notifyAll();
				}

			}
		} catch (Exception e) {
			System.out.println("Exception 2 :" + e.getMessage());
		}

	}
}

class ThreadC extends Thread {

	ResourceLock lock;

	ThreadC(ResourceLock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {

		try {
			synchronized (lock) {

				for (int i = 0; i < 10; i++) {

					while (lock.counter != 3) {
						lock.wait();
					}

					System.out.println("C "+i);
					Thread.sleep(1000);
					lock.counter = 1;
					lock.notifyAll();
				}

			}
		} catch (Exception e) {
			System.out.println("Exception 3 :" + e.getMessage());
		}

	}
}
