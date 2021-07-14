package exercise;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import exercise.order.domain.Customer;
import exercise.order.service.CustomerService;

public class Main {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("exercise/beans.xml"); 
	
		Customer customer = (Customer)ctx.getBean("customer");
	
		
		CustomerService customerService = (CustomerService)ctx.getBean("customerServiceImpl");
		customerService.saveCustomer(customer);
		customerService.deleteCustomer(1);		
		
	}

}
