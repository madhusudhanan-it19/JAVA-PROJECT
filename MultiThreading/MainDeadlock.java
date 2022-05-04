package MultiThreading;

class MainDeadlock{
	public static void main(String[] args) {
		try {
			System.out.println("Entering into deadlock!");
			Thread.currentThread().join();
			System.out.println("The statement after calling join()");
		}
		catch (InterruptedException interupted) {
			interupted.printStackTrace();
		}
	}
}