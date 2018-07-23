
public class EnumDemo {
	public static void main(String[] args) {
		Day day = new Day();
		day.setDay(WeekDays.MONDAY);
		System.out.println("Day is : "+day.getDay());
	}
}

