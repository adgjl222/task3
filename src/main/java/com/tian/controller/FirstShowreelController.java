package com.tian.controller;

import com.tian.model.FirstShowreel;
import com.tian.service.FirstShowreelSrevice;
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
@RequestMapping("/firstShowreel")
public class FirstShowreelController {

    @Resource
    private FirstShowreelSrevice firstShowreelSrevice;

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(FirstShowreelController.class);

    /**
     * 条件查询
     * @param firstShowreel
     * @return
     */
    @RequestMapping(value = {"/"},
    method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> selectByNameAndState(FirstShowreel firstShowreel){
        Map <String,Object> map = new HashMap<String, Object>();
        log.info(" name is "+ firstShowreel.getFirstShowreelName() + " and state is "+ firstShowreel.getFirstShowreelState());
        List<FirstShowreel> firstShowreelList = firstShowreelSrevice.selectByNameAndState(firstShowreel);
        if (firstShowreelList != null){
            map.put("code",200);
        }else {
            map.put("code",400);
        }
        map.put("message","条件查询结果");
        map.put("firstShowreelList",firstShowreelList);
        return map;
    }

    /**
     * 新增一级列表
     * @param firstShowreel
     * @return
     */
    @RequestMapping(value = {"/"},
            method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object>  insertFirstShowreel(FirstShowreel firstShowreel){
        Map <String,Object> map = new HashMap<String, Object>();
        log.info(firstShowreel.toString());
        int insert  = firstShowreelSrevice.insertSelective(firstShowreel);
        if (insert != 0){
            map.put("code",200);
        }else {
            map.put("code",400);
        }
        map.put("message","插入条数");
        map.put("insert",insert);
        return map;
    }

    /**
     * 一级列表上/下架
     * @param firstShowreel
     * @return
     */
    @RequestMapping(value = {"/state"},
            method = RequestMethod.PUT)
    @ResponseBody
    public Map<String,Object> updateStateByPrimaryKey(FirstShowreel firstShowreel){
        Map <String,Object> map = new HashMap<String, Object>();
        log.info("firstShowreel id is "+firstShowreel.getFirstShowreelId() +" state is "+firstShowreel.getFirstShowreelState());
        Boolean update = firstShowreelSrevice.updateStateByPrimaryKey(firstShowreel);
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
     * 编辑一级列表名字
     * @param firstShowreel
     * @return
     */
    @RequestMapping(value = {"/name"},
            method = RequestMethod.PUT)
    @ResponseBody
    public Map<String,Object> updateNameByPrimaryKey(FirstShowreel firstShowreel){
        Map <String,Object> map = new HashMap<String, Object>();
        log.info("firstShowreel id is "+firstShowreel.getFirstShowreelId() +" name is "+firstShowreel.getFirstShowreelName());
        Boolean update = firstShowreelSrevice.updateNameByPrimaryKey(firstShowreel);
        if (update == true){
            map.put("code",200);
        }else {
            map.put("code",400);
        }
        map.put("message","操作结果");
        map.put("update",update);
        return map;
    }

    @RequestMapping(value = {"/"},
            method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String,Object> deleteByPrimaryKey(Integer firstShowreelId){
        Map <String,Object> map = new HashMap<String, Object>();
        log.info(" firstShowreelId is "+firstShowreelId);
        Boolean delete  = firstShowreelSrevice.deleteByPrimaryKey(firstShowreelId);
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
