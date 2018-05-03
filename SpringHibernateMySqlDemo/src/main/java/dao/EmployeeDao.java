package dao;

import java.util.List;

import model.Employee;

public interface EmployeeDao {
	
	void saveEmployee(Employee employee);
	
	List<Employee> findAllEmployee();
	
	void deleteEmployeeBySsn(String ssn);
	
	Employee findBySsn(String ssn);
	
	void updateEmployee(Employee employee);
}
