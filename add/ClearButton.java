package add;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class ClearButton extends JButton{
	public ClearButton(JTextField[] i) {
		this.setPreferredSize(new Dimension(90,50));
		this.setText("Clear");
		this.addActionListener(new Clear(i));
	}
}

class Clear implements ActionListener{
	private JTextField[] inputs;
	public Clear(JTextField[] i) {
		this.inputs = i;
	}
	
	public void actionPerformed(ActionEvent a) {
		for(JTextField field: inputs)
			field.setText("");
	}
}
