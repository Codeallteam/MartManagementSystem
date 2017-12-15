import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JTextField;


public class managerCategoriesUpdateFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					managerCategoriesUpdateFrame frame = new managerCategoriesUpdateFrame();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public managerCategoriesUpdateFrame() {
		setTitle("Select Categories");
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
		
		JLabel lblUpdateCategories = new JLabel("SELECT PRODUCT");
		lblUpdateCategories.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateCategories.setForeground(Color.WHITE);
		lblUpdateCategories.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblUpdateCategories.setBounds(0, 0, 434, 70);
		panel.add(lblUpdateCategories);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(0, 70, 434, 25);
		contentPane.add(panel_1);
		
		JLabel label = new JLabel("<dynamic>");
		label.setHorizontalTextPosition(SwingConstants.RIGHT);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(0, 0, 425, 25);
		panel_1.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(52, 155, 330, 116);
		contentPane.add(panel_2);
		
		JLabel label_1 = new JLabel("Product ID");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(10, 0, 120, 22);
		panel_2.add(label_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setColumns(10);
		textField.setBorder(new LineBorder(Color.BLACK, 2));
		textField.setBounds(10, 25, 310, 35);
		panel_2.add(textField);
		
		JButton btnSelect = new JButton("SELECT PRODUCT");
		btnSelect.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSelect.setFocusable(false);
		btnSelect.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnSelect.setBackground(Color.LIGHT_GRAY);
		btnSelect.setBounds(10, 80, 150, 35);
		panel_2.add(btnSelect);
		
		JButton button_2 = new JButton("Back");
		button_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_2.setFocusable(false);
		button_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		button_2.setBackground(Color.LIGHT_GRAY);
		button_2.setBounds(170, 80, 150, 35);
		panel_2.add(button_2);
	}
}
