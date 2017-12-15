import java.awt.BorderLayout;
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
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class managerAddProduct extends JFrame {
	Connection conn = null;
	PreparedStatement pstmt = null;
	private JPanel contentPane;
	private JTextField addProductName;
	private JTextField addProductId;
	private JTextField addProductRate;
	private JTextField addProductQuantity;
	private JTextField addProductWeight;
	private JTextField addProductBrand;
	private JTextField addProductCategory;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public managerAddProduct(final String managerName) {
		setTitle("Add Product");
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
		
		JLabel lblNewLabel = new JLabel("ADD PRODUCT");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(0, 0, 434, 70);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(52, 110, 330, 260);
		contentPane.add(panel_1);
		
		addProductName = new JTextField();
		addProductName.setFont(new Font("Tahoma", Font.BOLD, 14));
		addProductName.setColumns(10);
		addProductName.setBorder(new LineBorder(Color.BLACK, 2));
		addProductName.setBounds(10, 25, 180, 35);
		panel_1.add(addProductName);
		
		addProductId = new JTextField();
		addProductId.setFont(new Font("Tahoma", Font.BOLD, 14));
		addProductId.setColumns(10);
		addProductId.setBorder(new LineBorder(Color.BLACK, 2));
		addProductId.setBounds(210, 25, 110, 35);
		panel_1.add(addProductId);
		
		addProductRate = new JTextField();
		addProductRate.setFont(new Font("Tahoma", Font.BOLD, 14));
		addProductRate.setColumns(10);
		addProductRate.setBorder(new LineBorder(Color.BLACK, 2));
		addProductRate.setBounds(10, 90, 90, 35);
		panel_1.add(addProductRate);
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProductName.setBounds(10, 3, 100, 22);
		panel_1.add(lblProductName);
		
		JLabel lblProductId = new JLabel("Product ID");
		lblProductId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProductId.setBounds(210, 3, 100, 22);
		panel_1.add(lblProductId);
		
		JLabel lblRate = new JLabel("Rate");
		lblRate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRate.setBounds(10, 68, 71, 22);
		panel_1.add(lblRate);
		
		JLabel lblBrand = new JLabel("Brand");
		lblBrand.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBrand.setBounds(10, 133, 70, 22);
		panel_1.add(lblBrand);
		
		JButton btnAddProduuct = new JButton("Add Product");
		btnAddProduuct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final String productName = addProductName.getText().trim();
				final String productId = addProductId.getText().trim();
				final String productRate = addProductRate.getText().trim();
				final String productQuantity =  addProductQuantity.getText().trim();
				mainMethodClass.productQuantityInt = parseInt(productQuantity); 
				final String productWeight = addProductWeight.getText().trim();
				final String productBrand = addProductBrand.getText().trim();
				final String productCategory = addProductCategory.getText().trim();
				if(productName.equals("") || productId.equals("") || productRate.equals("") || productWeight.equals("") || productQuantity.equals("") || productBrand.equals("") || productCategory.equals("")){
					JOptionPane.showMessageDialog(null, "Please fill the Given Field");
				}
				else{
					try{
						Class.forName(mainMethodClass.JDBC_DRIVER);
						conn = DriverManager.getConnection(mainMethodClass.DB_URL,"root","root");
						pstmt = conn.prepareStatement("INSERT INTO manager_add_product(product_name,product_id,rate,quantity,weight,brand,category,updated_by) VALUE(?,?,?,?,?,?,?,?)");
						pstmt.setString(1, productName);
						pstmt.setString(2, productId);
						pstmt.setString(3, productRate);
						pstmt.setString(4, productQuantity);
						pstmt.setString(5, productWeight);
						pstmt.setString(6, productBrand);
						pstmt.setString(7, productCategory);
						pstmt.setString(8, managerName);
						int i = pstmt.executeUpdate();
						if(i > 0){
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										succesfullAddProduct frame = new succesfullAddProduct(managerName, productName, productId, productRate, productQuantity);
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
			}

			private int parseInt(String trim) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		btnAddProduuct.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAddProduuct.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddProduuct.setFocusable(false);
		btnAddProduuct.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnAddProduuct.setBackground(Color.LIGHT_GRAY);
		btnAddProduuct.setBounds(10, 211, 150, 35);
		panel_1.add(btnAddProduuct);
		
		JButton button_1 = new JButton("Back");
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		button_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_1.setFocusable(false);
		button_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.setBounds(170, 211, 150, 35);
		panel_1.add(button_1);
		
		addProductQuantity = new JTextField();
		addProductQuantity.setFont(new Font("Tahoma", Font.BOLD, 14));
		addProductQuantity.setColumns(10);
		addProductQuantity.setBorder(new LineBorder(Color.BLACK, 2));
		addProductQuantity.setBounds(120, 90, 90, 35);
		panel_1.add(addProductQuantity);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuantity.setBounds(120, 68, 71, 22);
		panel_1.add(lblQuantity);
		
		addProductWeight = new JTextField();
		addProductWeight.setFont(new Font("Tahoma", Font.BOLD, 14));
		addProductWeight.setColumns(10);
		addProductWeight.setBorder(new LineBorder(Color.BLACK, 2));
		addProductWeight.setBounds(230, 90, 90, 35);
		panel_1.add(addProductWeight);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWeight.setBounds(230, 68, 71, 22);
		panel_1.add(lblWeight);
		
		addProductBrand = new JTextField();
		addProductBrand.setFont(new Font("Tahoma", Font.BOLD, 14));
		addProductBrand.setColumns(10);
		addProductBrand.setBorder(new LineBorder(Color.BLACK, 2));
		addProductBrand.setBounds(10, 155, 145, 35);
		panel_1.add(addProductBrand);
		
		addProductCategory = new JTextField();
		addProductCategory.setFont(new Font("Tahoma", Font.BOLD, 14));
		addProductCategory.setColumns(10);
		addProductCategory.setBorder(new LineBorder(Color.BLACK, 2));
		addProductCategory.setBounds(175, 155, 145, 35);
		panel_1.add(addProductCategory);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCategory.setBounds(175, 133, 70, 22);
		panel_1.add(lblCategory);
		
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
