package util;

import javax.swing.JOptionPane;

public class msg {

		public static void info() {
			
			JOptionPane.showMessageDialog(
	                null,
	                "蛋還未成功孵化",
	                "Warning",
	                JOptionPane.WARNING_MESSAGE);
		}
		
		
		public static void infob() {
			
			JOptionPane.showMessageDialog(
	                null,
	                "請輸入帳號將記錄上傳至系統",
	                "Warning",
	                JOptionPane.WARNING_MESSAGE);
		}
	}


