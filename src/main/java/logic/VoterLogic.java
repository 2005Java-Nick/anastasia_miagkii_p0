package logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class VoterLogic {
	
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
	public boolean passportLength(String num) {
		if(num.matches("[0-9]+") && num.length() == 9 && num.charAt(0)=='5') {
			return true;
		}else
		return false;
	}

	
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

	public boolean isCitizen(String answer) {
		if(answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
	
	
	

	    	
	