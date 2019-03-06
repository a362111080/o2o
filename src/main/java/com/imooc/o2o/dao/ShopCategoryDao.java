package com.imooc.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.imooc.o2o.entity.ShopCategory;

public interface ShopCategoryDao {

	/**
	 * 列出店铺种类
	 * @param shopcategory
	 * @return
	 */
	List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition")ShopCategory shopcategory);
}
