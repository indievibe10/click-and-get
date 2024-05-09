package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.user.queryPageUI;
import controller.user.userPageUI;
import dao.impl.itemsDaoImpl;
import dao.impl.queryDaoImpl;

import java.awt.GridLayout;
import javax.swing.JComboBox;

import model.items;
import model.query;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Panel;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.Label;
import javax.swing.JTextField;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class itemsUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Integer point;
	int balance;
	int C=5;
	int S=15;
	int W=30;
	int CA;
	int SA;
	int WA;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					itemsUI frame = new itemsUI();
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
	public itemsUI() {
 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 558, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 0, true));
		panel.setBounds(37, 123, 190, 180);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		
		
		JLabel lblNewLabel = new JLabel("三明治");
		panel.add(lblNewLabel);
		
		
			
		JComboBox<Integer> sandwichbox = new JComboBox<>();
		sandwichbox.setEditable(true);
		panel.add(sandwichbox);
		
		sandwichbox.addItem(0);
		sandwichbox.addItem(5);
		sandwichbox.addItem(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("親子丼");
		panel.add(lblNewLabel_1);

		
		JComboBox<Integer> donbox = new JComboBox<>();
		donbox.setEditable(true);
		panel.add(donbox);
		
		donbox.addItem(0);
		donbox.addItem(5);
		donbox.addItem(10);
		
		JLabel lblNewLabel_2 = new JLabel("快樂水");
		panel.add(lblNewLabel_2);
		
		JComboBox<Integer> waterbox = new JComboBox<>();
		waterbox.setEditable(true);
		panel.add(waterbox);
		
		waterbox.addItem(0);
		waterbox.addItem(5);
		waterbox.addItem(10);
		
	
		Panel panel_1 = new Panel();
		panel_1.setBounds(318, 10, 208, 293);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
	
		Label swpt = new Label("");
		panel_1.add(swpt);
		
		
		
		
		sandwichbox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange()==ItemEvent.SELECTED) {
				Integer Sandwich = (Integer) sandwichbox.getSelectedItem();
				CA=5*Sandwich;
				swpt.setText("三明治數量:" + Sandwich +"\t共計:"+CA+"點");
				
	
				}
			}

			});
		
		Label donpt = new Label("");
		panel_1.add(donpt);
		
		donbox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange()==ItemEvent.SELECTED) {
					 Integer Don = (Integer) donbox.getSelectedItem();	
					 SA= 15*Don;
					 donpt.setText("親子丼數量:"+Don+"\t共計:"+SA+"點");
					
				}
			}
			
		});
		
		Label wtpt = new Label("");
		panel_1.add(wtpt);
		
		
		waterbox.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange()==ItemEvent.SELECTED) {
						 Integer Water = (Integer) waterbox.getSelectedItem();
						 WA= 30*Water;
						 wtpt.setText("快樂水數量:"+Water+"\t共計:"+WA+"點");
				}
				}

			});
		
		System.out.println(+(CA+SA+WA));
		
		Label sumpoint = new Label("");
		panel_1.add(sumpoint);
	
		
		Label balancepoint = new Label("");
		panel_1.add(balancepoint);
		
				
				JButton submit = new JButton("兌換");
				submit.setBounds(395, 296, 75, 38);
				contentPane.add(submit);
				
				JPanel panel_2 = new JPanel();
				panel_2.setBounds(37, 37, 183, 83);
				contentPane.add(panel_2);
				panel_2.setLayout(null);
				
				JLabel lblNewLabel_3 = new JLabel("輸入帳號");   
				lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
				lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
				lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
				lblNewLabel_3.setBounds(22, 6, 125, 16);
				panel_2.add(lblNewLabel_3);
				
				
				JTextField name = new JTextField();
				name.setBounds(16, 22, 80, 26);
				panel_2.add(name);
				name.setColumns(10);
				
				JLabel available = new JLabel("");
				available.setBackground(new Color(245, 255, 146));
				available.setBounds(16, 51, 161, 26);
				panel_2.add(available);
				
				
				
				JButton btnNewButton_1 = new JButton("查詢");
				btnNewButton_1.setBounds(91, 22, 96, 29);
				panel_2.add(btnNewButton_1);
				btnNewButton_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						
					 List<query> l=new queryDaoImpl().querypoint(name.getText());
					
						 
					for (query q:l)
						{
							int balance = q.getBalance( ) != null ? q.getBalance( ) : 0;
							int net=q.getPoint() - balance;
							available.setText("可使用點數:"+net);
							point=net;
	
						}
						
					}
				});
				
				JButton btnNewButton = new JButton("登出");
				btnNewButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
					dispose();
					}
				});
				btnNewButton.setBounds(121, 0, 117, 29);
				contentPane.add(btnNewButton);
				
				JButton btnNewButton_2 = new JButton("回選單");
				btnNewButton_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
					userPageUI uP=new userPageUI();
					uP.setVisible(true);
					dispose(); 
					}
				});
				btnNewButton_2.setBounds(6, 0, 117, 29);
				contentPane.add(btnNewButton_2);
				

				
				
				submit.addMouseListener(new MouseAdapter() {
				    @Override
				    public void mouseClicked(MouseEvent e) {
				       
				            String Name = name.getText();
				            Integer Sandwich = (Integer) sandwichbox.getSelectedItem();
				            Integer Don = (Integer) donbox.getSelectedItem();
				            Integer Water = (Integer) waterbox.getSelectedItem();
				            try {
				            if (Name.equals("") || point == null) {
				                JOptionPane.showMessageDialog(
				                        null,
				                        "無法兌換，忘記輸入帳號名稱囉～",
				                        "Warning",
				                        JOptionPane.WARNING_MESSAGE);
				                return;
				            }

				            items i = new items(Name, Sandwich, Don, Water, point);
				            Integer Sum = i.getSum();
				            Integer Point = i.getPoint();

				            if (Sum > Point) {
				                int msg = JOptionPane.showOptionDialog(
				                        null,
				                        "本次商品兌換需 " + i.getSum() + " 點，請再多賺取點數或更改需要品項",
				                        "點數不足",
				                        JOptionPane.YES_NO_OPTION,
				                        JOptionPane.INFORMATION_MESSAGE,
				                        null,
				                        new String[]{"前往孵蛋中心", "重新選擇品項"},
				                        "前往孵蛋中心"
				                );

				                if (msg == JOptionPane.YES_OPTION) {
				                    taskUI tu = new taskUI();
				                    tu.setVisible(true);
				                    dispose();
				                } else if (msg == JOptionPane.NO_OPTION) {
				                    
				                }
				            }

				            if (Sum <= Point) {
				                name.setText("帳號" + i.getName());
				                swpt.setText("三明治數量" + i.getSandwich());
				                donpt.setText("親子丼數量" + i.getDon());
				                wtpt.setText("快樂水數量" + i.getWater());
				                sumpoint.setText("點數總計:" + String.valueOf(i.getSum()));

				                balance = Point - Sum;

				                balancepoint.setText("餘點:" + i.getBalance());

				                int msg2 = JOptionPane.showOptionDialog(
				                        null,
				                        "兌換完成，去查看紀錄",
				                        "繼續兌換",
				                        JOptionPane.YES_NO_OPTION,
				                        JOptionPane.INFORMATION_MESSAGE,
				                        null,
				                        new String[]{"兌換完成，去查看紀錄", "繼續兌換"},
				                        "兌換完成，去查看紀錄"
				                );

				                if (msg2 == JOptionPane.YES_OPTION) {
				                    queryPageUI qp = new queryPageUI();
				                    qp.setVisible(true);
				                    dispose();
				                } else if (msg2 == JOptionPane.NO_OPTION) {
				                	dispose();
				                	itemsUI frame = new itemsUI();
									frame.setVisible(true);
				                    
				                }

				                new itemsDaoImpl().add(i);
				            }
				        } catch (Exception ex) {
				            ex.printStackTrace();
				        }
				    }
				});
}
}
