/**
* Author: Karl Roth
* Date: June 26, 2018
* 
* Program to test Scanner Class.
*/

import java.util.Scanner;

class ScannerDemo {
	public static void main(String[] args) {
		getInputFromScanner();
			}

	public static void getInputFromScanner() {
		Scanner sc = new Scanner(System.in);
		Employee employee = new Employee();

		System.out.print("Enter the employee's name : ");
		employee.setName(sc.nextLine());

		System.out.print("Enter the employee ID : ");
		employee.setId(sc.nextInt());

		System.out.print("Enter the employee's salary : ");
		employee.setSalary(sc.nextFloat());

		System.out.println(employee);
	}


	
}