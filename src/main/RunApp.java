package main;

import java.sql.Connection;

import controller.Controller;
import datamodel.DatabaseManager;
import view.MainView;

public class RunApp {

	private static Connection connection = null;
	
	public static void main(String[] args) {
		int menuChoice = -1;
		DatabaseManager manager = new DatabaseManager();
		MainView view = new MainView();
		Controller controller = new Controller(manager, view);
		controller.connectToDB(manager);
		MainView menu = new MainView();
		while(menuChoice != 0) {
			menuChoice = controller.processChoice(menu.displayMainMenu());
		}
	}

}
