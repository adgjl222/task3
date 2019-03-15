package com.tian.service;

import com.tian.model.BannerManage;

import java.util.List;

public interface BannerManageService {
    /**
     * 根据bannerManageId删除banner
     * @param bannerManageId
     * @return
     */
    Boolean deleteByPrimaryKey(Integer bannerManageId);

    /**
     * 新增banner
     * @param bannerManage
     * @return
     */
    int insert(BannerManage bannerManage);


    Boolean updateBannerStateByPrimaryKey(BannerManage bannerManage);
    Boolean updateUrlByPrimaryKey(BannerManage bannerManage);

    List<BannerManage> selectByCompileAndState(BannerManage bannerManage);
}
