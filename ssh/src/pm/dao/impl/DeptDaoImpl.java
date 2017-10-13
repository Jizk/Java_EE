package pm.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import pm.dao.DeptDao;
import pm.entity.Dept;

public class DeptDaoImpl implements DeptDao{
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Dept> getAll() {
		
		return sessionFactory.getCurrentSession().createQuery("from Dept").list();
	}

	@Override
	public Dept findById(int id) {
		
		return (Dept) sessionFactory.getCurrentSession().get(Dept.class, id);
	}

}
