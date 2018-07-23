/**
* Author: Karl Roth
* Date: June 26, 2018
* 
* Program to test BufferedReader Class.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException; 

class BufferedReaderDemo {
	public static void main(String[] args) {
		getInputFromBufferedReader();
	}

	public static void getInputFromBufferedReader() {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Employee employee = new Employee();

		try {
			System.out.print("Name : ");
			String name = br.readLine();
			
			System.out.print("ID : ");
			int id = Integer.parseInt(br.readLine());

			System.out.print("Salary : ");
			float salary =  Float.valueOf(br.readLine());

			employee.setName(name);
			employee.setId(id);
			employee.setSalary(salary);

			System.out.println(employee);

		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}	
}