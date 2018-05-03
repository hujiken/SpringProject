package controller;

import java.math.BigDecimal;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import configuration.AppConfig;
import model.Employee;
import service.EmployeeService;

public class AppMain {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		EmployeeService service = (EmployeeService) context.getBean("employeeService");
		
		Employee employee1 = new Employee();
        employee1.setName("Huy Pham");
        employee1.setSalary(new BigDecimal(20000));
        employee1.setSsn("ssn00000002");
        
//        service.saveEmployee(employee1);
        service.deleteEmployeeBySsn("ssn00000001");
	}

}
