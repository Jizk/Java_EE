package pm.service.impl;

import java.util.List;

import pm.dao.EmployeeDao;
import pm.dao.impl.EmployeeDaoImpl;
import pm.entity.Employee;
import pm.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeDao employeeDao = new EmployeeDaoImpl();

	@Override
	public List<Employee> getAll() {
		
		return employeeDao.getAll();
	}

	@Override
	public Employee findById(int id) {
		
		return employeeDao.findById(id);
	}

	@Override
	public void save(Employee emp) {
		
		employeeDao.save(emp);
	}

	@Override
	public void update(Employee emp) {
		employeeDao.update(emp);
	}

}
