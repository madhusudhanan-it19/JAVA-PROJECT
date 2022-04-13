package SolidPrinciples;

import java.util.InputMismatchException;

class AddPro extends Operation{
	public AddPro() {
		try {
			System.out.println("Enter Project Id: ");
			int pro_id = scInt.nextInt();
			System.out.println("Enter Project Name: ");
			String pro_name = scStr.nextLine();
			pro.put(pro_id, pro_name);
			System.out.println("Added successfully!");
		} catch (InputMismatchException imee) {
			System.out.println("Input mismatch Please try again!");
		}
	}
}