package algorithm;

public class LeftRightWaitNotifyExample {
	final static String str = "1";

	public static void main(String[] args) throws InterruptedException {

		new LeftLegThread(str).start();
		new RightLegThread(str).start();
	}
}

class LeftLegThread extends Thread {
	String monitor;

	public LeftLegThread(String str) {
		monitor = str;
	}

	@Override
	public void run() {
		try {
			synchronized (monitor) {
				while (true) {
					System.out.println("Left ");
					monitor.wait();
					monitor.notify();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class RightLegThread extends Thread {
	String monitor;

	public RightLegThread(String str) {
		monitor = str;
	}

	@Override
	public void run() {
		try {
			synchronized (monitor) {
				while (true) {
					System.out.println("Right ");
					monitor.notify();
					monitor.wait();
				}
			}
		} catch (InterruptedException e) {

		}
	}
}