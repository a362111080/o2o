package com.imooc.o2o.entity;

import java.util.Date;

public class ProductCategory {
	private Long productCategoryId;
	private Long shopId;
	private String productCategoryName;
	private Integer prioruty;
	private Date createTimel;
	
	public Long getProductCategoryId() {
		return productCategoryId;
	}
	public void setProductCategoryId(Long productCategoryId) {
		this.productCategoryId = productCategoryId;
	}
	public Long getShopId() {
		return shopId;
	}
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	public String getProductCategoryName() {
		return productCategoryName;
	}
	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
	}
	public Integer getPrioruty() {
		return prioruty;
	}
	public void setPrioruty(Integer prioruty) {
		this.prioruty = prioruty;
	}
	public Date getCreateTimel() {
		return createTimel;
	}
	public void setCreateTimel(Date createTimel) {
		this.createTimel = createTimel;
	}

}
