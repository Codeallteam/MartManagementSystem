import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Component;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;

import java.awt.SystemColor;

import javax.swing.UIManager;

import java.awt.Cursor;

import javax.swing.border.SoftBevelBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class mainSelectedFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public mainSelectedFrame() {
		setTitle("Mart Management");
		setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 434, 70);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MART ONLINE MANAGEMENT");
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 434, 70);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(82, 143, 286, 80);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		final JButton btnManager = new JButton("MANAGER");
		btnManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnManager){
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
		btnManager.setFocusable(false);
		btnManager.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnManager.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnManager.setBackground(Color.LIGHT_GRAY);
		btnManager.setForeground(new Color(0, 0, 0));
		btnManager.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnManager.setBounds(102, 16, 173, 48);
		panel_1.add(btnManager);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("D:\\java-eclipse\\Selected\\icons\\boss_man-5121.png"));
		lblNewLabel_1.setBounds(2, 2, 86, 76);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(82, 256, 286, 80);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		final JButton btnEmployee = new JButton("EMPLOYEE");
		btnEmployee.setForeground(new Color(0, 0, 0));
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnEmployee){
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								employeeFirstFrame eff = new employeeFirstFrame();
								eff.setLocationRelativeTo(null);
								eff.setVisible(true);
								dispose();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			}
		});
		btnEmployee.setFocusable(false);
		btnEmployee.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnEmployee.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEmployee.setBackground(Color.LIGHT_GRAY);
		btnEmployee.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEmployee.setBounds(102, 16, 173, 48);
		panel_2.add(btnEmployee);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\java-eclipse\\Selected\\icons\\user-5121.png"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setAlignmentY(0.0f);
		label.setBounds(0, 2, 86, 76);
		panel_2.add(label);
	}
}
