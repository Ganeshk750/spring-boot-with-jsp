package com.ganesh.controller;

import com.ganesh.model.Department;
import com.ganesh.model.Employee;
import com.ganesh.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping (value = "/addEmployee", method = RequestMethod.GET)
    public String newEmployee(ModelMap model){
        Employee emp = new Employee();
        model.addAttribute("emp", emp);
        return "addEmployee";
    }

    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("emp") Employee emp, ModelMap model){
        if(employeeService.saveEmployee(emp)){
            return "redirect:/viewEmployees";
        }
        return "redirect:/addEmployee";
    }

    @RequestMapping(value = "/viewEmployees", method = RequestMethod.GET)
    public ModelAndView viewEmployees(){
        List<Employee> empList = employeeService.getAllEmployees();
        return new ModelAndView("viewEmployees", "empList", empList);
    }

    @RequestMapping(value = "/editEmployee/{id}", method = RequestMethod.GET)
    public String editEmployee(@PathVariable long id, ModelMap model){
        Employee emp = employeeService.getEmployeeById(id);
        model.addAttribute("emp", emp);
        return "editEmployee";
    }
    @RequestMapping(value = "/editEmployee", method = RequestMethod.POST)
    public String editEmployees(@ModelAttribute("emp") Employee emp){
        if(employeeService.updateEmployee(emp)){
            return "redirect:/viewEmployees";
        }
        return "redirect:/editEmployee/{" + emp.getId() + "}";
    }

    @ModelAttribute("dep")
    public List<Department> getDepartments(){
        return employeeService.getDepartments();
    }
}
