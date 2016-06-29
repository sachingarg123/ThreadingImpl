package BlockingQueue;

import java.util.LinkedList;
import java.util.List;

public class LinkedBlockingQueueCustom<E> {

private List<E> queue;
private int maxSize;

	public LinkedBlockingQueueCustom(int maxSize){
		this.maxSize = maxSize;
		queue = new LinkedList<E>();
	}
	
	public synchronized void put(E item) throws InterruptedException{
		if(queue.size()==maxSize){
			this.wait();
		}
		queue.add(item);
		this.notifyAll();
	}
	
	public synchronized E take() throws InterruptedException{
		if(queue.size()==0){
			this.wait();
		}
		
		notifyAll();
		return queue.remove(0);
	}
	
	public int size(){
		return queue.size();
	}
}
