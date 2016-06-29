package Exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerRunnable implements Runnable {
	private Exchanger exchanger = null;
	Object object = null;
	public ExchangerRunnable(Exchanger exchanger,Object object){
		this.exchanger = exchanger;
		this.object = object;
	}

	@Override
	public void run() {
		System.out.println("Enetred into Runnable thread"+Thread.currentThread().getName());
		System.out.println("Current object"+this.object);
		
		try {
			this.object = exchanger.exchange(this.object);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Exchanged Object y thread"+Thread.currentThread().getName()+" is "+ this.object);
				

	}

}
