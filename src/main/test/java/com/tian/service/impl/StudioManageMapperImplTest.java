package com.tian.service.impl;

import com.tian.model.StudioManage;

import com.tian.service.StudioManageSrevice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)//为了让测试在Spring容器环境下执行
@ContextConfiguration({"classpath:spring-mybatis.xml"})// 加载spring配置文件
public class StudioManageMapperImplTest {

    @Resource
    private StudioManageSrevice studioManageSrevice;

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(StudioManageMapperImplTest.class);

    @Test
    public  void testInsert() throws Exception{
        StudioManage studioManage = new StudioManage();
        studioManage.setStudioType("艺术家简介");
        studioManage.setStudioState(0);
        studioManage.setStudioPictures("http://tupian");
        studioManage.setStudioBody("晓宇，海胆 🍓");

        studioManage.setCompileBy("黄觉🥂");
        studioManageSrevice.insertSelective(studioManage);
        log.info(" id为 "+ studioManage.getStudioId() +" 的工作室插入成功 ");
    }


    @Test
    public void selectByStudioManageTypeAndStudioManageState(){
        StudioManage studioManage = new StudioManage();
        studioManage.setStudioType("艺术");
        studioManage.setStudioState(0);
        log.info(" Type is "+ studioManage.getStudioType() + " and State is "+ studioManage.getStudioState());
        List<StudioManage> list = studioManageSrevice.selectByStudioManageTypeAndStudioManageState(studioManage);
        log.info(""+list);
    }

    @Test
    public void testUpdateStateByPrimaryKey(){
        StudioManage studioManage = new StudioManage();
        studioManage.setStudioId(1);
        studioManage.setStudioState(1);
        studioManageSrevice.updateStateByPrimaryKey(studioManage);
    }


    @Test
    public void testUpdateNameByPrimaryKey(){
        StudioManage studioManage = new StudioManage();
        studioManage.setStudioId(2);
        studioManage.setStudioType("人员简介");
        studioManage.setStudioState(1);
        studioManageSrevice.updateNameByPrimaryKey(studioManage);
    }

    @Test
    public void testDeleteByPrimaryKey(){
        Integer studioId = 2;
        studioManageSrevice.deleteByPrimaryKey(studioId);
    }
}
