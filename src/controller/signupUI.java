package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.user.loginUI;
import dao.impl.adminDaoImpl;
import model.user;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class signupUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField account;
	private JTextField password;
	private JTextField address;
	private JTextField email;
	private JLabel accounterror;
	private JLabel pwderror;
	private JLabel emailerror;
	private JLabel lblNewLabel_4;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signupUI frame = new signupUI();
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
	public signupUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 404, 439);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 145));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("*使用者帳號 ");
		lblNewLabel.setBounds(63, 142, 113, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("*密碼");
		lblNewLabel_1.setBounds(79, 194, 77, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("居住地");
		lblNewLabel_2.setBounds(79, 243, 46, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("*Email");
		lblNewLabel_3.setBounds(79, 299, 46, 15);
		contentPane.add(lblNewLabel_3);
		
		account = new JTextField();
		account.setBounds(188, 138, 144, 21);
		contentPane.add(account);
		account.setColumns(10);
		
		password = new JTextField();
		password.setBounds(188, 190, 144, 21);
		contentPane.add(password);
		password.setColumns(10);
		
		address = new JTextField();
		address.setBounds(188, 239, 144, 21);
		contentPane.add(address);
		address.setColumns(10);
		
		email = new JTextField();
		email.setBounds(188, 295, 144, 21);
		contentPane.add(email);
		email.setColumns(10);
		
		accounterror = new JLabel("");
		accounterror.setBounds(63, 167, 144, 15);
		contentPane.add(accounterror);
		
		pwderror = new JLabel("");
		pwderror.setBounds(79, 216, 144, 15);
		contentPane.add(pwderror);
		
		emailerror = new JLabel("");
		emailerror.setBounds(79, 326, 144, 15);
		contentPane.add(emailerror);
		
		
		
		JButton register = new JButton("註冊");
		JButton btnNewButton= new JButton();
		
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
											
				String Account=account.getText();
				String Password=password.getText();
				String Email=email.getText();
				String Address=address.getText();
				
				if  (Account.length()<=0) {
					accounterror.setText("請設定帳號");
				} else 
				if (Password.length()<5) {
					pwderror.setText("密碼須至少5個字元");
			   } else
				
			   
				if (new adminDaoImpl().queryUsername(Account))
				{
				JOptionPane.showMessageDialog(btnNewButton, "帳號重複", "Error", JOptionPane.WARNING_MESSAGE);
				
				 }else {
			    	
				user u=new user(Account, Password, Email, Address);
				new adminDaoImpl().add(u);
				JOptionPane.showMessageDialog(btnNewButton, "註冊成功","Success", JOptionPane.INFORMATION_MESSAGE);
			  
				loginUI lg=new loginUI();
				lg.setVisible(true);
				dispose();
				 }
		
				
			}

			
		});
		register.setBounds(158, 342, 87, 48);
		contentPane.add(register);
		
		lblNewLabel_4 = new JLabel("快速註冊成為養雞員！");
		lblNewLabel_4.setForeground(new Color(53, 113, 168));
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(63, 31, 214, 61);
		contentPane.add(lblNewLabel_4);
		
		
		
		    
	}
}

