import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * This class is in charge of checking validity input methods.
 */
public class CheckValidity {
    /**
     * Check if user input in mainMenu.
     *
     * @param userChoice user input, valid value is from 0 to 7.
     * @return true if input valid, otherwise returns false.
     */
    public static boolean isMainMenuInputValid(String userChoice) {
        switch (userChoice) {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "0":
                return true;
        }
        return false;
    }
    /**
     * Checks if a department name input is valid or not.
     *
     * @param departmentStr Department name
     * @return true if valid, false if not
     */
    public static boolean isInputDepartmentValid(String departmentStr) {
        int validNumber = 0;
        for (Department d : HumanResources.departments
        ) {
            if (d.getName().equalsIgnoreCase(departmentStr)) {
                validNumber++;
            }
        }
        return validNumber > 0;
    }

    /**
     * Checks if input String is an valid date or not.
     * Valid date format: uuuu-MM-d
     *
     * @param inputString the string user input
     * @return true if the string follows valid date format, otherwise returns false
     */
    public static boolean isDateInputValid(String inputString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-d");
        try {
            LocalDate.parse(inputString, formatter);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    /**
     * Checks if an input string is double type parsable or not.
     *
     * @param inputString the string user input
     * @return true if the string is double type parsable, otherwise returns false
     */
    public static boolean isDouble(String inputString) {
        try {
            Double.parseDouble(inputString);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     * Checks if an input string is integer parsable or not.
     *
     * @param numberString input String
     * @return true if input String is numeric, otherwise return false
     */
    public static boolean isNumeric(String numberString) {
        try {
            Integer.parseInt(numberString);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     * Check if an input for position choice valid or not
     *
     * @param positionChoice user input for position option selection
     * @return true if input value is "1", "2" or "3", otherwise returns false
     */
    public static boolean isPositionInputValid(String positionChoice) {
        return positionChoice.equals("1") || positionChoice.equals("2") || positionChoice.equals("3");
    }

    /**
     * Checks if input for choosing adding between new Employee and new Manager valid or not
     *
     * @param userChoice user's input
     * @return true if valid, false if not
     */
    public static boolean addNewStaffValid(String userChoice) {
        return userChoice.equalsIgnoreCase("E")
                || userChoice.equalsIgnoreCase("M");
    }
}
