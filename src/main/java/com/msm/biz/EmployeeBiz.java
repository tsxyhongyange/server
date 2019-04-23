package com.msm.biz;

import java.util.List;

import com.msm.domain.Employee;

public interface EmployeeBiz {
		//增加员工
		public String addEmployee(Employee e);
		//删除员工
		public String deleteEmployee(int eid);
		//获取员工
		public Employee selectEmployee(int eid);
		//获取经理
		public String selectManager(int mgr);
		//获取工作地点
		public String selectLoc(int eid);
		
		//-------------------二
		//获取经理姓名
		public String selectMaName(int eid);
		//获取所有员工
		public List<Employee> selectAllEmp();
		//获取经理管理的员工
		public List<Employee> selectByMagr(int magr);
}
