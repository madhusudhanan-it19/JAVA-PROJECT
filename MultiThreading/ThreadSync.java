package MultiThreading;
class Counter{
	 static int count = 0;
	 static synchronized void increment() {
		 count++;
	 }
}
class Threadex extends Thread{
	public void run() {
		for(int i = 0;i<10000;i++) {
			Counter.increment();
		}
	}
}
class Threadexample extends Thread{
	public void run() {
		for(int i = 0;i<10000;i++) {
			Counter.increment();
		}
	}
}
class ThreadSync {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Threadex();
		Thread thread2 = new Threadexample();
		thread.start();
		thread2.start();
		thread.join();
		//thread2.join();
		System.out.println(Counter.count);
	}
}