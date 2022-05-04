package MultiThreading;
class MyThread3 implements Runnable{
	public void run() {
		try {
			Thread.sleep(1500);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("The state of thread while it is called join() method on thread1(mt3): "+ StateOfThread.thread.getState());
		try {
			Thread.sleep(200);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("The state of thread after end of Mythread3 class: "+StateOfThread.thread.getState());
	}
}
public class StateOfThread implements Runnable{
	public static StateOfThread sot;
	public static Thread thread;
	public static void main(String[] args) {
		sot = new StateOfThread();
		thread = new Thread(sot);
		
		System.out.println("The state of thread(sot) while creating it: "+thread.getState());
		thread.start();
		System.out.println("The state of thread(sot) while calling start() method: "+thread.getState());
		
	
	}
	public void run() {
		MyThread3 mt3 = new MyThread3();
		Thread thread1 = new Thread(mt3);
		System.out.println("The state of thread(mt3) while creating it: "+thread1.getState());
		thread1.start();
		System.out.println("The state of thread(mt3) while calling start() method: "+thread1.getState());
		try {
			Thread.sleep(200);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("The state of thread1 while it is calling sleep() method: "+thread1.getState());
		try {
			thread1.join();
		}
		catch(Exception e ) {
			e.printStackTrace();
		}
		
		System.out.println("The state of Thread1 after the end of the executions: "+thread1.getState());
	}
}