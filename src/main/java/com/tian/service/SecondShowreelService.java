package com.tian.service;

import com.tian.model.SecondShowreel;

import java.util.List;

public interface SecondShowreelService {

        /**
         * 新增二级作品集分类列表
         */
        int  insert(SecondShowreel secondShowreel);


        /**
         * 根据二集作品集分类名称和状态查询二级作品集
         * @param
         * @return
         */
        List<SecondShowreel> selectBySecondShowreelStateAndSecondShowreelName(SecondShowreel secondShowreel);


        /**
         * 上架/下架 根据二级作品集分类id修改二级作品集状态
         * @param secondShowreel
         * @return
         */
        Boolean updateSecondShowreelStateByPrimaryKey(SecondShowreel secondShowreel);

        /**
         * 编辑 根据二级作品集分类id修改二级作品集名称
         * @param secondShowreel
         * @return
         */
        Boolean updateSecondShowreelNameByPrimaryKey(SecondShowreel secondShowreel);

    /**
     * 根据二集作品集分类名称和状态删除二级作品集
     * @param secondShowreelId
     * @return
     */
        Boolean deleteByPrimaryKey(Integer secondShowreelId);

}
