package pm.service;

import java.util.List;

import pm.entity.Employee;

public interface EmployeeService {
	
	void save(Employee emp);
	
	void update(Employee emp);
	
	void delete(int id);
	
	void deleteMany(int[] ids);
	
	Employee findById(int id);
	
	List<Employee> getAll();
	
	List<Employee> getAll(String empName);
}
