package MultiThreading;
class ThreadClass extends Thread{
	public ThreadClass(String name) {
		super(name);
	}
	public void run() {
		if(Thread.currentThread().isDaemon()) {
			System.out.println(getName()+" is Daemon Thread");
		}
		else {
			System.out.println(getName()+" is user Thread");
		}
	}
}
class DaemonThread{
	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new ThreadClass("thread1");
		Thread thread2 = new ThreadClass("thread2");
		Thread thread3 = new ThreadClass("thread3");
		if(Thread.currentThread().isDaemon()) {
			System.out.println(Thread.currentThread().getName() + " is daemon thread" );
		}
		else {
			System.out.println(Thread.currentThread().getName() + " is user thread" );
		}
		
		thread1.setDaemon(true); 
		thread1.start();
		thread2.start();
		
		thread3.start();
		thread3.setDaemon(true); 
		 
	}
}