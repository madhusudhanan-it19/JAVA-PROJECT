import java.util.*;
class Car{
	String name;
	int price;
	int model;
	Car(String name, int price, int model){
		this.name = name;
		this.price = price;
		this.model = model;
	}
}
class ShowRoom{
	private ArrayList<Car> cars;
	ShowRoom(ArrayList<Car> cars){
		this.cars = cars;
	}
	void printData() {
		for(Car car : cars) {
			System.out.println("Name: "+car.name+" Model: "+car.model+" Price: "+car.price);
		}
	}
}
class Composition{
	public static void main(String[] args) {
		Car c1 = new Car("BMW",1000000,1001);
		Car c2 = new Car("Ford",700000,2001);
		Car c3 = new Car("Jaguar",900000,3001);
		ArrayList<Car> cars = new ArrayList<>();
		cars.add(c1);
		cars.add(c2);
		cars.add(c3);
		ShowRoom showroom = new ShowRoom(cars);
		showroom.printData();
	}
}