package com.msm.biz;

import java.util.List;

import com.msm.domain.Bill;
import com.msm.domain.CanTing;

public interface BillBiz {
		//添加小票
		public String addBill(Bill b);
		//获取小票 某个用户所有的小票
		public List<Bill> selectBill(int userid);
		//获取餐厅消费排行榜
		public List<CanTing> findCT();
		
		//获取员工服务的单数
		public int serviceBill(int eid);
		//获取员工所卖出的金额
		public double salMoney(int eid);
}
