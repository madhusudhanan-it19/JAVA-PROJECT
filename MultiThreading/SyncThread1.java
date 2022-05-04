package MultiThreading;

class Car{
	public void status(String status) {
		System.out.println("The task is "+ status);
		try {
			Thread.sleep(1000);
		}
		catch(InterruptedException IE) {
			
		}
		System.out.println(status +" has sent");
	}
}

class ThreadClass1 extends Thread{
	Car car;
	String status;
	public ThreadClass1(Car car, String status) {
		this.car = car;
		this.status = status;
	}
	public void run() {
		synchronized (car) {
			car.status(status);
		}
	}
}

class SyncThread1{
	public static void main(String[] args) {
		Car car = new Car();
		ThreadClass1 thread1 = new ThreadClass1(car,"started");
		ThreadClass1 thread2 = new ThreadClass1(car,"completed");
		thread1.start();
		thread2.start();
		try {
			thread1.join();
			thread2.join();
		}
		catch (Exception e) {
		}
	}
}