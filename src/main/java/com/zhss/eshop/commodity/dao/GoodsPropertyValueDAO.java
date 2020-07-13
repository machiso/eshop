package com.zhss.eshop.commodity.dao;

import com.zhss.eshop.commodity.domain.GoodsPropertyValueDO;

import java.util.List;

/**
 * 商品属性值管理DAO组件接口
 * @author zhonghuashishan
 *
 */
public interface GoodsPropertyValueDAO {
	
	/**
	 * 根据商品id查询属性值
	 * @param goodsId 商品id
	 * @return 属性值
	 */
	List<GoodsPropertyValueDO> listByGoodsId(Long goodsId);

	/**
	 * 新增商品属性值
	 * @param goodsPropertyValue 商品属性值
	 */
	void save(GoodsPropertyValueDO goodsPropertyValue);
	
	/**
	 * 根据商品id删除属性值
	 * @param goodsId 商品id
	 */
	void removeByGoodsId(Long goodsId);
	
}
