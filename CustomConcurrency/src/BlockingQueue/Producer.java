package BlockingQueue;

public class Producer implements Runnable {
	
	private LinkedBlockingQueueCustom<Integer> linkedBlockingQueue = null;
	
	public Producer(LinkedBlockingQueueCustom<Integer> linkedBlockingQueue){
		this.linkedBlockingQueue = linkedBlockingQueue;
	}

	@Override
	public void run() {
		 try {
			 linkedBlockingQueue.put(1);
			 System.out.println("Data Enetered"+linkedBlockingQueue);
	            //Thread.sleep(3000);
	            linkedBlockingQueue.put(2);
	            System.out.println("Data Enetered"+linkedBlockingQueue);
	            //Thread.sleep(3000);
	            linkedBlockingQueue.put(3);
	            System.out.println("Data Enetered"+linkedBlockingQueue);
	            linkedBlockingQueue.put(4);
	            System.out.println("Data Enetered"+linkedBlockingQueue);
	            linkedBlockingQueue.put(5);
	            System.out.println("Data Enetered"+linkedBlockingQueue);
	            linkedBlockingQueue.put(6);
	            System.out.println("Data Enetered"+linkedBlockingQueue);
	            linkedBlockingQueue.put(7);
	            System.out.println("Data Enetered"+linkedBlockingQueue);
	            linkedBlockingQueue.put(8);
	            System.out.println("Data Enetered"+linkedBlockingQueue);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		
	}

	

}
