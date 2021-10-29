package people;

import java.io.Serializable;

/*
 *Each instance of the class Student stores the name, id, eMail, major, and wheter or not the tuition has been payed
 *
 * The implementation of the interface Serializable is what allows us to save the students in a text file
*/
public class Student implements Serializable {
  private String name, id, eMail, major;
  private boolean tuition;

  public Student(String n, String i, String e, String m, boolean t) {
    this.name = n;
    this.id = i;
    this.eMail = e;
    this.major = m;
    this.tuition = t;
  }

  public String getName() {
    return this.name;
  }

  public String getID() {
    return this.id;
  }

  public String getEMail() {
    return this.eMail;
  }

  public String getMajor() {
    return this.major;
  }

  public boolean getTuition() {
    return this.tuition;
  }
}
