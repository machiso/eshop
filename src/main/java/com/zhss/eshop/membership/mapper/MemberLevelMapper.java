package com.zhss.eshop.membership.mapper;

import com.zhss.eshop.membership.domain.MemberLevelDO;
import org.apache.ibatis.annotations.*;

/**
 * 会员等级管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface MemberLevelMapper {

	/**
	 * 根据用户账号id查询会员等级
	 * @param userAccountId 用户账号id
	 * @return 会员等级
	 */
	@Select("SELECT "
				+ "id,"
				+ "user_account_id,"
				+ "growth_value,"
				+ "level,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM membership_member_level "
			+ "WHERE user_account_id=#{userAccountId}")  
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "user_account_id", property = "userAccountId"),
		@Result(column = "growth_value", property = "growthValue"),
		@Result(column = "level", property = "level"), 
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified") 
	})
	MemberLevelDO getByUserAccountId(@Param("userAccountId") Long userAccountId);
	
	/**
	 * 新增会员等级
	 * @param memberLevel 会员等级
	 */
	@Insert("INSERT INTO membership_member_level("
				+ "user_account_id,"
				+ "growth_value,"
				+ "level,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{userAccountId},"
				+ "#{growthValue},"
				+ "#{level},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")") 
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true) 
	void save(MemberLevelDO memberLevel);
	
	/**
	 * 更新会员等级
	 * @param memberLevel 会员等级
	 */
	@Update("UPDATE membership_member_level SET "
				+ "growth_value=#{growthValue},"
				+ "level=#{level},"
				+ "gmt_modified=#{gmtModified} "
			+ "WHERE id=#{id}") 
	void update(MemberLevelDO memberLevel);
	
}
