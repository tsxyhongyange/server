package com.msm.biz.impl;

import com.msm.biz.CardBiz;
import com.msm.dao.CardDao;
import com.msm.dao.impl.CardDaoImpl;

public class CardBizImpl implements CardBiz {
	CardDao cd;
	
	public CardBizImpl() {
		super();
		this.cd =new CardDaoImpl();
	}

	@Override
	public String bopenCard(int userid) {
		// TODO Auto-generated method stub
		return this.cd.openCard(userid)?"开卡成功！":"开卡失败！";
	}

	@Override
	public double selectBal(int userid) {
		// TODO Auto-generated method stub
		return this.cd.findBal(userid);
	}

	@Override
	public String selectCard(int userid) {
		// TODO Auto-generated method stub
		return this.cd.findCard(userid)?"您已经有卡了":"您还没有卡呢";
	}

	@Override
	public int selectCardId(int userid) {
		// TODO Auto-generated method stub
		return this.cd.findCardId(userid);
	}

	@Override
	public String blossCard(int userid) {
		// TODO Auto-generated method stub
		return this.cd.lossCard(userid)?"挂失失败！":"挂失失败！";
	}

	@Override
	public String baliveCard(int userid) {
		// TODO Auto-generated method stub
		return this.cd.aliveCard(userid)?"激活成功！":"激活失败！";
	}

	@Override
	public String bchangeCard(int userid, int cardbal) {
		// TODO Auto-generated method stub
		return this.cd.changeCard(userid, cardbal)?"充值成功！":"充值失败！";
	}

	@Override
	public String bisloss(int userid) {
		// TODO Auto-generated method stub
		return this.cd.isloss(userid)?"卡已经被挂失了！":"卡没有挂失！";
	}

}
