package multithread;

public class DeadLock2 implements Runnable{
	private final Object lock1;
	private final Object lock2;

	public DeadLock2(Object lock1, Object lock2){
		this.lock1 = lock1;
		this.lock2 = lock2;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (lock2) {
				System.out.println("This part in lock2....");
				synchronized (lock1) {
					System.out.println("This part in lock1....");
				}
				System.out.println("Lock1 release....");
			}
			System.out.println("Lock2 release....");
		}
	}
}
