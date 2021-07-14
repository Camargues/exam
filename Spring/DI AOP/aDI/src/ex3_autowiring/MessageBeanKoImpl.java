package ex3_autowiring;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MessageBeanKoImpl implements MessageBean {

	private String name;
	private String message;
	
	// 자동으로 지정
	// @Autowired
	// 중복일시 outputer2로 지정
	// @Qualifier("outputer2")

	// 위 2가지를 합쳐서
	@Resource(name="outputer2")
	private Outputer out;
	
	// setter, constructor(생성자) 없음
	
	// setter
	public void setName(String name) {
		this.name = name;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void sayHello() {
		System.out.println(name+"님께 "+message);
		try {
			out.writeMessage(name+"님께 "+message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
