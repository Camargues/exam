package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmpDAO {

	// DB 연결 관련 변수 선언
	String driverName = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user = "HR";
	String pass = "1234";
	
	private EmpDAO() throws Exception {
		// 1. 드라이버 로딩
		Class.forName(driverName);
	}
	
	static EmpDAO dao = null;
	// static 함수로 접근하기 위해 static으로 싱글톤 선언
	public static EmpDAO getInstance() throws Exception {
		// jsp에서 클래스명으로 호출하기 위해 static으로 선언
		if(dao==null) dao = new EmpDAO();
		// 첫 사용자는 dao 가 null값이라 객체를 생성함
		// 그 다음 사용자 경우에는 dao가 이미 객체가 생성되어있어서
		// 추가로 객체를 생성하지 않음 = 싱글톤 패턴
		return dao;
	}
	
	public ArrayList<EmpVO> selectEmp() throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
		
		// 2. 연결객체 얻어오기
		
		con = DriverManager.getConnection(url, user, pass);
		
		// 3. sql 문장 만들기
		
		String sql = "SELECT * FROM employee";
		
		// 4. 전송객체 얻어오기
		
		ps = con.prepareStatement(sql);
		
		// 5. 전송
		
		ResultSet rs = ps.executeQuery();
		// select 문이라 executeQuery 사용
		
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		
		while(rs.next()) {
			EmpVO vo = new EmpVO();
			vo.setEno(rs.getInt("ENO"));
			vo.setEname(rs.getString("ENAME"));
			vo.setManager(rs.getInt("MANAGER"));
			vo.setJob(rs.getString("JOB"));
			list.add(vo);
		}
		return list;
		} finally {
		// 6. 닫기
		ps.close();
		con.close();
		}
		
	}
	
	public void insertEmp(EmpVO vo) throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
		
		// 2. 연결객체 얻어오기
		
		con = DriverManager.getConnection(url, user, pass);
		
		// 3. sql 문장 만들기
		
		String sql = "INSERT INTO employee(eno, ename, salary, job, hiredate)VALUES(?,?,?,?,to_date(?))";
		
		// 4. 전송객체 얻어오기
		
		ps = con.prepareStatement(sql);
		ps.setInt(1, vo.getEno());
		ps.setString(2, vo.getEname());
		ps.setInt(3, vo.getSalary());
		ps.setString(4, vo.getJob());
		ps.setString(5, vo.getHiredate());
		// 5. 전송
		
		ps.executeUpdate();
		// insert 문이라 executeQuery 사용
		
	
		

		// 6. 닫기
		}finally{
		ps.close();
		con.close();
		}
		
	}
	
	public EmpVO viewEmp(int eno) throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
		
		// 2. 연결객체 얻어오기
		
		con = DriverManager.getConnection(url, user, pass);
		
		// 3. sql 문장 만들기
		
		String sql = "SELECT * FROM employee WHERE eno=?";
		
		// 4. 전송객체 얻어오기
		
		ps = con.prepareStatement(sql);
		ps.setInt(1, eno);
		
		// 5. 전송
		
		ResultSet rs = ps.executeQuery();
		
		EmpVO vo = new EmpVO();
		// select 문이라 executeQuery 사용
		if(rs.next()) {
			// 다음 레코드가 있으면 true 없으면 false
			vo.setEno(rs.getInt("ENO"));
			vo.setEname(rs.getString("ENAME"));
			vo.setManager(rs.getInt("MANAGER"));
			vo.setJob(rs.getString("JOB"));
			vo.setHiredate(rs.getString("HIREDATE"));
			vo.setSalary(rs.getInt("SALARY"));
			vo.setCommission(rs.getInt("COMMISSION"));
			vo.setDno(rs.getInt("DNO"));
			
		}
		return vo;
		} finally {
		// 6. 닫기
		ps.close();
		con.close();
		}


	}
	
	public int deleteEmp(int eno) throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
		
		// 2. 연결객체 얻어오기
		
		con = DriverManager.getConnection(url, user, pass);
		
		// 3. sql 문장 만들기
		
		String sql = "DELETE FROM employee WHERE eno=?";
		
		// 4. 전송객체 얻어오기
		
		ps = con.prepareStatement(sql);
		ps.setInt(1, eno);
		// 5. 전송
		
		return ps.executeUpdate();
		// delete 문이라 executeQuery 사용
		
		
		
		

		// 6. 닫기
		}finally{
		ps.close();
		con.close();
		}
		
	}
	
	
		
	public int updateEmp(EmpVO vo, int exeno) throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
		
		// 2. 연결객체 얻어오기
		
		con = DriverManager.getConnection(url, user, pass);
		
		// 3. sql 문장 만들기
		
		String sql = "UPDATE employee SET ENO=?, ENAME=?, SALARY=?, JOB=?, HIREDATE=to_date(?) WHERE ENO=?";
		
		// 4. 전송객체 얻어오기
		
		ps = con.prepareStatement(sql);
		ps.setInt(1, vo.getEno());
		ps.setString(2, vo.getEname());
		ps.setInt(3, vo.getSalary());
		ps.setString(4, vo.getJob());
		ps.setString(5, vo.getHiredate());
		ps.setInt(6, exeno);
		// 5. 전송
		
		return ps.executeUpdate();
		// insert 문이라 executeQuery 사용
		
	
		

		// 6. 닫기
		}finally{
		ps.close();
		con.close();
		}
		
	}
	
	public EmpVO loginEmp(String ename, int eno) throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
		
		// 2. 연결객체 얻어오기
		
		con = DriverManager.getConnection(url, user, pass);
		
		// 3. sql 문장 만들기
		
		String sql = "SELECT * FROM employee WHERE ename=? AND eno=?";
		
		// 4. 전송객체 얻어오기
		
		ps = con.prepareStatement(sql);
		ps.setString(1, ename);
		ps.setInt(2, eno);
		
		// 5. 전송
		
		ResultSet rs = ps.executeQuery();
		
		EmpVO vo = new EmpVO();
		// select 문이라 executeQuery 사용
		if(rs.next()) {
			// 다음 레코드가 있으면 true 없으면 false
			vo.setEno(rs.getInt("ENO"));
			vo.setEname(rs.getString("ENAME"));
			vo.setManager(rs.getInt("MANAGER"));
			vo.setJob(rs.getString("JOB"));
			vo.setHiredate(rs.getString("HIREDATE"));
			vo.setSalary(rs.getInt("SALARY"));
			vo.setCommission(rs.getInt("COMMISSION"));
			vo.setDno(rs.getInt("DNO"));
			
		}
		return vo;
		} finally {
		// 6. 닫기
		ps.close();
		con.close();
		}
	}
}
