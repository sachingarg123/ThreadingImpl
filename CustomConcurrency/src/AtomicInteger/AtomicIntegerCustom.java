package AtomicInteger;

public class AtomicIntegerCustom {
	
	int currentValue;
   	int previousValue;
   	
   	
   	public AtomicIntegerCustom() {
   		currentValue=0;
   	}
   	
   	public AtomicIntegerCustom(int currentValue ) {
   		this.currentValue=currentValue;
   	}


   	public synchronized int get() {
   		return currentValue;
   	}
   	
   	public synchronized void set(int currentValue) {
   		this.currentValue = currentValue;
   		
   	}
   	
   	public synchronized int getAndSet(int newValue){
   		{
   			previousValue =  currentValue;
   			currentValue = newValue;
   			return previousValue;
   		}
   	}
   	
   	public synchronized boolean compareAndSet(int expect, int update) {
   		if(expect==currentValue) {
   			currentValue = update;
   			return true;
   		}else {
   			return false;
   		}
   		
   	}
   	
   	public synchronized int addAndGet(int value){
      	return currentValue+=value;
	}
   	
   	public synchronized int incrementAndGet(){
      	return ++currentValue;
	}
}
