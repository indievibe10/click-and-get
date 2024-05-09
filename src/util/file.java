package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class file {
	public static ObjectOutputStream addFile(String file,int loadedComplete, int loadedPoint)
	{
		ObjectOutputStream oos=null;
		
		try {
			FileOutputStream fos=new FileOutputStream(file);
			oos=new ObjectOutputStream(fos);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return oos;
	}
	
	//讀取
	
	public static ObjectInputStream readFile(String file)
	{
		ObjectInputStream ois=null;
		try {
			FileInputStream fis=new FileInputStream(file);
			ois=new ObjectInputStream(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ois;
	}

	public static void savePoints(String file, int complete, int point) {
        try (ObjectOutputStream oos = 
        		new ObjectOutputStream(new FileOutputStream("a.txt"))) {
            oos.writeInt(complete);
            oos.writeInt(point);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	
public static void loadPoints(String file) throws ClassNotFoundException {
    try (ObjectInputStream ois =
    		new ObjectInputStream(new FileInputStream("a.txt"))) {
    } catch (IOException e2) {
        e2.printStackTrace();
    }
}
}
