package welcome;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import file.GetStudents;
import people.Student;

public class WelcomeWindow extends JFrame{
	ArrayList<Student> school = new ArrayList<Student>();
	File f = new File("school.txt");
	
	public static void main(String[] args) {
		new WelcomeWindow();
	}
	
	public WelcomeWindow() {
		
		
		this.setSize(300, 100);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("School Management");
		
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		
		JLabel l1 = new JLabel("What do you want to do?");
		
		JPanel label = new JPanel();	
		label.setLayout(new BoxLayout(label, BoxLayout.LINE_AXIS));
		
		label.add(Box.createHorizontalGlue());
		label.add(l1);
		label.add(Box.createHorizontalGlue());
		
		JPanel buttons = new JPanel();
		
		AddButton b1 = new AddButton();
		SearchButton b2 = new SearchButton(GetStudents.go());
		
		buttons.add(b1);
		buttons.add(b2);
		
		p.add(Box.createVerticalGlue());
		p.add(label);
		p.add(Box.createVerticalGlue());
		p.add(buttons);
		
		this.setContentPane(p);
		this.setVisible(true);
	}
}
