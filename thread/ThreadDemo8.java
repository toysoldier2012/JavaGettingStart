package thread;
import java.util.concurrent.locks.*;

class Plat {
	private int id = 1;
	private String name;
	private boolean flag = false;
	Lock lock = new ReentrantLock();
	Condition con1 = lock.newCondition();
	Condition con2 = lock.newCondition();

	public void set(String name) {
		lock.lock();
		try {
			while (flag) {
				System.out.println(Thread.currentThread().getName() + " is waiting");
				con1.await();
			}
			this.name = name;
			System.out.print("This is " + Thread.currentThread().getName() + " cook the No." + id + " plate----");
			System.out.println("Name is :" + name);
			id++;
			flag = true;
			con2.signal();
			System.out.println(Thread.currentThread().getName() + " notify thread eat");
		} catch (InterruptedException e) {

		} finally {
			lock.unlock();
		}

	}

	public void get() {
		lock.lock();
		try {
			while (!flag) {
				System.out.println(Thread.currentThread().getName() + " is waiting");
				con2.await();
			}

			System.out.print("This is " + Thread.currentThread().getName() + " eat the No." + id + " plate----");
			System.out.println("Name is :" + name);
			flag = false;
			con1.signal();
			System.out.println(Thread.currentThread().getName() + " notify thread cook");
		} catch (InterruptedException e) {

		} finally {
			lock.unlock();
		}

	}
}

class Producer implements Runnable {
	private int x = 0;
	private Plat p;

	public Producer(Plat p) {
		this.p = p;
	}

	public void run() {
		while (true) {
			if (x == 0)
				p.set("marmite de boeuf");
			else
				p.set("aubergine");
			x = (x + 1) % 2;
		}
	}

}

class Consumer implements Runnable {
	private Plat p;

	public Consumer(Plat p) {
		this.p = p;
	}

	public void run() {
		while (true) {
			p.get();
		}
	}
}

public class ThreadDemo8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Plat p = new Plat();
		Producer p1 = new Producer(p);
		Consumer c1 = new Consumer(p);

		Thread t1 = new Thread(p1, "t1");
		Thread t2 = new Thread(p1, "t2");
		Thread t3 = new Thread(c1, "t3");
		Thread t4 = new Thread(c1, "t4");

		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}

}
