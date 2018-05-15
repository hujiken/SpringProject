package controller;

import java.math.BigDecimal;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import configuration.AppConfig;
import model.Employee;
import model.email.CustomerInfo;
import model.email.ProductOrder;
import service.EmployeeService;
import service.email.OrderService;

public class AppMain {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		EmployeeService service = (EmployeeService) context.getBean("employeeService");
//		
//		Employee employee1 = new Employee();
//        employee1.setName("Huy Pham");
//        employee1.setSalary(new BigDecimal(20000));
//        employee1.setSsn("ssn00000002");
//        
////        service.saveEmployee(employee1);
//        service.deleteEmployeeBySsn("ssn00000001");
		
		OrderService orderService = (OrderService) context.getBean("orderService");
		orderService.sendOrderComfirmation(getOrder());
	}
	
	public static ProductOrder getOrder() {
		ProductOrder order = new ProductOrder();
		order.setOrderId("1111");
		order.setProductName("Huy Pham");
		order.setStatus("Success");
		
		CustomerInfo customerInfo = new CustomerInfo();
		customerInfo.setAddress("Bac Giang");
		customerInfo.setEmail("phamhuycntt1@gmail.com");
		customerInfo.setName("Huy Pham");
		order.setCustomerInfo(customerInfo);
		
		return order;
	}

}
