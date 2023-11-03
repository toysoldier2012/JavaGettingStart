package multithread;

public class JoinTest {

	public static void main(String[] args) {
		Thread t1 = new Thread(new VipThread(), "vip");
		Thread t2 = new Thread(new NormalThread(t1));

		t1.start();
		t2.start();
	}

}

class NormalThread implements Runnable {
	Thread thread;

	public NormalThread(Thread t) {
		this.thread = t;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("normal------" + i);
			if (i == 50) {
				try {
					thread.join();
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
}

class VipThread implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("vip----------" + i);
		}
	}
}
