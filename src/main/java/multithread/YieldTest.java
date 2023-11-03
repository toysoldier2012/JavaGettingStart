package multithread;

public class YieldTest {
	public static void main(String[] args) {
		new YieldThread("thread 1").start();
		new YieldThread("thread 2").start();
	}
}

class YieldThread extends Thread{

	public YieldThread(String name){
		super(name);
	}

	@Override
	public void run(){
		System.out.println("1-------------" + Thread.currentThread().getName());
		Thread.yield();
		System.out.println("2-------------" + Thread.currentThread().getName());
	}
}
