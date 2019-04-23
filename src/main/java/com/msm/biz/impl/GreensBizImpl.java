package com.msm.biz.impl;

import java.util.List;

import com.msm.biz.GreensBiz;
import com.msm.dao.GreensDao;
import com.msm.dao.impl.GreensDaoImpl;
import com.msm.domain.Greens;

public class GreensBizImpl implements GreensBiz {
	GreensDao gd;
	
	public GreensBizImpl() {
		super();
		this.gd =new GreensDaoImpl();
	}

	@Override
	public String addGreens(Greens g) {
		// TODO Auto-generated method stub
		return this.gd.insertGreens(g)?"添加成功！":"添加失败！";
	}

	@Override
	public String updatePrice(int gid, int price) {
		// TODO Auto-generated method stub
		return this.gd.alterPrice(gid, price)?"修改成功!":"修改失败!";
	}

	@Override
	public String updatePriced(int gid, int priced) {
		// TODO Auto-generated method stub
		return this.gd.alterPriced(gid, priced)?"修改成功!":"修改失败!";
	}

	@Override
	public String delete(int gid) {
		// TODO Auto-generated method stub
		return this.gd.revome(gid)?"删除成功！":"删除失败！";
	}

	@Override
	public List<Greens> welGreens() {
		// TODO Auto-generated method stub
		return this.gd.popularGreens();
	}

	@Override
	public List<Greens> selectGreens() {
		// TODO Auto-generated method stub
		return this.gd.findGreens();
	}

	@Override
	public Greens selectGreensById(int gid) {
		// TODO Auto-generated method stub
		return this.gd.findGreensById(gid);
	}

	@Override
	public void updateVolume(int gid) {
		this.gd.alterVolume(gid);
		
	}

}
