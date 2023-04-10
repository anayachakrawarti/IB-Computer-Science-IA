// inventory menu
package GourmetDelight;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class inventory extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inventory frame = new inventory();
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
	public inventory() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 518);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 245));
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
				
				updateinventory update = new updateinventory();
				update.setVisible(true);
				dispose();
			}
		});
		btnUpdateRecord.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdateRecord.setBounds(97, 183, 227, 30);
		panel.add(btnUpdateRecord);
		
		JButton btnViewInventory = new JButton("View Inventory");
		btnViewInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				viewinventory view = new viewinventory();
				view.setVisible(true);
				dispose();
			}
		});
		btnViewInventory.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnViewInventory.setBounds(97, 224, 227, 30);
		panel.add(btnViewInventory);
		
		JButton btnInventoryBack = new JButton("Back");
		btnInventoryBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				mainmenu menu = new mainmenu();
				menu.setVisible(true);
				dispose();
			}
		});
		btnInventoryBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnInventoryBack.setBounds(97, 265, 227, 30);
		panel.add(btnInventoryBack);
		
		JLabel lblInventory = new JLabel("Inventory");
		lblInventory.setFont(new Font("Calibri", Font.PLAIN, 26));
		lblInventory.setBounds(78, 223, 110, 33);
		contentPane.add(lblInventory);
	}
}
