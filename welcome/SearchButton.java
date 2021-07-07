package welcome;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import file.GetStudents;
import people.Student;

public class SearchButton extends JButton{
	private ArrayList<Student> school;
	SearchButton(ArrayList<Student> s){
		this.school = s;
		
		this.setText("Search Student");
		this.addActionListener(new a(s));
	}	
}

class a implements ActionListener{
	private ArrayList<Student> school;
	public a(ArrayList<Student> s) {
		this.school = s;
	}
	
	public void actionPerformed(ActionEvent a){
		new search.SearchWindow(GetStudents.go());
	}
}
