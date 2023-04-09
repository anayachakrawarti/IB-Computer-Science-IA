package GourmetDelight;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField login_user;
	private JPasswordField login_pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 374, 332);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginPage = new JLabel("Login Page");
		lblLoginPage.setForeground(Color.BLACK);
		lblLoginPage.setBackground(Color.WHITE);
		lblLoginPage.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblLoginPage.setBounds(112, 11, 133, 59);
		contentPane.add(lblLoginPage);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblUsername.setBounds(32, 76, 117, 30);
		contentPane.add(lblUsername);
		
		login_user = new JTextField();
		login_user.setBounds(32, 104, 294, 30);
		contentPane.add(login_user);
		login_user.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblPassword.setBounds(32, 158, 82, 20);
		contentPane.add(lblPassword);
		
		login_pass = new JPasswordField();
		login_pass.setBounds(32, 182, 294, 30);
		contentPane.add(login_pass);
		
		final JButton login_button = new JButton("Login");
		login_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String uname = login_user.getText();
				String pass = login_pass.getText();
				
				if (uname.equals("Username") && pass.equals("Password")) {
					mainmenu menu = new mainmenu();
					menu.setVisible(true);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(login_button, "Invalid Login");
				}
			}
		});
		login_button.setBackground(new Color(245, 255, 250));
		login_button.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		login_button.setBounds(124, 228, 109, 30);
		contentPane.add(login_button);
	}
}
