package MultiThreading;

class Hi extends Thread{
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("Hi");
			try{Thread.sleep(1000);}catch(Exception e) {};
		}
	}
}

class Name extends Thread{
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("Madhu");
			try{Thread.sleep(1000);}catch(Exception e) {};
		}
	}
}

class HRU implements Runnable{
	public void run() {
		for(int i =0;i<5;i++) {
			System.out.println("How are you");
			try{Thread.sleep(1000);}catch(Exception e) {};
		}
	}
}
class Thread3{
	public static void main(String[] args) {
		Hi h = new Hi();
		Name he = new Name();
		Runnable obj = new HRU();
		h.start();
		try{Thread.sleep(10);}catch(Exception e) {};
		he.start();
		Thread t1 = new Thread(obj);
		t1.start();
		
	}
}