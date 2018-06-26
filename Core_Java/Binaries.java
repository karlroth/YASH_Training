class Binaries {
	public static void main(String[] args) {
		
		for(int i = 0; i <= 15; i++){
			String result = integerToBinary(i);

			System.out.println(i + " = " + result);
			
		}

		System.out.println("1010 = "+binaryToInteger("1010"));
		
	}

	static String integerToBinary(int number) {
		

		if( number == 0){
			return "0";
		}
		else if(number == 1) {
			return "1";
		}
		return integerToBinary(number/2) + Integer.toString(number%2);
	}

	static int binaryToInteger(String bin) {
		String[] binary = bin.split("");
		int output = 0;
		int power = 0; 

		for(int i = binary.length -1; i > -1; i--){
			if(binary[i].equals("1")) {
				output += twoTo(power);
			}
			
			power++;
		}
		return output;
	}

	static int twoTo(int power) {
		int output = 1;
		for(int i = 0; i < power; i++) {
			output *= 2; 
		}
		return output;
	}
}