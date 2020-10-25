import java.time.LocalDate;

/**
 * This class holds basic data of staff
 */
public abstract class Staff {
    private String id;
    private String name;
    private int age;
    private double payRate;
    private LocalDate startDate;
    private Department department;
    private int numDayOff; //number of day off

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getNumDayOff() {
        return numDayOff;
    }

    public void setNumDayOff(int numDayOff) {
        this.numDayOff = numDayOff;
    }

    public Staff(String id, String name, int age, double payRate, LocalDate startDate, Department department, int numDayOff) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.payRate = payRate;
        this.startDate = startDate;
        this.department = department;
        this.numDayOff = numDayOff;
    }

    public abstract double calculateSalary();

    @Override
    public abstract String toString();
}
