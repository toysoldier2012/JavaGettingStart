package multithread;

public class ThreadSafeSingleton {
	private static ThreadSafeSingleton instance;

	private ThreadSafeSingleton(){}

	public static ThreadSafeSingleton getInstance(String lock){
		if (instance == null) {
			synchronized (lock) {
				if(instance == null){
					instance = new ThreadSafeSingleton();
				}
			}
		}

		return instance;
	}
}
