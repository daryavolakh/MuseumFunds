import controller.Controller;
import model.MuseumsDB;

public class MainClass {
	MuseumsDB museumsDb = new MuseumsDB();
	Controller controller = new Controller(museumsDb);
	MainWindow mainWindow = new MainWindow(controller);
}
