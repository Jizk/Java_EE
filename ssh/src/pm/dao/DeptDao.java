package pm.dao;

import java.util.List;

import pm.entity.Dept;

public interface DeptDao {
	
	List<Dept> getAll();
	
	Dept findById(int id);

}
