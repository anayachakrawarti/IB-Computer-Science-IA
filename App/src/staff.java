// staff menu
package GourmetDelight;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class staff extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					staff frame = new staff();
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
	public staff() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 235));
		panel.setBounds(266, 0, 421, 479);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnUpdateRecord = new JButton("Update Record");
		btnUpdateRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				updateemployee update = new updateemployee();
				update.setVisible(true);
				dispose();
			}
		});
		btnUpdateRecord.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdateRecord.setBounds(97, 206, 227, 30);
		panel.add(btnUpdateRecord);
		
		JButton btnViewEmployees = new JButton("View Employees");
		btnViewEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				viewemployee view = new viewemployee();
				view.setVisible(true);
				dispose();
			}
		});
		btnViewEmployees.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnViewEmployees.setBounds(97, 247, 227, 30);
		panel.add(btnViewEmployees);
		
		JButton btnEmployeeBack = new JButton("Back");
		btnEmployeeBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				mainmenu menu = new mainmenu();
				menu.setVisible(true);
				dispose();
			}
		});
		btnEmployeeBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEmployeeBack.setBounds(97, 288, 227, 30);
		panel.add(btnEmployeeBack);
		
		JButton btnAddOrder = new JButton("Add Order");
		btnAddOrder.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				addorder add = new addorder();
				add.setVisible(true);
				dispose();
			}
		});
		btnAddOrder.setBounds(97, 165, 227, 30);
		panel.add(btnAddOrder);
		
		JLabel lblStaff = new JLabel("Staff");
		lblStaff.setFont(new Font("Calibri", Font.PLAIN, 26));
		lblStaff.setBounds(105, 223, 54, 33);
		contentPane.add(lblStaff);
	}
}
