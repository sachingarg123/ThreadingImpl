package ThreadPool;

import BlockingQueue.LinkedBlockingQueueCustom;

public class ThreadPool {

	private LinkedBlockingQueueCustom<Runnable> taskQueue;
	
	public boolean isshutDown = false;

	public ThreadPool(int size) {
		taskQueue = new LinkedBlockingQueueCustom<>(size);

		for (int i = 0; i <= size; i++) {
			ThreadPoolThread threadPoolThread = new ThreadPoolThread(taskQueue,this);
			threadPoolThread.setName("Thread-" + i);
			System.out.println("Thread-" + i + " created in ThreadPool.");
			threadPoolThread.start();
		}
	}
	
	public synchronized void  execute(Runnable task) throws InterruptedException{
		if(this.isshutDown){
			throw new InterruptedException("ThreadPool Shutdown inititated, we do not add task now");
		}
		 System.out.println("task has been added.");
	        this.taskQueue.put(task);
	}
	
	public synchronized void shutdown(){
		this.isshutDown=true;
		 System.out.println("ThreadPool SHUTDOWN initiated.");
	}

}
