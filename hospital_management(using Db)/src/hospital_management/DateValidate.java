package hospital_management;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValidate {
	
	public static boolean dateValidate(String dateString) {
		boolean isTrue;
		Date date;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		try {
			date =sdf.parse(dateString);
			isTrue=true;
		} catch (ParseException e) {
			System.out.println("Pleade enter valid date(yyyy/MM/dd)"+e.getMessage());
			isTrue=false;
		}
		return isTrue;
	}

}
