package com.msm.biz.impl;

import java.util.List;

import com.msm.biz.BillBiz;
import com.msm.dao.BillDao;
import com.msm.dao.impl.BillDaoImpl;
import com.msm.domain.Bill;
import com.msm.domain.CanTing;

public class BillBizImpl implements BillBiz {
	private BillDao bi;
	
	public BillBizImpl() {
		super();
		this.bi =new BillDaoImpl();
	}

	@Override
	public String addBill(Bill b) {
		return this.bi.insertBill(b)?"添加成功!":"添加失败!";
	}

	@Override
	public List<Bill> selectBill(int userid) {
		return this.bi.findBill(userid);
	}

	@Override
	public List<CanTing> findCT() {
		return this.bi.findCT();
	}

	@Override
	public int serviceBill(int eid) {
		// TODO Auto-generated method stub
		return this.bi.serviceTuser(eid);
	}

	@Override
	public double salMoney(int eid) {
		// TODO Auto-generated method stub
		return this.bi.sumMoney(eid);
	}

}
