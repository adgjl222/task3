package com.tian.controller;

import com.tian.model.BannerManage;
import com.tian.service.BannerManageService;
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
@RequestMapping("/banner")
public class BannerManageController {

    @Resource
    private BannerManageService bannerManageService;

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(BannerManageController.class);

    @RequestMapping(value = {"/"},
            method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> selectByCompileAndState(BannerManage bannerManage){
        Map<String,Object> map = new HashMap<String, Object>();
        log.info(" complile by  "+ bannerManage.getCompileBy()+" state is "+ bannerManage.getBannerState() );
        List<BannerManage> bannerManages = bannerManageService.selectByCompileAndState(bannerManage);
        if (bannerManages != null){
            map.put("code",200);
        }else {
            map.put("code",400);
        }
        map.put("message","条件查询结果");
        map.put("bannerManages",bannerManages);
        return map;

    }

    @RequestMapping(value = {"/"},
            method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> insert(BannerManage bannerManage) {
        Map<String,Object> map = new HashMap<String, Object>();
        log.info(bannerManage.toString());
        int insert  = bannerManageService.insert(bannerManage);
        if (insert != 0){
            map.put("code",200);
        }else {
            map.put("code",400);
        }
        map.put("message","插入条数");
        map.put("insert",insert);
        return map;
    }

    @RequestMapping(value = {"/state"},
            method = RequestMethod.PUT)
    @ResponseBody
    public Map<String,Object> updateBannerStateByPrimaryKey(BannerManage bannerManage) {
        Map<String,Object> map = new HashMap<String, Object>();
        log.info(" bannerid is  "+ bannerManage.getBannerId()+" state is "+ bannerManage.getBannerState() + "update at "+ bannerManage.getUpdatedAt());
        Boolean update = bannerManageService.updateBannerStateByPrimaryKey(bannerManage);
        if (update == true){
            map.put("code",200);
        }else {
            map.put("code",400);
        }
        map.put("message","操作结果");
        map.put("update",update);
        return map;
    }
    @RequestMapping(value = {"/url"},
            method = RequestMethod.PUT)
    @ResponseBody
    public Map<String,Object> updateUrlByPrimaryKey(BannerManage bannerManage) {
        Map<String,Object> map = new HashMap<String, Object>();
        log.info(" bannerid is  "+ bannerManage.getBannerId()+" url is "+ bannerManage.getUrl());
        Boolean update  = bannerManageService.updateUrlByPrimaryKey(bannerManage);
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
    public Map<String,Object> deleteByPrimaryKey(Integer bannerManageId) {
        Map<String,Object> map = new HashMap<String, Object>();
        log.info(" bannerid is "+ bannerManageId);
        Boolean delete = bannerManageService.deleteByPrimaryKey(bannerManageId);
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
