package com.tian.dao;

import com.tian.model.SecondShowreel;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondShowreelMapper {


    /**
     * 根据二级作品集id删除二级作品集
     * @param secondShowreelId
     * @return
     */
    int deleteByPrimaryKey(Integer secondShowreelId);

    /**
     * 新增二级作品集分类列表
     */
    int insert(SecondShowreel secondShowreel);


    /**
     * 根据二集作品集分类名称和状态查询二级作品集
     * @param
     * @return
     */
    List<SecondShowreel> selectBySecondShowreelStateAndSecondShowreelName(SecondShowreel secondShowreel);




    int updateByPrimaryKeySelective(SecondShowreel secondShowreel);





}