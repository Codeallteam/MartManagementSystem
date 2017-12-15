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
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;


public class managerCategoriesSearchFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public managerCategoriesSearchFrame(final String managerName) {
		setTitle("Search Categories");
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
		
		JLabel lblSearchCategories = new JLabel("SEARCH CATEGORIES");
		lblSearchCategories.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchCategories.setForeground(Color.WHITE);
		lblSearchCategories.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblSearchCategories.setBounds(0, 0, 434, 70);
		panel.add(lblSearchCategories);
		
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
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(100, 130, 250, 60);
		contentPane.add(panel_2);
		
		JButton btnSearchEmployee = new JButton("SEARCH EMPLOYEE");
		btnSearchEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							managerSearchEmployee frame = new managerSearchEmployee(managerName);
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnSearchEmployee.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearchEmployee.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearchEmployee.setFocusable(false);
		btnSearchEmployee.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnSearchEmployee.setBackground(Color.LIGHT_GRAY);
		btnSearchEmployee.setBounds(80, 12, 160, 35);
		panel_2.add(btnSearchEmployee);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\java-eclipse\\Selected\\icons\\searchEmployee.png"));
		label.setBounds(5, 0, 60, 60);
		panel_2.add(label);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_3.setBackground(Color.GRAY);
		panel_3.setBounds(100, 225, 250, 60);
		contentPane.add(panel_3);
		
		JButton btnSearchProduct = new JButton("SEARCH PRODUCT");
		btnSearchProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							managerSearchProduct frame = new managerSearchProduct(managerName);
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnSearchProduct.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearchProduct.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearchProduct.setFocusable(false);
		btnSearchProduct.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnSearchProduct.setBackground(Color.LIGHT_GRAY);
		btnSearchProduct.setBounds(80, 12, 160, 35);
		panel_3.add(btnSearchProduct);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("D:\\java-eclipse\\Selected\\icons\\searchProduct.png"));
		label_2.setBounds(5, 4, 60, 58);
		panel_3.add(label_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.GRAY);
		panel_4.setBounds(144, 301, 180, 60);
		contentPane.add(panel_4);
		
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
		panel_4.add(button_2);
	}
}
