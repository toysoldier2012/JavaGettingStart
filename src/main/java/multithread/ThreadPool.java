package multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ThreadPool {
	public void threadPoolWithSamephore(){
		ExecutorService executorService = Executors.newCachedThreadPool();
		final Semaphore semaphore = new Semaphore(5);

		for (int i = 0; i < 20; i++) {
			final int NO = i;
			Runnable runnable = () -> {
				try {
					semaphore.acquire();
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}

				System.out.println("Thread " + NO + " begin...");

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}

				semaphore.release();
			};
			executorService.execute(runnable);
		}
		executorService.shutdown();
	}

	public static void main(String[] args) {
		new ThreadPool().threadPoolWithSamephore();
	}
}
