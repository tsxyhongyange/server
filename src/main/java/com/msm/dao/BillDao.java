package com.msm.dao;

import java.util.List;

import com.msm.domain.Bill;
import com.msm.domain.CanTing;

public interface BillDao {
	//添加小票
	public boolean insertBill(Bill b);
	//获取小票 某个用户所有的小票
	public List<Bill> findBill(int userid);
	//获取餐厅消费排行榜
	public List<CanTing> findCT();
	
	//获取员工所服务过的用户数量
	public int serviceTuser(int eid);
	//获取员工所经手的交易额
	public double sumMoney(int eid);
}
