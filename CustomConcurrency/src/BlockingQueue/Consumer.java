package BlockingQueue;

public class Consumer implements Runnable {

	LinkedBlockingQueueCustom<Integer> blockingQueue=null;
	public Consumer(LinkedBlockingQueueCustom<Integer> blockingQueue){
		this.blockingQueue=blockingQueue;
	}

	@Override
	public void run() {
		try {
            System.out.println(blockingQueue.take());
            Thread.sleep(3000);
            System.out.println(blockingQueue.take());
            Thread.sleep(3000);
            System.out.println(blockingQueue.take());
            Thread.sleep(3000);
            System.out.println(blockingQueue.take());
            Thread.sleep(3000);
            System.out.println(blockingQueue.take());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
	}

}
