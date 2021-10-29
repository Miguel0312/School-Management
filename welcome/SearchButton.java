package welcome;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import file.GetStudents;
import people.Student;

/*
  *Creates a window in which the user can search a specific student by ID or by name and delete a student from the database
*/
public class SearchButton extends JButton {
  SearchButton(ArrayList<Student> s) {

    this.setText("Search Student");
    this.addActionListener(new addSearchWindow());
  }
}

class addSearchWindow implements ActionListener {
  public void actionPerformed(ActionEvent a) {
    new search.SearchWindow(GetStudents.go());
  }
}
