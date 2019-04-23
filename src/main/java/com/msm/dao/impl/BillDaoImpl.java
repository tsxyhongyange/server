package com.msm.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.msm.dao.BillDao;
import com.msm.domain.Bill;
import com.msm.domain.CanTing;
import com.msm.util.DBUtil;

public class BillDaoImpl implements BillDao{
	DBUtil db;
	@Override
	public boolean insertBill(Bill b) {
		this.db=new DBUtil();
		String sql="insert into Bill values(?,?,?,?,?,?,?)";
		try {
			Date d=new Date(b.getBdate().getTime());
			int i = this.db.update(sql, b.getUuid(),b.getEid(),b.getUserid(),b.getCardid(),d,b.getBprice(),b.getLoc());
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return false;
	}
	//获取小票 某个用户所有的小票
	@Override
	public List<Bill> findBill(int userid) {
		this.db=new DBUtil();
		List<Bill> list=new ArrayList<Bill>();
		String sql="select *from bill where userid="+userid;
		try {
			ResultSet rs = this.db.query(sql);
			while(rs.next()){
				list.add(new Bill(rs.getInt("eid"), rs.getInt("userid"), rs.getInt("cardid"), rs.getDouble("bprice"), rs.getString("loc")));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//获取餐厅消费排行榜
	@Override
	public List<CanTing> findCT() {
		this.db=new DBUtil();
		List<CanTing> list=new ArrayList<CanTing>();
		String sql="select loc,sum(bprice) price from bill group by loc order by sum(bprice) desc";
		try {
			ResultSet rs = this.db.query(sql);
			while(rs.next()){
				list.add(new CanTing(rs.getString("loc"), rs.getDouble("price")));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int serviceTuser(int eid) {
		this.db=new DBUtil();
		String sql="select count(userid) from bill group by eid having eid="+eid;
		try {
			ResultSet rs = this.db.query(sql);
			if(rs.next()){
				return rs.getInt("count(userid)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public double sumMoney(int eid) {
		this.db=new DBUtil();
		String sql="select sum(bprice) from bill group by eid having eid="+eid;
		try {
			ResultSet rs = this.db.query(sql);
			if(rs.next()){
				return rs.getInt("sum(bprice)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
