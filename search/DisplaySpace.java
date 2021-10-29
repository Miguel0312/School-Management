package search;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import people.Student;

/*
*This is the panel where the information about the current student will be displayed
*/
public class DisplaySpace extends JPanel {
  private JLabel name = new JLabel(), id = new JLabel(), eMail = new JLabel(), major = new JLabel(),
      tuition = new JLabel();
  private SearchWindow owner;

  public DisplaySpace(SearchWindow owner) {
    this.owner = owner;

    Font font = new Font("Arial", Font.PLAIN, 20);
    this.setBackground(new Color(180, 200, 219));

    this.setPreferredSize(new Dimension(400, 600));
    this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

    JLabel name = new JLabel("Name: ");
    name.setFont(font);
    JLabel id = new JLabel("ID: ");
    id.setFont(font);
    JLabel eMail = new JLabel("e-mail: ");
    eMail.setFont(font);
    JLabel major = new JLabel("Major: ");
    major.setFont(font);
    JLabel tuition = new JLabel("Tuition: ");
    tuition.setFont(font);

    this.name.setFont(font);
    this.id.setFont(font);
    this.eMail.setFont(font);
    this.major.setFont(font);
    this.tuition.setFont(font);

    this.add(Box.createVerticalGlue());
    this.add(leftAligned(name, this.name));
    this.add(Box.createVerticalGlue());
    this.add(leftAligned(id, this.id));
    this.add(Box.createVerticalGlue());
    this.add(leftAligned(eMail, this.eMail));
    this.add(Box.createVerticalGlue());
    this.add(leftAligned(major, this.major));
    this.add(Box.createVerticalGlue());
    this.add(leftAligned(tuition, this.tuition));

    this.add(Box.createVerticalGlue());

  }

  public void setName(String s) {
    this.name.setText(s);
  }

  public void setID(String s) {
    this.id.setText(s);
  }

  public void setEMail(String s) {
    this.eMail.setText(s);
  }

  public void setMajor(String s) {
    this.major.setText(s);
  }

  public SearchWindow getOwner() {
    return this.owner;
  }

  public void setTuition(Boolean b) {
    try {
      if (b)
        this.tuition.setText("Paid");
      else
        this.tuition.setText("Not paid");
    } catch (NullPointerException e) {
      this.tuition.setText("");
    }
  }

  /*
   * This method will retrieve the target student stored at the SearchWindow and
   * display its informations to the user
   * 
   * The if/else block to set the tuition message allows the representation of a
   * student that has no information, effectively cleaning up the display are both
   * for when the window is first opened and for when the selected student is
   * deleted.
   */
  public void displayStudent() {
    Student student = owner.getStudent();
    setName(student.getName());
    setID(student.getID());
    setEMail(student.getEMail());
    setMajor(student.getMajor());
    if (!student.getName().equals(""))
      setTuition(student.getTuition());
    else
      setTuition(null);
  }

  private static Box leftAligned(JLabel l1, JLabel l2) {
    Box b = Box.createHorizontalBox();

    b.add(l1);
    b.add(l2);
    b.add(Box.createHorizontalGlue());

    return b;
  }
}
