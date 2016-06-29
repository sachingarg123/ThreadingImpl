package CyclicBarrierCustom;

public class CyclicBarrierImpl {
	
	public static void main(String arg[]){
		CyclicBarrierCustom ccCustom = new CyclicBarrierCustom(3, new CyclicBarrierEvent());
		MyRunnable runnable = new MyRunnable(ccCustom);
		Thread a = new Thread(runnable);
		Thread b = new Thread(runnable);
		Thread c = new Thread(runnable);
		a.start();
		b.start();
		c.start();
	}

}
