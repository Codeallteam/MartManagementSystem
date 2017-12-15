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
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class managerUpdateProduct extends JFrame {
	String productName;
	String productId;
	String rate;
	String quantity;
	String weight;
	String brand;
	String category;
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public managerUpdateProduct(final String managerName, final String productID) { 
		try{
		      //STEP 2: Register JDBC driver
		      Class.forName(mainMethodClass.JDBC_DRIVER);

		      //STEP 3: Open a connection
		      conn = DriverManager.getConnection(mainMethodClass.DB_URL, "root", "root");
		      
		      //STEP 4: Execute a query
		      pstmt = conn.prepareStatement("SELECT product_name, product_id, rate, quantity, weight, brand, category FROM manager_add_product WHERE product_id = ?");
		      pstmt.setString(1, productID);
		      ResultSet rs = pstmt.executeQuery();

		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		         productName  = rs.getString("product_name");
		         productId  = rs.getString("product_id");
		         rate  = rs.getString("rate");
		         quantity = rs.getString("quantity");
		         weight = rs.getString("weight");
		         brand = rs.getString("brand");
		         category = rs.getString("category");
		         
		      }
		      rs.close();
		   }catch(SQLException se){
		      JOptionPane.showMessageDialog(null, se);
		      se.printStackTrace();
		   }catch(Exception e){
			   JOptionPane.showMessageDialog(null, e);
		      e.printStackTrace();
		   }
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
		lblUpdateProduct.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUpdateProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateProduct.setForeground(Color.WHITE);
		lblUpdateProduct.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblUpdateProduct.setBounds(0, 0, 434, 70);
		panel.add(lblUpdateProduct);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(52, 110, 330, 260);
		contentPane.add(panel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setColumns(10);
		textField.setBorder(new LineBorder(Color.BLACK, 2));
		textField.setBounds(10, 25, 180, 35);
		panel_1.add(textField);
		textField.setText(productName);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_1.setColumns(10);
		textField_1.setBorder(new LineBorder(Color.BLACK, 2));
		textField_1.setBounds(210, 25, 110, 35);
		panel_1.add(textField_1);
		textField_1.setText(productId);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_2.setColumns(10);
		textField_2.setBorder(new LineBorder(Color.BLACK, 2));
		textField_2.setBounds(10, 90, 90, 35);
		panel_1.add(textField_2);
		textField_2.setText(rate);
		
		JLabel label = new JLabel("Product Name");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(10, 3, 100, 22);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("Product ID");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(210, 3, 100, 22);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Rate");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(10, 68, 71, 22);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Brand");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_3.setBounds(10, 133, 70, 22);
		panel_1.add(label_3);
		
		JButton btnUpdateProduct = new JButton("Update Product");
		btnUpdateProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final String updateProductName = textField.getText().trim();
				final String updateProductId = textField_1.getText().trim();
				final String updateRate = textField_2.getText().trim();
				final String updateQuantity = textField_3.getText().trim();
				String upgateWeight = textField_4.getText().trim();
				String updateBrand = textField_5.getText().trim();
				String updateCategory = textField_6.getText().trim();
				try{
					Class.forName(mainMethodClass.JDBC_DRIVER);
					conn = DriverManager.getConnection(mainMethodClass.DB_URL,"root","root");
					pstmt = conn.prepareStatement("UPDATE manager_add_product SET product_name = ?,product_id = ?,rate = ? ,quantity = ?, weight = ?,brand = ?,category = ? WHERE product_id = ?");
					pstmt.setString(1, updateProductName);
					pstmt.setString(2, updateProductId);
					pstmt.setString(3, updateRate);
					pstmt.setString(4, updateQuantity);
					pstmt.setString(5, upgateWeight);
					pstmt.setString(6, updateBrand);
					pstmt.setString(7, updateCategory);
					pstmt.setString(8, productID);
					int i = pstmt.executeUpdate();
					if(i > 0){
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									succesfullUpdateProduct frame = new succesfullUpdateProduct(managerName, updateProductName, updateProductId, updateRate, updateQuantity);
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
						JOptionPane.showMessageDialog(null, "Data Not Save");
					}
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnUpdateProduct.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdateProduct.setFocusable(false);
		btnUpdateProduct.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnUpdateProduct.setBackground(Color.LIGHT_GRAY);
		btnUpdateProduct.setBounds(10, 211, 150, 35);
		panel_1.add(btnUpdateProduct);
		
		final JButton button_1 = new JButton("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				if(e1.getSource() == button_1){
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								managerSearchProductUpdate mff = new managerSearchProductUpdate(managerName);
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
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_3.setColumns(10);
		textField_3.setBorder(new LineBorder(Color.BLACK, 2));
		textField_3.setBounds(120, 90, 90, 35);
		panel_1.add(textField_3);
		textField_3.setText(quantity);
		
		JLabel label_4 = new JLabel("Quantity");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_4.setBounds(120, 68, 71, 22);
		panel_1.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_4.setColumns(10);
		textField_4.setBorder(new LineBorder(Color.BLACK, 2));
		textField_4.setBounds(230, 90, 90, 35);
		panel_1.add(textField_4);
		textField_4.setText(weight);
		
		JLabel label_5 = new JLabel("Weight");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_5.setBounds(230, 68, 71, 22);
		panel_1.add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_5.setColumns(10);
		textField_5.setBorder(new LineBorder(Color.BLACK, 2));
		textField_5.setBounds(10, 155, 145, 35);
		panel_1.add(textField_5);
		textField_5.setText(brand);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_6.setColumns(10);
		textField_6.setBorder(new LineBorder(Color.BLACK, 2));
		textField_6.setBounds(175, 155, 145, 35);
		panel_1.add(textField_6);
		textField_6.setText(category);
		
		JLabel label_6 = new JLabel("Category");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_6.setBounds(175, 133, 70, 22);
		panel_1.add(label_6);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(0, 70, 434, 25);
		contentPane.add(panel_2);
		
		JLabel label_7 = new JLabel(managerName);
		label_7.setHorizontalTextPosition(SwingConstants.RIGHT);
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_7.setBounds(0, 0, 425, 25);
		panel_2.add(label_7);
	}


}