package com.tian.dao;

import com.tian.model.BannerManage;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BannerManageMapper {


    /**
     * 根据bannerManageId删除banner
     * @param bannerManageId
     * @return
     */
    int deleteByPrimaryKey(Integer bannerManageId);

    /**
     * 新增banner
     * @param bannerManage
     * @return
     */
    int insert(BannerManage bannerManage);


    int updateByPrimaryKeySelective(BannerManage bannerManage);


    List<BannerManage> selectByCompileAndState(BannerManage bannerManage);

}