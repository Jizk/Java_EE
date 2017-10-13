package pm.service;

import java.util.List;

import pm.entity.Dept;

public interface DeptService {
	
	List<Dept> getAll();
	
	Dept findById(int id);
}
