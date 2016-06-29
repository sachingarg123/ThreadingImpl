package BlockingQueue;

public class BlockingQueueImpl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedBlockingQueueCustom<Integer> blockingQueue = new LinkedBlockingQueueCustom<>(5);
		
		Thread consumer  = new Thread(new Consumer(blockingQueue));
		Thread producer = new Thread(new Producer(blockingQueue));
		
		consumer.start();
		producer.start();

	}

}
