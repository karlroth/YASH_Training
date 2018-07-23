import java.util.Scanner;

HosetlRegistrationTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		printMainMenu();


		do {
			switch() {
				case 1:
				System.out.println("Adding Student");
				break;
				case 2:
				System.out.println("Getting Total Registraiont");
				break;
				case 0;
				System.out.println("Exiting...");
				System.exit(0);
				break;
			}
		} while()

	}

	public static void printMainMenu() {
		System.out.println("----Main Menu----");
		System.out.println("1. Register Student");
		System.out.println("2. Count Total Registration");
		System.out.println("0. Exit");	
	}
}