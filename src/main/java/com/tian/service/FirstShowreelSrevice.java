package com.tian.service;


import com.tian.dao.FirstShowreelMapper;
import com.tian.model.FirstShowreel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FirstShowreelSrevice {
    /**
     * 根据id删除一级作品集
     * @param firstShowreelId
     * @return
     */
    Boolean deleteByPrimaryKey(Integer firstShowreelId);

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

    Boolean updateStateByPrimaryKey(FirstShowreel firstShowreel);
    Boolean updateNameByPrimaryKey(FirstShowreel firstShowreel);
    int updateSecondByPrimaryKey(FirstShowreel firstShowreel);


}
