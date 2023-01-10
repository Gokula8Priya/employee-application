package com.ty.employeeapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.employeeapp.dto.EmployeeDto;

@Repository
public class EmployeeDao {
	@Autowired
	private EntityManagerFactory factory;

	public EmployeeDto insertEmployee(EmployeeDto employeeDto) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(employeeDto);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return employeeDto;
	}

	public List<EmployeeDto> getAllEmployee() {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("FROM EmployeeDto");
		return query.getResultList();

	}

	public EmployeeDto findEmployee(int employeeId) {

		EntityManager manager = factory.createEntityManager();
		EmployeeDto employeeDto = manager.find(EmployeeDto.class, employeeId);
		return employeeDto;
	}

	public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.merge(employeeDto);
			transaction.commit();

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return employeeDto;
	}

	public EmployeeDto delete(EmployeeDto employeeDto) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			EmployeeDto deleteEmploye = manager.merge(employeeDto);
			manager.remove(deleteEmploye);
			transaction.commit();
			return deleteEmploye;

		} catch (Exception e) {
			transaction.commit();
		}
		return null;
	}
}
