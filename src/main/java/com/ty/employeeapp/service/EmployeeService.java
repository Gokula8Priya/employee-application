package com.ty.employeeapp.service;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.employeeapp.beans.Employee;
import com.ty.employeeapp.dao.EmployeeDao;
import com.ty.employeeapp.dto.EmployeeDto;
@Service
public class EmployeeService {


	@Autowired
	private EmployeeDao employeeDao;
	public EmployeeDto addEmployee(Employee newEmployee) {
			EmployeeDto employeeDto=new EmployeeDto();
			employeeDto.setName(newEmployee.getName());
			employeeDto.setEmailId(newEmployee.getEmailId());
			LocalDate dob=LocalDate.parse(newEmployee.getDateOfBirth());
			employeeDto.setDateOfBirth(dob);
			int age=LocalDate.now().getYear()-dob.getYear();
			employeeDto.setAge(age);
			employeeDto.setSalary(newEmployee.getSalary());
			employeeDto.setEmployeeStatus(newEmployee.getEmployeeStatus());
			return employeeDao.insertEmployee(employeeDto);
		}
	public List<EmployeeDto> getAllEmployee() {
		
		return employeeDao.getAllEmployee();
	}
	public EmployeeDto serachEmployee(int employeeId) {
	 
			
			return employeeDao.findEmployee(employeeId);
		}
	public EmployeeDto updateEmployeeDetails(Employee employee, int employeeId) {
		EmployeeDto employeeDto=new EmployeeDto();
		employeeDto.setEmployeeId(employeeId);
		System.out.println(employeeId);
		employeeDto.setName(employee.getName());
		employeeDto.setEmailId(employee.getEmailId());
		LocalDate dob=LocalDate.parse(employee.getDateOfBirth());
		employeeDto.setDateOfBirth(dob);
		int age=LocalDate.now().getYear()-dob.getYear();
		employeeDto.setAge(age);
		employeeDto.setSalary(employee.getSalary());
		employeeDto.setEmployeeStatus(employee.getEmployeeStatus());
		return employeeDao.updateEmployee(employeeDto);
		
	}
	public EmployeeDto deleteEmployeeDetails(int employeeId) {
		EmployeeDto employeeDto= employeeDao.findEmployee(employeeId);
		return employeeDao.delete(employeeDto);
	}
	
		
	

}
