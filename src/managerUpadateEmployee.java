import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import com.mysql.jdbc.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class managerUpadateEmployee extends JFrame {
	String firstName;
	String LastName;
	String emailAddress;
	String password;
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	private JPanel contentPane;
	private JTextField firstname;
	private JTextField lastname;
	private JTextField emailaddress;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public managerUpadateEmployee(final String managerName, final String givenEmailAddress) {
		try{
		      //STEP 2: Register JDBC driver
		      Class.forName(mainMethodClass.JDBC_DRIVER);

		      //STEP 3: Open a connection
		      conn = DriverManager.getConnection(mainMethodClass.DB_URL, "root", "");
		      
		      //STEP 4: Execute a query
		      pstmt = conn.prepareStatement("SELECT first_name, last_name, email_address, password FROM manager_add_employee WHERE email_address = ?");
		      pstmt.setString(1, givenEmailAddress);
		      ResultSet rs = pstmt.executeQuery();

		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		         firstName  = rs.getString("first_name");
		         LastName  = rs.getString("last_name");
		         emailAddress  = rs.getString("email_address");
		         password = rs.getString("password");		         
		      }
		      rs.close();
		   }catch(SQLException se){
		      JOptionPane.showMessageDialog(null, se);
		      se.printStackTrace();
		   }catch(Exception e){
			   JOptionPane.showMessageDialog(null, e);
		      e.printStackTrace();
		   }

		setTitle("Update Employee");
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
		
		JLabel lblUpdateEmployee = new JLabel("UPDATE EMPLOYEE");
		lblUpdateEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateEmployee.setForeground(Color.WHITE);
		lblUpdateEmployee.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblUpdateEmployee.setBounds(0, 0, 434, 70);
		panel.add(lblUpdateEmployee);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(52, 110, 330, 260);
		contentPane.add(panel_1);
		
		firstname = new JTextField();
		firstname.setFont(new Font("Tahoma", Font.BOLD, 14));
		firstname.setColumns(10);
		firstname.setBorder(new LineBorder(Color.BLACK, 2));
		firstname.setBounds(10, 25, 150, 35);
		panel_1.add(firstname);
		firstname.setText(firstName);
		
		lastname = new JTextField();
		lastname.setFont(new Font("Tahoma", Font.BOLD, 14));
		lastname.setColumns(10);
		lastname.setBorder(new LineBorder(Color.BLACK, 2));
		lastname.setBounds(170, 25, 150, 35);
		panel_1.add(lastname);
		lastname.setText(LastName);
		
		emailaddress = new JTextField();
		emailaddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		emailaddress.setColumns(10);
		emailaddress.setBorder(new LineBorder(Color.BLACK, 2));
		emailaddress.setBounds(10, 90, 310, 35);
		panel_1.add(emailaddress);
		emailaddress.setText(emailAddress);
		
		JLabel label_1 = new JLabel("First Name");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(10, 3, 100, 22);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Last Name");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(170, 3, 100, 22);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Email Address");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_3.setBounds(10, 68, 100, 22);
		panel_1.add(label_3);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new LineBorder(Color.BLACK, 2));
		passwordField.setBounds(10, 155, 310, 35);
		panel_1.add(passwordField);
		passwordField.setText(password);
		
		JLabel label_4 = new JLabel("Password");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_4.setBounds(10, 132, 100, 22);
		panel_1.add(label_4);
		
		JButton btnUpdateAccount = new JButton("Update Account");
		btnUpdateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final String updateFirstName = firstname.getText().trim();
				final String updateLastName = lastname.getText().trim();
				final String updateEmailAddress = emailaddress.getText().trim();
				final String updatePassword = passwordField.getText().trim();
				try{
					Class.forName(mainMethodClass.JDBC_DRIVER);
					conn = DriverManager.getConnection(mainMethodClass.DB_URL,"root","");
					pstmt = conn.prepareStatement("UPDATE manager_add_employee SET first_name = ? ,last_name = ?,email_address = ? ,password = ? WHERE email_address = ?");
					pstmt.setString(1, updateFirstName);
					pstmt.setString(2, updateLastName);
					pstmt.setString(3, updateEmailAddress);
					pstmt.setString(4, updatePassword);
					pstmt.setString(5, givenEmailAddress);
					int i = pstmt.executeUpdate();
					if(i > 0){
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									succesfullUpdateEmployee frame = new succesfullUpdateEmployee(managerName, updateFirstName, updateLastName, updateEmailAddress, updatePassword);
									frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}
					else{
						JOptionPane.showMessageDialog(null, "Data Not Save");
					}
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnUpdateAccount.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdateAccount.setFocusable(false);
		btnUpdateAccount.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnUpdateAccount.setBackground(Color.LIGHT_GRAY);
		btnUpdateAccount.setBounds(10, 211, 150, 35);
		panel_1.add(btnUpdateAccount);
		
		final JButton button_1 = new JButton("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				if(e1.getSource() == button_1){
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								managerSearchEmployeeUpdate mff = new managerSearchEmployeeUpdate(managerName);
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
		button_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_1.setFocusable(false);
		button_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.setBounds(170, 211, 150, 35);
		panel_1.add(button_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(0, 70, 434, 25);
		contentPane.add(panel_2);
		
		JLabel label_5 = new JLabel(managerName);
		label_5.setHorizontalTextPosition(SwingConstants.RIGHT);
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_5.setBounds(0, 0, 425, 25);
		panel_2.add(label_5);
	}

}
