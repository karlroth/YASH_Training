
public class Employee {

	private int id;
	private String name;
	
	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String toString() {
		return "{id: "+this.getId()+", name:\""+this.getName()+"\" }";
	}

	public int getId() {
		
		return this.id;
	}

	public String getName() {
		return this.name;
	}
	
	
}
