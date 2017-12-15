import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;

import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.DropMode;

import java.awt.event.KeyAdapter;
import java.awt.Point;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.mysql.jdbc.ResultSet;


public class employeeFirstFrame extends JFrame {

	private JPanel contentPane;
	private JPasswordField managerPassword;
	private JTextField managerUserName;
	private JLabel lblNewLabel_1;
	Connection conn = null;
	PreparedStatement pstmt = null;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public employeeFirstFrame() {
		setTitle("Employee Sign In");
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
		
		JLabel lblNewLabel = new JLabel("EMPLOYEE SIGN IN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 434, 70);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(15, 110, 400, 250);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		managerUserName = new JTextField();
		managerUserName.setLocation(new Point(10, 0));
		managerUserName.setHorizontalAlignment(SwingConstants.LEFT);
		managerUserName.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		managerUserName.setAlignmentX(Component.RIGHT_ALIGNMENT);
		managerUserName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		managerUserName.setForeground(Color.BLACK);
		managerUserName.setCaretColor(Color.WHITE);
		managerUserName.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		managerUserName.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		managerUserName.setBorder(new LineBorder(Color.BLACK, 2));
		managerUserName.setBackground(Color.LIGHT_GRAY);
		managerUserName.setBounds(180, 52, 200, 35);
		panel_1.add(managerUserName);
		managerUserName.setColumns(20);
		
		managerPassword = new JPasswordField();
		managerPassword.setDoubleBuffered(true);
		managerPassword.setDisabledTextColor(Color.WHITE);
		managerPassword.setAlignmentX(Component.RIGHT_ALIGNMENT);
		managerPassword.setColumns(20);
		managerPassword.setForeground(Color.BLACK);
		managerPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		managerPassword.setBorder(new LineBorder(Color.BLACK, 2));
		managerPassword.setBackground(Color.LIGHT_GRAY);
		managerPassword.setBounds(180, 126, 200, 35);
		panel_1.add(managerPassword);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1.setIcon(new ImageIcon("D:\\java-eclipse\\Selected\\icons\\employeeSignIn.png"));
		lblNewLabel_1.setBounds(20, 32, 130, 130);
		panel_1.add(lblNewLabel_1);
		
		JButton btnSignInManager = new JButton("Sign in");
		btnSignInManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName(mainMethodClass.JDBC_DRIVER);
					conn = DriverManager.getConnection(mainMethodClass.DB_URL,"root","root");
					pstmt = conn.prepareStatement("SELECT * FROM manager_add_employee WHERE email_address = ? AND password = ?");
					pstmt.setString(1, managerUserName.getText().trim());
					pstmt.setString(2, managerPassword.getText().trim());
					java.sql.ResultSet result = pstmt.executeQuery();
					if(result.next()){
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										employeeBasicPage frame = new employeeBasicPage();
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
						JOptionPane.showMessageDialog(null, "Invalid Username Or Password");
						managerUserName.setText("");
						managerPassword.setText("");
					}
					
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnSignInManager.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnSignInManager.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSignInManager.setBackground(Color.LIGHT_GRAY);
		btnSignInManager.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSignInManager.setBounds(180, 188, 90, 30);
		panel_1.add(btnSignInManager);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							mainSelectedFrame frame = new mainSelectedFrame();
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
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBack.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnBack.setBackground(Color.LIGHT_GRAY);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(290, 188, 90, 30);
		panel_1.add(btnBack);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(180, 32, 100, 14);
		panel_1.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(180, 106, 100, 14);
		panel_1.add(lblPassword);
	}

}
