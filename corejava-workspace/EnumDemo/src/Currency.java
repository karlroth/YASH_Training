
public enum Currency {
	PENNY(1){
		@Override
		public String color() {
			return "Copper";
		}
	},
	NICKLE(5){
		@Override
		public String color() {
			return "Bronze";
		}
	},
	DIME(10){
		@Override
		public String color() {
			return "Silver";
		}
	},
	QUARTER(25){
		@Override
		public String color() {
			return "Silver";
		}
	};
	
	private int value;
	private Currency(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public abstract String color();
	
	@Override
	public String toString() {
		switch(this) {
		case PENNY: System.out.println("Penny: "+value); break;
		case DIME: System.out.println("Dime: "+value); break;
		case NICKLE: System.out.println("Nickel: "+value); break;
		case QUARTER: System.out.println("Quarter: "+value);break;
		}
		return super.toString();
	}
}
