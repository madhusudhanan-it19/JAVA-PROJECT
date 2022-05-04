package MultiThreading;
class MyThread2 implements Runnable{
	public void run() {
		System.out.println("Thread "+Thread.currentThread().getId()+" is running.");
	}
}
class RunnableEx1{
	public static void main(String[] args) {
		for(int i =0;i<5;i++) {
			Thread obj = new Thread(new MyThread2());
			obj.start();
		}
	}
}