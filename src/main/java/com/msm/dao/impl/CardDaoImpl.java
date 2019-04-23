package com.msm.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.msm.dao.CardDao;
import com.msm.util.DBUtil;

public class CardDaoImpl implements CardDao {
	DBUtil db;
	@Override
	public boolean openCard(int userid) {
		this.db=new DBUtil();
		String s="select seq_card.nextval from dual";
		ResultSet rs;
		try {
			rs = this.db.query(s);
			if(rs.next()){
				int a = rs.getInt("nextval");
				String sql="insert into card values(?,?,?,?)";	
				int i = this.db.update(sql,a,0,userid,1);
				return i>0;
			}				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return false;
	}

	@Override
	public double findBal(int userid) {
		this.db=new DBUtil();
		String sql="select cardbal from card where userid="+userid;
		try {
			ResultSet rs = this.db.query(sql);
			if(rs.next()){
				return rs.getInt("cardbal");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean findCard(int userid) {
		this.db=new DBUtil();
		String sql="select userid from card";
		try {
			ResultSet rs = this.db.query(sql);
			while(rs.next()){
				int i = rs.getInt("userid");
				if(i==userid){
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean lossCard(int userid) {
		this.db=new DBUtil();
		String sql="update card set cdelete=0 where userid="+userid;
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
	public boolean aliveCard(int userid) {
		this.db=new DBUtil();
		String sql="update card set cdelete=1 where userid="+userid;
		try {
			int i = this.db.update(sql);
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
//
	@Override
	public boolean changeCard(int userid,double cardbal) {
		this.db=new DBUtil();
		double bal = this.findBal(userid);
		String sql="update card set cardbal=? where userid="+userid;
		try {
			int i = this.db.update(sql, cardbal+bal);
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean isloss(int userid) {
		this.db=new DBUtil();
		String sql="select cdelete from card where userid="+userid;
		try {
			ResultSet rs = this.db.query(sql);
			if(rs.next()){
				int i=rs.getInt("cdelete");
				return i==0;
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int findCardId(int userid) {
		this.db=new DBUtil();
		String sql="select cardid from card where userid="+userid;
		try {
			ResultSet rs = this.db.query(sql);
			if(rs.next()){
				int i=rs.getInt("cardid");
				return i;
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
