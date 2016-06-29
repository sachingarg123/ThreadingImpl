package ExecutorService;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExcutorServiceExample {
	
	public static void main(String arg[]) throws InterruptedException{
		
		RejectedExecutionHandlerImpl rejectionHandler = new RejectedExecutionHandlerImpl();
		
		ThreadPoolExecutor threadPoolExample = new ThreadPoolExecutor(2, 4, 10,TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(2) , Executors.defaultThreadFactory(), rejectionHandler);
		WorkerThread workerThread = new WorkerThread();
		for(int i=0;i<10;i++){
			threadPoolExample.execute(workerThread);
		}
		
		Thread.sleep(3000);
		threadPoolExample.shutdown();
		
	}

}

