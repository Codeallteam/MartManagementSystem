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


public class succesfullUpdateProduct extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public succesfullUpdateProduct(final String managerName , String updateProductName, String updateProductId, String updateRate, String updateQuantity) {
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
		
		JLabel lblUpdateSuccessful = new JLabel("UPDATE SUCCESSFUL");
		lblUpdateSuccessful.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateSuccessful.setForeground(Color.WHITE);
		lblUpdateSuccessful.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblUpdateSuccessful.setBounds(0, 0, 434, 70);
		panel.add(lblUpdateSuccessful);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(51, 136, 300, 200);
		contentPane.add(panel_1);
		
		JLabel label = new JLabel("Productname : ");
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(30, 5, 130, 14);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel(updateProductName);
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label_1.setBounds(160, 3, 160, 18);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Product ID : ");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_2.setBounds(30, 34, 110, 14);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel(updateProductId);
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label_3.setBounds(140, 31, 160, 19);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("Rate  : ");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_4.setBounds(40, 63, 70, 14);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel(updateRate);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label_5.setBounds(110, 60, 100, 18);
		panel_1.add(label_5);
		
		JLabel label_6 = new JLabel("Quantity  : ");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_6.setBounds(30, 93, 100, 14);
		panel_1.add(label_6);
		
		JLabel label_7 = new JLabel(updateQuantity);
		label_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_7.setForeground(Color.BLACK);
		label_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label_7.setBounds(140, 90, 100, 18);
		panel_1.add(label_7);
		
		final JButton button = new JButton("OK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button){
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								managerCategoryUpdateFrame mff = new managerCategoryUpdateFrame(managerName);
								mff.setLocationRelativeTo(null);
								mff.setVisible(true);
								dispose();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			}
		});
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.setFocusable(false);
		button.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(90, 140, 120, 35);
		panel_1.add(button);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(0, 70, 434, 25);
		contentPane.add(panel_2);
		
		JLabel label_8 = new JLabel(managerName);
		label_8.setHorizontalTextPosition(SwingConstants.RIGHT);
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_8.setBounds(0, 0, 425, 25);
		panel_2.add(label_8);
	}
}
