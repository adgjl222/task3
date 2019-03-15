package com.tian.controller;

import com.tian.model.StudioManage;
import com.tian.service.SecondShowreelService;
import com.tian.service.StudioManageSrevice;
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
@RequestMapping("/studio")
public class StudioManageController {
    @Resource
    private StudioManageSrevice studioManageSrevice;

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(StudioManageController.class);

    /**
     * 条件查询
     * @param studioManage
     * @return
     */
    @RequestMapping(value = {"/"},
            method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> selectByStudioManageTypeAndStudioManageState(StudioManage studioManage) {
        Map<String,Object> map = new HashMap<String, Object>();
    log.info(" studio type(name) is "+ studioManage.getStudioType()+" state is "+ studioManage.getStudioState());
    List<StudioManage> studioManages = studioManageSrevice.selectByStudioManageTypeAndStudioManageState(studioManage);
        if (studioManages != null){
            map.put("code",200);
        }else {
            map.put("code",400);
        }
        map.put("message","条件查询结果");
        map.put("studioManages",studioManages);
        return map;
    }

    /**
     * 新增工作室简介
     * @param studioManage
     * @return
     */
    @RequestMapping(value = {"/"},
            method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> insertSelective(StudioManage studioManage) {
        Map<String,Object> map = new HashMap<String, Object>();
        log.info(studioManage.toString());
        int insert = studioManageSrevice.insertSelective(studioManage);
        if (insert != 0){
            map.put("code",200);
        }else {
            map.put("code",400);
        }
        map.put("message","新增条数");
        map.put("insert",insert);
        return map;
    }

    /**
     * 上/下架工作室
     * @param studioManage
     * @return
     */
    @RequestMapping(value = {"/state"},
            method = RequestMethod.PUT)
    @ResponseBody
    public Map<String,Object> updateStateByPrimaryKey(StudioManage studioManage) {
        Map<String,Object> map = new HashMap<String, Object>();
        log.info(" studioid is "+ studioManage.getStudioId()+" state is "+ studioManage.getStudioState());
        Boolean update  = studioManageSrevice.updateStateByPrimaryKey(studioManage);
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
     * 编辑工作室
     * @param studioManage
     * @return
     */
    @RequestMapping(value = {"/name"},
            method = RequestMethod.PUT)
    @ResponseBody
    public Map<String,Object> updateNameByPrimaryKey(StudioManage studioManage) {
        Map<String,Object> map = new HashMap<String, Object>();
        log.info(" studioManageId is "+ studioManage.getStudioId()+" name is "+ studioManage.getStudioType());
        Boolean update = studioManageSrevice.updateNameByPrimaryKey(studioManage);
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
     * 删除工作室
     * @param studioManageId
     * @return
     */
    @RequestMapping(value = {"/"},
            method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String,Object> deleteByPrimaryKey(Integer studioManageId) {
        Map<String,Object> map = new HashMap<String, Object>();
        log.info(" studioManageId is " + studioManageId);
        Boolean delete  = studioManageSrevice.deleteByPrimaryKey(studioManageId);
        if (delete == true){
            map.put("code",200);
        }else {
            map.put("code",400);
        }
        map.put("message","操作结果");
        map.put("update",delete);
        return map;
    }


}
