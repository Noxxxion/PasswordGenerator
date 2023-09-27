package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Mainloop {
	
	private static boolean upperCaseLetter , lowerCaseLetter , numbers, symbols = false;
	private static int length;

	public void passwortGenerator() {
		PasswordBuilder pb = new PasswordBuilder();
		while (true) {
			this.userInput();
			System.out.println("Dein Passwort lautet: "+ pb.passwordBuilder(length, upperCaseLetter,lowerCaseLetter, numbers, symbols));
			break;
		}
	}
	
	//METHOF GETS USER CHOICE 
	private void userInput() {

		try {
			Scanner s = new Scanner(System.in);

			while (true) {
				question1(s);
				question2(s);
				question3(s);
				question4(s);
				question5(s);
				
				//Check for >0 Options
				if (lowerCaseLetter || upperCaseLetter || numbers || symbols) {
					break;
				} else {
					System.out.println("\nYou must use at least 1 Option!\n");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//METHOD REQUEST OF UPPERCASE
	private static void question1(Scanner s) {
		while (true) {
			System.out.println("\nDo you want to include uppercase letters? ( yes = 1 / no = 0 )");
			try {
				int option = s.nextInt();
				if (option == 0) {
					System.out.println("You selected NO uppercase Letters");
					break;
				} else if (option == 1) {
					upperCaseLetter = true;
					System.out.println("You selected uppercase Letters");
					break;
				} else {
					System.out.println("Pls Input a Valid Option");
				}
			} catch (InputMismatchException e) {
				System.out.println(s.nextLine() + " is not a Valid Input");

			}
		}
	}
	
	//METHOD REQUEST OF LOWERCASE
	private static void question2(Scanner s) {
		while (true) {
			System.out.println("\nDo you want to include lowercase letters? ( yes = 1 / no = 0 )");
			try {
				int option = s.nextInt();
				if (option == 0) {
					System.out.println("You selected NO lowercase Letters");
					break;
				} else if (option == 1) {
					lowerCaseLetter = true;
					System.out.println("You selected lowercase Letters");
					break;
				} else {
					System.out.println("Pls Input a Valid Option");
				}
			} catch (InputMismatchException e) {
				System.out.println(s.nextLine() + " is not a Valid Input");

			}
		}
	}
	
	//METHOD REQUEST OF NUMBERS
	private static void question3(Scanner s) {
		while (true) {
			System.out.println("\nDo you want to include Numbers? ( yes = 1 / no = 0 )");
			try {
				int option = s.nextInt();
				if (option == 0) {
					System.out.println("You selected NO Numbers");
					break;
				} else if (option == 1) {
					numbers = true;
					System.out.println("You selected Numbers");
					break;
				} else {
					System.out.println("Pls Input a Valid Option");
				}
			} catch (InputMismatchException e) {
				System.out.println(s.nextLine() + " is not a Valid Input");

			}
		}
	}
	
	//METHOD REQUEST OF SYMBOLS
	private static void question4(Scanner s) {
		while (true) {
			System.out.println("\nDo you want to include Symbols? ( yes = 1 / no = 0 )");
			try {
				int option = s.nextInt();
				if (option == 0) {
					System.out.println("You selected NO Symbols");
					break;
				} else if (option == 1) {
					symbols = true;
					System.out.println("You selected Symbols");
					break;
				} else {
					System.out.println("Pls Input a Valid Option");
				}
			} catch (InputMismatchException e) {
				System.out.println(s.nextLine() + " is not a Valid Input");
				
			}
		}
	}
	
	//METHOD REQUEST OF LENGTH
	private static void question5(Scanner s) {
		while (true) {
			System.out.println("\nEnter the desired length of the password.");
			try {
				int option = s.nextInt();
				if (option <= 0) {
					System.out.println("Pls Input a Valid Option");
				} else if (option >= 1) {
					length = option;
					System.out.println("Your Password will be " + option + " Character long");
					break;
				} else {
				}
			} catch (InputMismatchException e) {
				System.out.println(s.nextLine() + " is not a Valid Input");
				
			}
		}
	}
}