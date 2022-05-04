package MultiThreading;

class MyThread1 extends Thread{
	public void run() {
		System.out.println("Thread "+Thread.currentThread().getId()+" is running.");
	}
}
class ThreadEx1{
	public static void main(String[] args) {
		for(int i =0;i<5;i++) {
			Thread obj = new MyThread1();
			obj.start();
		}
	}
}