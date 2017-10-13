package pm.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import pm.dao.EmployeeDao;
import pm.entity.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Employee emp) {
		sessionFactory.getCurrentSession().save(emp);

	}

	@Override
	public void update(Employee emp) {
		sessionFactory.getCurrentSession().update(emp);

	}

	@Override
	public void delete(int id) {
		sessionFactory.getCurrentSession()
				.createQuery("delete from Employee where id=?")
				.setParameter(0, id).executeUpdate();

	}

	@Override
	public Employee findById(int id) {

		return (Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAll() {

		return sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAll(String empName) {

		return sessionFactory.getCurrentSession()
				.createQuery("from Employee where empName like ?")
				.setParameter(0, "%"+empName+"%")
				.list();
	}

}
