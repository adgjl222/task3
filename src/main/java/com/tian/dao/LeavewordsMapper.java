package com.tian.dao;

import com.tian.model.Leavewords;

import java.util.List;

public interface LeavewordsMapper {

    /**
     * 根据留言id删除留言
     * @param leavewordsId
     * @return
     */
    int deleteByPrimaryKey(Integer leavewordsId);



    /**
     * 根据作品标题和留言状态查询留言
     * @param leavewords
     * @return
     */
    List<Leavewords> selectBylProductionNameAndleavewordsState(Leavewords leavewords);

    List<Leavewords> select();

    /**
     * 编辑 根据留言id修改留言状态
     * @param
     * @return
     */
    int updateLeavewordsStateByleavewordsId(Leavewords leavewords);

    /**
     * 添加留言回复
     * @param
     * @return
     */
    int updateReplyByleavewordsId(Leavewords leavewords );

    /**
     * 添加作品留言
     * @param leavewords
     * @return
     */
    int insertLeavewords(Leavewords leavewords);

    /*int insert(Leavewords record);

    int insertSelective(Leavewords record);

    List<Leavewords> selectByExample(LeavewordsExample example);

    int updateByExampleSelective(@Param("record") Leavewords record, @Param("example") LeavewordsExample example);

    int updateByExample(@Param("record") Leavewords record, @Param("example") LeavewordsExample example);

    long countByExample(LeavewordsExample example);

    int deleteByExample(LeavewordsExample example);*/
}
