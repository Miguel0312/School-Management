package search;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import people.Student;

/*
  *DelStudent is a button that will delete the current selected student in the search window
*/
public class DelStudent extends JButton {
  private SearchWindow owner;
  private DisplaySpace dSpace;

  public DelStudent(SearchWindow owner, DisplaySpace dSpace) {
    this.setText("Delete student's data");
    this.setPreferredSize(new Dimension(200, 50));
    this.owner = owner;
    this.dSpace = dSpace;
    this.addActionListener(new Delete(this.owner, this.dSpace));
  }

}

class Delete implements ActionListener {
  private SearchWindow owner;
  private DisplaySpace dSpace;

  /*
   * We store the SearchWindow where the information about the student that the
   * user wants to delete is saved and the DisplaySpace where these informations
   * are stored
   */
  public Delete(SearchWindow owner, DisplaySpace dSpace) {
    this.owner = owner;
    this.dSpace = dSpace;
  }

  public SearchWindow getOwner() {
    return owner;
  }

  /*
   * When the button is pressed, the program will confirm if the user really wants
   * to delete the information of the student.
   * 
   * To delete the information, the program will store all the students that are
   * not the one that the user wants to delete and then update both the text file
   * (by overwriting) and the ArrayList (by calling the method
   * SearchWindow.updateSchool())
   */
  public void actionPerformed(ActionEvent e) {
    if (owner.getStudent().getName().equals("") && owner.getStudent().getID().equals("")) {
      return;
    }
    String[] options = { "Yes", "No" };
    int confirm = JOptionPane.showOptionDialog(owner,
        "Are you sure that you want to delete " + owner.getStudent().getName() + " data?", "Confirm",
        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[1]);
    if (confirm == JOptionPane.YES_OPTION) {
      ObjectOutputStream oos;
      try {
        oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("school.txt"))));
        for (Student st : owner.getSchool()) {
          if (!st.equals(owner.getStudent()))
            oos.writeObject(st);
        }
        owner.updateSchool();
        oos.close();
      } catch (IOException error) {
        error.printStackTrace();
      }
      owner.setStudent(new Student("", "", "", "", false));
      dSpace.displayStudent();
    }
  }
}
