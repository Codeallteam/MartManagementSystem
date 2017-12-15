import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import com.mysql.jdbc.Driver;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class managerAddEmployee extends JFrame {
	Connection conn = null;
	PreparedStatement pstmt = null;
	private JPanel contentPane;
	private JTextField addEmplyeeFirstName;
	private JTextField addEmplyeeLastName;
	private JTextField addEmployeeEmailAddress;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public managerAddEmployee(final String managerName) {
		setTitle("Add Employee");
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
		
		JLabel lblNewLabel = new JLabel("ADD EMPLOYEE");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 434, 70);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(52, 110, 330, 260);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		addEmplyeeFirstName = new JTextField();
		addEmplyeeFirstName.setBorder(new LineBorder(Color.BLACK, 2));
		addEmplyeeFirstName.setFont(new Font("Tahoma", Font.BOLD, 14));
		addEmplyeeFirstName.setBounds(10, 25, 150, 35);
		panel_1.add(addEmplyeeFirstName);
		addEmplyeeFirstName.setColumns(10);
		
		addEmplyeeLastName = new JTextField();
		addEmplyeeLastName.setBorder(new LineBorder(Color.BLACK, 2));
		addEmplyeeLastName.setFont(new Font("Tahoma", Font.BOLD, 14));
		addEmplyeeLastName.setColumns(10);
		addEmplyeeLastName.setBounds(170, 25, 150, 35);
		panel_1.add(addEmplyeeLastName);
		
		addEmployeeEmailAddress = new JTextField();
		addEmployeeEmailAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		addEmployeeEmailAddress.setBorder(new LineBorder(Color.BLACK, 2));
		addEmployeeEmailAddress.setBounds(10, 90, 310, 35);
		panel_1.add(addEmployeeEmailAddress);
		addEmployeeEmailAddress.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFirstName.setBounds(10, 3, 100, 22);
		panel_1.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLastName.setBounds(170, 3, 100, 22);
		panel_1.add(lblLastName);
		
		JLabel lblMobileNumber = new JLabel("Email Address");
		lblMobileNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMobileNumber.setBounds(10, 68, 100, 22);
		panel_1.add(lblMobileNumber);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new LineBorder(Color.BLACK, 2));
		passwordField.setBounds(10, 155, 310, 35);
		panel_1.add(passwordField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(10, 132, 100, 22);
		panel_1.add(lblPassword);
		
		JButton btnAddEmployee = new JButton("Create Account");
		btnAddEmployee.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final String firstName = addEmplyeeFirstName.getText().trim();
				final String lastName = addEmplyeeLastName.getText().trim();
				final String emailAddress = addEmployeeEmailAddress.getText().trim();
				final String password = passwordField.getText().trim();
				
				if(firstName.equals("") || lastName.equals("") || emailAddress.equals("") || password.equals("")){
					JOptionPane.showMessageDialog(null, "Please Fill the Given Field");
					addEmplyeeFirstName.setText("");
					addEmplyeeLastName.setText("");
					addEmployeeEmailAddress.setText("");
					passwordField.setText("");
				}
				else{
					try{
						Class.forName(mainMethodClass.JDBC_DRIVER);
						conn = DriverManager.getConnection(mainMethodClass.DB_URL , "root" , "root");
						pstmt = conn.prepareStatement("INSERT INTO manager_add_employee(first_name,last_name,email_address,password) VALUE(?,?,?,?)");
						pstmt.setString(1, firstName);
						pstmt.setString(2, lastName);
						pstmt.setString(3, emailAddress);
						pstmt.setString(4, password);
						int i = pstmt.executeUpdate();
						if(i > 0){
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										succesfullAddEmployee frame = new succesfullAddEmployee(managerName, firstName, lastName, emailAddress, password);
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
							JOptionPane.showMessageDialog(null, "Database Error");
						}
					}catch(Exception e){
						JOptionPane.showMessageDialog(null, e);
					}
				}

			}
		});
		btnAddEmployee.setBackground(Color.LIGHT_GRAY);
		btnAddEmployee.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnAddEmployee.setFocusable(false);
		btnAddEmployee.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddEmployee.setBounds(10, 211, 150, 35);
		panel_1.add(btnAddEmployee);
		
		JButton btnBack = new JButton("Back");
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBack.addActionListener(new ActionListener() {
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
		btnBack.setBackground(Color.LIGHT_GRAY);
		btnBack.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnBack.setFocusable(false);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(170, 211, 150, 35);
		panel_1.add(btnBack);
		
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
