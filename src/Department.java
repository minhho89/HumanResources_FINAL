/**
 * This class holds general data about departments
 */
public class Department {
    private String id;
    private String name;
    private int employeesNum;

    public Department(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Department(String id, String name, int employeesNum) {
        this.id = id;
        this.name = name;
        this.employeesNum = employeesNum;
    }

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

    public int getEmployeesNum() {
        return employeesNum;
    }

    public void setEmployeesNum(int employeesNum) {
        this.employeesNum = employeesNum;
    }

    @Override
    public String toString() {
        return String.format("%-10s%-20s%-20d", this.id, this.name, this.employeesNum);
    }
}
