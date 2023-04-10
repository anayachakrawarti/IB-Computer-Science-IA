// add inventory, edit details or remove inventory items
package GourmetDelight;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class updateinventory extends JFrame {

	private JPanel contentPane;
	private JTextField inventory_name;
	private JTextField inventory_stockdate;
	private JTextField inventory_expirydate;
	private JTextField inventory_amount;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateinventory frame = new updateinventory();
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
	public updateinventory() {
					
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(545, 0, 339, 511);
		panel.setBackground(new Color(173, 216, 230));
		contentPane.add(panel);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack.setBounds(36, 415, 280, 30);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				inventory inv = new inventory();
				inv.setVisible(true);
				dispose();
			}
		});
		panel.setLayout(null);
		panel.add(btnBack);
		
		JLabel lblItemName = new JLabel("Item Name");
		lblItemName.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblItemName.setBounds(36, 89, 89, 21);
		panel.add(lblItemName);
		
		inventory_name = new JTextField();
		inventory_name.setBounds(36, 108, 280, 28);
		panel.add(inventory_name);
		inventory_name.setColumns(10);
		
		inventory_stockdate = new JTextField();
		inventory_stockdate.setBounds(36, 178, 280, 28);
		panel.add(inventory_stockdate);
		inventory_stockdate.setColumns(10);
		
		inventory_expirydate = new JTextField();
		inventory_expirydate.setBounds(36, 248, 280, 28);
		panel.add(inventory_expirydate);
		inventory_expirydate.setColumns(10);
		
		inventory_amount = new JTextField();
		inventory_amount.setBounds(36, 318, 280, 28);
		panel.add(inventory_amount);
		inventory_amount.setColumns(10);
		
		JLabel lblLastStocked = new JLabel("Last Stocked");
		lblLastStocked.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblLastStocked.setBounds(36, 159, 89, 23);
		panel.add(lblLastStocked);
		
		JLabel lblDateofExpiry = new JLabel("Date of Expiry");
		lblDateofExpiry.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblDateofExpiry.setBounds(36, 226, 109, 23);
		panel.add(lblDateofExpiry);
		
		JLabel lblAmountinStock = new JLabel("Amount in Stock");
		lblAmountinStock.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblAmountinStock.setBounds(36, 298, 109, 23);
		panel.add(lblAmountinStock);
		
		//Add item to MySQL database
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String name = inventory_name.getText();
				String lastStocked = inventory_stockdate.getText();
				String expiryDate = inventory_expirydate.getText();
				String amountInStock = inventory_amount.getText();
				
				Connection con1;
				PreparedStatement insert;
				
				//MySQL connector
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","");
					insert = con1.prepareStatement("insert into inventory(item_name,last_stocked,expiry_date,stock_amount) values(?,?,?,?)");
					insert.setString(1, name);
					insert.setString(2, lastStocked);
					insert.setString(3, expiryDate);
					insert.setString(4, amountInStock);
					insert.executeUpdate();
					
					table_update();
					
					inventory_name.setText("");
					inventory_stockdate.setText("");
					inventory_expirydate.setText("");
					inventory_amount.setText("");
					
					inventory_name.requestFocus();
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} //end sql connector for Add
		});
		btnAdd.setBounds(36, 376, 89, 28);
		panel.add(btnAdd);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Connection con1; 
				PreparedStatement insert;
				DefaultTableModel Df = (DefaultTableModel)table.getModel();
				int selectedIndex = table.getSelectedRow();
				
				try {
					
					int number = Integer.parseInt(Df.getValueAt(selectedIndex, 0).toString());
					String name = inventory_name.getText();
					String lastStocked = inventory_stockdate.getText();
					String expiryDate = inventory_expirydate.getText();
					String amountInStock = inventory_amount.getText();
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","");
					insert = con1.prepareStatement("update inventory set item_name=?, "
							+ "last_stocked=?, expiry_date=?, stock_amount=? where number=? ");
					insert.setString(1, name);
					insert.setString(2, lastStocked);
					insert.setString(3, expiryDate);
					insert.setString(4, amountInStock);
					insert.setInt(5, number);
					insert.executeUpdate();
					
					table_update();
					
					inventory_name.setText("");
					inventory_stockdate.setText("");
					inventory_expirydate.setText("");
					inventory_amount.setText("");
					
					inventory_name.requestFocus();
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnEdit.setBounds(135, 376, 89, 28);
		panel.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Connection con1; 
				PreparedStatement insert;
				DefaultTableModel Df = (DefaultTableModel)table.getModel();
				int selectedIndex = table.getSelectedRow();
				
				try {
					
					int number = Integer.parseInt(Df.getValueAt(selectedIndex, 0).toString());
										
					Class.forName("com.mysql.cj.jdbc.Driver");
					con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","");
					insert = con1.prepareStatement("delete from inventory where number=? ");
					insert.setInt(1, number);
					insert.executeUpdate();
					
					table_update();
					
					inventory_name.setText("");
					inventory_stockdate.setText("");
					inventory_expirydate.setText("");
					inventory_amount.setText("");
					
					inventory_name.requestFocus();
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(234, 376, 82, 28);
		panel.add(btnDelete);
		
		JLabel lblUpdateInventory = new JLabel("Update Inventory");
		lblUpdateInventory.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblUpdateInventory.setBounds(105, 40, 153, 30);
		panel.add(lblUpdateInventory);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 81, 525, 365);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DefaultTableModel Df = (DefaultTableModel)table.getModel();
				int selectedIndex = table.getSelectedRow();
				
				inventory_name.setText(Df.getValueAt(selectedIndex, 1).toString());
				inventory_stockdate.setText(Df.getValueAt(selectedIndex, 2).toString());
				inventory_expirydate.setText(Df.getValueAt(selectedIndex, 3).toString());
				inventory_amount.setText(Df.getValueAt(selectedIndex, 4).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Item Name", "Last Stocked", "Date of Expiry", "Stock"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(69);
		table.getColumnModel().getColumn(1).setPreferredWidth(151);
		table.getColumnModel().getColumn(2).setPreferredWidth(104);
		table.getColumnModel().getColumn(3).setPreferredWidth(95);
		table.getColumnModel().getColumn(4).setPreferredWidth(97);
		scrollPane.setViewportView(table);
		
		JLabel lblInventoryDatabase = new JLabel("Inventory Database");
		lblInventoryDatabase.setBackground(Color.WHITE);
		lblInventoryDatabase.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblInventoryDatabase.setBounds(191, 45, 170, 25);
		contentPane.add(lblInventoryDatabase);
		
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

