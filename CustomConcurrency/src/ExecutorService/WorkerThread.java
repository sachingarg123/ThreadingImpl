package ExecutorService;

import java.util.Date;

public class WorkerThread implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" Start. Time = "+new Date());
		processCommand();
		System.out.println(Thread.currentThread().getName()+" End. Time = "+new Date());
	}

	
	public void processCommand(){
		
		
		try{
			Thread.sleep(5000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
