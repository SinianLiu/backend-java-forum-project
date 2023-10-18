package com.springboot.forum.dao;

import com.springboot.forum.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//首页查询功能
@Mapper
public interface DiscussPostMapper {
//    offset是每一页起始行的行号，limit是每一页展示帖子的数量
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);


//  查询该用户主页有多少帖子/或者查询总有多少帖子（比如论坛首页） 时userID为0
    // @Param注解用于给参数取别名,
    // 如果该方法只有一个参数,并且在动态SQL <if>里使用,则必须加别名.
    int selectDiscussPostRows(@Param("userId") int userId);

    int insertDiscussPost(DiscussPost discussPost);

    DiscussPost selectDiscussPostById(int id);

    int updateCommentCount(int id, int commentCount);

}
