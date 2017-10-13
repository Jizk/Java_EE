package pm.dao.impl;

import org.hibernate.SessionFactory;

import pm.dao.AdminDao;
import pm.entity.Admin;
import pm.entity.Employee;

public class AdminDaoImpl implements AdminDao{
	
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Admin admin) {
		sessionFactory.getCurrentSession().save(admin);
		
	}

	@Override
	public Admin findByAdmin(Admin admin) {
		
		 return (Admin) sessionFactory.getCurrentSession()
				.createQuery("from Admin where adminName=? and pwd=?")
				.setString(0, admin.getAdminName())
				.setString(1, admin.getPwd())
				.uniqueResult(); //不重复
		 
	}

}
