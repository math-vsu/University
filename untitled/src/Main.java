import java.io.*;
import ru.vsu.math.java.*;
import ru.vsu.math.java.entity.Group;
import ru.vsu.math.java.ui.*;

public class Main {
  public static void main(String[] args) {
    Application app = Application.getInstance();
    Seeder.createData(app);

    for(Object group: app.getGroups()){
        System.out.println(group);
    }

    MainUI mainUI = new MainUI(app);
    mainUI.setVisible(true);
  }
}
