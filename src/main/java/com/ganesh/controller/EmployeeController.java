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
    EmployeeService empService;

    @RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
    public String newEmployee(ModelMap model) {
        Employee emp = new Employee();
        model.addAttribute("emp", emp);

        return "addEmployee";
    }

    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("emp") Employee emp, ModelMap model) {

        if (empService.saveEmployee(emp)) {
            return "redirect:/viewEmployees";
        }

        return "redirect:/addEmployee";
    }

    @RequestMapping(value = "/viewEmployees", method = RequestMethod.GET)
    public ModelAndView viewEmployees() {
        List<Employee> empList = empService.getAllEmployees();

        return new ModelAndView("viewEmployees", "empList", empList);
    }

    @RequestMapping(value = "/editEmployee/{id}", method = RequestMethod.GET)
    public String editEmployee(@PathVariable Long id, ModelMap model) {
        Employee emp = empService.getEmployeeById(id);
        model.addAttribute("emp", emp);

        return "editEmployee";
    }

    @RequestMapping(value = "/editSaveEmployee", method = RequestMethod.POST)
    public String editSaveEmployee(@ModelAttribute("emp") Employee emp) {

        if (empService.updateEmployee(emp)) {
            return "redirect:/viewEmployees";
        }

        return "redirect:/editEmployee/{" + emp.getId() + "}";
    }

    @RequestMapping(value = "/deleteEmployee/{id}", method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable Long id, ModelMap model) {

        if (!empService.deleteEmployee(id)) {
            System.out.println("Some error occured while deleting");
        }

        return "redirect:/viewEmployees";
    }

    @ModelAttribute("dep")
    public List<Department> getDepartments() {
        return empService.getDepartments();
    }
}
