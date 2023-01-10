package com.ty.employeeapp.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.employeeapp.beans.Employee;
import com.ty.employeeapp.dto.EmployeeDto;
import com.ty.employeeapp.service.EmployeeService;


@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/index")
	public ModelAndView getIndexPage(ModelAndView modelAndView) {
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@GetMapping("/add-employee")
	public ModelAndView getEmployeeForm(ModelAndView modelAndView) {
		modelAndView.setViewName("add-employee");

		return modelAndView;
	}

	@PostMapping("/employee")
	public ModelAndView addEmployee(ModelAndView modelAndView, Model model, Employee newEmployee) {
		EmployeeDto addedEmployee = employeeService.addEmployee(newEmployee);
		if (addedEmployee != null) {

			modelAndView.setViewName("redirect:/index");
			return modelAndView;
		} else {

			modelAndView.setViewName("redirect:/add-employee");
			return modelAndView;
		}

	}

	@GetMapping("/display-all")
	public ModelAndView getAllEmployeeDetails(ModelAndView modelAndView, Model model) {
		List<EmployeeDto> allEmployee = employeeService.getAllEmployee();
		model.addAttribute("employee", allEmployee);
		modelAndView.setViewName("display-all");
		return modelAndView;

	}

	@GetMapping("/edit/{employeeId}")
	public ModelAndView editForm(ModelAndView modelAndView, @PathVariable("employeeId") int employeeId,
			Model model) {
		EmployeeDto serachEmployee = employeeService.serachEmployee(employeeId);
		if(serachEmployee==null) {
			model.addAttribute("msg", "Update cannot be done because data not found for employee number"+employeeId);
			modelAndView.setViewName("display-train");
		} else {
			model.addAttribute("employee", serachEmployee);
			modelAndView.setViewName("edit");
		}
		return modelAndView;
		
	}
	@PostMapping("/update-employee")
	public String updateTain(Employee employee,ModelAndView modelAndView,@RequestParam("employeeId") int employeeId) {
		
		EmployeeDto updatedEmployee=employeeService.updateEmployeeDetails(employee, employeeId);
		return "redirect:/display-all";
	}

	@GetMapping("/delete/{employeeId}")
	public String deleteTrain(@PathVariable("employeeId") int employeeId,Model model) {
		EmployeeDto deletedEmployee=employeeService.deleteEmployeeDetails(employeeId);
		if(deletedEmployee==null) {
			model.addAttribute("msg", "delete cannot be done because data not found for employee number"+deletedEmployee);
			return "display-all";
		} else {
			return "forward:/display-all";
		}

	}
}
