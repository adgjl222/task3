package com.tian.dao;

import com.tian.model.ProductionManage;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductionManageMapper {


    /**
     * 根据作品id删除作品
     * @param productionId
     * @return
     */
    int deleteByPrimaryKey(Integer productionId);

    /**
     * 新增作品
     * @param productionManage
     * @return
     */
    Integer insert(ProductionManage productionManage);

    /**
     * 根据作品标题和作品状态查询作品
     * @param productionName
     * @param productionState
     * @return
     */
    List<ProductionManage> selectByproductionNameAndproductionState(@Param(value="productionName") String productionName,
                                                                    @Param(value="productionState") Integer productionState);


    /**
     * 根据作品ID修改作品标题
     * @param productionId
     * @param productionName
     * @return
     */
    int updateProductionNameByPrimaryKey(@Param(value="productionId") Integer productionId,
                                             @Param(value="productionName")String productionName,
                                         @Param(value="updatedAt")Long updatedAt
    );

    /**
     * 根据id修改作品状态 上架/下架
     * @param productionId
     * @param productionState
     * @return
     */
    int updateProductionStateByPrimaryKey(@Param(value="productionId")Integer productionId,
                                              @Param(value="productionState")Integer productionState,
                                          @Param(value="updatedAt")Long updatedAt

                                          );


    /**
     * 根据作品id修改作品留言
     * @param productionId
     * @param productionLeavewords
     * @return
     */
    int updateLeaveWordsByPrimaryKey(@Param(value="productionId")Integer productionId,
                                         @Param(value="productionLeavewords")String productionLeavewords,
                                      @Param(value="updatedAt")Long updatedAt
    );

    String selectProductionNameByPrimaryKey(Integer productionId);


}