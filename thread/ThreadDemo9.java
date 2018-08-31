package thread;
class StopThread implements Runnable {
	public int num = 0;
	public boolean flag = true;

	public synchronized void run() {
//		while (flag) {
//			try {
//				wait();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				System.out.println("exception");
//			}
//			System.out.println(Thread.currentThread().getName() + "not stop");
//		}
		
		for(int i= 0; i<60; i++) {
			System.out.println(Thread.currentThread().getName()+"-----"+i);
		}
	}

	public void changeFlag() {
		flag = false;
	}
}

public class ThreadDemo9 {
	public static void main(String[] args) {
		StopThread st = new StopThread();

		Thread t1 = new Thread(st);
		Thread t2 = new Thread(st);

//		t1.setDaemon(true);
//		t2.setDaemon(true);
		t1.start();
		t2.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (true) {
			if (st.num == 60) {
				//st.changeFlag();
				//t1.interrupt();
				//t2.interrupt();
				break;
			}
			st.num++;
			System.out.println(Thread.currentThread().getName() + "running---" + st.num);
		}
	}
}
