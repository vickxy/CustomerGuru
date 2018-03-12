import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAdjusters;

public class CustomerGuru_01 {
	public static void main(String [] args){
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter fromdate date (yyy-mm-dd):");
        String fromDate = sc.nextLine();
        System.out.println("Enter todate date (yyyy-mm-dd):");
        String todate = sc.nextLine();
        firstAndLast_(fromDate.trim(), todate.trim());
	}

	private static void firstAndLast_(String fromdate, String todate) {
		LocalDate today, convertedDate, fromdatereturn, todatereturn;
		today = LocalDate.now();
		try {
			convertedDate = LocalDate.parse(fromdate, DateTimeFormatter.ofPattern("yyyy-M-d"));
			fromdatereturn = convertedDate.with(TemporalAdjusters.firstDayOfMonth());
			convertedDate = LocalDate.parse(todate, DateTimeFormatter.ofPattern("yyyy-M-d"));
			todatereturn = convertedDate.withDayOfMonth(
			                                convertedDate.getMonth().length(convertedDate.isLeapYear()));		
		if(todatereturn.compareTo(today) > 0) {
			todatereturn = today;
		}
		System.out.println("fromdatereturn: " + fromdatereturn);
		System.out.println("todatereturn: " + todatereturn);
		} catch (DateTimeParseException e) {
            System.out.println("Please enter a valid date in the specified format...");
        }
	}
}
