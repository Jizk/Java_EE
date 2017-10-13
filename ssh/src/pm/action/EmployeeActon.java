package pm.action;

import java.util.List;
import java.util.Map;

import pm.entity.Employee;
import pm.service.DeptService;
import pm.service.EmployeeService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EmployeeActon extends ActionSupport{
	
	private EmployeeService employeeService;
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	private DeptService deptService;
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
	
	public String list(){
		List<Employee> list = employeeService.getAll();
		Map<String,Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("list", list);
		return "list";
	}
	
}
