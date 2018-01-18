package id.ac.booklist.gui;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CobaForm extends JFrame{
	public CobaForm() {
		setMinimumSize(new Dimension(200, 200));
		getContentPane().setLayout(null);
		
		JButton btnBackToMain = new JButton("Back to Main");
		btnBackToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnBackToMain.setBounds(37, 71, 110, 23);
		getContentPane().add(btnBackToMain);
	}

}
