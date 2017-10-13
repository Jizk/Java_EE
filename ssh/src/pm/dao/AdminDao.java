package pm.dao;

import pm.entity.Admin;

public interface AdminDao {
	
	void save(Admin admin);
	
	Admin findByAdmin(Admin admin);
}
