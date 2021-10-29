package add;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
  *This is the JFrame that contains the panel used to add a new student (AddSpace) and the one that lists all registered students (ListSpace)
*/
public class AddWindow extends JFrame {

  public AddWindow() {
    this.setTitle("School Management");
    this.setSize(800, 600);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    JPanel pane = new JPanel();
    pane.setLayout(new BoxLayout(pane, BoxLayout.LINE_AXIS));
    pane.setBackground(new Color(180, 200, 219));

    ListSpace l = new ListSpace();

    pane.add(new AddSpace(l));
    pane.add(l);

    this.setContentPane(pane);

    this.setVisible(true);
  }
}
