package add;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import file.GetStudents;
import people.Student;

/*
  *Pane in which all the informations of every registered student is displayed
*/
public class ListSpace extends JPanel {
  ArrayList<Student> s = new ArrayList<Student>();
  File f = new File("school.txt");
  JTable students;
  JScrollPane scroll;

  /*
   * The constructor sets up a JTable and put the students' informations in it
   * 
   * The JScrollPane allows the user to access all the information independently
   * of the sizes of the list and the screen
   */
  public ListSpace() {
    this.setBackground(new Color(180, 200, 219));
    this.setPreferredSize(new Dimension(400, 600));
    this.setLayout(new BorderLayout());

    String[] title = new String[] { "Name", "ID", "e-mail", "Major", "Tuition" };

    this.s = GetStudents.go();
    int number = this.s.size(), i = 0;

    String[][] data = new String[number][5];

    for (Student st : this.s) {
      data[i][0] = st.getName();
      data[i][1] = st.getID();
      data[i][2] = st.getEMail();
      data[i][3] = st.getMajor();
      data[i][4] = (st.getTuition() ? "Paid" : "Not paid");
      i++;
    }

    this.students = new JTable(data, title);

    this.students.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    this.students.getColumnModel().getColumn(0).setPreferredWidth(200);
    this.students.getColumnModel().getColumn(1).setPreferredWidth(100);
    this.students.getColumnModel().getColumn(2).setPreferredWidth(200);
    this.students.getColumnModel().getColumn(3).setPreferredWidth(100);
    this.students.getColumnModel().getColumn(4).setPreferredWidth(100);

    this.scroll = new JScrollPane(this.students);

    this.scroll.getViewport().setBackground(new Color(180, 200, 219));

    this.add(this.scroll);
  }

  public JTable getTable() {
    return this.students;
  }

  /*
   * This method alllows the table to be updated when new students are added
   */
  public void updateTable() {
    String[] title = new String[] { "Name", "ID", "e-mail", "Major", "Tuition" };

    this.s = GetStudents.go();
    int number = this.s.size(), i = 0;

    String[][] data = new String[number][5];

    for (Student st : this.s) {
      data[i][0] = st.getName();
      data[i][1] = st.getID();
      data[i][2] = st.getEMail();
      data[i][3] = st.getMajor();
      data[i][4] = (st.getTuition() ? "Paid" : "Not paid");
      i++;
    }

    this.students = new JTable(data, title);

    this.students.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    this.students.getColumnModel().getColumn(0).setPreferredWidth(180);
    this.students.getColumnModel().getColumn(1).setPreferredWidth(80);
    this.students.getColumnModel().getColumn(2).setPreferredWidth(180);
    this.students.getColumnModel().getColumn(3).setPreferredWidth(80);
    this.students.getColumnModel().getColumn(4).setPreferredWidth(80);

    JScrollPane scroll = new JScrollPane(this.students);

    scroll.getViewport().setBackground(new Color(180, 200, 219));

    this.remove(this.scroll);

    this.scroll = scroll;

    this.add(this.scroll);
    this.revalidate();

  }
}
