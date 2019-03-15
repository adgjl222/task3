package com.tian.service;

import com.tian.model.Leavewords;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface LeavewordsService {
    /**
     * 根据留言id删除留言
     * @param leavewordsId
     * @return
     */
    Boolean deleteByPrimaryKey(Integer leavewordsId);



    /**
     * 根据作品标题和留言状态查询留言
     * @param
     * @return
     */
    List<Leavewords>  selectBylProductionNameAndleavewordsState(Leavewords leavewords);

    List<Leavewords> select();



    /**
     * 编辑 根据留言id修改留言状态
     * @param leavewords
     * @return
     */
    Boolean updateLeavewordsStateByleavewordsId(Leavewords leavewords);



    /**
     * 根据留言id添加留言回复 同时修改留言状态
     * 留言有回复即此条留言状态为精选留言
     * @param
     * @return
     */
    Boolean updateReplyAndLeavewordsStateByleavewordsId(Leavewords leavewords);


    int insertLeavewords(Leavewords leavewords);

}
