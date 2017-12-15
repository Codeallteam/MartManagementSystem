import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class succesfullAddProduct extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public succesfullAddProduct(final String managerName , String productName, String productId, String productRate, String productQuantity) {
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
		
		JLabel label = new JLabel("ADD SUCCESSFUL");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 24));
		label.setBounds(0, 0, 434, 70);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(51, 136, 300, 200);
		contentPane.add(panel_1);
		
		JLabel lblProductname = new JLabel("Productname : ");
		lblProductname.setHorizontalTextPosition(SwingConstants.CENTER);
		lblProductname.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductname.setForeground(Color.BLACK);
		lblProductname.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblProductname.setBounds(30, 5, 130, 14);
		panel_1.add(lblProductname);
		
		JLabel label_2 = new JLabel(productName);
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label_2.setBounds(160, 3, 160, 18);
		panel_1.add(label_2);
		
		JLabel lblProductId = new JLabel("Product ID : ");
		lblProductId.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductId.setForeground(Color.BLACK);
		lblProductId.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblProductId.setBounds(30, 34, 110, 14);
		panel_1.add(lblProductId);
		
		JLabel label_4 = new JLabel(productId);
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label_4.setBounds(140, 31, 160, 19);
		panel_1.add(label_4);
		
		JLabel lblRate = new JLabel("Rate  : ");
		lblRate.setHorizontalAlignment(SwingConstants.LEFT);
		lblRate.setForeground(Color.BLACK);
		lblRate.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRate.setBounds(40, 63, 70, 14);
		panel_1.add(lblRate);
		
		JLabel label_6 = new JLabel(productRate);
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label_6.setBounds(110, 60, 100, 18);
		panel_1.add(label_6);
		
		JLabel lblQuantity = new JLabel("Quantity  : ");
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setForeground(Color.BLACK);
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblQuantity.setBounds(30, 93, 100, 14);
		panel_1.add(lblQuantity);
		
		JLabel label_8 = new JLabel(productQuantity);
		label_8.setHorizontalAlignment(SwingConstants.LEFT);
		label_8.setForeground(Color.BLACK);
		label_8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label_8.setBounds(140, 90, 100, 18);
		panel_1.add(label_8);
		
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
		panel_1.add(button);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(0, 70, 434, 25);
		contentPane.add(panel_2);
		
		JLabel label_9 = new JLabel(managerName);
		label_9.setHorizontalTextPosition(SwingConstants.RIGHT);
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_9.setBounds(0, 0, 425, 25);
		panel_2.add(label_9);
	}
}
