package com.msm.biz;

public interface CardBiz {
		//开卡
		public String bopenCard(int userid);
		//查询余额
		public double selectBal(int userid);
		//查看是否有卡(开卡前判断)
		public String selectCard(int userid);
		//查询卡号
		public int  selectCardId(int userid);
		//挂失
		public String blossCard(int userid);
		//激活
		public String baliveCard(int userid);
		//充值
		public String bchangeCard(int userid,int cardbal);
		//判断卡是否被挂失
		public String bisloss(int userid);
}
