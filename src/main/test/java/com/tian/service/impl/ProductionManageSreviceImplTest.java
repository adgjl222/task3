package com.tian.service.impl;


import com.tian.model.ProductionManage;
import com.tian.service.ProductionManageSrevice;
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
public class ProductionManageSreviceImplTest {


    @Resource//@Resource（这个注解属于J2EE的），默认安照名称进行装配
    private ProductionManageSrevice productionManageSrevice;


    private static final org.slf4j.Logger log = LoggerFactory.getLogger(ProductionManageSreviceImpl.class);



    ProductionManage productionManage = new ProductionManage();

    /**
     * 根据id添加留言内容
     */
    @Test
    public void testupdateLeaveWordsByPrimaryKey(){
        Integer productionId = 4;
        String productionLeavewords = "好好看";
        Long updatedAt  = DateTime.getTime();
        productionManageSrevice.updateLeaveWordsByPrimaryKey(productionId,productionLeavewords,updatedAt);
    }


    /**
     * 新增作品
     */
    @Test
    public void testInsert(){
        ProductionManage productionManage = new ProductionManage();
        productionManage.setProductionName("被驯服的象");
        productionManage.setIntro("歌曲");
        productionManage.setThumbnail("http");
        productionManage.setVideoUrl("url");
        productionManage.setParticulars("hhhttp");
        productionManage.setIntroduce("一首好听的歌曲");

        productionManageSrevice.insert(productionManage);
        log.info("作品id为"+ productionManage.getProductionId() + "的作品新增成功");
    }


    /**
     * 根据id删除
     */
    @Test
    public void testDeleteByPrimaryKey(){
        Integer productionId = 1;
        productionManageSrevice.deleteByPrimaryKey(productionId);
    }

    /**
     * 根据id更新状态
     */
    @Test
    public void testUpdateProductionStateByPrimaryKey(){
        Integer productionId = 3;
        Integer productionState = 0;
        Long updatedAt  = DateTime.getTime();
        productionManageSrevice.updateProductionStateByPrimaryKey(productionId,productionState,updatedAt);
    }

    /**
     * 根据作品标题和状态查询
     */
    @Test
    public void testsSlectByproductionNameAndproductionState(){
        String productionName = "被";
        Integer productionState = 0;
        List<ProductionManage> productionManageList =
                productionManageSrevice.selectByproductionNameAndproductionState(productionName,productionState);
        log.info(""+productionManageList);
    }

    /**
     * 根据id修改作品标题
     */
    @Test
    public void testUpdateProductionNameByPrimaryKey(){
        Integer productionId = 1;
        String productionName = "十万毫升泪水";
        Long updatedAt  = DateTime.getTime();
        productionManageSrevice.updateProductionNameByPrimaryKey(productionId,productionName,updatedAt);
    }

}