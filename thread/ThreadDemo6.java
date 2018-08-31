package thread;
/*
 * 死锁练习
 * 同时运用了匿名内部类，异常，多线程，同步
 */

public class ThreadDemo6  {
	private static Object ob1 = new Object();
	private static Object ob2 = new Object();
	
	public static void deadLock() {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				synchronized(ob1) {
					try {
						System.out.println(Thread.currentThread().getName() +" is running and get lock ob1");
						Thread.sleep(100);
						System.out.println("Sleep for 100ms");
					}
					catch(Exception e) {
						e.printStackTrace();
					}
					System.out.println("Waiting for lock ob2");
					synchronized(ob2) {
						System.out.println(Thread.currentThread().getName() +" is running and get lock ob2");
					}
					
				}
			}
		}, "Thread1");
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				synchronized(ob2) {
					try {
						System.out.println(Thread.currentThread().getName() +" is running and get lock ob2");
						Thread.sleep(100);
						System.out.println("Sleep for 100ms");
					}
					catch(Exception e) {
						e.printStackTrace();
					}
					System.out.println("Waiting for lock ob1");
					synchronized(ob1) {
						System.out.println(Thread.currentThread().getName() +" is running and get lock ob1");
					}
					
				}
			}
		}, "Thread2");
		
		t1.start();
		t2.start();
	}
	
	public static void main(String[] args) {
		deadLock();
	}
}