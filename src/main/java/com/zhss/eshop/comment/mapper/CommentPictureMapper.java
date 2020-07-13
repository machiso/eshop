package com.zhss.eshop.comment.mapper;

import com.zhss.eshop.comment.domain.CommentPictureDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 评论晒图管理模块的mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface CommentPictureMapper {

	/**
	 * 新增评论晒图
	 * @param commentPictureDO 评论晒图DO对象
	 */
	@Insert("INSERT INTO comment_picture("
				+ "comment_info_id,"
				+ "comment_picture_path,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ")"
			+ "VALUES("
				+ "#{commentInfoId},"
				+ "#{commentPicturePath},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")") 
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void saveCommentPicture(CommentPictureDO commentPictureDO);
	
	/**
	 * 根据评论信息id查询图片
	 * @param commentId 评论信息id
	 * @return 评论图片
	 */
	@Select("SELECT "
				+ "id,"
				+ "comment_info_id,"
				+ "comment_picture_path,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM comment_picture "
			+ "WHERE comment_info_id=#{commentId}")  
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "comment_info_id", property = "commentInfoId"),
		@Result(column = "comment_picture_path", property = "commentPicturePath"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	List<CommentPictureDO> listByCommentId(@Param("commentId") Long commentId);
	
	/**
	 * 根据id查询图片
	 * @param id 评论图片id
	 * @return 评论图片
	 */
	@Select("SELECT "
				+ "id,"
				+ "comment_info_id,"
				+ "comment_picture_path,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM comment_picture "
			+ "WHERE id=#{id}")  
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "comment_info_id", property = "commentInfoId"),
		@Result(column = "comment_picture_path", property = "commentPicturePath"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	CommentPictureDO getById(@Param("id") Long id);
	
}
