package search;
import java.awt.GridLayout;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFrame;

import people.Student;

public class SearchWindow extends JFrame{
	private ArrayList<Student> school = new ArrayList<Student>();
	
	public SearchWindow(ArrayList<Student> s) {
		this.school = s;
		
		this.setTitle("School Management");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		this.setLayout(new GridLayout(1,2));
		
		DisplaySpace display = new DisplaySpace();
		
		this.add(new SearchSpace(display, this.school));
		this.add(display);
		
		this.setVisible(true);
	}
}
