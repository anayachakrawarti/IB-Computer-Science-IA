// view inventory database from MySQL
package GourmetDelight;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import java.awt.SystemColor;

public class viewinventory extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnUpdateInventory;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewinventory frame = new viewinventory();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public viewinventory() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 518);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				inventory inv = new inventory();
				inv.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(357, 423, 280, 30);
		contentPane.add(btnBack);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 62, 667, 350);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Item Name", "Last Stocked", "Date of Expiry", "Stock"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(82);
		table.getColumnModel().getColumn(1).setPreferredWidth(170);
		table.getColumnModel().getColumn(2).setPreferredWidth(122);
		table.getColumnModel().getColumn(3).setPreferredWidth(126);
		table.getColumnModel().getColumn(4).setPreferredWidth(124);
		scrollPane.setViewportView(table);
		
		btnUpdateInventory = new JButton("Update Inventory Database");
		btnUpdateInventory.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnUpdateInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				updateinventory update = new updateinventory();
				update.setVisible(true);
				dispose();
			}
		});
		btnUpdateInventory.setBounds(50, 423, 280, 30);
		contentPane.add(btnUpdateInventory);
		
		JLabel lblNewLabel = new JLabel("Inventory Database");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNewLabel.setBounds(262, 23, 163, 28);
		contentPane.add(lblNewLabel);
		
		table_update();
	}
	public void table_update() {
		  
		  Connection con1; 
		  PreparedStatement insert; 
		  int c; 
		  
		  try {
		  Class.forName("com.mysql.cj.jdbc.Driver"); 
		  con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root",""); 
		  insert = con1.prepareStatement("select * from inventory"); 
		  ResultSet rs = insert.executeQuery(); 
		  ResultSetMetaData Rss = rs.getMetaData(); 
		  c = Rss.getColumnCount();
		  
		  DefaultTableModel Df = (DefaultTableModel)table.getModel();
		  Df.setRowCount(0);
		  
		  while(rs.next()) { 
			  Vector v2 = new Vector(); 
			  for (int a=1; a<=c; a++) {
				  v2.add(rs.getString("number")); 
				  v2.add(rs.getString("item_name"));
				  v2.add(rs.getString("last_stocked")); 
				  v2.add(rs.getString("expiry_date"));
				  v2.add(rs.getString("stock_amount")); 
				  
			  }
		  
		  Df.addRow(v2); 
		  }
		  
		  } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		  
		  }
	}
}
