interface EmpSalary{
	int salary();
}
class Hr5 implements EmpSalary{
	public int salary() {
		return 5000;
	}
}
class TeamLeader implements EmpSalary{
	public int salary() {
		return 6000;
	}
}
class Interface{
	public static void main(String[] args) {
		EmpSalary hr = new Hr5();
		EmpSalary tl = new TeamLeader();
		System.out.println(hr.salary());
		System.out.println(tl.salary());
	}
}