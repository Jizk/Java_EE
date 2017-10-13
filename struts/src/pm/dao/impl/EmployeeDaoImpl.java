package pm.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import pm.dao.EmployeeDao;
import pm.entity.Employee;
import pm.util.JdbcUtil;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public List<Employee> getAll() {
		String sql = "select * from employee";
		try {
			return JdbcUtil.getQuerrRunner().query(sql,new BeanListHandler<Employee>(Employee.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Employee findById(int id) {
		String sql = "select * from employee where id=?";
		try {
			return JdbcUtil.getQuerrRunner().query(sql,new BeanHandler<Employee>(Employee.class),id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void save(Employee emp) {
		String sql = "insert into employee(empName,workDate) values (?,?)";
		try {
			JdbcUtil.getQuerrRunner().update(sql,emp.getEmpName(),emp.getWorkDate());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(Employee emp) {
		String sql = "update employee set empName=?,workDate=? where id=?";
		try {
			JdbcUtil.getQuerrRunner().update(sql,emp.getEmpName(),emp.getWorkDate(),emp.getId());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
