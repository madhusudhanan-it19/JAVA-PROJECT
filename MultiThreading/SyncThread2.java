package MultiThreading;

class ThreadMain1 extends Thread{
	static int count = 0;
	public void run() {
		function(Thread.currentThread().getName());
	}
	 void function(String name) {
		System.out.println(name + "Thread started");
		//try{Thread.sleep(2000);} catch(Exception e) {}
		for(int i = 0;i<3;i++) {
			count++;
		}
		System.out.println(name+ " : "+ count );
	}
}

class ThreadMain2 extends Thread{
	static int count = 0;
	public void run() {
		function(Thread.currentThread().getName());
	}
	 void function(String name) {
		System.out.println(name + "Thread started");
		//try{Thread.sleep(2000);} catch(Exception e) {}
		synchronized (this) {
		for(int i = 0;i<3;i++) {
			count++;
		}
		System.out.println(name+ " : "+ count );
		}
	}
}

class SyncThread2{
	public static void main(String[] args) {
		ThreadMain1 tc11 = new ThreadMain1();
		ThreadMain1 tc12 = new ThreadMain1();
		tc11.setName("tc11"); tc12.setName("tc12");
		tc11.start();
		tc12.start();
		try{Thread.sleep(5000);} catch(Exception e) {}
		ThreadMain2 tc21 = new ThreadMain2();
		ThreadMain2 tc22 = new ThreadMain2();
		tc21.setName("tc21"); tc22.setName("tc22");
		tc21.start();
		tc22.start();
		
	}
}