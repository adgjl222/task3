package com.tian.dao;

import com.tian.model.StudioManage;

import java.util.List;

public interface StudioManageMapper {


    /**
     * 新增工作室管理
     * @param studioManage
     * @return
     */
    int insertSelective(StudioManage studioManage);

    /**
     * 根据工作室名称和工作室状态查询工作室信息
     * @param studioManage

     * @return
     */
    List<StudioManage> selectByStudioManageTypeAndStudioManageState(StudioManage studioManage);


    int deleteByPrimaryKey(Integer studioId);

    int updateByPrimaryKey(StudioManage studioManage);

}