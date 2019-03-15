package com.tian.service;

import com.tian.model.StudioManage;

import java.util.List;

public interface StudioManageSrevice {

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

    Boolean deleteByPrimaryKey(Integer studioId);

    Boolean updateStateByPrimaryKey(StudioManage studioManage);

    Boolean updateNameByPrimaryKey(StudioManage studioManage);
}
