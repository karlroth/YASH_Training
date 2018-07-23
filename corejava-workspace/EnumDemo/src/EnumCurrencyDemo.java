
public class EnumCurrencyDemo {
	
	public static void main(String[] args) {
		Currency curr = Currency.QUARTER;
	
		/*
		System.out.println(curr);
		System.out.println(curr.getValue());
		*/
		
		Currency[] currency = Currency.values();
		for(Currency elem : currency ) {
			elem.toString();
		}
	}
	
	
}
