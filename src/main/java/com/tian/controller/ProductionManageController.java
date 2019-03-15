package com.tian.controller;

import com.tian.model.ProductionManage;
import com.tian.service.ProductionManageSrevice;
import com.util.DateTime;
import org.apache.ibatis.annotations.Param;
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
@RequestMapping("/production")
public class ProductionManageController {
    @Resource
    private ProductionManageSrevice productionManageSrevice;

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(ProductionManageController.class);

    /**
     * 条件查询
     * @param productionName
     * @param productionState
     * @return
     */
    @RequestMapping(value = {"/"},
            method = {RequestMethod.GET}
    )
    @ResponseBody
    public Map<String,Object> sleectByNameAndState(String productionName, Integer productionState){
        Map<String,Object> map = new HashMap<String, Object>();
        log.info(" state is "+productionState+" name is "+ productionName);
        List<ProductionManage> productionManages = productionManageSrevice.selectByproductionNameAndproductionState(productionName,productionState);
        if (productionManages != null){
            map.put("code",200);
        }else {
            map.put("code",400);
        }
        map.put("message","条件查询结果");
        map.put("productionManages",productionManages);
        return map;
    }

    /**
     * 新增作品
     * @param productionManage
     * @return
     */
    @RequestMapping(value = {"/"},
            method = {RequestMethod.POST}
    )
    @ResponseBody
    public Map<String,Object> insert(ProductionManage productionManage){
        Map<String,Object> map = new HashMap<String, Object>();
        log.info(productionManage.toString());
        int insert =  productionManageSrevice.insert(productionManage);
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
     * 编辑作品标题
     * @param productionId
     * @param productionName
     * @param updatedAt
     * @return
     */
    @RequestMapping(value = {"/name"},
            method = {RequestMethod.PUT}
    )
    @ResponseBody
    public Map<String,Object> updateName(Integer productionId,String productionName,Long updatedAt){
        Map<String,Object> map = new HashMap<String, Object>();
        updatedAt  = DateTime.getTime();
        log.info("productionId is "+ productionId+" productionName is "+productionName+" updatedAt is "+updatedAt);
        Boolean update = productionManageSrevice.updateProductionNameByPrimaryKey(productionId,productionName,updatedAt);
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
     * 上/下架作品
     * @param productionId
     * @param productionState
     * @param updatedAt
     * @return
     */
    @RequestMapping(value = {"/state"},
            method = {RequestMethod.PUT}
    )
    @ResponseBody
    public Map<String,Object> updateState(Integer productionId,Integer productionState,Long updatedAt){
        Map<String,Object> map = new HashMap<String, Object>();
        updatedAt  = DateTime.getTime();
        log.info("productionId is "+ productionId+" productionState is "+productionState+" updatedAt is "+updatedAt);
        Boolean update = productionManageSrevice.updateProductionStateByPrimaryKey(productionId,productionState,updatedAt);
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
     * 留言
     * @param productionId
     * @param productionLeavewords
     * @param updatedAt
     * @return
     */
    @RequestMapping(value = {"/leavewords"},
            method = {RequestMethod.PUT}
    )
    @ResponseBody
    public Map<String,Object> updateLeavewords(Integer productionId, String productionLeavewords,Long updatedAt){
        Map<String,Object> map = new HashMap<String, Object>();
        updatedAt  = DateTime.getTime();
        log.info("productionId is "+ productionId +" productionLeavewords is" +productionLeavewords + " updatedAt is "+updatedAt);
        Boolean update = productionManageSrevice.updateLeaveWordsByPrimaryKey(productionId,productionLeavewords,updatedAt);
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
     * 删除作品
     * @param productionId
     * @return
     */
    @RequestMapping(value = {"/"},
            method = {RequestMethod.DELETE}
    )
    @ResponseBody
    public Map<String,Object> deleteByPrimaryKey(Integer productionId){
        Map<String,Object> map = new HashMap<String, Object>();
        log.info("productionId is "+ productionId);
        Boolean delete = productionManageSrevice.deleteByPrimaryKey(productionId);
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
