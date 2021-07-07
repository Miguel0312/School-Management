package search;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DisplaySpace extends JPanel{
	JLabel n = new JLabel(), i = new JLabel(), e = new JLabel(), m = new JLabel(), t = new JLabel();
	
	public DisplaySpace() {
		Font font = new Font("Arial", Font.PLAIN, 20);
		this.setBackground(new Color(180,200,219));
		
		Dimension verticalSplit = new Dimension(0,75);
		
		this.setPreferredSize(new Dimension(400, 600));
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JLabel name = new JLabel("Name: ");
		name.setFont(font);
		JLabel id = new JLabel("ID: ");
		id.setFont(font);
		JLabel eMail = new JLabel("e-mail: ");
		eMail.setFont(font);
		JLabel major = new JLabel("Major: ");
		major.setFont(font);
		JLabel tuition = new JLabel("Tuition: ");
		tuition.setFont(font);
		
		
		this.n.setFont(font);
		this.i.setFont(font);
		this.e.setFont(font);
		this.m.setFont(font);
		this.t.setFont(font);
		
		this.add(Box.createVerticalGlue());
		this.add(leftAligned(name, n));
		this.add(Box.createVerticalGlue());
		this.add(leftAligned(id,i));
		this.add(Box.createVerticalGlue());
		this.add(leftAligned(eMail, e));
		this.add(Box.createVerticalGlue());
		this.add(leftAligned(major, m));
		this.add(Box.createVerticalGlue());
		this.add(leftAligned(tuition, t));
		
		this.add(Box.createVerticalGlue());
		
	}
	
	public void setName(String s) {
		this.n.setText(s);
	}
	
	public void setID(String s) {
		this.i.setText(s);
	}
	
	public void setEMail(String s) {
		this.e.setText(s);
	}
	
	public void setMajor(String s) {
		this.m.setText(s);
	}
	
	public void setTuition(Boolean b) {
		try {
		if(b)
			this.t.setText("Paid");
		else
			this.t.setText("Not paid");
		}catch(NullPointerException e) {
			this.t.setText("");
		}
	}
	
	private static Box leftAligned(JLabel l1, JLabel l2) {
		Box b = Box.createHorizontalBox();
		
		b.add(l1);
		b.add(l2);
		b.add(Box.createHorizontalGlue());
		
		return b;
	}
}
