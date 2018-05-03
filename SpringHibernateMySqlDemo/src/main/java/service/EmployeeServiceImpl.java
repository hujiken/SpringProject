package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.EmployeeDao;
import model.Employee;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	public void saveEmployee(Employee employee) {
		employeeDao.saveEmployee(employee);
	}

	public List<Employee> findAllEmployees() {
		return employeeDao.findAllEmployee();
	}

	public void deleteEmployeeBySsn(String ssn) {
		employeeDao.deleteEmployeeBySsn(ssn);
		System.out.println(ssn + " deleted!");
	}

	public Employee findBySsn(String ssn) {
		return employeeDao.findBySsn(ssn);
	}

	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}

}
