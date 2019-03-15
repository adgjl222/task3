package com.tian.service.impl;

import com.tian.dao.BannerManageMapper;
import com.tian.model.BannerManage;
import com.tian.service.BannerManageService;
import com.util.DateTime;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BannerManageServiceImpl implements BannerManageService {

   @Resource
    private BannerManageMapper bannerManageMapper;

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(BannerManageServiceImpl.class);
    /**
     * 根据bannerManageId删除banner
     *
     * @param bannerManageId
     * @return
     */
    @Override
    public Boolean deleteByPrimaryKey(Integer bannerManageId) {
        Boolean delete = false;
        log.info("bannerManageId is "+bannerManageId);
        int count = bannerManageMapper.deleteByPrimaryKey(bannerManageId);
        if (count != 0){
            delete = true;
            log.info("id为"+ bannerManageId +"的banner删除"+delete);
        }else {
            log.info("id为"+ bannerManageId +"的banner删除"+delete);
        }
        return delete;
    }

    /**
     * 新增banner
     *
     * @param bannerManage
     * @return
     */
    @Override
    public int insert(BannerManage bannerManage) {
        bannerManage.setCreatedAt(DateTime.getTime());
        return this.bannerManageMapper.insert(bannerManage);
    }

    @Override
    public Boolean updateBannerStateByPrimaryKey(BannerManage bannerManage) {
        bannerManage.setUpdatedAt(DateTime.getTime());
        Boolean update = false;

        int count = bannerManageMapper.updateByPrimaryKeySelective(bannerManage);
        if (count != 0){
            update = true;
            log.info("id为"+ bannerManage.getBannerId()
                    +"的banner状态更新为"+bannerManage.getBannerState());
        }else {
            update = false;
            log.info("id为"+ bannerManage.getBannerId()
                    +"的banner状态更新为"+bannerManage.getBannerState());
        }
        return update;
    }

    @Override
    public Boolean updateUrlByPrimaryKey(BannerManage bannerManage) {
        bannerManage.setUpdatedAt(DateTime.getTime());
        Boolean update = false;

        int count = bannerManageMapper.updateByPrimaryKeySelective(bannerManage);
        if (count != 0){
            update = true;
            log.info("id为 "+ bannerManage.getBannerId()
                    +" 的bannerurl更新为 "+bannerManage.getUrl());
        }else {
            log.info("id为 "+ bannerManage.getBannerId()
                    +" 的banner状态更新为 "+bannerManage.getUrl());
        }
        return update;
    }

    @Override
    public List<BannerManage> selectByCompileAndState(BannerManage bannerManage) {
        return this.bannerManageMapper.selectByCompileAndState(bannerManage);
    }
}
