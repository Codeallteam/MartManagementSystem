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
import javax.swing.ImageIcon;
import java.awt.Cursor;


public class managerCategoryUpdateFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public managerCategoryUpdateFrame(final String managerName) {
		setTitle("Update Category");
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
		
		JLabel lblUpdateCategories = new JLabel("UPDATE CATEGORIES");
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
		
		JLabel label = new JLabel(managerName);
		label.setHorizontalTextPosition(SwingConstants.RIGHT);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(0, 0, 425, 25);
		panel_1.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(100, 130, 250, 60);
		contentPane.add(panel_2);
		
		JButton btnUpdateEmployee = new JButton("UPDATE EMPLOYEE");
		btnUpdateEmployee.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdateEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							managerSearchEmployeeUpdate frame = new managerSearchEmployeeUpdate(managerName);
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
		btnUpdateEmployee.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdateEmployee.setFocusable(false);
		btnUpdateEmployee.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnUpdateEmployee.setBackground(Color.LIGHT_GRAY);
		btnUpdateEmployee.setBounds(80, 12, 160, 35);
		panel_2.add(btnUpdateEmployee);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\java-eclipse\\Selected\\icons\\updateEmployee.png"));
		label_1.setBounds(0, 0, 60, 60);
		panel_2.add(label_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_3.setBackground(Color.GRAY);
		panel_3.setBounds(100, 225, 250, 60);
		contentPane.add(panel_3);
		
		JButton btnUpdateProduct = new JButton("UPDATE PRODUCT");
		btnUpdateProduct.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdateProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							managerSearchProductUpdate frame = new managerSearchProductUpdate(managerName);
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
		btnUpdateProduct.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdateProduct.setFocusable(false);
		btnUpdateProduct.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnUpdateProduct.setBackground(Color.LIGHT_GRAY);
		btnUpdateProduct.setBounds(80, 12, 160, 35);
		panel_3.add(btnUpdateProduct);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("D:\\java-eclipse\\Selected\\icons\\updateFile.png"));
		label_2.setBounds(5, 4, 60, 58);
		panel_3.add(label_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.GRAY);
		panel_4.setBounds(144, 301, 180, 60);
		contentPane.add(panel_4);
		
		final JButton button = new JButton("Back");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button){
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								managerCategoriesSelectedFrame mff = new managerCategoriesSelectedFrame(managerName);
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
		button.setBounds(35, 15, 110, 30);
		panel_4.add(button);
	}

}
