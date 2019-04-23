package com.msm.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.msm.dao.EmployeeDao;
import com.msm.domain.Employee;
import com.msm.domain.Tuser;
import com.msm.util.DBUtil;

public class EmployeeDaoImpl implements EmployeeDao {
	DBUtil db;
	@Override
	public boolean insertEmployee(Employee e) {
		this.db=new DBUtil();
		String s="select seq_employee.nextval from dual";
		ResultSet rs;		
		try {
			rs = this.db.query(s);
			if(rs.next()){
				int a = rs.getInt("nextval");
				String sql="insert into employee values(?,?,?,?)";
				int i = this.db.update(sql, a,e.getMagr(),e.getEname(),e.getEpassword());
				return i>0;
			}	
		} catch (SQLException e1) {
			return false;
		}
		return false;
	}

	@Override
	public boolean removeEmployee(int eid) {
		this.db=new DBUtil();
		String sql="delete from employee where eid="+eid;
		try {
			int i = this.db.update(sql);
			return i>0;
		} catch (SQLException e) {
			return false;
		}
		
	}

	@Override
	public Employee findEmployee(int eid) {
		this.db=new DBUtil();
		String sql="select *from employee where eid="+eid;
		try {
			ResultSet rs = this.db.query(sql);
			if(rs.next()){
				return new Employee(rs.getInt("eid"), rs.getInt("magr"), rs.getString("ename"), rs.getString("epassword"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}

	@Override
	public String findManager(int magr) {
		this.db=new DBUtil();
		String sql="select mpassword from manager where magr="+magr;
		try {
			ResultSet rs = this.db.query(sql);
			if(rs.next()){
				return rs.getString("mpassword");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}

	@Override
	public String findLoc(int eid) {
		this.db=new DBUtil();
		String sql="select e.eid,m.loc from employee e,manager m where m.magr=e.magr and e.eid="+eid;
		try {
			ResultSet rs = this.db.query(sql);
			if(rs.next()){
				return rs.getString("loc");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String findMaName(int eid) {
		this.db=new DBUtil();
		String sql="select e.eid,m.mname from employee e,manager m where m.magr=e.magr and e.eid="+eid;
		try {
			ResultSet rs = this.db.query(sql);
			if(rs.next()){
				return rs.getString("mname");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Employee> findAllEmp() {
		this.db=new DBUtil();
		List<Employee> list=new ArrayList<Employee>();
		String sql="select *from employee";
		try {
			ResultSet rs = this.db.query(sql);
			while(rs.next()){
				list.add(new Employee(rs.getInt("eid"), rs.getInt("magr"), rs.getString("ename"), rs.getString("epassword")));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Employee> findByMagr(int magr) {
		this.db=new DBUtil();
		List<Employee> list=new ArrayList<Employee>();
		String sql="select *from employee where magr="+magr;
		try {
			ResultSet rs = this.db.query(sql);
			while(rs.next()){
				list.add(new Employee(rs.getInt("eid"), rs.getInt("magr"), rs.getString("ename"), rs.getString("epassword")));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
