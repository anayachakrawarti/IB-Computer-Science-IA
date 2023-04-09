package GourmetDelight;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
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
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import javax.swing.table.DefaultTableModel;

public class updateemployee extends JFrame {

	private JPanel contentPane;
	private JTextField staff_name;
	private JTextField staff_age;
	private JTextField staff_area;
	private JTextField staff_deliveries;
	private JTextField staff_phone;
	private double staff_salary;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateemployee frame = new updateemployee();
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
	public updateemployee() {
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
				
				staff st = new staff();
				st.setVisible(true);
				dispose();
			}
		});
		panel.setLayout(null);
		panel.add(btnBack);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblName.setBounds(36, 88, 89, 21);
		panel.add(lblName);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblAge.setBounds(36, 159, 89, 23);
		panel.add(lblAge);
		
		JLabel lblArea = new JLabel("Area");
		lblArea.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblArea.setBounds(36, 228, 109, 21);
		panel.add(lblArea);
		
		JLabel lblDeliveries = new JLabel("Deliveries");
		lblDeliveries.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblDeliveries.setBounds(36, 298, 109, 23);
		panel.add(lblDeliveries);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String name = staff_name.getText();
				String age = staff_age.getText();
				String phone = staff_phone.getText();
				String area = staff_area.getText();
				String deliveries = staff_deliveries.getText();
				double str1 = Double.parseDouble(deliveries);
				double salary = (str1*10.0 + 50);
				
				Connection con1;
				PreparedStatement insert;
				
				//sql connector
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","");
					insert = con1.prepareStatement("insert into employee(employee_name,employee_age,phone_number,delivery_area,employee_deliveries,employee_salary) values(?,?,?,?,?,?)");
					insert.setString(1, name);
					insert.setString(2, age);
					insert.setString(3, phone);
					insert.setString(4, area);
					insert.setString(5, deliveries);
					insert.setDouble(6, salary);
					insert.executeUpdate();
					
					table_update();
					
					staff_name.setText("");
					staff_age.setText("");
					staff_phone.setText("");
					staff_area.setText("");
					staff_deliveries.setText("");
					
					staff_name.requestFocus();
					
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
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAdd.setBounds(36, 376, 89, 28);
		panel.add(btnAdd);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Connection con1; 
				PreparedStatement insert;
				DefaultTableModel Df = (DefaultTableModel)table.getModel();
				int selectedIndex = table.getSelectedRow();
				
				try {
					
					int id = Integer.parseInt(Df.getValueAt(selectedIndex, 0).toString());
					String name = staff_name.getText();
					String age = staff_age.getText();
					String phone = staff_phone.getText();
					String area = staff_area.getText();
					String deliveries = staff_deliveries.getText();
					double str1 = Double.parseDouble(deliveries);
					double salary = (str1*10.0 + 50);
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","");
					insert = con1.prepareStatement("update employee set employee_name=?, employee_age=?, phone_number=?, delivery_area=?, employee_deliveries=?, employee_salary=? where id=? ");
					insert.setString(1, name);
					insert.setString(2, age);
					insert.setString(3, phone);
					insert.setString(4, area);
					insert.setString(5, deliveries);
					insert.setDouble(6, salary);
					insert.setInt(7, id);
					insert.executeUpdate();
					
					table_update();
					
					staff_name.setText("");
					staff_age.setText("");
					staff_phone.setText("");
					staff_area.setText("");
					staff_deliveries.setText("");
					
					staff_name.requestFocus();
					
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
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEdit.setBounds(135, 376, 89, 28);
		panel.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Connection con1; 
				PreparedStatement insert;
				DefaultTableModel Df = (DefaultTableModel)table.getModel();
				int selectedIndex = table.getSelectedRow();
				
				try {
					
					int id = Integer.parseInt(Df.getValueAt(selectedIndex, 0).toString());
										
					Class.forName("com.mysql.cj.jdbc.Driver");
					con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","");
					insert = con1.prepareStatement("delete from employee where id=? ");
					insert.setInt(1, id);
					insert.executeUpdate();
					
					table_update();
					
					staff_name.setText("");
					staff_age.setText("");
					staff_phone.setText("");
					staff_area.setText("");
					staff_deliveries.setText("");
					
					staff_name.requestFocus();
					
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
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDelete.setBounds(234, 376, 82, 28);
		panel.add(btnDelete);
		
		JLabel lblUpdateEmployee = new JLabel("Update Employee");
		lblUpdateEmployee.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblUpdateEmployee.setBounds(105, 40, 153, 30);
		panel.add(lblUpdateEmployee);
		
		staff_name = new JTextField();
		staff_name.setBounds(36, 108, 280, 28);
		panel.add(staff_name);
		staff_name.setColumns(10);
		
		staff_age = new JTextField();
		staff_age.setBounds(36, 178, 54, 28);
		panel.add(staff_age);
		staff_age.setColumns(10);
		
		staff_area = new JTextField();
		staff_area.setBounds(36, 248, 280, 28);
		panel.add(staff_area);
		staff_area.setColumns(10);
		
		staff_deliveries = new JTextField();
		staff_deliveries.setBounds(36, 318, 280, 28);
		panel.add(staff_deliveries);
		staff_deliveries.setColumns(10);
		
		staff_phone = new JTextField();
		staff_phone.setBounds(109, 178, 207, 28);
		panel.add(staff_phone);
		staff_phone.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Phone Number");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel.setBounds(109, 161, 101, 18);
		panel.add(lblNewLabel);
		
		JLabel lblEmployeeDatabase = new JLabel("Employee Database");
		lblEmployeeDatabase.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblEmployeeDatabase.setBounds(191, 45, 170, 25);
		contentPane.add(lblEmployeeDatabase);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 81, 525, 365);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DefaultTableModel Df = (DefaultTableModel)table.getModel();
				int selectedIndex = table.getSelectedRow();
				
				//inventory_number.setText(Df.getValueAt(selectedIndex, 0).toString());
				staff_name.setText(Df.getValueAt(selectedIndex, 1).toString());
				staff_age.setText(Df.getValueAt(selectedIndex, 2).toString());
				staff_phone.setText(Df.getValueAt(selectedIndex, 3).toString());
				staff_area.setText(Df.getValueAt(selectedIndex, 4).toString());
				staff_deliveries.setText(Df.getValueAt(selectedIndex, 5).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Age", "Phone", "Delivery Area", "Deliveries", "Salary"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(64);
		table.getColumnModel().getColumn(1).setPreferredWidth(129);
		table.getColumnModel().getColumn(2).setPreferredWidth(67);
		table.getColumnModel().getColumn(3).setPreferredWidth(98);
		table.getColumnModel().getColumn(4).setPreferredWidth(110);
		table.getColumnModel().getColumn(6).setPreferredWidth(79);
		scrollPane.setViewportView(table);
		
		table_update();
	}
	public void table_update() {
		  
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
		  
		  DefaultTableModel Df = (DefaultTableModel)table.getModel();
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
