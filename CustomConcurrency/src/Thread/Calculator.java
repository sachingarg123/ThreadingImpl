package Thread;

public class Calculator implements Runnable {
	
	int total;
	@Override
	public void run() {
		 synchronized (this) {
			 System.out.println("Calculator took lock");
			for(int i=0;i<=100;i++){
				total = total+i;
			}
			
		System.out.println("Total is"+total);
		System.out.println("Calculator going to notify all thread");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			notifyAll();
		}
		 
		
	}

}
