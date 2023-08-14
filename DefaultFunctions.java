import java.util.Scanner;
import java.time.LocalDate;
import java.util.Scanner;


public class DefaultFunctions
{
    
    
    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            System.out.println("Failed to clear console: " + e.getMessage());
        }
    }
    
    public static LocalDate dateVerifier(){
        Scanner scanner = new Scanner(System.in);
        LocalDate foundationDate = null;
        boolean validDate = false;
        while (!validDate) {
            String inputDate = scanner.nextLine();
    
            String[] dateParts = inputDate.split("-");
            if (dateParts.length == 3) {
                int year = Integer.parseInt(dateParts[0]);
                int month = Integer.parseInt(dateParts[1]);
                int day = Integer.parseInt(dateParts[2]);
    
                if (DefaultFunctions.isValidDate(year, month, day)) {
                    foundationDate = LocalDate.of(year, month, day);
                    validDate = true;
                } else {
                    System.out.println("Invalid date format or values. Please enter date in yyyy-MM-dd format:");
                }
            } else {
                System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format:");
            }
        }
        return foundationDate;
    }

    public static boolean isValidDate(int year, int month, int day) {
        if (month < 1 || month > 12) {
            return false;
        }
    
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && isLeapYear(year)) {
            daysInMonth[1] = 29;
        }
    
        return day >= 1 && day <= daysInMonth[month - 1];
    }
    
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
