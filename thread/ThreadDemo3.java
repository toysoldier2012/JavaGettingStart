package thread;
/*
 * 1.最简单的Thread子类多线程程序
 * 2.实现Runnable接口多线程程序
 * 3.同步
 * 		方式有两种同步代码块和同步函数
 */
class Ticket3 implements Runnable {
	private int tick = 1000;
	boolean flag = true;	
	public void run() {
		if(flag) {
			while(true) {
				//同步代码块
				//验证同步函数的锁为this
				synchronized(this){
					if(tick > 0) {
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
		}
		else {
			while(true) {
				show();
			}
		}
	}
	//同步函数
	public synchronized void show() {
		if(tick > 0) {
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

public class ThreadDemo3 {
	public static void main(String[] args) {
		Ticket3 t = new Ticket3();
		
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

	
