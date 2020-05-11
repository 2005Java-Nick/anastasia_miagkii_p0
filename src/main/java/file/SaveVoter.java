package file;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SaveVoter {
	
	String fullName = null;
    String idNumber = null;
    
    
    public void storeUserData(String name, String id, String birthDate){
        
        fullName = name;
        System.out.println("Full Name is: " + fullName);
        idNumber = id;
        System.out.println("username is: " + idNumber);
        
        try{
            FileOutputStream fs = new FileOutputStream(id + ".ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(fullName);
            os.writeObject(idNumber);
            os.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
	
	

   
