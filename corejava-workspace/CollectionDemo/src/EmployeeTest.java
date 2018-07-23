
public class EmployeeTest {

	
	public static void main(String[] args) {
        EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
        Employee[] employeeList = employeeServiceImpl.listEmployees();
        System.out.println("[");
        for (Employee employee : employeeList) {
            System.out.println("    "+employee);
        }
        System.out.println("]");
        
        Employee[] sortedList = employeeServiceImpl.sortEmployees();
        System.out.println("[");
        for (Employee employee : sortedList) {
            System.out.println("    "+employee);
        }
        System.out.println("]");
	}
}
