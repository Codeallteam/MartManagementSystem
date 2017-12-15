import java.awt.EventQueue;

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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class managerSearchProductUpdate extends JFrame {
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
	public managerSearchProductUpdate(final String managerName) {
		setTitle("Update Product");
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
		
		JLabel lblUpdateProduct = new JLabel("UPDATE PRODUCT");
		lblUpdateProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateProduct.setForeground(Color.WHITE);
		lblUpdateProduct.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblUpdateProduct.setBounds(0, 0, 434, 70);
		panel.add(lblUpdateProduct);
		
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
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(52, 155, 330, 116);
		contentPane.add(panel_2);
		
		JLabel label_2 = new JLabel("Product ID");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(10, 0, 120, 22);
		panel_2.add(label_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setColumns(10);
		textField.setBorder(new LineBorder(Color.BLACK, 2));
		textField.setBounds(10, 25, 310, 35);
		panel_2.add(textField);
		
		JButton btnUpdateProduct = new JButton("Get Data");
		btnUpdateProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final String productId = textField.getText().trim();
				try{
				      //STEP 2: Register JDBC driver
				      Class.forName(mainMethodClass.JDBC_DRIVER);

				      //STEP 3: Open a connection
				      conn = DriverManager.getConnection(mainMethodClass.DB_URL, "root", "");
				      
				      //STEP 4: Execute a query

				      // Extract records without any condition.
				      pstmt = conn.prepareStatement("SELECT * FROM manager_add_product WHERE product_id = ?");
				      pstmt.setString(1, productId);
				      java.sql.ResultSet rs = pstmt.executeQuery();
				      if(rs.next()){
				    	  EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										managerUpdateProduct frame1 = new managerUpdateProduct(managerName, productId);
										frame1.setLocationRelativeTo(null);
										frame1.setVisible(true);
										dispose();
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
				      }else{
				    	  JOptionPane.showMessageDialog(null, "Invalid Product ID");
				      }
				      rs.close();
				   }catch(SQLException se){
				      //Handle errors for JDBC
				      se.printStackTrace();
				   }catch(Exception e1){
				      //Handle errors for Class.forName
				      e1.printStackTrace();
				   }
			}
		});
		btnUpdateProduct.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdateProduct.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdateProduct.setFocusable(false);
		btnUpdateProduct.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnUpdateProduct.setBackground(Color.LIGHT_GRAY);
		btnUpdateProduct.setBounds(10, 80, 150, 35);
		panel_2.add(btnUpdateProduct);
		
		final JButton button_1 = new JButton("Back");
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button_1){
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								managerCategoryUpdateFrame mff = new managerCategoryUpdateFrame(managerName);
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
		button_1.setBounds(170, 80, 150, 35);
		panel_2.add(button_1);
	}
}
