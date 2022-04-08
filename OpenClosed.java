package SolidProperties;
class VehicleNumber{
	
	public void getNumber() {
		
		System.out.println("No vehicle is identified!");
	}
}
class Car extends VehicleNumber{
		static int carno = 1000;
		public void getNumber() {
		System.out.println("The number for this car:"+ carno);
		carno++;
	}
}
class Bike extends Car{
	static int bikeno = 1000;
	public void getNumber() {
	System.out.println("The number for this bike:"+ bikeno);
	bikeno++;
}
}
class OpenClosed{
	public static void main(String[] args) {
		VehicleNumber vh = new VehicleNumber();
		VehicleNumber car = new Car();
		VehicleNumber bike = new Bike();
		vh.getNumber();
		car.getNumber();
		bike.getNumber();
	}
}