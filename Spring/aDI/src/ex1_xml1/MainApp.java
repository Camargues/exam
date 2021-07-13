package ex1_xml1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {

		//--------------------------------------
		// 0. Pojo
		// 개발자가 객체 직접 생성
		/*
		 * MessageBean bean1 = new MessageBeanKoImpl(); bean1.sayHello("홍길동");
		 * 
		 * MessageBean bean2 = new MessageBeanEnImpl(); bean2.sayHello("John");
		 */

		//--------------------------------------
		// 1. DI
		// 스프링이 객체 생성
		ApplicationContext context = new ClassPathXmlApplicationContext("ex1_xml1/applicationContext.xml");
		System.out.println("--------start--------");
		MessageBean b1 = (MessageBean) context.getBean("ko");
		b1.sayHello("홍길자");
		System.out.println("--------start--------");
		MessageBean b2 = (MessageBean)context.getBean("en");
		b2.sayHello("James");
		MessageBean b3 = (MessageBean)context.getBean("en");
		b3.sayHello("Ann");
	}

}
