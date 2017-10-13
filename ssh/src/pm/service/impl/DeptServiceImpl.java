package pm.service.impl;

import java.util.List;

import pm.dao.DeptDao;
import pm.entity.Dept;
import pm.service.DeptService;

public class DeptServiceImpl implements DeptService{
	
	private DeptDao deptDao ;
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}
	
	@Override
	public List<Dept> getAll() {
		
		return deptDao.getAll();
	}

	@Override
	public Dept findById(int id) {
		
		return deptDao.findById(id);
	}

}
