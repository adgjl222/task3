package com.tian.controller;


import com.tian.model.Leavewords;
import com.tian.service.LeavewordsService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/leavewords")
public class LeavewordsCtontroller {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(LeavewordsCtontroller.class);

    @Resource
    private LeavewordsService leavewordsService;

    /**
     * 条件查询
     * @param leavewords
     * @return
     */
    @RequestMapping(value = {"/"},
    method = {RequestMethod.GET}
    )
    @ResponseBody
    public Map<String,Object>  selectBylProductionNameAndleavewordsState(Leavewords leavewords){
        Map <String,Object> map = new HashMap <String, Object>();
        log.info(" ProductionName is "+ leavewords.getlProductionName()+ " leavewordsState is "+leavewords.getLeavewordsState());
       List<Leavewords> leavewordsList = leavewordsService.selectBylProductionNameAndleavewordsState(leavewords);
       if (leavewordsList != null){
           map.put("code",200);
       }else {
           map.put("code",400);
       }
       map.put("message","条件查询结果");
       map.put("leavewordsList",leavewordsList);
       return map;
    }


    /**
     * 上/下架
     * @param leavewords
     * @return
     */
    @RequestMapping( value = {"/state"},
            method = {RequestMethod.PUT}
    )
    @ResponseBody
    public  Map<String,Object> updateLeavewordsStateByleavewordsId(Leavewords leavewords){
        Map <String,Object> map = new HashMap <String, Object>();
        log.info("id is "+ leavewords.getLeavewordsId()+" state is "+ leavewords.getLeavewordsState());
        Boolean update= leavewordsService.updateLeavewordsStateByleavewordsId(leavewords);
        if (update == true){
            map.put("code",200);
        }else {
            map.put("code",400);
        }
        map.put("message","操作结果");
        map.put("update",update);
        return map;
    }

    /**
     * 回复留言
     * @param leavewords
     * @return
     */
    @RequestMapping( value = {"/reply"},
            method = {RequestMethod.PUT}
    )
    @ResponseBody
    public Map<String,Object> updateReplyAndLeavewordsStateByleavewordsId(Leavewords leavewords){
        Map <String,Object> map = new HashMap <String, Object>();
        log.info("id is "+ leavewords.getLeavewordsId()+" state is "+ leavewords.getLeavewordsState() + " reply is "+ leavewords.getReply());
        Boolean update= leavewordsService.updateLeavewordsStateByleavewordsId(leavewords);
        if (update == true){
            map.put("code",200);
        }else {
            map.put("code",400);
        }
        map.put("message","操作结果");
        map.put("update",update);
        return map;

    }

    /**
     * 删除
     * @param leavewordsId
     * @return
     */
    @RequestMapping( value = {"/"},
            method = {RequestMethod.DELETE}
    )
    @ResponseBody
    public Map<String,Object> deleteByPrimaryKey(Integer leavewordsId){
        Map <String,Object> map = new HashMap <String, Object>();
        log.info("id is "+ leavewordsId);
        Boolean delete = leavewordsService.deleteByPrimaryKey(leavewordsId);
        if (delete == true){
            map.put("code",200);
        }else {
            map.put("code",400);
        }
        map.put("message","操作结果");
        map.put("delete",delete);
        return map;

    }


    /**
     * 新增留言
     * @param leavewords
     * @return
     */
    @RequestMapping( value = {"/"},
            method = {RequestMethod.POST}
    )
    @ResponseBody
    public Map<String,Object> insertLeavewords(Leavewords leavewords){
        Map <String,Object> map = new HashMap <String, Object>();
        log.info(leavewords.toString());
        int insert  = leavewordsService.insertLeavewords(leavewords);
        if (insert != 0){
            map.put("code",200);
        }else {
            map.put("code",400);
        }
        map.put("message","新增条数");
        map.put("insert",insert);
        return map;
    }


}
