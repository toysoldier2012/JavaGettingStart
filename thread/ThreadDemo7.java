package thread;
class Personne {
	private String name;
	private String sex;
	private boolean flag = true;

	public synchronized void set(String name, String sex) {
		if (flag)
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		this.name = name;
		this.sex = sex;
		flag = true;
		notify();
	}

	public synchronized void get() {
		if (!flag)
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("Name is " + name + " and sex is " + sex);
		flag = false;
		notify();
	}
}

class Write implements Runnable {
	Personne p;

	public Write(Personne p) {
		this.p = p;
	}

	public void run() {
		int x = 0;
		while (true) {
			if (x == 0)
				p.set("David", "male");
			else
				p.set("Julia", "female");
			x = (x + 1) % 2;
		}
	}
}

class Read implements Runnable {
	Personne p;

	public Read(Personne p) {
		this.p = p;
	}

	public void run() {
		while (true) {
			p.get();
		}
	}
}

public class ThreadDemo7 {

	public static void main(String[] args) {
		Personne p = new Personne();
		Write w = new Write(p);
		Read r = new Read(p);
		Thread th1 = new Thread(w, "thread1");
		Thread th4 = new Thread(r, "thread4");
		th1.start();
		th4.start();
	}

}
