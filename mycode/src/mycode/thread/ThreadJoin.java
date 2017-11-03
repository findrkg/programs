package mycode.thread;

public class ThreadJoin {
	static int total = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread t0 = new Thread(new Runnable() {
			@Override
			public void run() {				
				total = total + 10;
				System.out.println(Thread.currentThread().getName()+" : added 10 : "+total);
			}
		});

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				total = total + 20;
				System.out.println(Thread.currentThread().getName()+" : added 20 : "+total);
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				total = total + 30;
				System.out.println(Thread.currentThread().getName()+" : added 30 : "+total);
			}
		});

		try {
			t0.start();
			//t0.join();
			t1.start();
			//t1.join();
			t2.start();
			//t2.join();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" : "+total);
	}

}
