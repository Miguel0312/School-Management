import welcome.WelcomeWindow;
import java.io.File;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		try {
      File myObj = new File("school.txt");
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File "+ myObj+ " already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
		new WelcomeWindow();
	}
}
