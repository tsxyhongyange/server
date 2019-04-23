package com.msm.dao;

import java.util.List;

import com.msm.domain.Greens;

public interface GreensDao {
	//增加菜品
	public boolean insertGreens(Greens g);
	//修改菜品价格
	public boolean alterPrice(int gid,int price);
	//修改今日价格
	public boolean alterPriced(int gid,int priced);
	//删除菜品
	public boolean revome(int gid);
	//最受欢迎的菜
	public List<Greens> popularGreens();
	//查询所有菜品
	public List<Greens> findGreens();
	//根据菜品ID查询菜品
	public Greens findGreensById(int gid);
	
	//修改菜品销量
	public boolean alterVolume(int gid);
}
