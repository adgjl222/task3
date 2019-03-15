package com.tian.service.impl;

import com.tian.dao.LeavewordsMapper;
import com.tian.dao.ProductionManageMapper;
import com.tian.model.Leavewords;
import com.tian.model.ProductionManage;
import com.tian.service.LeavewordsService;
import com.tian.service.ProductionManageSrevice;
import com.util.DateTime;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productionManageSrevice")
public class ProductionManageSreviceImpl implements ProductionManageSrevice {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(ProductionManageSreviceImpl.class);

    @Autowired
    /**
     * @Autowired注解：在启动springIoC时，容器自动装载了一个AutowiredAnnotationBeanPostProcessor后置处理器，
     * 当容器扫描到@Autowied、@Resource或@Inject时，就会在IoC容器自动查找需要的bean，并装配给该对象的属性
     * @Autowired 注释，它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。 通过 @Autowired的使用来消除 set ，get方法。
     */
    private ProductionManageMapper productionManageMapper;


    @Autowired//@Autowired默认按类型装配（这个注解是属业spring的）
    private LeavewordsService leavewordsService;

    ProductionManage productionManage = new ProductionManage();

    /**
     * 根据作品id删除作品
     *
     * @param productionId
     * @return
     */
    @Override
    public Boolean deleteByPrimaryKey(Integer productionId) {
        Boolean delete = false;
        log.info("productionId is "+productionId);
        int count = productionManageMapper.deleteByPrimaryKey(productionId);
        if (count != 0){
            delete = true;
            log.info("作品删除"+delete);
        }else {
            log.info("作品删除"+delete);
        }
        return delete;
    }

    /**
     * 新增作品
     * @param productionManage
     * @return
     */
    @Override
    public int insert(ProductionManage productionManage) {
        productionManage.setCreatedAt(DateTime.getTime());
        return this.productionManageMapper.insert(productionManage);
    }

    /**
     * 根据作品标题和作品状态查询作品
     *
     * @param productionName
     * @param productionState
     * @return
     */
    @Override
    public List<ProductionManage> selectByproductionNameAndproductionState(String productionName, Integer productionState) {
        log.info(""+productionName);
        return this.productionManageMapper.selectByproductionNameAndproductionState(productionName,productionState);
    }

    /**
     * 根据作品ID修改作品标题
     * @param productionId
     * @param productionName
     * @return
     */
    @Override
    public Boolean updateProductionNameByPrimaryKey(Integer productionId,String productionName,Long updatedAt) {
        Boolean update = false;
        log.info("productionId is "+productionId);
        int count = productionManageMapper.updateProductionNameByPrimaryKey(productionId,productionName,updatedAt);
        if (count != 0){
            update = true;
            log.info("作品标题修改"+update);
        }else {
            log.info("作品标题修改"+update);
        }
        return update;
    }

    /**
     * 根据id修改作品状态 上架/下架
     * @param productionId
     * @param productionState
     * @return
     */
    @Override
    public Boolean updateProductionStateByPrimaryKey(Integer productionId,Integer productionState,Long updatedAt) {
        Boolean update = false;
        log.info("productionId is "+productionId);


        int count = productionManageMapper.updateProductionStateByPrimaryKey(productionId,productionState,updatedAt);
        if (count != 0){
            update = true;
            log.info("更新作品状态为"+productionState);
        }else {
            log.info("更新作品状态为"+productionState);
        }
        return update;
    }

    /**
     * 根据作品id向作品添加留言
     *
     * @param productionId
     * @param productionLeavewords
     * @return
     */
    @Override
    public Boolean updateLeaveWordsByPrimaryKey(Integer productionId, String productionLeavewords,Long updatedAt) {
        Boolean update = false;
        log.info("productionId is "+productionId);
        int count = productionManageMapper.updateLeaveWordsByPrimaryKey(productionId,productionLeavewords,updatedAt);
        if (count != 0){
            update = true;
            log.info("作品留言"+update);
            Leavewords leavewords = new Leavewords();
            ProductionManage productionManage = new ProductionManage();
            log.info(""+productionId+productionLeavewords);
            leavewords.setlPronductionId(1);
            leavewords.setLeavewords("好");
            leavewords.setCreatedAt(DateTime.getTime());
            leavewords.setlProductionName(productionManageMapper.selectProductionNameByPrimaryKey(productionId));
            leavewords.setVisitorNickname("菜菜");
            int a = leavewordsService.insertLeavewords(leavewords);
            log.info("作品id为"+productionId+"的作品《"+productionManageMapper.selectProductionNameByPrimaryKey(productionId)+
                    "》成功添加留言ID为 "+ leavewords.getLeavewordsId()+" 的留言 "+ productionLeavewords);
        }else {
            log.info("作品留言"+update);
        }
        return update;
    }

    @Override
    public String selectProductionNameByPrimaryKey(Integer productionId) {
        return this.productionManageMapper.selectProductionNameByPrimaryKey(productionId);
    }
}
