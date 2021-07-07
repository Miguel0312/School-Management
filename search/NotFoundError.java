package search;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NotFoundError extends JFrame{
	public NotFoundError(char c) {
		JLabel error = new JLabel();
		if(c=='n')
			error.setText("No student was found with this name");
		if(c=='i')
			error.setText("No student was found with this ID");
		error.setFont(new Font("Arial", Font.PLAIN, 20));
		
		this.setSize(400,150);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("Error");
		
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.LINE_AXIS));
		
		p.add(Box.createHorizontalGlue());
		p.add(error);
		p.add(Box.createHorizontalGlue());
		
		JPanel f = new JPanel();
		f.setLayout(new BoxLayout(f,BoxLayout.PAGE_AXIS));
		
		f.add(Box.createVerticalGlue());
		f.add(p);
		f.add(Box.createVerticalGlue());
		
		this.add(f);
		
		this.setVisible(true);
	}
}
