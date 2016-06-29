package ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExceutorServiceExample {
	
	public static void main(String arg[]){
		
		ExecutorService service = Executors.newFixedThreadPool(5);
		WorkerThread task = new WorkerThread();
		for(int i=0;i<3;i++){
			try {
				Thread.sleep(1000);
				service.execute(task);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		service.shutdown();
		if(!service.isTerminated()){
			System.out.println("Finished all Threads");
		}
	}

}
