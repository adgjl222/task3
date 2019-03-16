package com.tian.service.impl;

import com.tian.model.BannerManage;
import com.tian.service.BannerManageService;
import com.util.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)//为了让测试在Spring容器环境下执行
@ContextConfiguration({"classpath:spring-mybatis.xml"})// 加载spring配置文件
public class BannerManageServiceImplTest {

    @Resource
    private BannerManageService bannerManageService;

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(BannerManageServiceImplTest.class);


    @Test
    public void testInsert() throws Exception{
        BannerManage bannerManage = new BannerManage();
        bannerManage.setUrl("http://url");
        bannerManage.setBannerConver("http");
        bannerManage.setBannerState(0);

        bannerManage.setCompileBy("西🍑");
        log.info(""+bannerManage);
        bannerManageService.insert(bannerManage);
        log.info("id为 "+bannerManage.getBannerId() +" 的封面图新增成功");

    }

    @Test
    public void testSelectByCompileAndState(){
        BannerManage bannerManage = new BannerManage();
        bannerManage.setCompileBy("西");
        bannerManage.setBannerState(null);
        log.info("Compile by" + bannerManage.getCompileBy()+ " and State is " +bannerManage.getBannerState());
        List<BannerManage> list = bannerManageService.selectByCompileAndState(bannerManage);
        log.info(""+list);
    }

    @Test
    public void testUpdateBannerUrlByPrimaryKey() throws Exception{
        BannerManage bannerManage = new BannerManage();
        bannerManage.setBannerId(1);
        bannerManage.setUrl("http:xiuga");

        log.info("BannerId is" + bannerManage.getBannerId()+ " and BannerUrl is " + bannerManage.getUrl());
        bannerManageService.updateUrlByPrimaryKey(bannerManage);
    }

    @Test
    public void testUpdateBannerStateByPrimaryKey() throws Exception{
        BannerManage bannerManage = new BannerManage();
        bannerManage.setBannerId(1);
        bannerManage.setBannerState(1);

        log.info("BannerId is" + bannerManage.getBannerId()+ "State is " +bannerManage.getBannerState());
        bannerManageService.updateBannerStateByPrimaryKey(bannerManage);
    }


    @Test
    public void testDeleteByPrimaryKey(){
        Integer bannerManageId = 1;
        log.info(""+bannerManageId);
        bannerManageService.deleteByPrimaryKey(bannerManageId);

    }

}
