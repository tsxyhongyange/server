package com.msm.dao;

import java.util.List;

import com.msm.domain.Employee;


public interface EmployeeDao {
	//增加员工
	public boolean insertEmployee(Employee e);
	//删除员工
	public boolean removeEmployee(int eid);
	//获取员工
	public Employee findEmployee(int eid);
	//获取经理
	public String findManager(int mgr);
	//获取工作地点
	public String findLoc(int eid);
	
	//获取经理姓名
	public String findMaName(int eid);
	//获取所有员工
	public List<Employee> findAllEmp();
	//获取经理管理的员工
	public List<Employee> findByMagr(int magr);
}
