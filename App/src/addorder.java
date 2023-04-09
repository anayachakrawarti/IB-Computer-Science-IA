package GourmetDelight;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JTextField;

public class addorder extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JTable table_1;
	private JScrollPane scrollPane_1;
	private JTextField item;
	private JTextField quantity;
	private JButton btnAdd;
	private JTextField employee;
	private JButton btnPlaceOrder;
	private JButton btnBack;
	private JLabel lblEmployeeName;
	private JLabel lblItemName;
	private JLabel lblAmountDelivered;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addorder frame = new addorder();
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
	public addorder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 536, 269);
		contentPane.add(scrollPane);
	
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DefaultTableModel Df = (DefaultTableModel)table.getModel();
				int selectedIndex = table.getSelectedRow();
				item.setText(Df.getValueAt(selectedIndex, 1).toString());
			}
		});
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
		scrollPane.setViewportView(table);
		
		table_update();
		
		Panel panel = new Panel();
		panel.setBackground(new Color(173, 216, 230));
		panel.setBounds(569, 0, 324, 504);
		contentPane.add(panel);
		panel.setLayout(null);
		
		item = new JTextField();
		item.setBounds(27, 304, 139, 30);
		panel.add(item);
		item.setColumns(10);
		
		quantity = new JTextField();
		quantity.setBounds(177, 304, 130, 30);
		panel.add(quantity);
		quantity.setColumns(10);
		
		btnAdd = new JButton("Add Item");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Connection con1; 
				PreparedStatement insert;
				DefaultTableModel Df = (DefaultTableModel)table.getModel();
				int selectedIndex = table.getSelectedRow();
				
				try {
					
					int number = Integer.parseInt(Df.getValueAt(selectedIndex, 0).toString());
					String amt = Df.getValueAt(selectedIndex, 4).toString();
					int qt = Integer.parseInt(amt);
					String user_input = quantity.getText();
					int user_qt = Integer.parseInt(user_input);
					if (user_qt>qt) {
						JOptionPane.showMessageDialog(btnAdd, "Not Enough Inventory");
					}
					else {
						int stock = qt-user_qt;
						String amountInStock = String.valueOf(stock);
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","");
						insert = con1.prepareStatement("update inventory set stock_amount=? where number=? ");
						insert.setString(1, amountInStock);
						insert.setInt(2, number);
						insert.executeUpdate();
						
						table_update();
						
						item.setText("");
						quantity.setText("");
						
						item.requestFocus();
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
		});
		btnAdd.setBounds(89, 356, 144, 30);
		panel.add(btnAdd);
		
		employee = new JTextField();
		employee.setBounds(27, 145, 280, 30);
		panel.add(employee);
		employee.setColumns(10);
		
		btnPlaceOrder = new JButton("Update Deliveries");
		btnPlaceOrder.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnPlaceOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Connection con1; 
				PreparedStatement insert;
				DefaultTableModel Df = (DefaultTableModel)table_1.getModel();
				int selectedIndex = table_1.getSelectedRow();
				
				try {
					
					int id = Integer.parseInt(Df.getValueAt(selectedIndex, 0).toString());
					String deliveries = Df.getValueAt(selectedIndex, 5).toString();
					double del = Double.parseDouble(deliveries);
					del++;
					String newdeliveries = String.valueOf(del);
					double salary = (del*10.0 + 50);
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","");
					insert = con1.prepareStatement("update employee set employee_deliveries=?, employee_salary=? where id=? ");
					insert.setString(1, newdeliveries);
					insert.setDouble(2, salary);
					insert.setInt(3, id);
					insert.executeUpdate();
					
					table_update2();
					
					employee.setText("");
					
					employee.requestFocus();
					
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
		btnPlaceOrder.setBounds(89, 196, 144, 30);
		panel.add(btnPlaceOrder);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				staff st = new staff();
				st.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack.setBounds(28, 436, 279, 30);
		panel.add(btnBack);
		
		JLabel lblAddOrder = new JLabel("Add Order");
		lblAddOrder.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblAddOrder.setBounds(117, 41, 87, 30);
		panel.add(lblAddOrder);
		
		lblEmployeeName = new JLabel("Employee Name");
		lblEmployeeName.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblEmployeeName.setBounds(28, 124, 103, 20);
		panel.add(lblEmployeeName);
		
		lblItemName = new JLabel("Item Name");
		lblItemName.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblItemName.setBounds(28, 286, 103, 20);
		panel.add(lblItemName);
		
		lblAmountDelivered = new JLabel("Dispatch Amount");
		lblAmountDelivered.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblAmountDelivered.setBounds(177, 286, 117, 20);
		panel.add(lblAmountDelivered);
				
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
		  
		    scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(10, 291, 536, 200);
			contentPane.add(scrollPane_1);
			
			table_1 = new JTable();
			table_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					DefaultTableModel Df = (DefaultTableModel)table_1.getModel();
					int selectedIndex = table_1.getSelectedRow();
					employee.setText(Df.getValueAt(selectedIndex, 1).toString());
				}
			});
			table_1.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"ID", "Name", "Age", "Phone", "Delivery Area", "Deliveries", "Salary"
					}
				));
				table_1.getColumnModel().getColumn(0).setPreferredWidth(69);
				table_1.getColumnModel().getColumn(1).setPreferredWidth(142);
				table_1.getColumnModel().getColumn(2).setPreferredWidth(67);
				table_1.getColumnModel().getColumn(3).setPreferredWidth(99);
				table_1.getColumnModel().getColumn(4).setPreferredWidth(97);
			scrollPane_1.setViewportView(table_1);
			
			table_update2();
								
	}
	public void table_update2() {
		  
		  Connection con1; 
		  PreparedStatement insert; 
		  int c; 
		  
		  try {
		  Class.forName("com.mysql.cj.jdbc.Driver"); 
		  con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root",""); 
		  insert = con1.prepareStatement("select * from employee"); 
		  ResultSet rs = insert.executeQuery(); 
		  ResultSetMetaData Rss = rs.getMetaData(); 
		  c = Rss.getColumnCount();
		  
		  DefaultTableModel Df = (DefaultTableModel)table_1.getModel();
		  Df.setRowCount(0);
		  
		  while(rs.next()) { 
			  Vector v2 = new Vector(); 
			  for (int a=1; a<=c; a++) {
				  v2.add(rs.getString("id")); 
				  v2.add(rs.getString("employee_name"));
				  v2.add(rs.getString("employee_age")); 
				  v2.add(rs.getString("phone_number"));
				  v2.add(rs.getString("delivery_area")); 
				  v2.add(rs.getString("employee_deliveries"));
				  v2.add(rs.getString("employee_salary"));
				  
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
