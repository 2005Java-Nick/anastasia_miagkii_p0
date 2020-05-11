package logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class VoterLogic {
	
	//creating objects
	AdminPassword admin = new AdminPassword();
	
	//checks if person is 18 and older
	public boolean CalculateAge(String birthDate) throws ParseException {
	
			//creating objects
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		  Date d = sdf.parse(birthDate);
		  Calendar c = Calendar.getInstance();
		  c.setTime(d);
		  int year = c.get(Calendar.YEAR);
		  int month = c.get(Calendar.MONTH) + 1;
		  int date = c.get(Calendar.DATE);
		  LocalDate l = LocalDate.of(year, month, date);
		  LocalDate now = LocalDate.now();
		  Period diff = Period.between(l, now);
	  
	  if(diff.getYears()>= 18) {
		  return true;
	  	}
		  else {
			  return false;
		}
	  
	}
	
	//check if id contains 5-digits
	public boolean IdLength(String id) {
		if(id.matches("[0-9]+") && id.length() == 5) {
			return true;
		}else
		return false;
	}

//check if name contains only letters (METHOD DOESN'T WORK!!!)
//	public boolean isLetters(String fullName) {
//		if (Pattern.matches("[a-zA-Z]+",fullName)) { 
//			  return true;
//			}else{
//			  return false;    
//			}
//	}
	
	//check if person typed full name, should contain space
	public boolean hasSpace (String fullName ) {
		if(fullName.contains(" ") ) {
			return true;
		}else
		return false;
	}
	
	
	//check if it was typed "admin"
	public boolean checkAdmin(String fullName) {
		if(fullName.equals("admin")) {
			return true;
		}
		else {
			return false;
		}
	}

	
	
}
	
	
	

	    	
	