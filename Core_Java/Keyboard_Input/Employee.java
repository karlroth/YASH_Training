public class Employee {

	private String name;
	private int id;
	private float salary; 

	public void print() {
		
		System.out.println();
		System.out.println("----Employee Information----");
		System.out.println("Name : "+this.name);
		System.out.println("ID: "+this.id); 
		System.out.println("Salary: "+this.salary);
		System.out.println();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public void setSalary(float salary) {
		this.salary = salary; 
	}

	public float getSalary() {
		return this.salary;
	}

	@Override
	public String toString() {
		return "[id : "+this.id+", name : "+this.name+", salary : "+this.salary+"]";
	}
}