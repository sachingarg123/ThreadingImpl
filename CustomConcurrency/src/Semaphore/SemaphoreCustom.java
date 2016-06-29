package Semaphore;

public class SemaphoreCustom {

	private int permits;
	public SemaphoreCustom(int permits){
		this.permits = permits;
	}
	
	public void acquire() throws InterruptedException{
		if(permits==0){
			this.wait();
			permits--;
		}
		
		permits--;
	}
	
	public void release(){
		permits++;
		if(permits>0){
			this.notifyAll();
		}
	}
	
	
}
