package com.msm.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.msm.dao.GreensDao;
import com.msm.domain.Greens;
import com.msm.util.DBUtil;

public class GreensDaoImpl implements GreensDao {
	DBUtil db;
	@Override
	public boolean insertGreens(Greens g) {
		this.db=new DBUtil();
		String s="select seq_greens.nextval from dual";
		ResultSet rs;	
		try {
			rs = this.db.query(s);
			if(rs.next()){
				int a = rs.getInt("nextval");
				String sql="insert into greens values(?,?,?,?,?,?,?)";
				int i = this.db.update(sql, a,g.getGname(),g.getGprice(),g.getGpriced(),g.getGtypeid(),g.getGvolume(),g.getCdelete());
				return i>0;
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean alterPrice(int gid,int price) {
		this.db=new DBUtil();
		String sql="update greens set gprice=? where gid="+gid;
		try {
			int i = this.db.update(sql, price);
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean alterPriced(int gid,int priced) {
		this.db=new DBUtil();
		String sql="update greens set gpriced=? where gid="+gid;
		try {
			int i = this.db.update(sql, priced);
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean revome(int gid) {
		this.db=new DBUtil();
		String sql="update greens set cdelete=0 where gid="+gid;
		try {
			int i = this.db.update(sql);
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Greens> popularGreens() {
		this.db=new DBUtil();
		List<Greens> list =new ArrayList<Greens>();
		String sql="select *from greens order by gvolume desc";
		try {
			ResultSet rs = this.db.query(sql);
			while(rs.next()){
				list.add(new Greens(rs.getInt("gid"), rs.getString("gname"), rs.getDouble("gprice"), rs.getDouble("gpriced"), rs.getInt("gvolume"), rs.getInt("gtypeid"), rs.getInt("cdelete")));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Greens> findGreens() {
		this.db=new DBUtil();
		List<Greens> list =new ArrayList<Greens>();
		String sql="select *from greens order by gtypeid desc";
		try {
			ResultSet rs = this.db.query(sql);
			while(rs.next()){
				list.add(new Greens(rs.getInt("gid"), rs.getString("gname"), rs.getDouble("gprice"), rs.getDouble("gpriced"), rs.getInt("gvolume"), rs.getInt("gtypeid"), rs.getInt("cdelete")));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Greens findGreensById(int gid) {
		this.db=new DBUtil();
		String sql="select *from greens where gid="+gid;
		try {
			ResultSet rs = this.db.query(sql);
			if(rs.next()){
				return new Greens(rs.getInt("gid"), rs.getString("gname"), rs.getDouble("gprice"), rs.getDouble("gpriced"), rs.getInt("gvolume"), rs.getInt("gtypeid"), rs.getInt("cdelete"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean alterVolume(int gid) {
		this.db=new DBUtil();
		String sql="select gvolume from greens where gid="+gid;
		try {
			ResultSet rs = this.db.query(sql);
			if(rs.next()){
				int a = rs.getInt("gvolume");
				String sql2="update greens set gvolume=? where gid="+gid;
				int i = this.db.update(sql2, a+1);
				return i>0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
