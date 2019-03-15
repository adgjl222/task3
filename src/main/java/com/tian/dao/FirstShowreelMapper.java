package com.tian.dao;

import com.tian.model.FirstShowreel;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FirstShowreelMapper {


    /**
     * 根据id删除一级作品集
     * @param firstShowreelId
     * @return
     */
    int deleteByPrimaryKey(Integer firstShowreelId);

    /**
     * 新增一级作品集
     * @param
     * @return
     */
    int insertSelective(FirstShowreel firstShowreel);


    /**
     * 根据一级作品集作品标题和状态查询作品集信息
     * @param
     * @return
     */
    List<FirstShowreel> selectByNameAndState(FirstShowreel firstShowreel);

    FirstShowreel selectByPrimaryKey(Integer firstShowreelId);

    FirstShowreel selectByName(String firstShowreelName);

    /**
     * 更新一级作品集
     * @param firstShowreel
     * @return
     */
    int updateByPrimaryKey(FirstShowreel firstShowreel);

    int selectCount();




}