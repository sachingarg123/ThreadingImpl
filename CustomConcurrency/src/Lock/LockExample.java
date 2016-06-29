package Lock;

public class LockExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrinterQueue printerQueue = new PrinterQueue();
		PrintingJob printingJob = new PrintingJob(printerQueue);
	      Thread thread[] = new Thread[10];
	      for (int i = 0; i < 10; i++)
	      {
	         thread[i] = new Thread(printingJob, "Thread " + i);
	      }
	      for (int i = 0; i < 10; i++)
	      {
	         thread[i].start();
	      }
	   }

}
