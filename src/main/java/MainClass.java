import controller.Controller;
import model.MuseumsDB;
import view.MainWindow;

public class MainClass {
	MuseumsDB museumsDb = new MuseumsDB();
	Controller controller = new Controller(museumsDb);
	MainWindow mainWindow = new MainWindow(controller);
}
