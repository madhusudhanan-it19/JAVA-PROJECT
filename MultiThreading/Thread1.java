package MultiThreading;
class Multi implements Runnable{
	public void run() {
		System.out.println("Runnable interface is running");
	}
}
class ABC extends Thread{
	public void run() {
		System.out.println("Thread class is running");
	}
}
class Thread1{
	public static void main(String[] args) throws InterruptedException {
		ABC t1 = new ABC();
		t1.start();
		Multi m1 = new Multi(); 
		Thread t2 = new Thread(m1);
		t2.start();
		Thread t3 = new Thread("My Thread");
		Thread.sleep(5);
		System.out.println(t3.getName());
		Thread t4 = new Thread(m1,"Runnable constructor");
		t4.start();
		System.out.println(t4);
	}
}