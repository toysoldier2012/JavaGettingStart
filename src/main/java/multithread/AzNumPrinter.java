package multithread;

public class AzNumPrinter {
	public static void main(String[] args) {
		Object lock = new Object();
		new Thread(new AzThread(lock)).start();
		new Thread(new NumThread(lock)).start();
	}
}


class AzThread implements Runnable {
	Object lock;

	public AzThread(Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		char c = 'A';
		synchronized (lock) {
			for (int i = 0; i < 26; i++) {
				System.out.println(c);
				c += 1;
				lock.notify();
				if(i < 25) {
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

class NumThread implements Runnable {
	Object lock;

	public NumThread(Object lock) {
		this.lock = lock;
	}
	@Override
	public void run() {
		synchronized (lock) {
			for (int i = 0; i < 26; i++) {
				System.out.println(i + 1);
				lock.notify();
				if(i < 25) {
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