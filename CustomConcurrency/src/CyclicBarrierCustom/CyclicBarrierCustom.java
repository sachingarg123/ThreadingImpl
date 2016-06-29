package CyclicBarrierCustom;

public class CyclicBarrierCustom {
	
	private int initialParties;
	private int partiesAwait;
	Runnable cyclicBarrrierEvent;
	
	public CyclicBarrierCustom(int parties, Runnable cyclicBarrrierEvent){
		this.initialParties = parties;
		this.partiesAwait = parties;
		this.cyclicBarrrierEvent = cyclicBarrrierEvent;
	}
	
	public synchronized void await() throws InterruptedException{
		partiesAwait--;
		if(partiesAwait>0){
			this.wait();
		}else{
			partiesAwait = initialParties;
			notifyAll();
			cyclicBarrrierEvent.run();
		}
	}
	

}
