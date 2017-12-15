import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Dimension;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class managerCategoriesSelectedFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public managerCategoriesSelectedFrame(final String managerName) {
		setTitle("Categories");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 434, 70);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CATEGORIES");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 434, 70);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setBounds(284, 70, 150, 25);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.setBorder(new LineBorder(Color.BLACK, 2));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(28, 130, 178, 60);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\java-eclipse\\Selected\\icons\\addFile.png"));
		lblNewLabel_1.setBounds(5, 0, 53, 60);
		panel_1.add(lblNewLabel_1);
		
		JButton btnAddManagerCategories = new JButton("ADD");
		btnAddManagerCategories.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							dispose();
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
		btnAddManagerCategories.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAddManagerCategories.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnAddManagerCategories.setBackground(Color.WHITE);
		btnAddManagerCategories.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddManagerCategories.setFocusable(false);
		btnAddManagerCategories.setBounds(65, 17, 100, 25);
		panel_1.add(btnAddManagerCategories);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(228, 130, 178, 60);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\java-eclipse\\Selected\\icons\\fileUpdate.png"));
		lblNewLabel_2.setBounds(5, 0, 53, 60);
		panel_2.add(lblNewLabel_2);
		
		JButton btnUpdateManagerCategories = new JButton("UPDATE");
		btnUpdateManagerCategories.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							managerCategoryUpdateFrame frame = new managerCategoryUpdateFrame(managerName);
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
		btnUpdateManagerCategories.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdateManagerCategories.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnUpdateManagerCategories.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdateManagerCategories.setFocusable(false);
		btnUpdateManagerCategories.setBackground(Color.WHITE);
		btnUpdateManagerCategories.setBounds(65, 17, 100, 25);
		panel_2.add(btnUpdateManagerCategories);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(28, 212, 178, 60);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnDeleteManagerCategories = new JButton("DELETE");
		btnDeleteManagerCategories.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								dispose();
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
		btnDeleteManagerCategories.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDeleteManagerCategories.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDeleteManagerCategories.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDeleteManagerCategories.setFocusable(false);
		btnDeleteManagerCategories.setBackground(Color.WHITE);
		btnDeleteManagerCategories.setBounds(65, 17, 100, 25);
		panel_3.add(btnDeleteManagerCategories);
		
		JLabel label_1 = new JLabel("");
		label_1.setSize(new Dimension(10, 10));
		label_1.setIcon(new ImageIcon("D:\\java-eclipse\\Selected\\icons\\fileDelete.png"));
		label_1.setBounds(8, 0, 53, 60);
		panel_3.add(label_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_4.setBounds(228, 212, 178, 60);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								dispose();
								managerCategoriesSearchFrame frame = new managerCategoriesSearchFrame(managerName);
								frame.setVisible(true);
								frame.setLocationRelativeTo(null);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
			}
		});
		btnSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnSearch.setBounds(65, 17, 100, 25);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.setFocusable(false);
		btnSearch.setBackground(Color.WHITE);
		panel_4.add(btnSearch);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\java-eclipse\\Selected\\icons\\searchFile.png"));
		lblNewLabel_3.setBounds(5, -2, 54, 60);
		panel_4.add(lblNewLabel_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.GRAY);
		panel_5.setBounds(128, 294, 180, 60);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		final JButton btnBackManagerCategories = new JButton("Back");
		btnBackManagerCategories.setFocusable(false);
		btnBackManagerCategories.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnBackManagerCategories){
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								managerFirstFrame mff = new managerFirstFrame();
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
		btnBackManagerCategories.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBackManagerCategories.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBackManagerCategories.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBackManagerCategories.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnBackManagerCategories.setBackground(Color.LIGHT_GRAY);
		btnBackManagerCategories.setBounds(25, 15, 110, 30);
		panel_5.add(btnBackManagerCategories);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.GRAY);
		panel_6.setBounds(0, 70, 434, 25);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel managerUserName = new JLabel(managerName);
		managerUserName.setHorizontalAlignment(SwingConstants.RIGHT);
		managerUserName.setHorizontalTextPosition(SwingConstants.RIGHT);
		managerUserName.setForeground(Color.WHITE);
		managerUserName.setFont(new Font("Tahoma", Font.BOLD, 14));
		managerUserName.setBounds(0, 0, 425, 25);
		panel_6.add(managerUserName);
	}
}
