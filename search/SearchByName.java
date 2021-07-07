package search;
import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

import people.Student;

public class SearchByName extends JButton{
	private ArrayList<Student> school;
	public SearchByName(JTextField t, DisplaySpace d, ArrayList<Student> s) {
		this.setText("Search by name");
		this.setPreferredSize(new Dimension(130,50));
		this.school = s;
		this.addActionListener(new Search(t,d,s));
	}
	
	class Search implements ActionListener{
		private ArrayList<Student> school = new ArrayList<Student>();
		private DisplaySpace d;
		private JTextField input;
		
		public Search(JTextField t, DisplaySpace d, ArrayList<Student> s) {
			this.school = s;
			this.input = t;
			this.d = d;
		}
		
		public void actionPerformed(ActionEvent e) {
			String s = this.input.getText();
			boolean found = false;
			
			this.d.setName("");
			this.d.setID("");
			this.d.setEMail("");
			this.d.setMajor("");
			this.d.setTuition(null);
			this.input.setText("");
			try {
			for(Student st : this.school) {
				if(st.getName().equals(s)){
					this.d.setName(st.getName());
					this.d.setID(st.getID());
					this.d.setEMail(st.getEMail());
					this.d.setMajor(st.getMajor());
					this.d.setTuition(st.getTuition());
					found = true;
				}
				}
			}catch(NullPointerException n) {}
			try {
			if(!found)
				new NotFoundError('n');
			}catch(NullPointerException n) {
				new NotFoundError('n');
			}
		}
	}
}