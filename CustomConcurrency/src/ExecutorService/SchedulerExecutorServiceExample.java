package ExecutorService;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchedulerExecutorServiceExample {

	
	public static void main(String arg[]) throws InterruptedException{
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		
		//schedule to run after sometime
        System.out.println("Current Time = "+new Date());
        for(int i=0; i<3; i++){
            Thread.sleep(1000);
            WorkerThread worker = new WorkerThread();
          //  scheduledThreadPool.schedule(worker, 10, TimeUnit.SECONDS);
           // scheduledThreadPool.scheduleAtFixedRate(worker, 5, 10,
                    //TimeUnit.SECONDS);
            scheduledThreadPool.scheduleWithFixedDelay(worker, 5, 10,
                    TimeUnit.SECONDS);
        }
         
        //add some delay to let some threads spawn by scheduler
        Thread.sleep(30000);
         
        scheduledThreadPool.shutdown();
        while(!scheduledThreadPool.isTerminated()){
            //wait for all tasks to finish
        }
        System.out.println("Finished all threads");
	}
}
