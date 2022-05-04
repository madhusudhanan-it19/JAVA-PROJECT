package MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyRunnable5 implements Runnable{
	private String name;
	public MyRunnable5(String name) {
		this.name = name;
	}
	public void run() {
		System.out.println("Start thread : " + name);
		try {
			Thread.sleep(1000);
		}
		catch(InterruptedException ie) {
			ie.printStackTrace();
		}
		System.out.println("End Thread: "+ name);
	}
}
public class ThreadPool1 {
			public static void main(String[] args) {
				ExecutorService exeser = Executors.newFixedThreadPool(5);
				int i;
				for( i =0;i<=10;i++) {
					Runnable run = new MyRunnable5("thread" + i);
					exeser.execute(run);
				}
				exeser.shutdown();
			
				while(exeser.isShutdown()) {}
				
				System.out.println("All are successfully completed");
			}
}


















