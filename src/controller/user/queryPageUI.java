package controller.user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.impl.queryDaoImpl;
import model.query;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class queryPageUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField name;
	private JButton btnNewButton_2;
	private JLabel balance;
	private JButton btnNewButton_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					queryPageUI frame = new queryPageUI();
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
	public queryPageUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 93, 595, 220);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		scrollPane.setViewportView(table);
		
		name = new JTextField();
		name.setBounds(19, 33, 130, 26);
		contentPane.add(name);
		name.setColumns(10);
		
		JButton btnNewButton = new JButton("孵化紀錄");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Name = name.getText();

                if (Name.equals("")) {
                    JOptionPane.showMessageDialog(btnNewButton, "請輸入姓名");
                } else {
                    if (new queryDaoImpl().record(Name) != null) {
                        
                    	table.setVisible(true);
                        ArrayList<Object[]> record = new queryDaoImpl().record(Name);
                        DefaultTableModel model = new DefaultTableModel();
                        model.setColumnIdentifiers(new String[]{"id", "帳號名稱", "孵化次數", "點數"});

                        for (Object[] row : record) {
                        model.addRow(row);
                        }

                        table.setModel(model);
                    } else {
                        
                        JOptionPane.showMessageDialog(btnNewButton, "查無此人");
                    }
                }
				
				
				
			}
		});
		btnNewButton.setBounds(161, 6, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("兌換紀錄");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Name = name.getText();

      		  if (Name.equals("")) {
                    JOptionPane.showMessageDialog(btnNewButton, "請輸入姓名"); 
                  
      		  } else {
      		  
      			  table.setVisible(true);
                   ArrayList<Object[]> items = new queryDaoImpl().items(Name);
                   DefaultTableModel model = new DefaultTableModel();
                   model.setColumnIdentifiers(new String[]{"序號","帳號名稱", "三明治", "親子丼", "快樂水","點數總計","餘額"});

                   for (Object[] row:items) {
                   model.addRow(row);
                   }

                   table.setModel(model);
                   };
        
				
			}
		});
		btnNewButton_1.setBounds(161, 33, 117, 29);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("剩餘點數");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String Name = name.getText();

	      		  if (Name.equals("")) {
	                    JOptionPane.showMessageDialog(btnNewButton, "請輸入姓名"); 
	                  
	      		  } else {
	      			 List<query> l=new queryDaoImpl().querypoint(name.getText());
	      			 for (query q:l)
					{
	      				 int net=q.getPoint()-q.getBalance();
	      				 balance.setText("可使用點數:"+net);		 
	      			
	      			 }
	      			  
	      		
	      		  }
	      		  
				
				
			}
		});
		btnNewButton_2.setBounds(161, 61, 117, 29);
		contentPane.add(btnNewButton_2);
		
		balance = new JLabel("");
		balance.setBounds(291, 66, 137, 16);
		contentPane.add(balance);
		
		btnNewButton_3 = new JButton("回選單");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			userPageUI uP=new userPageUI();
			uP.setVisible(true);
			dispose();
			}
		});
		btnNewButton_3.setBounds(484, 6, 117, 29);
		contentPane.add(btnNewButton_3);
	}
}
