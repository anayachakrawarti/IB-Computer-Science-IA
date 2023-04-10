// main menu
package GourmetDelight;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mainmenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainmenu frame = new mainmenu();
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
	public mainmenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(0, 0, 687, 479);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblWelcomeUser = new JLabel("Welcome User");
		lblWelcomeUser.setFont(new Font("Calibri", Font.PLAIN, 26));
		lblWelcomeUser.setBackground(new Color(240, 255, 240));
		lblWelcomeUser.setBounds(50, 220, 162, 38);
		panel.add(lblWelcomeUser);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(135, 206, 235));
		panel_1.setBounds(266, 0, 421, 479);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton inventory_button = new JButton("Inventory");
		inventory_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				inventory inv = new inventory();
				inv.setVisible(true);
				dispose();
			}
		});
		inventory_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		inventory_button.setBounds(97, 202, 227, 30);
		panel_1.add(inventory_button);
		
		JButton staff_button = new JButton("Staff");
		staff_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				staff st = new staff();
				st.setVisible(true);
				dispose();
			}
		});
		staff_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		staff_button.setBounds(97, 242, 227, 30);
		panel_1.add(staff_button);
	}
}
