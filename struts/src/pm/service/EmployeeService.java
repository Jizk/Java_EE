package pm.service;

import java.util.List;

import pm.entity.Employee;

public interface EmployeeService {
	
	List<Employee> getAll();
	
	Employee findById(int id);
	
	void save(Employee emp);
	
	void update(Employee emp);
}
