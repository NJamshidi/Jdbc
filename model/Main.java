package model;

import dataaccess.SQLConnection;

import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        SQLConnection sqlConnection = new SQLConnection();
        sqlConnection.getConnection();
        Department department = new Department();
        department.setDepartmentId(145);
        department.setName("tarikh");
        department.setPhoneNumber("9123333");
        Employee employee = new Employee();
        employee.setEmployeeId(145);
        employee.setName("raha");
        employee.setFamily("razavi");
        employee.setPersonalNumber(100);
        employee.setBirthDate(Date.valueOf("2001-07-04"));
        employee.setDepartmentId(department.getDepartmentId());

     int addEmpCount =  sqlConnection.addEmployee(employee);
      System.out.println(addEmpCount);
       int addDepCount =  sqlConnection.addDepartment(department);
       System.out.println(addDepCount);
       int updateEmpCount = sqlConnection.updateEmployee(3,"zahra","akbari");
       System.out.println(updateEmpCount);
        int updateDepCount = sqlConnection.updateDepartment(1,"honar");
       System.out.println(updateDepCount);
     List<Employee> allEmployees= sqlConnection.getAllEmployee();
     for(Employee employee1:allEmployees) {
         System.out.println(employee1.toString());
     }

        System.out.println(sqlConnection.getEmployeeByDepartment(department));
    }

}
