package Generics;
import java.util.*;

abstract class Period{
	abstract void period();
}
class Maths extends Period{
	void period() {
		System.out.println("This is Maths period");
	}
}
class Science extends Period{
	void period() {
		System.out.println("This is Science Period");
	}
}
class WildCard{
	static void print(List<? extends Period> l) {
		for(Period p: l) {
			p.period();
		}
	}
	public static void main(String[] args) {
		List<Maths> maths = new ArrayList<>();
		Maths m1 = new Maths();
		Maths m2 = new Maths();
		Maths m3 = new Maths();
		maths.add(m1); maths.add(m2); maths.add(m3);
		List<Science> sci = new ArrayList<>();
		Science s1 = new Science();
		Science s2 = new Science();
		Science s3 = new Science();
		sci.add(s1); sci.add(s2); sci.add(s3);
		print(sci);
		print(maths);
	}
}