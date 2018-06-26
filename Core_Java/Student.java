class Student {
	
	static int numStudents = 0; 
	
	private int id;
	String studentName; 
	int year; 

	public Student() {
		this.id = numStudents +1;
		numStudents++;
	}

	public Student(String name) {
		this.studentName = name; 
		this.id = numStudents +1;
		numStudents++;
	}

	public Student(int year) {
		this.year = year;
		this.id = numStudents + 1; 
		numStudents++;
	}

	public Student(String studentName, int year) {
		this.studentName = studentName;
		this.year = year;
		this.id = numStudents + 1; 
		numStudents++; 
	}

	public int getID() {
		return this.id;
	}

	public String getName() {
		return this.studentName;
	}

	public int getYear() {
		return this.year;
	}

	public void setName(String studentName) {
		this.studentName = studentName;
	}

	public void setYear(int year) {
		this.year = year;
	}


	public static void main(String[] args) {
		Student karl = new Student("Karl", 3);
		Student nick = new Student("Nick",  4);
		Student kanika = new Student("Kanika", 4);

		System.out.println("There are "+numStudents+" students at the hostel.");
		System.out.println("Karl's ID is: "+karl.getID());
		System.out.println("Nick's ID is: "+nick.getID());
		System.out.println("Kanika's ID is: "+kanika.getID());
	}
}