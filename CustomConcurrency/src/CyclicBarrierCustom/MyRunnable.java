package CyclicBarrierCustom;

public class MyRunnable implements Runnable {
	
	private CyclicBarrierCustom cntDonwCustom;
	
	public MyRunnable(CyclicBarrierCustom cntDonwCustom) {
		this.cntDonwCustom = cntDonwCustom;
	}

	@Override
	public void run() {
		System.out.println("Enetered into runnable Thread");
		try {
			cntDonwCustom.await();
			System.out.println("BarrierOver: work start");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
