package com.msm.dao;

import java.util.List;

import com.msm.domain.Greens;
import com.msm.domain.Shopping;

public interface ShoppingDao {
	//添加购物车信息
	public boolean insertShopping(Shopping s);
}
