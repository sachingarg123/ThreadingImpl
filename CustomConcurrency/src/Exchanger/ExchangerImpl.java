package Exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerImpl {

	
	public static void main(String arg[]){
		Exchanger exchanger  = new Exchanger();
		ExchangerRunnable runnable1 = new ExchangerRunnable(exchanger, "A");
		ExchangerRunnable runnable2 = new ExchangerRunnable(exchanger, "B");
		Thread a = new Thread(runnable1);
		Thread b = new Thread(runnable2);
		a.start();
		b.start();
	}
}
