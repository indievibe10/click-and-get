package util;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class timeFormat {
	
		public static String updatetime() {
			  LocalDateTime now=LocalDateTime.now();
			  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
			  return now.format(formatter);
			 
		
		}

		
}