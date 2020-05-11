package file;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class ReadFile implements Serializable {
	
		public boolean y = false;
		public String correctId = null;
		
		
		    public boolean confirmLogin(String fullName, String id){
		             
		            try{
		            	ObjectInputStream is = new ObjectInputStream(new FileInputStream(id + ".ser"));

		                correctId = (String) is.readObject();
		                is.close();
		                } catch(Exception ex){
		                ex.printStackTrace();
		                }
		                 
		            System.out.println("name is: " + fullName);
		        System.out.println("id is: " + id);
		     
		    return y;
		     
		 
		        }
	
	

}
