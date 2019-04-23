package com.msm.biz.impl;

import java.util.List;

import com.msm.biz.EmployeeBiz;
import com.msm.dao.EmployeeDao;
import com.msm.dao.impl.EmployeeDaoImpl;
import com.msm.domain.Employee;

public class EmployeeBizImpl implements EmployeeBiz {
	EmployeeDao emp;
	
	public EmployeeBizImpl() {
		super();
		this.emp =new EmployeeDaoImpl();
	}

	@Override
	public String addEmployee(Employee e) {
		// TODO Auto-generated method stub
		return this.emp.insertEmployee(e)?"添加成功！":"添加失败!";
	}

	@Override
	public String deleteEmployee(int eid) {
		// TODO Auto-generated method stub
		return this.emp.removeEmployee(eid)?"删除成功！":"删除失败！";
	}

	@Override
	public Employee selectEmployee(int eid) {
		// TODO Auto-generated method stub
		return this.emp.findEmployee(eid);
	}

	@Override
	public String selectManager(int mgr) {
		// TODO Auto-generated method stub
		return this.emp.findManager(mgr);
	}

	@Override
	public String selectLoc(int eid) {
		// TODO Auto-generated method stub
		return this.emp.findLoc(eid);
	}

	//---------------------二
	@Override
	public String selectMaName(int eid) {
		// TODO Auto-generated method stub
		return this.emp.findMaName(eid);
	}

	@Override
	public List<Employee> selectAllEmp() {
		// TODO Auto-generated method stub
		return this.emp.findAllEmp();
	}

	@Override
	public List<Employee> selectByMagr(int magr) {
		// TODO Auto-generated method stub
		return this.emp.findByMagr(magr);
	}

}
