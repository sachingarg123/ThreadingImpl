package Thread;

public class Reader implements Runnable {

	Calculator c;

	public Reader(Calculator c) {
		this.c = c;
	}




	@Override
	public void run() {
		synchronized (c) {
			try {
				System.out.println("Thread is going into wait status "+Thread.currentThread().getName());
				c.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Thread wait over" + Thread.currentThread().getName());
			System.out.println("Total is "+ c.total);
		}
	}
	
	
	
	public static void main(String[] args) {
		Calculator c = new Calculator();
		Reader r = new Reader(c);
		new Thread(r).start();
		new Thread(r).start();
		new Thread(r).start();
		new Thread(c).start();

	}

}
