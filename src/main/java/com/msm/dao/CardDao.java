package com.msm.dao;

public interface CardDao {
	//开卡
	public boolean openCard(int userid);
	//查询余额
	public double findBal(int userid);
	//查看是否有卡(开卡前判断)
	public boolean findCard(int userid);
	//查询卡号
	public int  findCardId(int userid);
	//挂失
	public boolean lossCard(int userid);
	//激活
	public boolean aliveCard(int userid);
	//充值
	public boolean changeCard(int userid,double cardbal);
	//判断卡是否被挂失
	public boolean isloss(int userid);
}
