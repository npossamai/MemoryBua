import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectLevel {
	public SelectLevel () {
		JFrame frame = new JFrame("Memory");
		//frame.DISPOSE_ON_CLOSE
		frame.setLayout(new BorderLayout());
		JLabel label = new JLabel("Seleziona livello: ", SwingConstants.LEFT);
		frame.add(label,BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		frame.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(1, 3, 10, 10));
		
		JButton btnNewButton_0 = new JButton();
		btnNewButton_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//frame.remove(panel_1);
				frame.remove(panel_1);
				frame.remove(label);
				Memory.run(frame,8);
			}
		});
		btnNewButton_0.setIcon(new ImageIcon("src/png01.png"));
		panel_1.add(btnNewButton_0);
		
		JButton btnNewButton_1 = new JButton();
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.remove(panel_1);
				frame.remove(label);
				Memory.run(frame,12);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("src/png02.png"));
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton();
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.remove(panel_1);
				frame.remove(label);
				Memory.run(frame,24);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("src/png03.png"));
		panel_1.add(btnNewButton_2);
		
		
		
		
		frame.setVisible(true);
		frame.setSize(340, 158);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

