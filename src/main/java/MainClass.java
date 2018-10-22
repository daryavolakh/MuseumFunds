import java.sql.SQLException;

import controller.Controller;
import model.MuseumsDB;
import view.MainWindow;

public class MainClass {

	public static void main(String[] args) throws SQLException {
		MuseumsDB museumsDb = new MuseumsDB();
		Controller controller = new Controller(museumsDb);
		MainWindow mainWindow = new MainWindow(controller);
		mainWindow.show();
	}
}
