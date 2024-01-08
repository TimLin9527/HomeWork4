package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


@SuppressWarnings("all")
public class intOut 
{	
	//寫入
	public static ObjectOutputStream addFile(String file) 
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
		
		return null;
	}
}
