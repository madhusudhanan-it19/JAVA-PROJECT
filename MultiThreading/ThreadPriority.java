package MultiThreading;



class ThreadPriority{
		static class RunnableThread implements Runnable{
			public void run() {
				System.out.println("Count down begins!");
				for(int i =10;i>=0;i--) {
					System.out.println(i);
				}
			}
		}
	
		public static void main(String[] args) {
			Thread mythread = new Thread(new RunnableThread());
			mythread.setPriority(Thread.MAX_PRIORITY);
			mythread.start();
			//Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
			System.out.println("Happy new year!");
		}	
}