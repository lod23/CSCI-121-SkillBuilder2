/**
 * This class provides various static methods that calculate various quantities
 * related to dates, including the day of week a date fall on.
 * @author
 * @version
 */
public class Date {
    /**
     * Returns true if the year is a leap year; otherwise false
     *
     * @param year the year
     * @return true if the year is a leap year; otherwise false.
     */
    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            }
            return true;
        }
        return false;
    }

    /**
     * Returns the name of the day given by dayValue
     *
     * @param dayValue Numerical value of the day in the range 0 to 6, inclusively
     * @return the name of the day given by dayValue
     */
    public static String getNameOfDay(int dayValue) {
        // Ensure dayValue is within the range [0, 6]
        int wrappedDay = ((dayValue % 7) + 7) % 7;

        String dayName;
        switch (wrappedDay) {
            case 0:
                dayName = "Sunday";
                break;
            case 1:
                dayName = "Monday";
                break;
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            case 4:
                dayName = "Thursday";
                break;
            case 5:
                dayName = "Friday";
                break;
            case 6:
                dayName = "Saturday";
                break;
            default:
                return null; // This case is never reached due to wrapping
        }
        return dayName; //Only one return statement, returning the dayName

    }

    public static void main(String[] args) {
        String day = getNameOfDay(32);  // Should return "Thursday"
        System.out.println(day); // Output: Thursday

        // Example usage of equalsIgnoreCase
        if ("thursday".equalsIgnoreCase(day)) {
            System.out.println("It's Thursday! Week is nearly ending.");
        } else {
            System.out.println("It's not Thursday.");
        }
    }


    /**
     * \
     * Returns the numeric value of the month.
     * 1 - January
     * 2 - February
     * ...
     * 12 - December
     *
     * @param name name of the month
     * @return the numeric value of the month.
     */
    public static int getMonthNumber(String name) {
        if (name.equalsIgnoreCase("January")) return 1;
        if (name.equalsIgnoreCase("February")) return 2;
        if (name.equalsIgnoreCase("March")) return 3;
        if (name.equalsIgnoreCase("April")) return 4;
        if (name.equalsIgnoreCase("May")) return 5;
        if (name.equalsIgnoreCase("June")) return 6;
        if (name.equalsIgnoreCase("July")) return 7;
        if (name.equalsIgnoreCase("August")) return 8;
        if (name.equalsIgnoreCase("September")) return 9;
        if (name.equalsIgnoreCase("October")) return 10;
        if (name.equalsIgnoreCase("November")) return 11;
        if (name.equalsIgnoreCase("December")) return 12;

        return -1; // Return -1 for invalid month names
    }

    /**
     * Returns the name of the month given the numeric value provided by month
     * 1 - January
     * 2 - February
     * ...
     * 12 - December
     *
     * @param month Numeric value of the month.  Should be 1 to 12, inclusively
     * @return the name of the month given the numeric value provided by month
     */
    public static String getMonthName(int month) {
        switch (month) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
        }
        return null;
    }

    /**
     * Returns the number of days in the month given by the parameter month
     *
     * @param month the numeric value of the month
     * @param year  year
     * @return the number of days in the month given by the parameter month
     */
