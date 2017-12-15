import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;

import javax.swing.ImageIcon;


public class managerCategoriesAddFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public managerCategoriesAddFrame(final String managerName) {
		setTitle("Add Categories");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 434, 70);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD CATEGORIES");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 434, 70);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(100, 130, 250, 60);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAddEmployee = new JButton("ADD EMPLOYEE");
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							managerAddEmployee frame = new managerAddEmployee(managerName);
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
		btnAddEmployee.setBackground(Color.LIGHT_GRAY);
		btnAddEmployee.setFocusable(false);
		btnAddEmployee.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddEmployee.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnAddEmployee.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAddEmployee.setBounds(80, 12, 160, 35);
		panel_1.add(btnAddEmployee);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\java-eclipse\\Selected\\icons\\addEmployee.png"));
		lblNewLabel_1.setBounds(0, 0, 60, 60);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBounds(100, 225, 250, 60);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnAddProduct = new JButton("ADD PRODUCT");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								managerAddProduct frame = new managerAddProduct(managerName);
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
		btnAddProduct.setBackground(Color.LIGHT_GRAY);
		btnAddProduct.setFocusable(false);
		btnAddProduct.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAddProduct.setBounds(80, 12, 160, 35);
		btnAddProduct.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddProduct.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.add(btnAddProduct);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\java-eclipse\\Selected\\icons\\adds-add-file-icon.png"));
		label.setBounds(0, 0, 60, 60);
		panel_2.add(label);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.GRAY);
		panel_3.setBounds(144, 301, 180, 60);
		contentPane.add(panel_3);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							managerCategoriesSelectedFrame frame = new managerCategoriesSelectedFrame(managerName);
							frame.setLocationRelativeTo(null);
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnBack.setFocusable(false);
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBack.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnBack.setBackground(Color.LIGHT_GRAY);
		btnBack.setBounds(35, 15, 110, 30);
		panel_3.add(btnBack);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.GRAY);
		panel_4.setBounds(0, 70, 434, 25);
		contentPane.add(panel_4);
		
		JLabel label_1 = new JLabel(managerName);
		label_1.setHorizontalTextPosition(SwingConstants.RIGHT);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(0, 0, 425, 25);
		panel_4.add(label_1);
	}
}
