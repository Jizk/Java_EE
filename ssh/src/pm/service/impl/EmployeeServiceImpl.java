package pm.service.impl;

import java.util.List;

import pm.dao.EmployeeDao;
import pm.entity.Employee;
import pm.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeDao employeeDao;
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@Override
	public void save(Employee emp) {
		
		employeeDao.save(emp);
	}

	@Override
	public void update(Employee emp) {
		
		employeeDao.update(emp);
	}

	@Override
	public void delete(int id) {
		employeeDao.delete(id);
		
	}

	@Override
	public void deleteMany(int[] ids) {
		if(ids!=null&&ids.length>0){
			for(int i:ids){
				delete(i);
			}
		}
		
	}

	@Override
	public Employee findById(int id) {
		
		return employeeDao.findById(id);
	}

	@Override
	public List<Employee> getAll() {
		
		return employeeDao.getAll();
	}

	@Override
	public List<Employee> getAll(String empName) {
		
		return employeeDao.getAll(empName);
	}

}
