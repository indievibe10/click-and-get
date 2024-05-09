package controller.user;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import controller.itemsUI;
import controller.taskUI;
import util.timeFormat;

import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class userPageUI extends JFrame {
	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userPageUI frame = new userPageUI();
					
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
	public userPageUI() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(218, 10, 207, 195);
		contentPane.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		
		JButton btnNewButton = new JButton("孵化");
		panel_1.add(btnNewButton, "name_159970683240154");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			taskUI t=new taskUI();
			t.setVisible(true);
			dispose();
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 215, 198, 201);
		contentPane.add(panel_2);
		panel_2.setLayout(new CardLayout(0, 0));
		
		JButton btnNewButton_2 = new JButton("紀錄");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				queryPageUI qp= new queryPageUI();
				qp.setVisible(true);
				dispose();
			}
		});
		panel_2.add(btnNewButton_2, "name_24110400076700");
		
		JButton btnNewButton_1 = new JButton("兌換");
		btnNewButton_1.setBounds(218, 217, 207, 195);
		contentPane.add(btnNewButton_1);
		
		JLabel currenttime = new JLabel("");
		currenttime.setBounds(58, 49, 146, 126);
		contentPane.add(currenttime);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				itemsUI i=new itemsUI();
				i.setVisible(true);
				dispose();
			}
		});
		
		 Timer timer = new Timer(1000, new ActionListener() {
		 @Override
		  public void actionPerformed(ActionEvent e) {
		  String ct = timeFormat.updatetime();
		  currenttime.setText( "現在時間:"+ct);

			
		           
		 	}
		    });
		        
		 timer.start();
		        
		 }
		

	}

	

