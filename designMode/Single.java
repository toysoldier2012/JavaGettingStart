package designMode;
//¶öººÊ½
class Single1 {
	private static Single1 s = null;
	private Single1() {
		System.out.println("Single 1 created");
	}
	
	public static Single1 getInstance() {
		synchronized(Single1.class) {
			if(s == null) {
				s = new Single1();
			}			
		}
		return s;
	}
}

//ÀÁººÊ½
class Single2 {
	private static final Single2 s = new Single2();
	private Single2() {}
	public static Single2 getInstance() {
		return s;
	}
}

public class Single {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World!");
		Single1.getInstance();
	}

}
