class ExpDemo2 {
	public static void main(String[] args) {
		try {
			if(args.length > 2){
				System.out.println("Must enter two and only two values");
				System.exit(0);
			}
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			
			int c = a/b; 

			System.out.println("Result: " +c);
		} catch(ArithmeticException ex) {
			System.out.println(ex.getMessage());
		} catch(ArrayIndexOutOfBoundsException ex) {
			System.out.println(ex.getMessage());
		} catch(NumberFormatException ex) {
			System.out.println(ex.getMessage());
		}
	}
}