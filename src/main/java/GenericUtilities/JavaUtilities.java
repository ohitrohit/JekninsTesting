package GenericUtilities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
/**
 * This class contain all the genric methods for Java 
 * @author rohit
 */

public class JavaUtilities {

	 /**
     * this method provide date and time
     * @return
     */
	public String getStringDate() {
		Date d = new Date();
		return d.toString();
	}
	/**
	 * this method provide date and time in a proper format
	 * @return
	 */
	public String getSystemDateInFormat() {
		
		Date d = new Date();
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/YYYY hh.mm a");
		String finalDate = date.format(d);
		return finalDate;
	}
	/**
	 * this method will return a random number for every run
	 * @return
	 */
	public static int getRandomNumber() {
		Random r = new Random();
		return r.nextInt(10000000);
	}
	/**
	 * this method is used to get different email ID Every time
	 * @return
	 */
//	 public static String getEmailID() {
//	        long timestamp = System.currentTimeMillis(); // Get current timestamp
//	        String email = "srk" + timestamp + getRandomNumber() + "@kine.ai"; // Append timestamp to email address
//	        return email;
//	    }
	
	/**
     * This method generates a company name using random prefixes and suffixes
     * @return Generated company name
     */
    public static String getCompanyName() {
        String[] prefixes = {"Tech", "Innovate", "Global", "Smart", "Dynamic"};
        String[] suffixes = {"Solutions", "Systems", "Labs", "Enterprises", "Tech"};

        Random random = new Random();
        StringBuilder companyNameBuilder = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            companyNameBuilder.append(prefixes[random.nextInt(prefixes.length)]);
            companyNameBuilder.append(suffixes[random.nextInt(suffixes.length)]);
        }

        // Trim the name to a maximum of 10 characters
        return companyNameBuilder.toString().substring(0, Math.min(companyNameBuilder.length(), 10));
    }
    
    public  String getCurrentDate() {
        LocalDate currentDate = LocalDate.now(); 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
        return currentDate.format(formatter); 
    }
}