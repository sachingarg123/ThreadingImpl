package CountDownLatch;

public class CountDownLatchCustom {

	int size;

	CountDownLatchCustom(int size) {
		this.size = size;
	}

	public synchronized void await() throws InterruptedException {
		if (size != 0) {
			this.wait();
		}
	}

	public synchronized void countdown() {

		size--;

		if (size == 0)
			notifyAll();
	}
}
