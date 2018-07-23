/**
*	Author: Karl Roth
*	Date: June 26, 2018
* 	A program that takes the users name and age using JOptionPane and informs the user of voting eligibility. 
*/
import javax.swing.JOptionPane;

class AgeTester {
	
	public static void main(String[] args) {
		getInput();
	}

	public static void getInput() {

		String name =  JOptionPane.showInputDialog(null,"Enter your name : ");
		int age = Integer.parseInt( JOptionPane.showInputDialog(null, "Enter your age : ") );

		if(age >= 18) {
			System.out.println("Hi "+name+", you are eligible for voting.");
		}
		else {
			System.out.println("Hi "+name+", you are not eligible for voting.");
		}
	}
}