package controller;

import java.sql.SQLException;

import datamodel.DatabaseManager;
import view.MainView;

public class Controller {
	private DatabaseManager manager;
	private MainView view;
	
	public Controller(DatabaseManager manager, MainView view) {
		this.manager = manager;
		this.view = view;
	}

	public void connectToDB(DatabaseManager manager) {
		manager.getConnection();
	}

	public int processChoice(int menuChoice) {
		String choice = "";
		int result = -1;
		switch (menuChoice) {
		case 1:
			view.displayRegisterUserMenu();
			break;
//		case 2:
//			view.displaySearchForUserMenu();
//			break;
//		case 3:
//			view.displayDownloadMovieMenu();
//			break;
//		case 4:
//			view.displayListDownloadedMoviesMenu();
//			break;
//		case 5:
//			view.displaySearchUserMenu();
//			break;
//		case 6:
//			view.displayChangeUserNameMenu();
//			break;
//		case 7:
//			view.displayDeleteUserMenu();
//			break;
		case 0:
			choice = view.displayExitMenu();
			if(choice.equals("y")) {
				manager.closeDBConnection();
				System.exit(0);
			}
		}
		return result;
	}
}
