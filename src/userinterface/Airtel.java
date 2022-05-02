package userinterface;
import java.util.Map;

public class Airtel implements SimProvider {
	int offerId = 0;
	double amount;
	 public double getOffers() {
		 
		 Map<Integer,Double> offerMap = Map.of (
					1,(double) 15,
					2,(double)239,
					3,(double)479,
					4,(double)666,
					5,(double)499,
					6,(double)549,
					7,(double)839						
	 			);
		System.out.println("Choose offers: ");
		System.out.println("1. Rs 19 Data: 1 GB validity: NA");
		System.out.println("2. Rs 239 Data: 1.5 GB/day validity: 24 Days");
		System.out.println("3. Rs 479 Data: 1.5 GB/day validity: 56 Days");
		System.out.println("4. Rs 666 Data: 1.5 GB/day validity: 84 Days");
		System.out.println("5. Rs 499 Data: 2 GB/day validity: 24 Days");
		System.out.println("6. Rs 549 Data: 2 GB/day validity: 56 Days");
		System.out.println("7. Rs 839 Data: 2 GB/day validity: 84 Days");
		offerId =  Validation.getInteger();
		amount = offerMap.get(offerId);
		return amount;
	}
}
