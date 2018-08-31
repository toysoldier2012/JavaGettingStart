package thread;
/*
 * 1.最简单的Thread子类多线程程序
 * 		有问题，静态成员生命周期太长，占用资源
 * 2.实现Runnable接口多线程程序
 * 3.同步
 */
class Ticket extends Thread {
	static private int ticket = 100;
	private String name;
	
	public Ticket() {
		
	}

	public Ticket(String name) {
		this.name = name;
	}
	

	public void run() {
		while(ticket > 0) {
			ticket--;
			System.out.println("当前线程为"+ this.getName() +"窗口"+ name +"在买票---还剩"+ ticket +"张票");
		}
	}
}

public class ThreadDemo1 {
	public static void main(String[] args) {
		Ticket t1 = new Ticket("one");
		t1.start();
		Ticket t2 = new Ticket("two");
		t2.start();
	}
}

