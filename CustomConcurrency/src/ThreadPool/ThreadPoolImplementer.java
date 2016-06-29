package ThreadPool;

public class ThreadPoolImplementer {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		ThreadPool threadPool = new ThreadPool(2);
		Runnable task=new Task();
		Runnable task1=new Task();
		threadPool.execute(task);
		threadPool.execute(task1);
		threadPool.shutdown();

	}

}
