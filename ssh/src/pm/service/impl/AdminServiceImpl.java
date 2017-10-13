package pm.service.impl;

import pm.dao.AdminDao;
import pm.entity.Admin;
import pm.service.AdminService;

public class AdminServiceImpl implements AdminService{

	private AdminDao adminDao;
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	@Override
	public void register(Admin admin) {
		adminDao.save(admin);
		
	}

	@Override
	public Admin login(Admin admin) {
		
		return adminDao.findByAdmin(admin);
	}

}
