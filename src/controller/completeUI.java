package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.user.userPageUI;
import dao.impl.taskDaoImpl;
import model.task;
import util.file;
import util.msg;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Panel;
import javax.swing.JProgressBar;

public class completeUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					completeUI frame = new completeUI();
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
	
	JTextArea textArea = new JTextArea();
	
	
	
	public completeUI() {
		setResizable(false);
	
		 int Complete, Point;                                                    
		 try (ObjectInputStream ois = file.readFile("a.txt")) {
               Complete = ois.readInt();
               Point = ois.readInt();
		 } catch (IOException e) {
               e.printStackTrace();
               Complete = 0;
               Point = 0;
           }
      
		  textArea.setText("已孵化: " + Complete + "顆\n"
			  		+ "點數: " + Point);
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(56, 250, 211, 72);
		contentPane.add(panel);
		panel.setLayout(null);
		textArea.setBounds(0, 6, 251, 65);
		panel.add(textArea);
		
		
	
		
		
		JButton Again = new JButton("繼續孵化");
		Again.setBounds(297, 260, 95, 54);
		Again.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					file.loadPoints("a.txt");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				taskUI t=new taskUI();
				t.setVisible(true);
				dispose();
			}
		});
		contentPane.add(Again);
		
		
		
		JButton btnNewButton_2 = new JButton("送出本次敷化紀錄");    
		btnNewButton_2.setBounds(286, 369, 134, 46);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (name.getText().isEmpty()) {
			            msg.infob();
				}else {
				try {
					file.loadPoints("a.txt");
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				 int Complete=0, Point=0;
				 try (ObjectInputStream ois = file.readFile("a.txt")) {
	                   Complete = ois.readInt();
	                   Point = ois.readInt();
				 } catch (IOException e2) {
	                    e2.printStackTrace();
	            
	             }
				
				String Name=name.getText();
				task t = new task(Name, +Complete, +Point);
				new taskDaoImpl().add(t);
				
				JOptionPane.showMessageDialog(null, "已新增紀錄");
				userPageUI up=new userPageUI();
				up.setVisible(true);
				dispose();
				
				
				 
				}	
			}
		});
		
		contentPane.add(btnNewButton_2);
		
		name = new JTextField();
		name.setBounds(163, 380, 108, 21);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("請輸入帳號名稱");
		lblNewLabel.setBounds(56, 383, 134, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(completeUI.class.getResource("/util/complete.gif")));
		lblNewLabel_1.setBounds(94, 26, 264, 196);
		contentPane.add(lblNewLabel_1);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(56, 349, 352, 88);
		contentPane.add(panel_1);
	
	}
}