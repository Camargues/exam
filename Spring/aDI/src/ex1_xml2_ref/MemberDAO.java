package ex1_xml2_ref;

public class MemberDAO {
	
	private MemberBean member;
	
	// 1) setter
	
	public void setMember(MemberBean member) {
		this.member = member;
	}
	
	// 2) 생성자
	
	public MemberDAO() {}
	public MemberDAO(MemberBean member) { this.member = member; }
	 
	
	public void insert() {
		member.output();
	}
}
