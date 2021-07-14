package ex1_xml2_ref;

/*
 *  멤버변수의 값을 지정하는 방식
 *  1) setter 이용
 *  2) 생성자 이용
 */
public class MemberBean {
	private String name;
	private int age;
	private String message;
	

	public void output() {
		System.out.println(name + "[" + age + "]" + message);
	}

	//-------------------------------
	// setter
	public void setName(String name) {
		this.name = name;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public void setMessage(String message) {
		this.message = message;
	}

	//---------------------------------
	// 생성자
	public MemberBean() {}
	
	public MemberBean(String name, int age, String message) {
		super();
		this.name = name;
		this.age = age;
		this.message = message;
	}
	
	
	
}
