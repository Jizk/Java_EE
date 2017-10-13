package pm.service;

import pm.entity.Admin;

public interface AdminService {
	
	void register(Admin admin);
	
	Admin login(Admin admin);
}
