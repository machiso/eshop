package com.zhss.eshop.inventory.dao.impl;

import com.zhss.eshop.inventory.dao.StockUpdateMessageDAO;
import com.zhss.eshop.inventory.domain.StockUpdateMessageDO;
import com.zhss.eshop.inventory.mapper.StockUpdateMessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 库存更新消息管理模块DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class StockUpdateMessageDAOImpl implements StockUpdateMessageDAO {

	/**
	 * 库存更新消息管理模块mapper组件
	 */
	@Autowired
	private StockUpdateMessageMapper stockUpdateMessageMapper;
	
	/**
	 * 新增库存更新消息
	 * @param stockUpdateMessageDO 库存更新消息DO对象
	 */
	@Override
	public void save(StockUpdateMessageDO stockUpdateMessageDO) throws Exception {
		stockUpdateMessageMapper.save(stockUpdateMessageDO);
	}
	
	/**
	 * 批量查询库存更新消息：每次50条
	 * @return 库存更新消息DO对象集合
	 */
	@Override
	public List<StockUpdateMessageDO> listByBatch() throws Exception {
		return stockUpdateMessageMapper.listByBatch();
	}
	
	/**
	 * 批量删除库存更新消息
	 * @param ids 库存更新消息id集合字符串
	 */
	@Override
	public void removeByBatch(String ids) throws Exception {
		stockUpdateMessageMapper.removeByBatch(ids);
	}
	
	/**
	 * 查询库存更新消息记录数
	 * @return 库存更新消息记录数
	 */
	@Override
	public Long count() throws Exception {
		return stockUpdateMessageMapper.count();
	}
	
}
