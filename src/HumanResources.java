import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


/**
 * Program "Human Resource" is an assignment for Project number #4 of subject PRO192x_02_VN.
 * Requirements: This program helps to manage human resource in a company.
 * Education unit: Funix University.
 *
 * @author Nhat-Minh Ho | FX03283
 * @date 2020-Oct-18
 * <p>
 * This class holds program's main thread including main() method.
 */
public class HumanResources {
    public static ArrayList<Department> departments = new ArrayList<>();
    public static ArrayList<Staff> staffList = new ArrayList<>();

    public static void main(String[] args) {
        addIntialData(); //
        addDepartments();
        UI.greeting();
        UI.displayMenu();
        process();
    }

    private static void addDepartments() {
    }

    /**
     * Adds data to test
     */
    private static void addIntialData() {
        Department dept1 = new Department("dept1", "Sale");
        departments.add(dept1);
        Department dept2 = new Department("dept2", "Tech");
        departments.add(dept2);
        Department dept3 = new Department("dept3", "Security");
        departments.add(dept3);

        //add Managers
//        Manager m1 = new Manager("m1", "Tom", "Business Leader", 40, 5.4, LocalDate.of(2000, 1, 30),
//                dept1, 10, 0);
//        for (Department dept : departments
//        ) {
//            if (dept.getName().equalsIgnoreCase(m1.getDepartment().getName())) {
//                dept.setEmployeesNum(dept.getEmployeesNum() + 1);
//            }
//
//        }
//        m1.setSalary();
//        staffList.add(m1);
//
//        Manager m2 = new Manager("m2", "Holland", "Project Leader", 30, 3.0, LocalDate.of(2010, 5, 4),
//                dept2, 15, 0);
//        for (Department dept : departments
//        ) {
//            if (dept.getName().equalsIgnoreCase(m2.getDepartment().getName())) {
//                dept.setEmployeesNum(dept.getEmployeesNum() + 1);
//            }
//
//        }
//        m2.setSalary();
//        staffList.add(m2);
//
        
//        //add Employees
//        Employee e1 = new Employee("e1", "Cris", 20, 3, LocalDate.of(2020, 10, 10), dept1,
//                20, 10.4, 0);
//        for (Department dept : departments
//        ) {
//            if (dept.getName().equalsIgnoreCase(e1.getDepartment().getName())) {
//                dept.setEmployeesNum(dept.getEmployeesNum() + 1);
//            }
//
//        }
//        e1.setSalary();
//        staffList.add(e1);
//
//        Employee e2 = new Employee("e2", "Tim", 26, 3.0, LocalDate.of(2019, 11, 10), dept2,
//                10, 20, 0);
//        for (Department dept : departments
//        ) {
//            if (dept.getName().equalsIgnoreCase(e2.getDepartment().getName())) {
//                dept.setEmployeesNum(dept.getEmployeesNum() + 1);
//            }
//        }
//        e2.setSalary();
//        staffList.add(e2);
//
//        Employee e3 = new Employee("e3", "Musk", 33, 1.5, LocalDate.of(2015, 3, 2), dept3,
//                3, 10, 0);
//        for (Department dept : departments
//        ) {
//            if (dept.getName().equalsIgnoreCase(e3.getDepartment().getName())) {
//                dept.setEmployeesNum(dept.getEmployeesNum() + 1);
//            }
//        }
//        e3.setSalary();
//        staffList.add(e3);
    }

    /**
     * Prints greeting lines and program version.
     */


    /**
     * This method lets user input option and check the input's validity.
     */
    private static void process() {
        Scanner scanner = new Scanner(System.in);
        String userChoice;
        boolean isContinue = true;
        if (isContinue) {
            while (true) {

                System.out.print("Your choice (0-7): ");
                userChoice = scanner.next();
                if (!CheckValidity.isMainMenuInputValid(userChoice)) {
                    UI.printInvalidMessage();
                    continue;
                }

                switch (userChoice) {
                    case "1" -> {
                        displayStaffList();
                        UI.printSeparatedLine(130);
                    }
                    case "2" -> {
                        displayDepartmentList();
                        UI.printSeparatedLine(130);
                    }
                    case "3" -> {
                        displayStaffByDepartment();
                        UI.printSeparatedLine(130);
                    }
                    case "4" -> {
                        addNewStaff();
                        UI.printSeparatedLine(50);
                    }
                    case "5" -> {
                        searchStaff();
                        UI.printSeparatedLine(130);
                    }
                    case "6" -> {
                        displaySalaryDescendingOrder();
                        UI.printSeparatedLine(130);
                    }
                    case "7" -> {
                        displaySalaryAscendingOrder();
                        UI.printSeparatedLine(130);
                    }
                    case "0" -> {
                        System.out.println("Thank you, good bye!");
                        UI.printSeparatedLine(50);
                        System.exit(0);
                    }
                }
                System.out.print("Do you want to continue (Y/N): ");
                boolean answer = decideContinue();
                if (answer) {
                    UI.displayMenu();
                    continue;
                }
                System.out.println("Thank you, good bye!");
                UI.printSeparatedLine(50);
                System.exit(0);
            }
        }
    }

