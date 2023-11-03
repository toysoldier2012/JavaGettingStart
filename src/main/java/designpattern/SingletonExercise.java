package designpattern;

public class SingletonExercise {
	private static SingletonExercise singletonExercise;

	private SingletonExercise(){
	}

	public static SingletonExercise getInstance(){
		if(singletonExercise == null) {
			synchronized (SingletonExercise.class) {
				if (singletonExercise == null) {
					singletonExercise = new SingletonExercise();
				}
			}
		}
		return singletonExercise;
	}
}
