package thread;
class Ticket4 implements Runnable {
	private int tick = 1000;
	boolean flag = true;	
	public void run() {
		if(flag == true) {
			while(true) {
				//验证同步静态函数的锁为类名.class
				synchronized(Ticket4.class){
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
public class ThreadDemo4 {

	public static void main(String[] args) {
		Ticket4 t = new Ticket4();
		
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

