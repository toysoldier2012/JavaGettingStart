package multithread;
public class LeftRightJoinExercise {
	public static void main(String[] args) {
		LeftStepThread leftStepThread = null;
		RightStepThread rightStepThread = null;
		Thread leftThread = new Thread(leftStepThread);
		Thread rightThread = new Thread(rightStepThread);

		final String lock = "1";

		leftStepThread = new LeftStepThread(rightThread, lock);
		rightStepThread = new RightStepThread(leftThread, lock);

		leftThread = new Thread(leftStepThread);
		rightThread = new Thread(rightStepThread);

		leftThread.start();
		rightThread.start();
	}
}


class LeftStepThread implements Runnable {
	Thread rightThread;
	final String lock;

	public LeftStepThread(Thread rightThread, String lock) {
		this.rightThread = rightThread;
		this.lock = lock;
	}

	@Override
	public void run() {
		synchronized (lock){
			for (int i = 0; i < 100; i++) {
				System.out.println("Left");
				try {
					rightThread.join();
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
}

class RightStepThread implements Runnable {
	Thread leftThread;
	final String lock;

	public RightStepThread(Thread leftThread, String lock) {
		this.leftThread = leftThread;
		this.lock = lock;
	}

	@Override
	public void run() {
		synchronized (lock) {
			for (int i = 0; i < 100; i++) {
				System.out.println("Right");
				try {
					leftThread.join();
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
}
