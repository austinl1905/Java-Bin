import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class JavaUI {
	public static void main (String[]args) throws InterruptedException {
	
		LocalDate myDate = LocalDate.now();
		DateTimeFormatter myDatePattern = DateTimeFormatter.ofPattern("E, MMM-dd-yyyy");
		
		String myDateFormatted = myDate.format(myDatePattern);
		System.out.println("Today's date is ".concat(String.valueOf(myDateFormatted))); 
	
		Thread.sleep(1000);  
		
		System.out.print("The time right now is ");
	
	while (true) {
		
		LocalTime myTime = LocalTime.now();
		DateTimeFormatter myTimePattern = DateTimeFormatter.ofPattern("h:mm a");
		String myTimeFormatted = myTime.format(myTimePattern);
		System.out.print(String.valueOf(myTimeFormatted));
		
		Thread.sleep(1000);
		System.out.print("\b\b\b\b\b\b\b"); }
		
	


	}
}