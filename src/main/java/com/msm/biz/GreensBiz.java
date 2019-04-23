package com.msm.biz;

import java.util.List;

import com.msm.domain.Greens;

public interface GreensBiz {
		//增加菜品
		public String addGreens(Greens g);
		//修改菜品价格
		public String updatePrice(int gid,int price);
		//修改今日价格
		public String updatePriced(int gid,int priced);
		//删除菜品
		public String delete(int gid);
		//最受欢迎的菜
		public List<Greens> welGreens();
		//查询所有菜品
		public List<Greens> selectGreens();
		//根据菜品ID查询菜品
		public Greens selectGreensById(int gid);
		
		//修改销量
		public void updateVolume(int gid);
}
