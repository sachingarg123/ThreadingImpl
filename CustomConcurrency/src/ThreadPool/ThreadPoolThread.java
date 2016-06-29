package ThreadPool;

import BlockingQueue.LinkedBlockingQueueCustom;

public class ThreadPoolThread extends Thread{
	
	LinkedBlockingQueueCustom<Runnable> taskQueue=null;
	ThreadPool threadPool=null;
	public ThreadPoolThread(LinkedBlockingQueueCustom<Runnable> taskQueue,ThreadPool threadPool){
		this.taskQueue=taskQueue;
		this.threadPool = threadPool;
	}
	public void run(){
			try{
				
				while(true){
				
				 System.out.println(Thread.currentThread().getName()
                         +" is READY to execute task.");
				 
				 Runnable run = taskQueue.take();
				 System.out.println(Thread.currentThread().getName()
                         +" has taken task.");
				 run.run();
				 
                 System.out.println(Thread.currentThread().getName()
                               +" has EXECUTED task.");
                 
                 if(this.threadPool.isshutDown
                         &&  this.taskQueue.size()==0){
                  this.interrupt();
                  /*
                   *  Interrupting basically sends a message to the thread
                   *  indicating it has been interrupted but it doesn't cause
                   *  a thread to stop immediately,
                   * 
                   *  if sleep is called, thread immediately throws
                   *  InterruptedException
                   */
                  Thread.sleep(1);
                 }
           }   
				
			}catch(Exception e){
				System.out.println(Thread.currentThread().getName()+" has been STOPPED.");
			}
	}

}
