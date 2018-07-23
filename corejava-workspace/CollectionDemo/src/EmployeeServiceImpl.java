import java.util.Arrays;

public class EmployeeServiceImpl {

	private Employee[] employeeRepository = { new Employee(101, "Pankaj Sharma"), new Employee(102, "Kanika"),
			new Employee(103, "Amit"), new Employee(104, "Vicky"), new Employee(105, "Bill") };

	public Employee[] listEmployees() {
		return employeeRepository;
	}

	public Employee[] sortEmployees() {
//		Employee[] sortedList = new Employee[employeeRepository.length];
//		String[] names = new String[employeeRepository.length];
//
//		for (int i = 0; i < employeeRepository.length; i++) {
//			sortedList[i] = employeeRepository[i];
//		}
//
//		for (int i = 0; i < sortedList.length; i++) {
//			for (int j = i + 1; j < sortedList.length; j++) {
//				char[] firstChar = sortedList[i].getName().toCharArray();
//				char[] secondChar = sortedList[j].getName().toCharArray();
//				if (firstChar[0] > secondChar[0]) {
//					Employee temp = sortedList[i];
//					sortedList[i] = sortedList[j];
//					sortedList[j] = temp;
//				}
//
//			}
//		}
		Arrays.sort(employeeRepository, new NameComparator());
		
		return employeeRepository;
	}

}
