package CustomReadWriteLock;

public class ReentrantReadWriteLock implements ReadWriteLock{
	
	private int readLockCount=0;
	private int writeLockCount=0;
	private int writeRequests = 0;
	private final ReentrantReadWriteLock.ReadLock readerLock;
	 private final ReentrantReadWriteLock.WriteLock writerLock;
	 
	 public ReentrantReadWriteLock(){
		 readerLock = new ReadLock();
		 writerLock = new WriteLock();
	 }
	
	@Override
	public WriteLock writeLock() {
		return writerLock;
	}

	@Override
	public ReadLock readLock() {
		return readerLock;
	}

	public class WriteLock {
		public void lock() throws InterruptedException{
			writeRequests++;
		if(writeLockCount>0||readLockCount>0){
			this.wait();
		}else{
			writeLockCount++;
			writeRequests--;
		}
	}
		public void unlock(){
			writeLockCount--;
			if(writeLockCount==0){
				notifyAll();
			}
	}
	}

	public class ReadLock {
		
		public void lock() throws InterruptedException{
		if(writeLockCount>0 ||writeRequests>0){
			this.wait();
		}else{
			readLockCount++;
		}
		}
		
		public void unlock(){
			readLockCount--;
			if(readLockCount==0){
			notifyAll();
			}
		}
			
	}
}



	

