package model;

public class Department {
    private int DepartmentId;
    private String name;
    private String phoneNumber;
    private static Employee[] employees = new Employee[10];



    public int getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.DepartmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static Employee[] getEmployees() {
        return employees;
    }

    public static void setEmployees(Employee[] employees) {
        Department.employees = employees;
    }
}
