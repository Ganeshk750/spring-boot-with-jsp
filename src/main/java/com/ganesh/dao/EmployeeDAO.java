package com.ganesh.dao;

import com.ganesh.model.Department;
import com.ganesh.model.Employee;

import javax.swing.*;
import java.util.List;

public interface EmployeeDAO {

    public boolean save(Employee emp);
    public List<Employee> getAllEmployees();
    public Employee getEmployeeById(int id);
    public boolean update(Employee emp);
    public boolean deleteEmployee(int id);
    public List<Department> getDepartments();
}
