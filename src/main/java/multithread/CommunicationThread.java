package multithread;

public class CommunicationThread {
	public static void main(String[] args) {
		Object lock = new Object();
		new Thread(new ThreadWait(lock), "thread wait").start();
		new Thread(new ThreadNotify(lock), "thread notify").start();
	}
}

class ThreadWait implements Runnable {
	Object lock;
	public ThreadWait(Object lock){
		this.lock = lock;
	}
	@Override
	public void run() {
		synchronized (lock){

			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + "-------" + i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
				if(i == 5) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}
			}
		}
	}
}

class ThreadNotify implements Runnable {
	Object lock;
	public ThreadNotify(Object lock){
		this.lock = lock;
	}
	@Override
	public void run() {
		synchronized (lock){

			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + "-------" + i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
				if(i == 9) lock.notifyAll();
			}
		}
	}
}