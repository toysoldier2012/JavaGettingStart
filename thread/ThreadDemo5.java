package thread;
class Single1 {
	//ÀÁººÊ½
	private static final Single1 s1 = new Single1();
	private Single1() {
		System.out.println("created");
	};
	public static Single1 getInstance() {
		return s1;
	}
}

class Single2 {
	//¶öººÊ½
	private static Single2 s2 = null;
	private Single2() {
		System.out.println("created");
};
	public static Single2 getInstance() {
		synchronized(Single2.class) {
			if(s2 == null)
				s2 = new Single2();
		}
		return s2;
	}
}

public class ThreadDemo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("HW");
		Single1.getInstance();
		Single2.getInstance();
	}

}
