package search;

import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

import people.Student;

public class SearchStudentButton extends JButton {
  private DisplaySpace owner;
  private ArrayList<Student> school = new ArrayList<Student>();
  private JTextField input;
  private boolean byID;

  public SearchStudentButton(JTextField text, DisplaySpace owner, ArrayList<Student> s, boolean byID) {
    this.owner = owner;
    this.byID = byID;
    this.setText("Search by " + (byID ? "ID" : "name"));
    this.setPreferredSize(new Dimension(130, 50));
    this.school = s;
    this.input = text;
    this.addActionListener(new Search(input, this.owner, this));
  }

  public ArrayList<Student> GetSchool() {
    return school;
  }

  public boolean isByID() {
    return byID;
  }

}

class Search implements ActionListener {
  private SearchStudentButton owner;
  private DisplaySpace dSpace;
  private JTextField input;

  public Search(JTextField text, DisplaySpace dSpace, SearchStudentButton owner) {
    this.owner = owner;
    this.input = text;
    this.dSpace = dSpace;
  }

  public void actionPerformed(ActionEvent e) {
    String s = this.input.getText();
    boolean found = false;

    this.dSpace.getOwner().setStudent(new Student("", "", "", "", false));
    this.dSpace.displayStudent();
    this.input.setText("");
    try {
      ArrayList<Student> school = owner.GetSchool();
      if (owner.isByID()) {
        for (Student st : school) {
          if (st.getID().equals(s)) {
            dSpace.getOwner().setStudent(st);
            dSpace.displayStudent();
            found = true;
          }
        }
      } else {
        for (Student st : school) {
          if (st.getName().equals(s)) {
            dSpace.getOwner().setStudent(st);
            dSpace.displayStudent();
            found = true;
          }
        }
      }
    } catch (NullPointerException n) {
    }
    try {
      if (!found)
        new NotFoundError((owner.isByID() ? 'i' : 'n'));
    } catch (NullPointerException n) {
      new NotFoundError('i');
    }
  }
}
