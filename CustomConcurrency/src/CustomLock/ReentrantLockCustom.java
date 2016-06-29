package CustomLock;

public class ReentrantLockCustom implements LockCustom {

	int lockHoldCount;
	long lockThreadId;

	public ReentrantLockCustom() {
		lockHoldCount = 0;
	}

	@Override
	public synchronized void lock() {
		
	if(lockHoldCount==0){
		lockHoldCount++;
		this.lockThreadId = Thread.currentThread().getId();
	}
	else if(lockHoldCount>0 && this.lockThreadId == Thread.currentThread().getId() ){
		lockHoldCount++;
	}else{
		try {
			this.wait();
			lockHoldCount++;
			this.lockThreadId = Thread.currentThread().getId();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}

	@Override
	public synchronized void unlock() {
		if(lockHoldCount!=0){
			lockHoldCount--;
		}else 
			throw new IllegalMonitorStateException();

		if(lockHoldCount==0){
			notify();
		}
	}

	@Override
	public synchronized boolean tryLock() {
		if(lockHoldCount!=0){
			return false;
		}else 
			lock();
			return true;

	}

}
