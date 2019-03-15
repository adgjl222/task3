package com.tian.service.impl;

import com.tian.dao.StudioManageMapper;
import com.tian.model.StudioManage;
import com.tian.service.StudioManageSrevice;
import com.util.DateTime;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class StudioManageMapperImpl  implements StudioManageSrevice {

    @Resource
    private StudioManageMapper studioManageMapper;

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(BannerManageServiceImpl.class);

    /**
     * 新增工作室管理
     *
     * @param studioManage
     * @return
     */
    @Override
    public int insertSelective(StudioManage studioManage) {
        studioManage.setCreatedAt(DateTime.getTime());
        return this.studioManageMapper.insertSelective(studioManage);
    }

    /**
     * 根据工作室名称和工作室状态查询工作室信息
     *
     * @param studioManage
     * @return
     */
    @Override
    public List<StudioManage> selectByStudioManageTypeAndStudioManageState(StudioManage studioManage) {
        return this.studioManageMapper.selectByStudioManageTypeAndStudioManageState(studioManage);
    }

    @Override
    public Boolean deleteByPrimaryKey(Integer studioId) {
        Boolean delete = false;

        int count = studioManageMapper.deleteByPrimaryKey(studioId);
        if (count != 0){
            delete = true;
            log.info( "id为 "+ studioId +" 的工作室删除 " + delete );
        }else {
            log.info( "id为 "+ studioId +" 的工作室删除 " + delete );
        }
        return delete;
    }

    @Override
    public Boolean updateStateByPrimaryKey(StudioManage studioManage) {
        studioManage.setUpdatedAt(DateTime.getTime());
        Boolean update = false;

        int count = studioManageMapper.updateByPrimaryKey(studioManage);
        if (count != 0){
            update = true;
            log.info( "id为 "+ studioManage.getStudioId()
                    +" 的studio状态更新为 "+studioManage.getStudioState());
        }else {
            log.info( "id为 "+ studioManage.getStudioId()
                    +" 的studio状态更新为 "+studioManage.getStudioState());
        }
        return update;
    }

    @Override
    public Boolean updateNameByPrimaryKey(StudioManage studioManage) {
        studioManage.setUpdatedAt(DateTime.getTime());
        Boolean update = false;

        int count = studioManageMapper.updateByPrimaryKey(studioManage);
        if (count != 0){
            update = true;
            log.info( "id为 "+ studioManage.getStudioId()
                    +" 的studio简介类型更新为 "+studioManage.getStudioType());
        }else {
            log.info( "id为 "+ studioManage.getStudioId()
                    +" 的studio简介类型更新为 "+studioManage.getStudioType());
        }
        return update;
    }
}
