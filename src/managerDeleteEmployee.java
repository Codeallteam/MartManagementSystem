import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class managerDeleteEmployee extends JFrame {
	Connection conn = null;
	PreparedStatement pstmt = null;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public managerDeleteEmployee(final String managerName) {
		setTitle("Delete Employee");
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
		
		JLabel lblDeleteEmployee = new JLabel("DELETE EMPLOYEE");
		lblDeleteEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteEmployee.setForeground(Color.WHITE);
		lblDeleteEmployee.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDeleteEmployee.setBounds(0, 0, 434, 70);
		panel.add(lblDeleteEmployee);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(52, 155, 330, 116);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblEmployeeName = new JLabel("Employee Email");
		lblEmployeeName.setBounds(10, 0, 120, 22);
		panel_1.add(lblEmployeeName);
		lblEmployeeName.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setColumns(10);
		textField.setBorder(new LineBorder(Color.BLACK, 2));
		textField.setBounds(10, 25, 310, 35);
		panel_1.add(textField);
		
		JButton btnDeleteAccount = new JButton("Delete Account");
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String employeeName = textField.getText().trim();
				try{
					Class.forName(mainMethodClass.JDBC_DRIVER);
					conn = DriverManager.getConnection(mainMethodClass.DB_URL, "root", "");
					pstmt = conn.prepareStatement("DELETE FROM manager_add_employee WHERE email_address = ?");
					pstmt.setString(1, employeeName);
					int i = pstmt.executeUpdate();
					if(i > 0){
						JOptionPane.showMessageDialog(null, "Successful Delete" + employeeName + "Employee");
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									managerCategoriesDeleteFrame frame = new managerCategoriesDeleteFrame(managerName);
									frame.setVisible(true);
									frame.setLocationRelativeTo(null);
									dispose();
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
						
					}
					else{
						JOptionPane.showMessageDialog(null, "Invalid Username");
						textField.setText("");
					}
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnDeleteAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDeleteAccount.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDeleteAccount.setFocusable(false);
		btnDeleteAccount.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnDeleteAccount.setBackground(Color.LIGHT_GRAY);
		btnDeleteAccount.setBounds(10, 80, 150, 35);
		panel_1.add(btnDeleteAccount);
		
		JButton button_1 = new JButton("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								managerCategoriesDeleteFrame frame = new managerCategoriesDeleteFrame(managerName);
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
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_1.setFocusable(false);
		button_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.setBounds(170, 80, 150, 35);
		panel_1.add(button_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(0, 70, 434, 25);
		contentPane.add(panel_2);
		
		JLabel label = new JLabel(managerName);
		label.setHorizontalTextPosition(SwingConstants.RIGHT);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(0, 0, 425, 25);
		panel_2.add(label);
	}
}
