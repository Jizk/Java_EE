package pm.dao;

import java.util.List;

import pm.entity.Employee;

public interface EmployeeDao {
	
	void save(Employee emp);
	
	void update(Employee emp);
	
	void delete(int id);
	
	Employee findById(int id);
	
	List<Employee> getAll();
	
	List<Employee> getAll(String empName);
}
