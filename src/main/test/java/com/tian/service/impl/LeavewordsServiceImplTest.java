package com.tian.service.impl;

import com.tian.dao.LeavewordsMapper;
import com.tian.model.Leavewords;
import com.tian.service.LeavewordsService;
import com.util.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)//为了让测试在Spring容器环境下执行
@ContextConfiguration({"classpath:spring-mybatis.xml"})// 加载spring配置文件
public class LeavewordsServiceImplTest {


    @Resource
    private LeavewordsService leavewordsService;

    @Resource
    private LeavewordsMapper leavewordsMapper;

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(LeavewordsServiceImplTest.class);


    /**
     * 根据id删除留言
     */
    @Test
    public void testDeleteByPrimaryKey(){
        Integer leavewordsId = 1;
        log.info(""+leavewordsId);
        leavewordsService.deleteByPrimaryKey(leavewordsId);
    }

    /**
     * 查询全部留言
     */
    @Test
    public void testSelect(){
        leavewordsService.select();
    }

    /**
     * 条件查询
     */
    @Test
    public void testSselectBylProductionNameAndleavewordsState(){
        Leavewords leavewords = new Leavewords();
        leavewords.setlProductionName("");
        leavewords.setLeavewordsState(null);
        log.info(""+leavewords);
        List<Leavewords> leavewordsList=leavewordsService.selectBylProductionNameAndleavewordsState(leavewords);

        log.info(""+leavewordsList);

    }
    /**
     * 根据id更新留言状态
     */
    @Test
    public void testUpdateLeavewordsStateByleavewordsId(){
        Leavewords leavewords = new Leavewords();
        leavewords.setLeavewordsState(1);
        leavewords.setLeavewordsId(5);
        leavewordsService.updateLeavewordsStateByleavewordsId(leavewords);
    }

    /**
     * 根据id修改留言回复和留言状态
     */
    @Test
    public void testUpdateReplyAndLeavewordsStateByleavewordsId(){
        Leavewords leavewords = new Leavewords();
        leavewords.setReply("真听");
        log.info(""+leavewords.getReply());
        leavewords.setLeavewordsId(1);

        leavewordsService.updateReplyAndLeavewordsStateByleavewordsId(leavewords);
    }

    @Test
    public void testInsertLeavewords(){
        Leavewords leavewords = new Leavewords();
        leavewords.setLeavewords("好看");
        leavewords.setlPronductionId(3);

        log.info(""+leavewords);
        leavewordsMapper.insertLeavewords(leavewords);
    }
}