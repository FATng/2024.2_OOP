package lab1;

import java.util.Scanner;

public class DayInMonth {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String monthInput;
        int year = -1; 
        String[] months = {"January", "February", "March", "April", "May", "June",
                           "July", "August", "September", "October", "November", "December"};
        String[] shortMonths = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", 
                                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        int monthIndex = -1;
        while (monthIndex == -1) {
            System.out.print("Enter the month (name, abbreviation, or number 1-12): ");
            monthInput = keyboard.next().trim();
            try {
                int monthNum = Integer.parseInt(monthInput);
                if (monthNum >= 1 && monthNum <= 12) {
                    monthIndex = monthNum - 1;
                }
            } catch (NumberFormatException e) {
                for (int i = 0; i < 12; i++) {
                    if (monthInput.equalsIgnoreCase(months[i]) || monthInput.equalsIgnoreCase(shortMonths[i])) {
                        monthIndex = i;
                        break;
                    }
                }
            }

            if (monthIndex == -1) {
                System.out.println("Invalid month. Please try again.");
            }
        }

        while (true) {
            System.out.print("Enter a valid year (non-negative integer): ");
            if (keyboard.hasNextInt()) {
                year = keyboard.nextInt();
                if (year >= 0) {
                    break;
                }
            } else {
                keyboard.next(); // Clear invalid input
            }
            System.out.println("Invalid year. Please enter a non-negative number.");
        }

        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        // Determine the number of days in the month
        int days;
        if (monthIndex == 1) { // February
            days = isLeapYear ? 29 : 28;
        } else if (monthIndex == 3 || monthIndex == 5 || monthIndex == 8 || monthIndex == 10) {
            days = 30;
        } else {
            days = 31;
        }

        // Output result
        System.out.println("The number of days in " + months[monthIndex] + " " + year + " is: " + days);
    }
}

