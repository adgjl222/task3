package com.tian.service.impl;

import com.tian.dao.LeavewordsMapper;
import com.tian.model.Leavewords;

import com.tian.service.LeavewordsService;
import com.util.DateTime;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class LeavewordsServiceImpl implements LeavewordsService {



    private static final org.slf4j.Logger log = LoggerFactory.getLogger(LeavewordsServiceImpl.class);

    @Autowired
    private LeavewordsMapper leavewordsMapper;

    Leavewords leavewords = new Leavewords();

    /**
     * 根据留言id删除留言
     *
     * @param leavewordsId
     * @return
     */
    @Override
    public Boolean deleteByPrimaryKey(Integer leavewordsId) {
        Boolean delete = false;
        log.info("leavewordsId is "+leavewordsId);
        int count = leavewordsMapper.deleteByPrimaryKey(leavewordsId);
        if (count != 0){
            delete = true;
            log.info("留言删除"+delete);
        }else {
            log.info("留言删除"+delete);
        }
        return delete;

    }

    /**
     * 根据作品标题和留言状态查询留言

     * @param
     * @return
     */
    @Override
    public List<Leavewords> selectBylProductionNameAndleavewordsState(Leavewords leavewords) {
        return this.leavewordsMapper.selectBylProductionNameAndleavewordsState(leavewords);
    }

    @Override
    public List <Leavewords> select() {
        List <Leavewords> leavewordsList = leavewordsMapper.select();
        log.info(""+leavewordsList);
        return this.leavewordsMapper.select();
    }

    /**
     * 编辑 根据留言id修改留言状态
     *
     * @param leavewords
     * @return
     */
    @Override
    public Boolean updateLeavewordsStateByleavewordsId(Leavewords leavewords) {
        leavewords.setUpdatedAt(DateTime.getTime());
        Boolean update = false;
        log.info("leavewordsId is "+leavewords.getLeavewordsId());
        int count = leavewordsMapper.updateLeavewordsStateByleavewordsId(leavewords);
        if (count != 0){
            update = true;
            log.info("留言状态更新"+update);
        }else {
            log.info("留言状态更新"+update);
        }
        return update;
    }



    /**
     * 根据留言id添加留言回复 同时修改留言状态
     * 留言有回复即此条留言状态为精选留言
     *
     * @param leavewords
     * @return
     */
    @Override
    public Boolean updateReplyAndLeavewordsStateByleavewordsId(Leavewords leavewords) {
        leavewords.setUpdatedAt(DateTime.getTime());
        Boolean update = false;
        log.info("leavewordsId is "+ leavewords.getLeavewordsId());
        int count = 0;

        count = leavewordsMapper.updateReplyByleavewordsId(leavewords);
        log.info("reply is "+ leavewords.getReply());
        if (count == 1){
            leavewords.setLeavewordsState(1);
            count = leavewordsMapper.updateLeavewordsStateByleavewordsId(leavewords);
        }else {
            log.info("无留言可回复");
        }

        if (count != 0){
            update = true;
            log.info("更新"+update);
        }else {
            log.info("更新"+update);
        }
        return update;
    }

    @Override
    public int insertLeavewords(Leavewords leavewords) {
        leavewords.setCreatedAt(DateTime.getTime());
        return this.leavewordsMapper.insertLeavewords(leavewords);
    }


}
