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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.ImageIcon;


public class managerCategoriesDeleteFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public managerCategoriesDeleteFrame(final String managerName) {
		setTitle("Delete Categories");
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
		
		JLabel lblDeleteCategories = new JLabel("DELETE CATEGORIES");
		lblDeleteCategories.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteCategories.setForeground(Color.WHITE);
		lblDeleteCategories.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDeleteCategories.setBounds(0, 0, 434, 70);
		panel.add(lblDeleteCategories);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(100, 130, 250, 60);
		contentPane.add(panel_1);
		
		JButton btnDeleteEmployee = new JButton("DELETE EMPLOYEE");
		btnDeleteEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								managerDeleteEmployee frame = new managerDeleteEmployee(managerName);
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
		btnDeleteEmployee.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDeleteEmployee.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDeleteEmployee.setFocusable(false);
		btnDeleteEmployee.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnDeleteEmployee.setBackground(Color.LIGHT_GRAY);
		btnDeleteEmployee.setBounds(80, 12, 160, 35);
		panel_1.add(btnDeleteEmployee);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\java-eclipse\\Selected\\icons\\deleteEmployee.png"));
		label.setBounds(0, 0, 60, 60);
		panel_1.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(100, 225, 250, 60);
		contentPane.add(panel_2);
		
		JButton btnDeleteProduct = new JButton("DELETE PRODUCT");
		btnDeleteProduct.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDeleteProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								managerDeleteProduct frame = new managerDeleteProduct(managerName);
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
		btnDeleteProduct.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDeleteProduct.setFocusable(false);
		btnDeleteProduct.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnDeleteProduct.setBackground(Color.LIGHT_GRAY);
		btnDeleteProduct.setBounds(80, 12, 160, 35);
		panel_2.add(btnDeleteProduct);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\java-eclipse\\Selected\\icons\\deleteProduct.png"));
		label_1.setBounds(5, 4, 60, 58);
		panel_2.add(label_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.GRAY);
		panel_3.setBounds(144, 301, 180, 60);
		contentPane.add(panel_3);
		
		JButton button_2 = new JButton("Back");
		button_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								managerCategoriesSelectedFrame frame = new managerCategoriesSelectedFrame(managerName);
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
		button_2.setHorizontalTextPosition(SwingConstants.CENTER);
		button_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_2.setFocusable(false);
		button_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		button_2.setBackground(Color.LIGHT_GRAY);
		button_2.setBounds(35, 15, 110, 30);
		panel_3.add(button_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.GRAY);
		panel_4.setBounds(0, 70, 434, 25);
		contentPane.add(panel_4);
		
		JLabel label_2 = new JLabel(managerName);
		label_2.setHorizontalTextPosition(SwingConstants.RIGHT);
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(0, 0, 425, 25);
		panel_4.add(label_2);
	}

}
