package ex2_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// dao라는 이름으로 메모리에 올려달라고 지정
@Component("dao")
public class MemberDAO {
	
	@Autowired
	private MemberBean member;
	
	// 1) setter
	
	/*
	 * public void setMember(MemberBean member) { this.member = member; }
	 */
	
	// 2) 생성자
	
	/*
	 * public MemberDAO() {} public MemberDAO(MemberBean member) { this.member =
	 * member; }
	 */
	 
	
	public void insert() {
		member.output();
	}
}
