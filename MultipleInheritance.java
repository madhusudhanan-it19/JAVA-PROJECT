package Inheritance;

interface Hr7{
	void hr();
}
interface Tl{
	void tl();
}
class Position implements Hr7,Tl{
	public void hr() {
		System.out.println("Hr");
	}
	public void tl() {
		System.out.println("TL");
	}
}
class MultipleInheritance{
	public static void main(String[] args) {
		Hr7 h = new Position();
		Tl t = new Position();
		h.hr();
		t.tl();
		
	}
}