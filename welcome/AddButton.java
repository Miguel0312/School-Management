package welcome;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import add.AddWindow;

public class AddButton extends JButton {
  AddButton() {
    this.setText("Add Student");
    this.addActionListener(new addStudentWindow());
  }
}

class addStudentWindow implements ActionListener {
  public void actionPerformed(ActionEvent a) {
    new AddWindow();
  }
}
