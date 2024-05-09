package controller;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

import controller.user.userPageUI;
import util.file;
import util.msg;
import javax.swing.ImageIcon;

public class taskUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private int feed = 0;
    private int play = 0;
    private int sing = 0;
    private JProgressBar progressBar;

    private static Integer complete = 0;
    private static Integer point = 0;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    taskUI frame = new taskUI();
                    frame.setVisible(true);
                    file.readFile("a.txt");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public taskUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 507, 523);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 248, 174));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        progressBar = new JProgressBar();
        progressBar.setBounds(215, 328, 146, 33);
        progressBar.setStringPainted(true);
        contentPane.add(progressBar);

        JLabel lblNewLabel = new JLabel("孵化進度");
        lblNewLabel.setForeground(new Color(25, 92, 201));
        lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
        lblNewLabel.setBounds(121, 328, 97, 20);
        contentPane.add(lblNewLabel);

        JButton s = new JButton("唱歌");
        s.setBounds(194, 373, 111, 38);
        s.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                sing += 20;
                fillBar();
            }
        });
        contentPane.add(s);

        JButton p = new JButton("玩耍");
        p.setBounds(328, 373, 111, 38);
        p.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                play += 15;
                fillBar();
            }
        });
        contentPane.add(p);

        JButton f = new JButton("餵食");
        f.setBounds(56, 373, 111, 38);
        contentPane.add(f);

        f.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                feed += 10;
                fillBar();
            }
        });

        JButton logout = new JButton("登出");
        logout.setBounds(6, 6, 97, 26);
        logout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });
        contentPane.add(logout);

        JButton claim = new JButton("查看");
        claim.setBackground(new Color(104, 124, 201));
        claim.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        claim.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (progressBar.getValue() == 100) {
                    complete += 1;
                    point += 10;

                    file.savePoints("a.txt", complete, point);
                    //"c:/new/a.txt"

                    completeUI c = new completeUI();
                    c.setVisible(true);

                    dispose();
                } else {
                    msg.info();
                }
            }
        });

        claim.setBounds(194, 438, 117, 38);
        contentPane.add(claim);

        JButton mainpage = new JButton("回到選單");
        mainpage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                userPageUI uP=new userPageUI();
                uP.setVisible(true);
                dispose();
            }
        });
        mainpage.setBounds(104, 5, 117, 29);
        contentPane.add(mainpage);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(taskUI.class.getResource("/util/xmasdragon_egg.png")));
        lblNewLabel_1.setBounds(135, 46, 226, 258);
        contentPane.add(lblNewLabel_1);
    }

    private void fillBar() {
        int progress = feed + play + sing;
        int max = 100;
        int value = (progress * max) / 100;
        progressBar.setValue(value);
        progressBar.repaint();
    }
}
