package com.ganesh.service;

import com.ganesh.model.Department;
import com.ganesh.model.Employee;

import java.util.List;

public interface EmployeeService {

    public boolean saveEmployee(Employee emp);
    public List<Employee> getAllEmployees();
    public Employee getEmployeeById(long id);
    public boolean updateEmployee(Employee emp);
    public boolean deleteEmployee(long id);
    public List<Department> getDepartments();
}
