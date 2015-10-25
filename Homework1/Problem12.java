import java.util.Scanner;

public class Problem12 {

	public static void main(String[] args) {
		// ¬исокосни години са всички години кратни на 4 с изключени€
		// столети€та, но без столети€ кратни на 400, т.е. 1900 не е високосна,
		// но 1600 и 2000 са високосни.
		// —ъставете програма, ко€то по дадени ден, месец, година отпечатва
		// следващата дата.
		// ¬ходни данни: три числа за ден, месец, година.
		
		System.out.println("Please enter year");
		int year = 0;
		boolean isLeapYear = false;
		year = CheckInteger(year);
		
		if (year % 400 == 0) {
			isLeapYear = true;
		} else if (year % 4 == 0 && year % 100 != 0 && year > 400){
			isLeapYear = true;
		}
		
		System.out.println("Please enter month");
		int month = 0;
		boolean isMonth = false;
		month = CheckInteger(month);
		
		while (!isMonth) {
			if(month >12 || month < 1) {
				System.err.println("Valid months are from 1 to 12! Try again!");
				month = CheckInteger(month);
			} else {
				isMonth = true;
			}
		}
		
		System.out.println("Please enter day");
		int day = 0;
		day = CheckInteger(day);
		boolean isDay = false;
		
		while (!isDay) {
			if (day <= 0) {
				System.err.println("Can't be negative number or zero");
				day = CheckInteger(day);
			} else if (day > 30 && (month == 4 || month == 6 || month == 9 || month == 11)) {
				System.err.println("This month has only 30 days! Try again!");
				day = CheckInteger(day);
			} else if (isLeapYear && day > 29 && month == 2) {
				System.err.println("In leap year Fenruary has 29 days! Try again!");
				day = CheckInteger(day);
			} else if (!isLeapYear && day > 28 && month == 2) {
				System.err.println("The year is not leap so February has 28 days! Try again!");
				day = CheckInteger(day);
			} else if (day > 31 && (month != 4 || month != 6 || month != 9 || month != 11)){
				System.err.println("This month has only 31 days! Try again!");
				day = CheckInteger(day);
			} else {
				isDay = true;
			}
		}
		
		int nextDay = day;
		int nextMonth = month;
		int nextYear = year;
		
		if (isLeapYear && day == 29 && month == 2) {
			nextDay = 1;
			nextMonth ++;
		} else if (day == 30 && (month == 4 || month == 6 || month == 9 || month == 11)) {
			nextDay = 1;
			nextMonth ++;
		} else if (day == 31 && month == 12) {
			nextDay = 1;
			nextMonth = 1;
			nextYear ++;
		} else if (day == 31) {
			nextDay = 1;
			nextMonth ++;
		} else {
			nextDay ++;
		}
		
		System.out.println("You entered: " + day + "/" + month + "/" + year);
		if (isLeapYear) {
			System.out.println(year + " is leap-year!");
		}
		System.out.println("Next date is " + nextDay + "/" + nextMonth + "/" + nextYear);
	}
	private static int CheckInteger (int number) {
		boolean inputOk = false;
		Scanner sc = new Scanner(System.in);
		while(!inputOk) {	        
            try {
            	number = sc.nextInt();
            	if (number >= 0) {
					inputOk = true;
				}else {
					System.err.println("Can't be negative! Try again!");
				}
            } catch (Exception e) {
                System.err.println("That's not an integer! TRY AGAIN!");
                sc.next(); 
            }
    }
		
		return number;
	}

}
