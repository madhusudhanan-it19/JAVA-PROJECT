package MultiThreading;

class LambdaThread{
	public static void main(String[] args) throws InterruptedException {
		/*Runnable run1 = ()->{
			for(int i =0;i<5;i++) {
				System.out.println("Hi");
				try{Thread.sleep(1000);}catch(Exception e) {};
			}
		};
		Runnable run2 = ()->{
			for(int i =0;i<5;i++) {
				System.out.println("Hello");
				try{Thread.sleep(1000);}catch(Exception e) {};
			}
		};
		*/
		Thread obj1 = new Thread(()->{
			for(int i =0;i<5;i++) {
				System.out.println("Hi" + Thread.currentThread());
				try{Thread.sleep(1000);}catch(Exception e) {};
			}
		},"Hi Thread");
		Thread obj2 = new Thread(()->{
			for(int i =0;i<5;i++) {
				System.out.println("Hello"+ Thread.currentThread());
				try{Thread.sleep(1000);}catch(Exception e) {};
			}
		}, "Hello Thread");
		System.out.println(obj1.getName() +"\n" + obj2.getName());
		obj1.start();
		try{Thread.sleep(10);}catch(Exception e) {};
		obj2.start();
		obj1.setPriority(Thread.MAX_PRIORITY);
		obj2.setPriority(Thread.MIN_PRIORITY);
		System.out.println(obj1.isAlive());
		obj1.join();
		obj2.join();
		
		System.out.println(obj1.isAlive());
		System.out.println("Bye");
	}
}