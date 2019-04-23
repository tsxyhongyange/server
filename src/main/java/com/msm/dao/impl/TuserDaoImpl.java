package com.msm.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.msm.dao.TuserDao;
import com.msm.domain.Tuser;
import com.msm.util.DBUtil;

public class TuserDaoImpl implements TuserDao {
	DBUtil db;
	//添加用户
	@Override
	public boolean insertTuser(Tuser t) {
		this.db=new DBUtil();
		String s="select seq_tuser.nextval from dual";
		ResultSet rs;
		try {
			rs = this.db.query(s);
			if(rs.next()){
				int a = rs.getInt("nextval");
				String sql="insert into tuser values(?,?,?,?)";
				int i = this.db.update(sql, a,t.getUname(),t.getMtype(),t.getCdelete());
				return i>0;
			}
		} catch (SQLException e) {
			return false;
		}
		return false;
	}
	//加会员
	@Override
	public boolean alterTuser(Tuser t,int mtype) {
		this.db=new DBUtil();
		String sql="update tuser set mtype=? where userid="+t.getUserid();
		try {
			int i = this.db.update(sql, mtype);
			return i>0;
		} catch (SQLException e) {
			return false;
		}		
	}
//冻结
	@Override
	public boolean freezeTuser(int userid) {
		this.db=new DBUtil();
		String sql="update tuser set cdelete=0 where userid="+userid;
		try {
			int i = this.db.update(sql);
			return i>0;
		} catch (SQLException e) {
			return false;
		}	
	}
//查找
	@Override
	public Tuser findTuser(int userid) {
		this.db=new DBUtil();
		String sql="select *from tuser where userid="+userid;
		try {
			ResultSet rs = this.db.query(sql);
			if(rs.next()){
				return new Tuser(rs.getInt("userid"), rs.getString("uname"), rs.getInt("mtype"), rs.getInt("cdelete"));
			}
		} catch (SQLException e) {
			
		}
		return null;
	}
	@Override
	public boolean isfreeze(int userid) {
		this.db=new DBUtil();
		String sql="select cdelete from tuser where userid="+userid;
		try {
			ResultSet rs = this.db.query(sql);
			if(rs.next()){
				return rs.getInt("cdelete")==0;
			}
		} catch (SQLException e) {
			return false;
		}
		return false;
	}
	@Override
	public Tuser findTuserName(String uname) {
		this.db=new DBUtil();
		String sql="select *from tuser where uname=?";
		try {
			ResultSet rs = this.db.query(sql,uname);
			if(rs.next()){
				return new Tuser(rs.getInt("userid"), rs.getString("uname"), rs.getInt("mtype"), rs.getInt("cdelete"));
			}
		} catch (SQLException e) {
			
		}
		return null;
	}
	@Override
	public int getSeq() {
		this.db=new DBUtil();
		String sql="select max(userid) from tuser";
		try {
			ResultSet rs = this.db.query(sql);
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	

}
