package com.tian.controller;

import com.tian.model.SecondShowreel;
import com.tian.service.SecondShowreelService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
@RequestMapping("/secondShowreel")
public class SecondShowreelController {
    @Resource
    private SecondShowreelService secondShowreelService;

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(SecondShowreelController.class);

    /**
     * 条件查询
     * @param secondShowreel
     * @return
     */
    @RequestMapping(value = {"/"},
            method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> selectBySecondShowreelStateAndSecondShowreelName(SecondShowreel secondShowreel){
        Map<String,Object> map = new HashMap<String, Object>();
        log.info(" state is "+secondShowreel.getSecondShowreelState() +" name is "+ secondShowreel.getSecondShowreelName());
        List<SecondShowreel> secondShowreels = secondShowreelService.selectBySecondShowreelStateAndSecondShowreelName(secondShowreel);
        if (secondShowreels != null){
            map.put("code",200);
        }else {
            map.put("code",400);
        }
        map.put("message","条件查询结果");
        map.put("firstShowreelList",secondShowreels);
        return map;
    }

    /**
     * 新增
     * @param secondShowreel
     * @return
     */
    @RequestMapping(value = {"/"},
            method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> insert(SecondShowreel secondShowreel){
        Map<String,Object> map = new HashMap<String, Object>();
        log.info(secondShowreel.getSecondShowreelName()+secondShowreel.getSecondShowreelState());
        log.info(secondShowreel.toString());
        int insert  = secondShowreelService.insert(secondShowreel);
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
     * 上/下架二级作品集
     * @param secondShowreel
     * @return
     */
    @RequestMapping(value = {"/state"},
            method = RequestMethod.PUT)
    @ResponseBody
    public Map<String,Object> updateState(SecondShowreel secondShowreel){
        Map<String,Object> map = new HashMap<String, Object>();
        log.info("secondShowreelid is "+secondShowreel.getSecondShowreelId()+" state is "+ secondShowreel.getSecondShowreelState());
        Boolean update =  secondShowreelService.updateSecondShowreelStateByPrimaryKey(secondShowreel);
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
     * 编辑二级作品集标题
     * @param secondShowreel
     * @return
     */
    @RequestMapping(value = {"/name"},
            method = RequestMethod.PUT)
    @ResponseBody
    public Map<String,Object> updateName(SecondShowreel secondShowreel){
        Map<String,Object> map = new HashMap<String, Object>();
        log.info("secondShowreelid is "+secondShowreel.getSecondShowreelId()+" name is "+ secondShowreel.getSecondShowreelName());
        Boolean update = secondShowreelService.updateSecondShowreelNameByPrimaryKey(secondShowreel);
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
     * 删除二级作品集
     * @param secondShowreelId
     * @return
     */
    @RequestMapping(value = {"/"},
            method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String,Object> deleteById(Integer secondShowreelId){
        Map<String,Object> map = new HashMap<String, Object>();
        log.info("secondShowreelId is "+ secondShowreelId);
        Boolean delete = secondShowreelService.deleteByPrimaryKey(secondShowreelId);
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
