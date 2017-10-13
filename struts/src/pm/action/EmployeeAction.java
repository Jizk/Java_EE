package pm.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

import pm.entity.Employee;
import pm.service.EmployeeService;
import pm.service.impl.EmployeeServiceImpl;

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	
	private Employee employee = new Employee();
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	//模型驱动
	@Override
	public Employee getModel() {
		return employee;
	}
	
	private EmployeeService employeeService = new EmployeeServiceImpl();
	
	//添加员工
	public String save(){
		try {
			employeeService.save(employee);
			return list();
			//return "addSuccess";
		} catch (Exception e) {
			
			e.printStackTrace();
			return ERROR;
		}
	}
	
	//列表显示
	public String list(){
		try {
			List<Employee> listEmp =  employeeService.getAll();
			ActionContext.getContext().getContextMap().put("list", listEmp);
			return "list";
		} catch (Exception e) {
			
			e.printStackTrace();
			return ERROR;
		}	
	}
	
	//修改员工
	public String viewUpdate(){
		//数据回显
		try {
			int id = employee.getId();
			Employee emp = employeeService.findById(id);
			ValueStack vs = ActionContext.getContext().getValueStack();
			vs.pop();
			vs.push(emp);
			return "update";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	public String update(){
		try {
			employeeService.update(employee);
			return list();
		} catch (Exception e) {
			
			e.printStackTrace();
			return ERROR;
		}
	}
	
	
}
