package aop1_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		
		ApplicationContext context = new 	
				ClassPathXmlApplicationContext("aop1_xml/applicationContext.xml");
		MessageBean target = context.getBean("targetBean",MessageBean.class);
		
		target.sayHello();
		System.out.println("---------------------------");
		target.engSayHello();
		System.out.println("---------------------------");
		target.test();

		
		
	}

}
