package add;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import file.GetStudents;
import people.Student;

public class AddButton extends JButton{
	public AddButton(JTextField name, JTextField id, JTextField eMail, JTextField major, JTextField tuition, File f, ListSpace l) {
		this.setText("Add");
		
		this.addActionListener(new Add(name, id, eMail, major, tuition, f, l));
	}
}

class Add implements ActionListener {
	JTextField name, id, eMail, major, t;
	File f;
	ListSpace l;
	public Add(JTextField name, JTextField id, JTextField eMail, JTextField major, JTextField tuition, File f, ListSpace l) {
		this.name = name;
		this.id = id;
		this.eMail = eMail;
		this.major = major;
		this.t = tuition;
		this.f = f;
		this.l = l;
	}
	
	public void actionPerformed(ActionEvent a) {
		ObjectOutputStream oos;
		ArrayList<Student> s = GetStudents.go();
		try {
		oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("school.txt"))));
		for(Student st:s)
			oos.writeObject(st);
		oos.writeObject(new Student(this.name.getText(), this.id.getText(), this.eMail.getText(),this.major.getText(),this.t.getText().toLowerCase().equals("paid")));
		oos.close();
		
		this.name.setText("");
		this.id.setText("");
		this.eMail.setText("");
		this.major.setText("");
		this.t.setText("");
		
		l.updateTable();
		
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
