package search;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;


/*
  *This is the panel where the user inputs the name or the ID of the student that they are searching and uses one of the buttons to launch the search
*/
public class SearchSpace extends JPanel {

  public SearchSpace(SearchWindow owner, DisplaySpace dSpace) {

    this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    this.setBackground(new Color(180, 200, 219));

    JTextField searchBar = new JTextField();
    searchBar.setSize(new Dimension(200, 40));
    searchBar.setFont(new Font("Arial", Font.PLAIN, 25));
    searchBar.setMaximumSize(new Dimension(300, 40));

    JPanel searchSpace = new JPanel();
    searchSpace.setSize(new Dimension(this.getWidth(), 400));
    searchSpace.setLayout(new BoxLayout(searchSpace, BoxLayout.LINE_AXIS));
    searchSpace.setBackground(new Color(180, 200, 219));

    searchSpace.add(searchBar);

    this.add(Box.createVerticalGlue());

    this.add(searchSpace);

    JPanel buttons = new JPanel();

    SearchStudentButton searchByName = new SearchStudentButton(searchBar, dSpace, false);
    SearchStudentButton searchByID = new SearchStudentButton(searchBar, dSpace, true);
    DelStudent delStudent = new DelStudent(owner, dSpace);

    buttons.add(searchByName);
    buttons.add(searchByID);
    buttons.add(delStudent);
    buttons.setBackground(new Color(180, 200, 219));

    this.add(buttons);

    this.add(Box.createVerticalGlue());
  }
}
