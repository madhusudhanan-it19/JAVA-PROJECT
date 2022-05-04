package MultiThreading;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.text.SimpleDateFormat;

class OwnThread implements Runnable{
	String name;
	public OwnThread(String name) {
		this.name = name;
	}
	public void run() {
		try {
			for(int i = 0;i<=5;i++) {
				Date date = new Date();
				SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
				if(i == 0) {
					System.out.println("The initialization time for "+name+"is "+ft.format(date));
				}
				else {
					System.out.println("The execution time for "+name+"is "+ft.format(date));
				}
				Thread.sleep(1000);
			}
			Thread.sleep(2000);
			System.out.println(name+ "is completed!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
class ThreadPool{
	public static void main(String[] args) {
		Runnable r1 = new OwnThread("Thread 1");
		Runnable r2 = new OwnThread("Thread 2");
		Runnable r3 = new OwnThread("Thread 3");
		Runnable r4 = new OwnThread("Thread 4");
		Runnable r5 = new OwnThread("Thread 5");
		
		ExecutorService pool = Executors.newFixedThreadPool(2);
		pool.execute(r1);
		pool.execute(r2);
		pool.execute(r3);
		pool.execute(r4);
		pool.execute(r5);
		
		
		pool.shutdown();
	}
}