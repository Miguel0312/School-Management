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

public class DelStudent extends JButton {
  private DisplaySpace owner;

  public DelStudent(DisplaySpace owner) {
    this.setText("Delete student's data");
    this.setPreferredSize(new Dimension(200, 50));
    this.owner = owner;
    this.addActionListener(new Delete(this, this.owner));
  }

}

class Delete implements ActionListener {
  private DelStudent owner;
  private DisplaySpace dSpace;

  public Delete(DelStudent owner, DisplaySpace dSpace) {
    this.owner = owner;
    this.dSpace = dSpace;
  }

  public DisplaySpace getDSpace() {
    return dSpace;
  }

  public void actionPerformed(ActionEvent e) {
    String[] options = { "Yes", "No" };
    int confirm = JOptionPane.showOptionDialog(dSpace.getOwner(),
        "Are you sure that you want to delete " + dSpace.getOwner().getStudent().getName() + " data?", "Confirm",
        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[1]);
    if (confirm == JOptionPane.YES_OPTION) {
      this.dSpace.getOwner().setStudent(new Student("", "", "", "", false));
      this.dSpace.displayStudent();
      ObjectOutputStream oos;
      try {
        oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("school.txt"))));
        for (Student st : dSpace.getOwner().getSchool()) {
          if (!st.equals(dSpace.getOwner().getStudent()))
            oos.writeObject(st);
        }
        dSpace.getOwner().updateSchool();
        oos.close();
      } catch (IOException error) {
        error.printStackTrace();
      }
    }
  }
}
