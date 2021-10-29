package add;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
  *This is the JPanel that contains the JTextFields needed to register a new student and the buttons to clear these text fields (ClearButton) and to effectively add a new student (AddButton)
 */
public class AddSpace extends JPanel {
  public AddSpace(ListSpace l) {
    this.setBackground(new Color(180, 200, 219));
    this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    this.setMaximumSize(new Dimension(400, 600));
    Font font = new Font("Arial", Font.PLAIN, 20);

    File f = new File("school.txt");

    Dimension horizontalBoxSize = new Dimension(0, 50);
    Dimension verticalBoxSize = new Dimension(30, 40);
    Dimension inputDimension = new Dimension(250, 40);

    JPanel p1 = new JPanel();
    p1.setLayout(new BoxLayout(p1, BoxLayout.LINE_AXIS));
    p1.setBackground(new Color(180, 200, 219));
    JLabel name = new JLabel("Name:  ");
    name.setFont(font);
    JTextField n = new JTextField();
    n.setMaximumSize(inputDimension);
    n.setFont(font);
    n.setPreferredSize(new Dimension(400, 40));

    p1.add(Box.createRigidArea(horizontalBoxSize));
    p1.add(name);
    p1.add(n);
    p1.add(Box.createRigidArea(horizontalBoxSize));

    JPanel p2 = new JPanel();
    p2.setLayout(new BoxLayout(p2, BoxLayout.LINE_AXIS));
    p2.setBackground(new Color(180, 200, 219));
    JLabel id = new JLabel("ID:       ");
    id.setFont(font);
    JTextField i = new JTextField();
    i.setFont(font);
    i.setMaximumSize(inputDimension);
    i.setPreferredSize(new Dimension(400, 40));

    p2.add(Box.createRigidArea(horizontalBoxSize));
    p2.add(id);
    p2.add(i);
    p2.add(Box.createRigidArea(horizontalBoxSize));

    JPanel p3 = new JPanel();
    p3.setLayout(new BoxLayout(p3, BoxLayout.LINE_AXIS));
    p3.setBackground(new Color(180, 200, 219));
    JLabel eMail = new JLabel("e-mail: ");
    eMail.setFont(font);
    JTextField e = new JTextField();
    e.setMaximumSize(inputDimension);
    e.setFont(font);
    e.setPreferredSize(new Dimension(400, 40));

    p3.add(Box.createRigidArea(horizontalBoxSize));
    p3.add(eMail);
    p3.add(e);
    p3.add(Box.createRigidArea(horizontalBoxSize));

    JPanel p4 = new JPanel();
    p4.setLayout(new BoxLayout(p4, BoxLayout.LINE_AXIS));
    p4.setBackground(new Color(180, 200, 219));
    JLabel major = new JLabel("Major:  ");
    major.setFont(font);
    JTextField m = new JTextField();
    m.setMaximumSize(inputDimension);
    m.setFont(font);
    m.setPreferredSize(new Dimension(400, 40));

    p4.add(Box.createRigidArea(horizontalBoxSize));
    p4.add(major);
    p4.add(m);
    p4.add(Box.createRigidArea(horizontalBoxSize));

    JPanel p5 = new JPanel();
    p5.setLayout(new BoxLayout(p5, BoxLayout.LINE_AXIS));
    p5.setBackground(new Color(180, 200, 219));
    JLabel tuition = new JLabel("Tuition: ");
    tuition.setFont(font);
    JTextField t = new JTextField();
    t.setMaximumSize(inputDimension);
    t.setFont(font);
    t.setPreferredSize(new Dimension(400, 40));

    p5.add(Box.createRigidArea(horizontalBoxSize));
    p5.add(tuition);
    p5.add(t);
    p5.add(Box.createRigidArea(horizontalBoxSize));

    JPanel buttons = new JPanel();
    buttons.setLayout(new BoxLayout(buttons, BoxLayout.LINE_AXIS));
    buttons.setBackground(new Color(180, 200, 219));

    JTextField[] fields = new JTextField[] { n, i, e, m, t };

    ClearButton b1 = new ClearButton(fields);
    AddButton b2 = new AddButton(n, i, e, m, t, f, l);

    buttons.add(b1);
    buttons.add(Box.createRigidArea(new Dimension(30, 0)));
    buttons.add(b2);

    this.add(Box.createRigidArea(verticalBoxSize));
    this.add(p1);
    this.add(Box.createRigidArea(verticalBoxSize));
    this.add(p2);
    this.add(Box.createRigidArea(verticalBoxSize));
    this.add(p3);
    this.add(Box.createRigidArea(verticalBoxSize));
    this.add(p4);
    this.add(Box.createRigidArea(verticalBoxSize));
    this.add(p5);
    this.add(Box.createRigidArea(verticalBoxSize));
    this.add(buttons);
  }

}
