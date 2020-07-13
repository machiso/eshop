package com.zhss.eshop.commodity.controller;

import com.zhss.eshop.commodity.domain.GoodsPropertyValueDTO;
import com.zhss.eshop.commodity.domain.GoodsPropertyValueVO;
import com.zhss.eshop.commodity.service.GoodsPropertyValueService;
import com.zhss.eshop.common.util.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品属性值管理controller组件
 * @author zhonghuashishan
 *
 */
@RestController
@RequestMapping("/commodity/goods/property/value") 
public class GoodsPropertyValueController {
	
	private static final Logger logger = LoggerFactory.getLogger(GoodsPropertyValueController.class);

	/**
	 * 商品属性值管理service组件
	 */
	@Autowired
	private GoodsPropertyValueService propertyValueService;

	/**
	 * 根据商品id查询属性值
	 * @param goodsId 商品id
	 * @return 属性值
	 */
	@GetMapping("/{goodsId}")  
	public List<GoodsPropertyValueVO> listByGoodsId(@PathVariable("goodsId") Long goodsId) {
		try {
			return ObjectUtils.convertList(propertyValueService.listByGoodsId(goodsId), 
					GoodsPropertyValueVO.class);  
		} catch (Exception e) {
			logger.error("error", e); 
			return new ArrayList<GoodsPropertyValueVO>();
		}
	}
	
	/**
	 * 新增商品属性值
	 * @param goodsPropertyValue 商品属性值
	 */
	@PostMapping("/")  
	public Boolean batchSave(@RequestBody List<GoodsPropertyValueVO> propertyValues) throws Exception {
		try {
			propertyValueService.batchSave(ObjectUtils.convertList(propertyValues, 
					GoodsPropertyValueDTO.class));
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 根据商品id删除属性值
	 * @param goodsId 商品id
	 */
	@DeleteMapping("/{id}") 
	public Boolean removeByGoodsId(@PathVariable("goodsId") Long goodsId) {
		try {
			propertyValueService.removeByGoodsId(goodsId);
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
}
