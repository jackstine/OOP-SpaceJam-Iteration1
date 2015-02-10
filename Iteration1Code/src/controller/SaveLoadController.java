package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class SaveLoadController {
	protected boolean pressedSave;
	
	public void save(TestGameController s){
		try
	      {
	         FileOutputStream fileOut =
	         new FileOutputStream("apple.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(s.apple);
	         out.close();
	         fileOut.close();
	         System.out.println("Serialized data is saved in apple.ser");
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
	}
	
	public void load(TestGameController s){
		  Apple a = null;
		  try
		  {
		     FileInputStream fileIn = new FileInputStream("apple.ser");
		     ObjectInputStream in = new ObjectInputStream(fileIn);
		     a = (Apple) in.readObject();
		     in.close();
		     fileIn.close();
		  }catch(IOException i)
		  {
		     i.printStackTrace();
		     return;
		  }catch(ClassNotFoundException c)
		  {
		     System.out.println("Apple class not found");
		     c.printStackTrace();
		     return;
		  }
		  s.apple = a;
	}
}
