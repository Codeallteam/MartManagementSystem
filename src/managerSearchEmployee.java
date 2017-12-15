import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;

import javax.swing.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.*;

public class managerSearchEmployee extends JPanel {
	static JFrame frame = new JFrame();
	private static JTextField jtfFilter = new JTextField(10);
    private Connection conexao = null;

    public managerSearchEmployee(final String managerName) {
        Vector columnNames = new Vector();
        Vector data = new Vector();

        try {
        	Class.forName("com.mysql.jdbc.Driver");
            //  Connect to an Access Database
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/selecteddb", "root", "root");

            //  Read data from a table
            String sql = "select email_address, first_name, last_name from manager_add_employee";
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get column names
            for (int i = 1; i <= columns; i++) {
                columnNames.addElement(md.getColumnName(i));
            }

            //  Get row data
            while (rs.next()) {
                Vector row = new Vector(columns);

                for (int i = 1; i <= columns; i++) {
                    row.addElement(rs.getObject(i));
                }

                data.addElement(row);
            }

            rs.close();
            stmt.close();
            conexao.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        final TableRowSorter<TableModel> rowSorter
        = new TableRowSorter<>(table.getModel());
        JPanel panel = new JPanel();
        JPanel panOuter = new JPanel();
        panOuter.add(panel, BorderLayout.WEST);
        JPanel btnPanel = new JPanel();
        panOuter.add(btnPanel, BorderLayout.EAST);
        JButton btn = new JButton("Back");
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.setFocusable(false);
        panel.add(jtfFilter, BorderLayout.CENTER);
        btnPanel.add(btn, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Search Product");
        frame.setBounds(10, 10, 1000, 1000);
        panel.add(jtfFilter, BorderLayout.CENTER);
        jtfFilter.setBounds(10, 25, 150, 35);
        frame.setLayout(new BorderLayout());
        //Display the window.
        frame.setContentPane(panOuter);
        frame.pack();
        frame.setBounds(0, 0,520, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        table.setBounds(0, 0, 2000, 2000);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(600, 100, 2000, 2000);
        frame.add(scrollPane);  
        table.getColumnModel().getColumn(0).setPreferredWidth(450);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        JPanel buttonPanel = new JPanel();
        add(buttonPanel, BorderLayout.SOUTH);
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.LEFT);
        table.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
        DefaultTableCellRenderer rightRenderer1 = new DefaultTableCellRenderer();
        rightRenderer1.setHorizontalAlignment(JLabel.LEFT);
        table.getColumnModel().getColumn(2).setCellRenderer(rightRenderer1);
        DefaultTableCellRenderer rightRenderer2 = new DefaultTableCellRenderer();
        rightRenderer2.setHorizontalAlignment(JLabel.LEFT);
        table.setRowSorter(rowSorter);
        btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							managerCategoriesSearchFrame frame1 = new managerCategoriesSearchFrame(managerName);
							frame1.setLocationRelativeTo(null);
							frame1.setVisible(true);
							frame.dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
        jtfFilter.getDocument().addDocumentListener(new DocumentListener(){
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
				
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				String text = jtfFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }	
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				String text = jtfFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }	
			}

        });
    }
}