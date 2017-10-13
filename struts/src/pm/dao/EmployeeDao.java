package pm.dao;

import java.util.List;

import pm.entity.Employee;

public interface EmployeeDao {
	
	List<Employee> getAll();
	
	Employee findById(int id);
	
	void save(Employee emp);
	
	void update(Employee emp);
}
