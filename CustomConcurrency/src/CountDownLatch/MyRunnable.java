package CountDownLatch;

public class MyRunnable implements Runnable {
	
	private CountDownLatchCustom cntDownCustom;
	
	public MyRunnable(CountDownLatchCustom cntDonwCustom) {
		this.cntDownCustom = cntDonwCustom;
	}

	@Override
	public void run() {
		System.out.println("Enetered into runnable Thread");
		try {
			Thread.sleep(1000);
			cntDownCustom.countdown();
			Thread.sleep(1000);
			cntDownCustom.countdown();
			Thread.sleep(1000);
			cntDownCustom.countdown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
