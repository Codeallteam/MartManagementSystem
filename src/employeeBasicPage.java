
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import java.awt.Font;

import javax.swing.SwingConstants;

public class employeeBasicPage extends JFrame {
	String givenQuantity;
	String totalAnsString;
	int totalBill;
	String minutString;
	int totalAdd;
	int totalMinus;
	java.sql.ResultSet rs;
	String totalSum;
	String sumString;
	int totalAmount;
	JLabel label;
	Connection conn = null;
	PreparedStatement pstmt = null;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField totalQuantity;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public employeeBasicPage() {
		setTitle("Billing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setMaximumSize(new Dimension(3000, 32767));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 11, 510, 203);
		
		textField = new JTextField();
		textField.setBounds(35, 278, 125, 20);
		textField.setColumns(10);
		label = new JLabel();
		label.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		JButton addBtn = new JButton("Add");
		addBtn.setFocusable(false);
		addBtn.setBounds(35, 309, 101, 23);
		table = new JTable();
		Object[] columns = {"Id", "Name", "Quantity", "Rate"};
		final DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		table.getColumnModel().getColumn(1).setPreferredWidth(117);
		table.setRowHeight(30);
		totalQuantity = new JTextField();
		totalQuantity.setBounds(180, 278, 76, 20);
		contentPane.add(totalQuantity);
		totalQuantity.setColumns(10);
		scrollPane.setViewportView(table);		
		final Object[] row = new Object[4];
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String produtId = textField.getText().trim();
				givenQuantity = totalQuantity.getText().trim();
				if(produtId.isEmpty() || givenQuantity.isEmpty()){
					JOptionPane.showMessageDialog(null, "Please Fill the Given Field");
				}else{
					try{
						Class.forName("com.mysql.jdbc.Driver");
						conn = DriverManager.getConnection("jdbc:mysql://localhost/selecteddb","root","");
						pstmt = conn.prepareStatement("SELECT product_name, product_id, rate FROM manager_add_product WHERE product_id = ?");
						pstmt.setString(1, produtId);
						rs = pstmt.executeQuery();
						if(rs.next()){
							row[0] = rs.getString("product_name");
							row[1] = rs.getString("product_id");
							row[2] = givenQuantity;
							row[3] = rs.getString("rate");
							totalAmount = Integer.parseInt(rs.getString("rate"));
							model.addRow(row);
							textField.setText("");
							totalQuantity.setText("");
							int stringGivenData = Integer.parseInt(givenQuantity);
							totalAmount = totalAmount * stringGivenData;
							setJlabelText(totalAmount , 0);
						}
						else{
							JOptionPane.showMessageDialog(null, "Invalid Product Id");
						}
					}catch(Exception e){
						JOptionPane.showMessageDialog(null, e);
					}
				}
			}
		});
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.setFocusable(false);
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int columns = 3;
				int row = table.getSelectedRow();
				if(row == -1){
					JOptionPane.showMessageDialog(null, "Please Select Row");
				}else{
					String value = table.getModel().getValueAt(row, columns).toString();
					int lessValue = Integer.parseInt(value);
					int stringGivenData = Integer.parseInt(givenQuantity);
					lessValue = lessValue * stringGivenData;
					setJlabelText(0 , lessValue);
					model.removeRow(row);
					
					 
				}
			}
		});
		label.setBounds(426, 278, 65, 34);
		deleteBtn.setBounds(155, 309, 101, 23);
		contentPane.setLayout(null);
		contentPane.add(label);
		contentPane.add(textField);
		contentPane.add(addBtn);
		contentPane.add(deleteBtn);
		contentPane.add(scrollPane);
		
		JLabel lblProductId = new JLabel("Product Id");
		lblProductId.setBounds(35, 263, 65, 14);
		contentPane.add(lblProductId);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(180, 263, 65, 14);
		contentPane.add(lblQuantity);
		
		JLabel lblTotalAmount = new JLabel("TOTAL AMOUNT");
		lblTotalAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalAmount.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotalAmount.setBounds(399, 258, 125, 20);
		contentPane.add(lblTotalAmount);
		
		JButton btnNewButton = new JButton("PRINT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName(mainMethodClass.JDBC_DRIVER);
					conn = DriverManager.getConnection(mainMethodClass.DB_URL,"root","");
					pstmt = conn.prepareStatement("INSERT INTO customer_billing(customer_bill) VALUE(?)");
					pstmt.setString(1, totalAnsString);
					int i = pstmt.executeUpdate();
					if(i > 0){
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									printDone frame = new printDone(totalAnsString);
									frame.setLocationRelativeTo(null);
									frame.setVisible(true);
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
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton.setFocusable(false);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(276, 277, 89, 55);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							employeeFirstFrame frame = new employeeFirstFrame();
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
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBounds(480, 225, 65, 23);
		contentPane.add(btnNewButton_1);
		
	}
	public void setJlabelText(int add , int minuts){
		if(add > 0 && minuts == 0){
			totalAdd += add;
		}
		else if(minuts > 0 && add == 0){
			totalAdd -= minuts;
		}
		totalAnsString = Integer.toString(totalAdd);
		label.setText(totalAnsString);
	}
}