//    public static int getDaysInMonth(int month, int year) {
//        switch (month) {
//            case 1:
//            case 3:
//            case 5:
//            case 7:
//            case 8:
//            case 10:
//            case 12:
//                return 31;
//            case 4:
//            case 6:
//            case 9:
//            case 11:
//                return 30;
//            case 2:
//                // Check if it's a leap year
//                if (isLeapYear(year)) {
//                    return 29;
//                } else {
//                    return 28;
//                }
//        }
//        return -1;
//    }

    /**
     * Returns the number of days in the month given by the parameter month
     *
     * @param month the name of the month
     * @param year  year
     * @return the number of days in the month
     */
    public static int getDaysInMonth(String month, int year) {
        int monthNumber = getMonthNumber(month);
        switch (monthNumber) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                // Check if it's a leap year
                if (isLeapYear(year)) {
                    return 29;
                } else {
                    return 28;
                }
        }
        return -1;
    }

    /**
     * Returns the offset in days for the month relative to January
     *
     * @param month numeric value of the month
     * @param year  year
     * @return the offset in days for the month relative to January
     */
    public static int getMonthOffset(int month, int year) {
            int[][] offsets = {
                    {0, 0}, // January
                    {3, 3}, // February
                    {3, 4}, // March
                    {6, 0}, // April
                    {1, 2}, // May
                    {4, 5}, // June
                    {6, 0}, // July
                    {2, 3}, // August
                    {5, 6}, // September
                    {0, 1}, // October
                    {3, 4}, // November
                    {5, 6}  // December
            };

            // Check if the month is valid
            if (month < 1 || month > 12) {
                return -1;
            }

            // Determine if it's a leap year
            boolean isLeapYear = year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);

            // Return the appropriate offset using the correct index (0 or 1)
            return offsets[month - 1][isLeapYear ? 1 : 0]; // month-1 as array index starts from 0
    }

    /**
     * Returns the day of the week that the date falls on
     * @param month numeric value of the month
     * @param dayOfMonth day of the month
     * @param year year
     * @return the day of the week that the date falls on
     */
    public static int dayOfWeek(int month, int dayOfMonth, int year) {
        if (month < 1 || month > 12 || dayOfMonth < 1 || dayOfMonth > getDaysInMonth(month, year)) {
            return -1; // Return -1 for invalid input
        }

        // Adjust month and year for Zeller's Congruence
        if (month < 3) {
            month += 12;
            year -= 1;
        }

        int k = year % 100;   // Last two digits of the year
        int j = year / 100;   // First two digits of the year

        // Zeller's Congruence formula
        int h = (dayOfMonth + (13 * (month + 1)) / 5 + k + (k / 4) + (j / 4) + (5 * j)) % 7;

        // Convert Zeller's output (0 = Saturday, 1 = Sunday, ..., 6 = Friday) to our format
        int dayOfWeek = (h + 6) % 7;

        return dayOfWeek;
    }

    // Method to get the number of days in a given month and year
    public static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
        }
        return -1;
    }

    /**
     * Returns the day of the week that the date falls on
     * @param month name of the month
     * @param dayOfMonth day of the month
     * @param year year
     * @return the day of the week that the date falls on
     */
    public static int dayOfWeek(String month, int dayOfMonth, int year) {
        // Convert month name to corresponding month number
        int monthNumber = getMonthNumber(month);
        if (monthNumber == -1 || dayOfMonth < 1 || dayOfMonth > getDaysInMonth(monthNumber, year)) {
            return -1; // Return -1 for invalid input
        }

        // Call the overloaded method using the month number
        return dayOfWeek(monthNumber, dayOfMonth, year);
    }

    // Overloaded dayOfWeek method that accepts an int month
//    public static int dayOfWeek(int month, int dayOfMonth, int year) {
//        if (month < 1 || month > 12 || dayOfMonth < 1 || dayOfMonth > getDaysInMonth(month, year)) {
//            return -1; // Return -1 for invalid input
//        }
//
//        // Adjust month and year for Zeller's Congruence
//        if (month < 3) {
//            month += 12;
//            year -= 1;
//        }
//
//        int k = year % 100;   // Last two digits of the year
//        int j = year / 100;   // First two digits of the year
//
//        // Zeller's Congruence formula
//        int h = (dayOfMonth + (13 * (month + 1)) / 5 + k + (k / 4) + (j / 4) + (5 * j)) % 7;
//
//        // Convert Zeller's output (0 = Saturday, 1 = Sunday, ..., 6 = Friday) to our format
//        int dayOfWeek = (h + 6) % 7;
//
//        return dayOfWeek;
//    }

    // Helper method to get the month number from the month name
//    public static int getMonthNumber(String month) {
//        switch (month.toLowerCase()) {
//            case "january": return 1;
//            case "february": return 2;
//            case "march": return 3;
//            case "april": return 4;
//            case "may": return 5;
//            case "june": return 6;
//            case "july": return 7;
//            case "august": return 8;
//            case "september": return 9;
//            case "october": return 10;
//            case "november": return 11;
//            case "december": return 12;
//            default: return -1; // Invalid month name
//        }
//    }

    // Method to get the number of days in a given month and year
//    public static int getDaysInMonth(int month, int year) {
//        switch (month) {
//            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
//                return 31;
//            case 4: case 6: case 9: case 11:
//                return 30;
//            case 2:
//                return isLeapYear(year) ? 29 : 28;
//        }
//        return -1; // Invalid month
//    }

}
