package multithread;

public class DeadLock {
	final static String lock1 = "1";
	final static String lock2 = "2";

	public static void main(String[] args) {
		new Thread1(lock1, lock2).start();
		new Thread2(lock1, lock2).start();
	}
}


class Thread1 extends Thread {
	String lock1;
	String lock2;

	public Thread1(String lock1, String lock2){
		this.lock1 = lock1;
		this.lock2 = lock2;
	}

	@Override
	public void run(){
		while (true) {
			synchronized (lock1){
				System.out.println("thread1 lock1");
				synchronized (lock2){
					System.out.println("thread1 lock2");
				}
			}
		}
	}
}
class Thread2 extends Thread {
	String lock1;
	String lock2;

	public Thread2(String lock1, String lock2){
		this.lock1 = lock1;
		this.lock2 = lock2;
	}

	@Override
	public void run(){
		while (true) {
			synchronized (lock2){
				System.out.println("thread2 lock2");
				synchronized (lock1){
					System.out.println("thread2 lock1");
				}
			}
		}
	}
}
