package com.javaclass.model;

public class MemberVO {
	
	private String id;
	private int age;
	private String name;
	private boolean state;
	
	public boolean isState() {
		return state;
	}



	public void setState(boolean state) {
		this.state = state;
	}



	public MemberVO() {
		
	}
	
	
	
	public MemberVO(String id, int age, String name) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
	}



	public String getId() {
		return id;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public void setId(String id) {
		this.id = id;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
