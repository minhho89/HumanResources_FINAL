import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * This class is in charge of processing printing message and user input methods.
 */

public class UI {

    /* PRINT METHODS */
    public static void greeting() {
        System.out.println("Welcome to Human Resource Management Program");
        System.out.println("version 1.0");
        UI.printSeparatedLine(50);
    }

    /**
     * Displays option menu.
     */
    public static void displayMenu() {
        System.out.println("Please select your command option:");
        System.out.println("1. Display all staff list.");
        System.out.println("2. Display all departments.");
        System.out.println("3. Display staff by departments.");
        System.out.println("4. Add new staff.");
        System.out.println("5. Search staff information by name or staff ID.");
        System.out.println("6. Display salary of all staff in sorted descending order.");
        System.out.println("7. Display salary of all staff sorted ascending order.");
        System.out.println("0. Exit program.");
        UI.printSeparatedLine(50);
    }
    /**
     * Print number of separated char (-).
     *
     * @param numOfChar number of separated "-" char
     */
    public static void printSeparatedLine(int numOfChar) {
        for (int i = 0; i < numOfChar; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Print title of the display result table.
     */
    public static void printTitle() {
        //                   id| name |age|pay |date|dept|off|ot   |pos |salary
        System.out.printf("%-5s%-20s%-5s%-10s%-15s%-15s%-10s%-15s%-20s%-15s",
                "ID", "Name", "Age", "Pay Rate", "Enter Date", "Department", "Day-off", "Overtime", "Position", "Salary");
        System.out.println();
        printSeparatedLine(130);
    }

    /**
     * Prints message when user inputs an invalid value.
     */
    public static void printInvalidMessage() {
        System.out.println("Invalid input. Please try again.");
    }


    /* INPUT METHODS */

    /**
     * Lets user input overtime hour field of new staff
     *
     * @return overtimeHour
     */
    public static double inputOverTimeHour() {
        Scanner scanner = new Scanner(System.in);
        String overtimeHourStr;
        double overtimeHour;
        while (true) {
            System.out.print("Enter number of overtime hour: ");
            overtimeHourStr = scanner.next();
            if (CheckValidity.isDouble(overtimeHourStr)) {
                overtimeHour = Double.parseDouble(overtimeHourStr);
                return overtimeHour;
            }
            UI.printInvalidMessage();
        }
    }


    /**
     * Lets user input number of off-day.
     *
     * @return numDayOff
     */
    public static int inputNumDayOff() {
        Scanner scanner = new Scanner(System.in);
        String numDayOffStr;
        int numDayOff;

        while (true) {
            System.out.print("Enter number of day-off: ");
            numDayOffStr = scanner.next();
            if (CheckValidity.isNumeric(numDayOffStr)) {
                numDayOff = Integer.parseInt(numDayOffStr);
                return numDayOff;
            }
            UI.printInvalidMessage();
        }
    }

    /**
     * Lets user input information of Staff department.
     * Add staff number to departments ArrayList.
     */
    public static Department inputDepartment() {
        Scanner scanner = new Scanner(System.in);
        String departmentStr;
        Department department;

        System.out.println("Please enter department name following below list: ");
        HumanResources.displayDepartmentList();
        int arrPosition;
        int staffNum;

        while (true) {
            System.out.print("Enter department name: ");
            departmentStr = scanner.nextLine();
            if (CheckValidity.isInputDepartmentValid(departmentStr)) {
                for (Department dept : HumanResources.departments) {
                    if (dept.getName().equalsIgnoreCase(departmentStr)) {
                        department = dept;

                        staffNum = department.getEmployeesNum();
                        staffNum++;
                        department.setEmployeesNum(staffNum);

                        arrPosition = HumanResources.departments.indexOf(department);
                        HumanResources.departments.set(arrPosition, department);

                        return department;
                    }
                }
            }
            System.out.println("Your input department is not existed, please choose again.");
        }
    }

    /**
     * Lets user input Start date
     *
     * @return startDate in LocalDate Object.
     */
    public static LocalDate inputStartDate() {
        Scanner scanner = new Scanner(System.in);
        String startDateStr;
        LocalDate startDate;

        while (true) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-d");
            System.out.print("Start date (YYYY-MM-DD): ");
            startDateStr = scanner.next();

            if (CheckValidity.isDateInputValid(startDateStr)) {
                startDate = LocalDate.parse(startDateStr, formatter);
                return startDate;
            }
            UI.printInvalidMessage();
        }
    }

    /**
     * Lets user input Pay-rate for new staff.
     *
     * @return payRate
     */
    public static double inputPayRate() {
        Scanner scanner = new Scanner(System.in);
        String payRateStr;
        double payRate;

        while (true) {
            System.out.print("Pay rate: ");
            payRateStr = scanner.next();
            scanner.nextLine(); //workaround skipping next line bug of Scanner next();
            if (CheckValidity.isDouble(payRateStr)) {
                payRate = Double.parseDouble(payRateStr);
                return payRate;
            }
            UI.printInvalidMessage();
        }
    }

    /**
     * Lets user input age for new staff.
     *
     * @return new staff's age
     */
    public static int inputAge() {
        Scanner scanner = new Scanner(System.in);
        String ageStr;
        int age;
        while (true) {
            System.out.print("Age: ");
            ageStr = scanner.next();
            if (CheckValidity.isNumeric(ageStr)) {
                age = Integer.parseInt(ageStr);
                return age;
            }
            UI.printInvalidMessage();
        }
    }

    /**
     * Lets user input Manager Position.
     *
     * @return position: Business Leader, Project Leader or Technical Leader
     */
    public static String inputPosition() {
        Scanner scanner = new Scanner(System.in);
        String positionChoice;

        while (true) {
            System.out.println("Please choose 1 from 3 position: ");
            System.out.println("For \"Business Leader\",  input 1");
            System.out.println("For \"Project Leader\",   input 2");
            System.out.println("For \"Technical Leader\", input 3");
            System.out.print("Your choice (1-3): ");
            positionChoice = scanner.next();

            if (CheckValidity.isPositionInputValid(positionChoice)) {
                switch (positionChoice) {
                    case "1" -> {
                        return "Business Leader";
                    }
                    case "2" -> {
                        return "Project Leader";
                    }
                    case "3" -> {
                        return "Technical Leader";
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + positionChoice);
                }
            }
            UI.printInvalidMessage();
        }
    }

    /**
     * Lets user input Name of new Staff.
     *
     * @return staff's name
     */
    public static String inputName() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Name: ");

        return scanner.nextLine();
    }

    /**
     * Lets user input ID of new Staff.
     *
     * @return staff's ID
     */
    public static String inputID() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ID: ");
        String id = scanner.next();
        scanner.nextLine(); //workaround skipping next line bug of Scanner next();

        return id;
    }
}
