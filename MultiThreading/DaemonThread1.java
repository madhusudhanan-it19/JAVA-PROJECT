package MultiThreading;

class ChildThread extends Thread{
	public void run() {
		try {
			for(int i =0;i<10;i++) {
				System.out.println("child thread");
				Thread.sleep(2000);
			}
		}
		catch(Exception e) {
			
		}
	}
}

class DaemonThread1{
	public static void main(String[] args) {
		ChildThread ct = new ChildThread();
		ct.setDaemon(true);
		//if this line get commented then the program get executed completely.
		ct.start();
		System.out.println("End of the main");
	}
}