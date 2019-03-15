package com.tian.service.impl;

import com.tian.dao.FirstShowreelMapper;
import com.tian.model.SecondShowreel;
import com.tian.service.SecondShowreelService;
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
public class SecondShowreelServiceImplTest {

    @Resource
    private SecondShowreelService secondShowreelService;



    private static final org.slf4j.Logger log = LoggerFactory.getLogger(SecondShowreelServiceImplTest.class);

    @Test
    public void testInsert(){
        SecondShowreel secondShowreel = new SecondShowreel();
        secondShowreel.setSecondShowreelName("音乐");
        secondShowreel.setFirstShowreelName("艺术学堂");
        secondShowreel.setCompileBy("王❤️");
        log.info("*************"+secondShowreel);
        secondShowreelService.insert(secondShowreel);
        log.info("id为 "+secondShowreel.getSecondShowreelId()+" 的二级作品集分类新增成功");
    }


    @Test
    public void testSelectBySecondShowreelStateAndSecondShowreelName(){
        SecondShowreel secondShowreel = new SecondShowreel();
        secondShowreel.setSecondShowreelName("");
        secondShowreel.setSecondShowreelState(0);
        log.info(""+secondShowreel);
        List<SecondShowreel> list =
                secondShowreelService.selectBySecondShowreelStateAndSecondShowreelName(secondShowreel);
        log.info(""+list);
    }

    @Test
    public void testUpdateSecondShowreelStateByPrimaryKey(){
        SecondShowreel secondShowreel = new SecondShowreel();
        secondShowreel.setSecondShowreelId(3);
        secondShowreel.setSecondShowreelState(1);

        log.info("setSecondShowreelId is "+ secondShowreel.getSecondShowreelId()+
        "setSecondShowreelState is " + secondShowreel.getSecondShowreelState());
        secondShowreelService.updateSecondShowreelStateByPrimaryKey(secondShowreel);

    }

    @Test
    public void testUpdateSecondShowreelNameByPrimaryKey(){
        SecondShowreel secondShowreel = new SecondShowreel();
        secondShowreel.setSecondShowreelId(2);
        secondShowreel.setSecondShowreelName("文学");
        log.info(""+secondShowreel.getSecondShowreelId()+secondShowreel.getSecondShowreelName());
        secondShowreelService.updateSecondShowreelNameByPrimaryKey(secondShowreel);
    }

    @Test
    public void testdeleteByPrimaryKey(){
        Integer secondShowreelId = 1;
        secondShowreelService.deleteByPrimaryKey(secondShowreelId);

    }
}
