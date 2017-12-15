import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class succesfullUpdateEmployee extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.

	/**
	 * Create the frame.
	 */
	public succesfullUpdateEmployee(final String managerName, String firstName, String lastName, String emailAddress, String password) {
		setTitle("Succesful");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 434, 70);
		contentPane.add(panel);
		
		JLabel label = new JLabel("UPDATE SUCCESSFUL");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 24));
		label.setBounds(0, 0, 434, 70);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(0, 70, 434, 25);
		contentPane.add(panel_1);
		
		JLabel label_1 = new JLabel(managerName);
		label_1.setHorizontalTextPosition(SwingConstants.RIGHT);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(0, 0, 425, 25);
		panel_1.add(label_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(67, 150, 350, 200);
		contentPane.add(panel_2);
		
		JLabel label_2 = new JLabel("Firstname : ");
		label_2.setHorizontalTextPosition(SwingConstants.CENTER);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_2.setBounds(30, 5, 100, 14);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel(firstName);
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label_3.setBounds(140, 2, 160, 18);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("Lastname : ");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_4.setBounds(30, 34, 100, 14);
		panel_2.add(label_4);
		
		JLabel label_5 = new JLabel(lastName);
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label_5.setBounds(140, 31, 160, 18);
		panel_2.add(label_5);
		
		JLabel label_6 = new JLabel("Email  : ");
		label_6.setHorizontalAlignment(SwingConstants.LEFT);
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_6.setBounds(40, 63, 70, 14);
		panel_2.add(label_6);
		
		JLabel label_7 = new JLabel(emailAddress);
		label_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_7.setForeground(Color.BLACK);
		label_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label_7.setBounds(110, 60, 240, 18);
		panel_2.add(label_7);
		
		JLabel label_8 = new JLabel("Password  : ");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setForeground(Color.BLACK);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_8.setBounds(30, 93, 100, 14);
		panel_2.add(label_8);
		
		JLabel label_9 = new JLabel(password);
		label_9.setHorizontalAlignment(SwingConstants.LEFT);
		label_9.setForeground(Color.BLACK);
		label_9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label_9.setBounds(140, 90, 160, 18);
		panel_2.add(label_9);
		
		JButton button = new JButton("OK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							managerCategoriesAddFrame frame = new managerCategoriesAddFrame(managerName);
							frame.setVisible(true);
							frame.setLocationRelativeTo(null);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.setFocusable(false);
		button.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(90, 140, 120, 35);
		panel_2.add(button);
	}

}
