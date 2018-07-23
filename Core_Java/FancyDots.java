/*
* Program to print patterns of asterisks to the command line.
*
* trianlge:
* 			*
*			* * 
* 			* * *
*			* * * *
* 
* valley:
*			*           *
*			* *       * *
*			* * *   * * *
*			* * * * * * *
*
* diamond:
*                 *
*               * * *
*             * * * * *
*               * * *
*                 *
* 
*/
class FancyDots {
	
	public static void main(String[] args) {
		
		triangle("* ", 4);
		
		System.out.println("\n");

		//System.out.println(valley("* ", 4);

		//System.out.println("\n");
		
		diamond();
	}

	static void triangle(String input, int size) {
		
		
		for(int i = 1; i <= size; i++) {
			System.out.println( multiplyString(input, i) );
			//temp = padString(temp, size - i);
		}

	}

	static String valley(String input, int size) {

		String output = "";

		for(int i = 1; i <= 4; i++) {
			String temp = multiplyString(input, i);
			temp = padString(temp, size - i);
			temp = reflectString(temp);

			output += temp + "\n";
		}

		return output;
	}

	static void diamond() {}

	/*
	* function that returns the string appended to itself 'x' times.
	* Ex. multiplyString("x ", 5) returns "x x x x x "
	*/
	static String multiplyString(String input, int x) {
		String result = input;
		for(int i = 1; i < x; i++) {
			result += input;
		}
		return result;
	}

	static String padString(String input, int padding) {
		String output = input;

		for(int i = 1; i <= padding; i++) {
			output += "  ";
		}
		return output;
	}

	static String reflectString(String input){
		return "";
	}
}











