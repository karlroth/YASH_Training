HostelRegistration {
	
	private Student[] students;
	private static int count = 0; 

	public HostelRegistration() {
		students = new Student[100];
	}

	public void addStudent(STudent student) {
		students[count] = student;
		count++;
	}

	public int getTotalRegisteredStudents() {
		return count;
	}

}