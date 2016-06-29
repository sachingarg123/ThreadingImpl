package CustomReadWriteLock;

public interface ReadWriteLock {
	
	 public ReentrantReadWriteLock.WriteLock writeLock();
	    public ReentrantReadWriteLock.ReadLock  readLock();

}
