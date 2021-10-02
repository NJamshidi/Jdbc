package dataaccess;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Department;
import model.Employee;

public class SQLConnection {

    public static Connection getConnection() throws SQLException {


//      Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/office",
                "root", "123asPKb73!");
        return connection;
    }

    public int addEmployee(Employee employee) throws SQLException {
        Connection connection = getConnection();
        if (connection != null) {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into employees values (?, ?, ?, ?, ? , ?)");
            preparedStatement.setInt(1, employee.getEmployeeId());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setString(3, employee.getFamily());
            preparedStatement.setInt(4, employee.getPersonalNumber());
            preparedStatement.setDate(5, employee.getBirthDate());
            preparedStatement.setInt(6, employee.getDepartmentId());
            int i = preparedStatement.executeUpdate();
            return i;
        } else {
            return 0;
        }
    }

    public int addDepartment(Department department) throws SQLException {
        Connection connection = getConnection();
        if (connection != null) {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into departments values (?, ?, ?)");
            preparedStatement.setInt(1, department.getDepartmentId());
            preparedStatement.setString(2, department.getName());
            preparedStatement.setString(3, department.getPhoneNumber());

            int i = preparedStatement.executeUpdate();
            return i;
        } else {
            return 0;
        }
    }


    public int updateEmployee(int id, String name, String family) throws SQLException {
        Connection connection = getConnection();
        if (connection != null) {
            String sql = "UPDATE employees SET name = ?, family = ?  WHERE employeeId = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setString(1, name);
            preparedStmt.setString(2, family);
            preparedStmt.setInt(3, id);


            int i = preparedStmt.executeUpdate();
            return i;
        } else {
            return 0;
        }
    }

    public int updateDepartment(int id, String name) throws SQLException {
        Connection connection = getConnection();

        if (connection != null) {
            String sql = "UPDATE departments SET name = ?  WHERE departmentId = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setString(1, name);
            preparedStmt.setInt(2, id);
            int i = preparedStmt.executeUpdate();
            return i;
        } else {
            return 0;
        }
    }


    public List<Employee> getAllEmployee() throws SQLException {
        Connection connection = getConnection();

        if (connection != null) {
            List<Employee> employees = new ArrayList<>();
            Statement statement = connection.createStatement();
            String sqlQuery = "SELECT * FROM employees";
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(resultSet.getInt("employeeId"));
                employee.setName(resultSet.getString("name"));
                employee.setFamily(resultSet.getString("family"));
                employee.setPersonalNumber(resultSet.getInt("personalNumber"));
                employee.setBirthDate(resultSet.getDate("BirthDate"));
                employee.setDepartmentId(resultSet.getInt("department"));

                employees.add(employee);
            }

            return employees;
        } else {
            return Collections.emptyList();
        }
    }

    public Employee getEmployeeByDepartment(Department department) throws SQLException {
        Connection connection = getConnection();

        if (connection != null) {
            Employee emp = new Employee();
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM employees WHERE department = " + "department";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            emp.setEmployeeId(rs.getInt("employeeId"));
            emp.setName(rs.getString("name"));
            emp.setFamily(rs.getString("family"));
            emp.setPersonalNumber(rs.getInt("personalNumber"));
            emp.setBirthDate(rs.getDate("birthDate"));
            return emp;
        } else {
            return null;
        }
    }
}

