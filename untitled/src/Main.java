import java.io.*;
import ru.vsu.math.java.cli.*;
import ru.vsu.math.java.*;
import ru.vsu.math.java.ui.*;

public class Main {
  public static void main(String[] args) {
    Application app = Application.getInstance();
    //Seeder.createData(app);

    //ConsoleController consoleController = new ConsoleController(app);
    //consoleController.run();
    MainUI mainUI = new MainUI();
    mainUI.setVisible(true);
  }
}
