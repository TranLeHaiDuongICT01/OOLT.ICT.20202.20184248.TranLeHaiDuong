package hust.soict.globalict.aims;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class PlayError extends JFrame {
	private JFrame frame;
	private static final long serialVersionUID = 1L;
	public PlayError(String a,String b,String c) {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 121, 482, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblNewLabel = new JLabel(b);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(25, 33, 248, 57);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(c);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(25, 162, 307, 57);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(361, 258, 85, 44);
		frame.getContentPane().add(btnNewButton);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setTitle(a);
		frame.setSize(501,349);
		frame.setVisible(true);
	}
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			@Override
//			public void run() {
//				new PlayError("","","");
//			}
//		});
//	}
}