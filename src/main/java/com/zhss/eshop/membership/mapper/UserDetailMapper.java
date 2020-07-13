package com.zhss.eshop.membership.mapper;

import com.zhss.eshop.membership.domain.UserDetailDO;
import org.apache.ibatis.annotations.*;

/**
 * 用户详细信息管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface UserDetailMapper {

	/**
	 * 新增用户详细信息
	 * @param userDetail 用户详细信息
	 */
	@Insert("INSERT INTO membership_user_detail("
				+ "user_account_id,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{userAccountId},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")")  
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true) 
	void save(UserDetailDO userDetail);
	
	/**
	 * 根据用户账号id查询用户详细信息
	 * @param userAccountId 用户账号id
	 * @return 用户详细信息
	 */
	@Select("SELECT "
				+ "id,"
				+ "user_account_id,"
				+ "name,"
				+ "gender,"
				+ "birthday,"
				+ "id_number,"
				+ "address,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM membership_user_detail "
			+ "WHERE user_account_id=#{userAccountId}") 
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "user_account_id", property = "userAccountId"),
		@Result(column = "name", property = "name"),
		@Result(column = "gender", property = "gender"),
		@Result(column = "birthday", property = "birthday"),
		@Result(column = "id_number", property = "idNumber"),
		@Result(column = "address", property = "address"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	UserDetailDO getByUserAccountId(@Param("userAccountId") Long userAccountId);
	
	/**
	 * 更新用户详细信息
	 * @param userDetail 用户详细信息
	 */
	@Update("UPDATE membership_user_detail SET "
				+ "name=#{name},"
				+ "gender=#{gender},"
				+ "birthday=#{birthday},"
				+ "id_number=#{idNumber},"
				+ "address=#{address},"
				+ "gmt_modified=#{gmtModified} "
			+ "WHERE user_account_id=#{userAccountId}")
 	void updateByUserAccountId(UserDetailDO userDetail);
	
}
