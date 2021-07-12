package mybatis.guest.service;

import java.util.HashMap;
import java.util.List;

import mybatis.guest.session.EmployeeRepository;

public class EmployeeService {
	
	private static EmployeeService service;
	
	private EmployeeService() {}
	public static EmployeeService getInstance(){
		if( service == null) service = new EmployeeService();
		return service;
	}
	
	EmployeeRepository repo = new EmployeeRepository();
	
	public List<HashMap> empSelect(){
		return repo.empSelect();
		
	}
	
}