package CountDownLatch;

public class CountDownCustomImpl {

	public static void main(String arg[]) throws InterruptedException{
		CountDownLatchCustom countDownLatchCut = new CountDownLatchCustom(3);
		MyRunnable runnable=  new MyRunnable(countDownLatchCut);
		Thread thread = new Thread(runnable);
		thread.start();
		countDownLatchCut.await();
		System.out.println("All work is done now");
	}
	
}
	