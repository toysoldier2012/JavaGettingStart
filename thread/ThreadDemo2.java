package thread;
/*
 * 1.最简单的Thread子类多线程程序
 * 2.实现Runnable接口多线程程序
 * 		启动多个线程，对一个对象进行处理
 * 		有问题，安全性
 * 3.同步
 */
class Ticket2 implements Runnable {
	private int tick = 100;
	public void run() {
		while(tick > 0) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() +"---sale :"+ tick--);
		}
	}
}

public class ThreadDemo2 {
	public static void main(String[] args) {
		Ticket2 t = new Ticket2();
		
		Thread th1 = new Thread(t);
		Thread th2 = new Thread(t);
		Thread th3 = new Thread(t);
		Thread th4 = new Thread(t);
		th1.start();
		th2.start();
		th3.start();
		th4.start();
	}
}

	
