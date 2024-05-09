package controller.user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.signupUI;

import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JPasswordField;

public class loginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField account;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginUI frame = new loginUI();
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
	public loginUI() {
		setForeground(UIManager.getColor("Button.background"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 289);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("帳號");
		lblNewLabel.setBounds(76, 65, 46, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密碼");
		lblNewLabel_1.setBounds(76, 116, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		account = new JTextField();
		account.setBounds(171, 61, 96, 21);
		contentPane.add(account);
		account.setColumns(10);
		
		JButton btnNewButton = new JButton("登入");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Account= account.getText();
				@SuppressWarnings("deprecation")
				String Password=passwordField.getText();
				
				try {
				
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/reedeem", "root", "94041000");		//!!	
					
					String SQL= "SELECT * from user where account=? and password=?";
					
					PreparedStatement ps=conn.prepareStatement(SQL);
					
					ps.setString(1, Account);
		            ps.setString(2, Password);
					ResultSet rs=ps.executeQuery();
					
					if(rs.next()) {
					
						userPageUI up=new userPageUI();
					    up.setTitle("Welcome，養雞員您好");
						up.setVisible(true); 
						
						dispose();
						}
						else {
							JOptionPane.showMessageDialog(btnNewButton, "帳號或密碼錯誤，請重新登入");
						}
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(210, 178, 87, 35);
		contentPane.add(btnNewButton);
		

		JButton btnNewButton_2 = new JButton("註冊");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				signupUI s=new signupUI();
				s.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(96, 178, 87, 35);
		contentPane.add(btnNewButton_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(171, 111, 96, 23);
		contentPane.add(passwordField);
	}
}
