package com.msm.biz;

import com.msm.domain.Tuser;

public interface TuserBiz {
		//添加用户
		public String addTuser(Tuser t);
		//修改用户会员
		public String updateTuser(Tuser t,int mtype);
		//冻结用户
		public String bfreezeTuser(int userid);
		//查找用户 id
		public Tuser selectTuser(int userid);
		//查找用户 姓名
		public Tuser selectTuserName(String uname);
		//判断用户是否被冻结
		public String bisfreeze(int userid);
		
		//获取最大ID
		public int selectMaxId();
		
}
