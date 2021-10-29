package search;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

import people.Student;

public class SearchWindow extends JFrame {
  private ArrayList<Student> school = new ArrayList<Student>();
  private Student student;

  public SearchWindow(ArrayList<Student> s) {
    this.school = s;
    this.student = new Student("", "", "", "", false);

    this.setTitle("School Management");
    this.setSize(800, 600);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    this.setLayout(new GridLayout(1, 2));
    DisplaySpace display = new DisplaySpace(this);
    this.add(new SearchSpace(display, this.school));
    this.add(display);
    this.setVisible(true);
  }

  public Student getStudent() {
    return this.student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }
}
