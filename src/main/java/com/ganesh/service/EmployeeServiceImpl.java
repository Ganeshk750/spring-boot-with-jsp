package com.ganesh.service;

import com.ganesh.dao.EmployeeDAO;
import com.ganesh.model.Department;
import com.ganesh.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDAO empDao;


    @Override
    public boolean saveEmployee(Employee emp) {
        return empDao.save(emp);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return empDao.getAllEmployees();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return empDao.getEmployeeById(id);
    }

    @Override
    public boolean updateEmployee(Employee emp) {
        return empDao.update(emp);
    }

    @Override
    public boolean deleteEmployee(int id) {
        return empDao.deleteEmployee(id);
    }

    @Override
    public List<Department> getDepartments() {
        return empDao.getDepartments();
    }
}