    /**
     * Helps user to continually perform program or quit.
     * If user answer "y": the program turns back to its start.
     * If user answer "n": quit program.
     * If user answer none above: deploys the method again.
     * @return true if continue, false if quit.
     */
    private static boolean decideContinue() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("y")) {
                return true;
            } else if (answer.equalsIgnoreCase("n")) {
                return false;
            } else {
                UI.printInvalidMessage();
                System.out.print("Do you want to continue (Y/N)? ");
                continue;
            }
        }

    }

    /**
     * Displays all the staff in company with details/
     */
    private static void displayStaffList() {
        System.out.println("Display all staff list");
        UI.printTitle();
        for (Staff f : staffList) {
            System.out.println(f.toString());
        }
    }

    /**
     * Displays all the departments with details.
     */
    static void displayDepartmentList() {
        System.out.println("Display all departments");
        System.out.printf("%-10s%-20s%-20s", "ID", "Department Name", "Number of staff");
        System.out.println();
        for (Department d : departments
        ) {
            System.out.println(d.toString());
        }
    }

    /**
     * Displays all the staff sorted by department.
     * <ul>This method process 3 steps:
     *      <li>1. Create a clone ArrayList from staff list so that sorted list doesn't effect to the original list.</li>
     *      <li>2. Sort the clone arrayList by departments.</li>
     *      <li>3. Print the clone arrayList with dividing line between different departments.</li>
     * </ul>
     */
    private static void displayStaffByDepartment() {
        ArrayList<Staff> sortedList = (ArrayList) staffList.clone(); //clone a new ArrayList of staffList to sort
        //Sort list following department using sort & Comparator.
        sortedList.sort(new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                return (o1.getDepartment().getName().compareToIgnoreCase(o2.getDepartment().getName()));
            }
        });
        System.out.println("Display staff by departments");
        UI.printTitle();

        int arrSize = sortedList.size();
        for (int i = 0; i < arrSize; i++) {
            /*
             * to print dividing line if staff belongs to different department
             */
            if (i == 0) {
                System.out.println(sortedList.get(i));
            } else if (0 < i && i < arrSize - 1) {
                if (!sortedList.get(i - 1).getDepartment().getName().equalsIgnoreCase(sortedList.get(i).getDepartment().getName())) {
                    UI.printSeparatedLine(130);
                }
                System.out.println(sortedList.get(i));
            } else {
                System.out.println(sortedList.get(i));
            }
        }

    }

    /**
     * Lets user add new employee or manager.
     * <ul>This method does:
     *      <li>1. Requires user to choose whether adding new employee or manager.</li>
     *      <li>2. Checks user input's validity.</li>
     *      <li>3. Add new employee or manager following user input.</li>
     * </ul>
     */
    private static void addNewStaff() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add new staff");
        String userChoice;
        while (true) {
            System.out.print("Do you want to add a new employee (E) or manager (M)? Input E/M: ");
            userChoice = scanner.next();
            if (CheckValidity.addNewStaffValid(userChoice)) {
                if (userChoice.equalsIgnoreCase("E")) {
                    addNewEmployee();
                    break;
                }
                addNewManager();
                break;
            }
            System.out.println("Invalid input. Please try again.");
        }
    }

    /**
     * Lets user inputs information and add new manager into ArrayList.
     * This method also add Number of staff in the department ArrayList.
     */
    private static void addNewManager() {
        String id;
        String name;
        int age;
        String position;
        double payRate;
        LocalDate startDate;
        Department department;
        int numDayOff;

        System.out.println("Add new Manager");
        UI.printSeparatedLine(16);

        /* ID */
        id = UI.inputID();

        /* NAME */
        name = UI.inputName();

        /* POSITION */
        position = UI.inputPosition();

        /* AGE */
        age = UI.inputAge();

        /* PAY RATE */
        payRate = UI.inputPayRate();

        /* START DATE */
        startDate = UI.inputStartDate();

        /* DEPARTMENTS */
        department = UI.inputDepartment();

        /* NUMBER OF DAY-OFF */
        numDayOff = UI.inputNumDayOff();

        /*ADD NEW MANAGER TO ARRAY LIST */
        Manager newManager = new Manager(id, name, position, age, payRate, startDate, department, numDayOff, 0);
        newManager.setSalary(); //calculate salary
        staffList.add(newManager);
        System.out.println("New manager has been added successfully.");
    }

    /**
     * Lets user inputs information and add new employee into ArrayList.
     */
    private static void addNewEmployee() {
        String id;
        String name;
        int age;
        double payRate;
        LocalDate startDate;
        Department department;
        int numDayOff;
        double overtimeHour;

        System.out.println("Add new Employee");
        UI.printSeparatedLine(16);

        /* ID */
        id = UI.inputID();

        /* NAME */
        name = UI.inputName();

        /* AGE */
        age = UI.inputAge();

        /* PAY RATE */
        payRate = UI.inputPayRate();
        /* START DATE */
        startDate = UI.inputStartDate();
        /* DEPARTMENTS */
        department = UI.inputDepartment();
        /* NUMBER OF DAY-OFF */
        numDayOff = UI.inputNumDayOff();
        /* OVERTIME HOUR */
        overtimeHour = UI.inputOverTimeHour();

        /*ADD NEW MANAGER TO ARRAY LIST */
        Employee newEmployee = new Employee(id, name, age, payRate, startDate, department, numDayOff, overtimeHour, 0);
        newEmployee.setSalary(); //calculate salary
        staffList.add(newEmployee);
        System.out.println("New employee has been added successfully.");
    }


    /**
     * Search staff by ID name.
     */
    private static void searchStaff() {
        Scanner scanner = new Scanner(System.in);
        String searchKey;
        ArrayList<Staff> searchStaff = new ArrayList<>();

        while (true) {
            System.out.println("Search staff information by staff ID or staff name:");
            System.out.print("Please enter staff ID or staff name: ");
            searchKey = scanner.nextLine();
            for (Staff s : staffList) {
                if (s.getId().toLowerCase().contains(searchKey.toLowerCase()) || s.getName().toLowerCase().contains(searchKey.toLowerCase())) {
                    searchStaff.add(s);
                }
            }
            if (searchStaff.isEmpty()) {
                System.out.println("There is no Staff matched your search information.");

            } else { //print staff info
                UI.printTitle();
                for (Staff s : searchStaff) {
                    System.out.println(s.toString());
                }
            }
            break;
        }
    }

    /**
     * Display staff list sorted by descending order of salary.
     * <ul>This method do following steps:
     *      <li>1. Clone staffList arrayList to a new list called sorted List.</li>
     *      <li>2. Sort the new arrayList by descending order of salary .</li>
     * </ul>
     */
    private static void displaySalaryDescendingOrder() {
        ArrayList<Staff> sortedList = (ArrayList) staffList.clone();
        sortedList.sort(new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                return (int) (o2.calculateSalary() - o1.calculateSalary());
            }
        });

        System.out.println("Display salary of all staff in sorted descending order");
        UI.printTitle();
        System.out.println();
        for (Staff s :
                sortedList) {
            System.out.println(s.toString());
        }
    }

    /**
     * Display staff list sorted by ascending order of salary.
     * <ul>This method do following steps:
     *      <li>1. Clone staffList arrayList to a new list called sorted List.</li>
     *      <li>2. Sort the new arrayList by ascending order of salary .</li>
     * </ul>
     */
    private static void displaySalaryAscendingOrder() {
        ArrayList<Staff> sortedList = (ArrayList) staffList.clone();
        sortedList.sort(new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                return (int) (o1.calculateSalary() - o2.calculateSalary());
            }
        });

        System.out.println("Display salary of all staff sorted ascending order");
        UI.printTitle();
        System.out.println();
        for (Staff s :
                sortedList) {
            System.out.println(s.toString());
        }
    }
}
