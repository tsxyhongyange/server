package com.msm.biz.impl;

import com.msm.biz.TuserBiz;
import com.msm.dao.TuserDao;
import com.msm.dao.impl.TuserDaoImpl;
import com.msm.domain.Tuser;

public class TuserBizImpl implements TuserBiz {
	TuserDao td;
	
	public TuserBizImpl() {
		super();
		this.td =new TuserDaoImpl();
	}

	@Override
	public String addTuser(Tuser t) {
		// TODO Auto-generated method stub
		return this.td.insertTuser(t)?"添加成功！":"添加失败！";
	}

	@Override
	public String updateTuser(Tuser t, int mtype) {
		// TODO Auto-generated method stub
		return this.td.alterTuser(t, mtype)?"修改成功！":"修改失败！";
	}

	@Override
	public String bfreezeTuser(int userid) {
		// TODO Auto-generated method stub
		return this.td.freezeTuser(userid)?"冻结成功！":"冻结失败！";
	}

	@Override
	public Tuser selectTuser(int userid) {
		// TODO Auto-generated method stub
		return this.td.findTuser(userid);
	}

	@Override
	public Tuser selectTuserName(String uname) {
		// TODO Auto-generated method stub
		return this.td.findTuserName(uname);
	}

	@Override
	public String bisfreeze(int userid) {
		// TODO Auto-generated method stub
		return this.td.isfreeze(userid)?"账户已被冻结！":"账户没有被冻结！";
	}

	@Override
	public int selectMaxId() {
		// TODO Auto-generated method stub
		return this.td.getSeq();
	}

}
