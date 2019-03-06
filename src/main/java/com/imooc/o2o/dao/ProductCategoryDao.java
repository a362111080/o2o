package com.imooc.o2o.dao;

import com.imooc.o2o.entity.ProductCategory;
import com.sun.swing.internal.plaf.synth.resources.synth_sv;

import java.util.List;

public interface ProductCategoryDao {
    /**
     * 通过shop id查询商铺商品类别
     *
     * @param shopId
     * @return
     */
    
    List<ProductCategory> queryProductCategoryList(long  shopId);
}
