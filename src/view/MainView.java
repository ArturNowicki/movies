package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainView {

	public int displayMainMenu() {
		int choice = -1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(choice < 0 || choice > 7) {
			System.out.println("Enter your choice: ");
			System.out.println("1 - Register new user");
			System.out.println("2 - Search for movie");
			System.out.println("3 - Download movie");
			System.out.println("4 - List downloaded movies");
			System.out.println("5 - Search for user");
			System.out.println("6 - Change user name");
			System.out.println("7 - Delete user");
			System.out.println("0 - EXIT");
			try {
				choice = parseWithDefault(br.readLine(), -1);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return choice;
	}

	private static int parseWithDefault(String number, int defaultVal) {
		  try {
		    return Integer.parseInt(number);
		  } catch (NumberFormatException e) {
		    return defaultVal;
		  }
		}

	public String displayExitMenu() {
		String choice = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(!choice.equals("y") && !choice.equals("n")) {
			System.out.println("Do you really want to quit? Y/N:");
			try {
				choice = br.readLine().toLowerCase();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return choice;
	}

	public void displayRegisterUserMenu() {
		String choice = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(!choice.equals("y") && !choice.equals("n")) {
			System.out.println("Do you really want to quit? Y/N:");
			try {
				choice = br.readLine().toLowerCase();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return choice;
	}
	
}
