package com.msm.dao;

import com.msm.domain.Tuser;

public interface TuserDao {	
	//添加用户
	public boolean insertTuser(Tuser t);
	//修改用户会员
	public boolean alterTuser(Tuser t,int mtype);
	//冻结用户
	public boolean freezeTuser(int userid);
	//查找用户 id
	public Tuser findTuser(int userid);
	//查找用户 姓名
	public Tuser findTuserName(String uname);
	//判断用户是否被冻结
	public boolean isfreeze(int userid);	
	//获取序列值
	public int getSeq();
}
