// view employee database table from MySQL
package GourmetDelight;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

public class viewemployee extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewemployee frame = new viewemployee();
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
	public viewemployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 518);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				staff st = new staff();
				st.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(357, 423, 280, 30);
		contentPane.add(btnNewButton);
		
		JButton btnUpdateStaff = new JButton("Update Employee Database");
		btnUpdateStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				updateemployee update = new updateemployee();
				update.setVisible(true);
				dispose();
			}
		});
		btnUpdateStaff.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnUpdateStaff.setBounds(50, 423, 280, 30);
		contentPane.add(btnUpdateStaff);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 62, 667, 350);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Age", "Phone", "Delivery Area", "Deliveries", "Salary"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(69);
		table.getColumnModel().getColumn(1).setPreferredWidth(142);
		table.getColumnModel().getColumn(2).setPreferredWidth(67);
		table.getColumnModel().getColumn(3).setPreferredWidth(99);
		table.getColumnModel().getColumn(4).setPreferredWidth(97);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Employee Database");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNewLabel.setBounds(261, 23, 165, 28);
		contentPane.add(lblNewLabel);
		
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
