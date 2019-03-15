package com.tian.service.impl;


import com.tian.model.FirstShowreel;
import com.tian.service.FirstShowreelSrevice;
import com.util.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)//为了让测试在Spring容器环境下执行
@ContextConfiguration({"classpath:spring-mybatis.xml"})// 加载spring配置文件
public class FirstShowreelSreviceImplTest {

    @Resource
    private FirstShowreelSrevice firstShowreelSrevice;

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(BannerManageServiceImplTest.class);

    @Test
    public void testInsertSelective(){
        FirstShowreel firstShowreel = new FirstShowreel();
        firstShowreel.setFirstShowreelName("艺术学堂");
        firstShowreel.setFirstShowreelState(0);
        firstShowreel.setCompileBy("晓海");
        firstShowreelSrevice.insertSelective(firstShowreel);
        log.info(" id为 "+ firstShowreel.getFirstShowreelId() );
    }

    @Test
    public void testSelectByNameAndState(){
        FirstShowreel firstShowreel = new FirstShowreel();
        firstShowreel.setFirstShowreelName("艺");
        firstShowreel.setFirstShowreelState(null);
        java.util.List<FirstShowreel> firstShowreelList = firstShowreelSrevice.selectByNameAndState(firstShowreel);
        log.info(""+firstShowreelList);
    }

    @Test
    public void testUpdateStateByPrimaryKey(){
        FirstShowreel firstShowreel = new FirstShowreel();
        firstShowreel.setFirstShowreelId(3);
        firstShowreel.setFirstShowreelState(0);

        log.info(" FirstShowreelid is "+ firstShowreel.getFirstShowreelId() + " state is "+ firstShowreel.getFirstShowreelState());
        firstShowreelSrevice.updateStateByPrimaryKey(firstShowreel);
    }

    @Test
    public void testUpdateNameByPrimaryKey(){
        FirstShowreel firstShowreel = new FirstShowreel();
        firstShowreel.setFirstShowreelId(1);
        firstShowreel.setFirstShowreelName("艺术学堂");
        firstShowreelSrevice.updateNameByPrimaryKey(firstShowreel);
    }

    @Test
    public void testDeleteByPrimaryKey(){
        Integer firstShowreelId = 6;
        firstShowreelSrevice.deleteByPrimaryKey(firstShowreelId);
    }


}
