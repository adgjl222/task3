package com.tian.service.impl;

import com.tian.dao.FirstShowreelMapper;
import com.tian.dao.SecondShowreelMapper;
import com.tian.model.FirstShowreel;
import com.tian.model.SecondShowreel;
import com.tian.service.SecondShowreelService;
import com.util.DateTime;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SecondShowreelServiceImpl implements SecondShowreelService {

    @Resource
    private SecondShowreelMapper secondShowreelMapper;

    @Resource
    private FirstShowreelMapper firstShowreelMapper;


    private static final org.slf4j.Logger log = LoggerFactory.getLogger(SecondShowreelServiceImpl.class);



    /**
     * 新增二级作品集分类列表
     *
     * @param secondShowreel
     */
    @Override
    public int insert(SecondShowreel secondShowreel) {
        secondShowreel.setSecondShowreelState(0);
        secondShowreel.setCreatedAt(DateTime.getTime());
            FirstShowreel firstShowreel = new FirstShowreel();
            firstShowreel.setFirstShowreelId(7);
            firstShowreel.setSecondShowreelName(secondShowreel.getSecondShowreelName());
            firstShowreel.setUpdatedAt(DateTime.getTime());
            firstShowreelMapper.updateByPrimaryKey(firstShowreel);
            log.info(" id为 "+ firstShowreel.getFirstShowreelId() +" 的一级作品集");
            return this.secondShowreelMapper.insert(secondShowreel);

    }

        /**
         * 根据二集作品集分类名称和状态查询二级作品集
         * @param secondShowreel
         * @return
         */
        @Override
        public List <SecondShowreel> selectBySecondShowreelStateAndSecondShowreelName (SecondShowreel
        secondShowreel){
            return this.secondShowreelMapper.selectBySecondShowreelStateAndSecondShowreelName(secondShowreel);
        }

        /**
         * 上架/下架 根据二级作品集分类id修改二级作品集状态
         *
         * @param secondShowreel
         * @return
         */
        @Override public Boolean updateSecondShowreelStateByPrimaryKey (SecondShowreel secondShowreel){
            Boolean update = false;
            secondShowreel.setUpdatedAt(DateTime.getTime());
            int count = secondShowreelMapper.updateByPrimaryKeySelective(secondShowreel);
            if (count != 0) {
                update = true;
                log.info("id为" + secondShowreel.getSecondShowreelId() + "的二级作品集分类列表状态更新为" + secondShowreel.getSecondShowreelState());
            } else {
                log.info("id为" + secondShowreel.getSecondShowreelId() + "的二级作品集分类列表状态更新为" + secondShowreel.getSecondShowreelState());
            }
            return update;
        }

        /**
         * 编辑 根据二级作品集分类id修改二级作品集名称
         *
         * @param secondShowreel
         * @return
         */
        @Override
        public Boolean updateSecondShowreelNameByPrimaryKey(SecondShowreel secondShowreel){
            Boolean update = false;
            secondShowreel.setUpdatedAt(DateTime.getTime());
            int count = secondShowreelMapper.updateByPrimaryKeySelective(secondShowreel);
            if (count != 0) {
                update = true;
                log.info("id为" + secondShowreel.getSecondShowreelId() + "的二级作品集分类列表姓名更新为" + secondShowreel.getSecondShowreelName());
            } else {
                log.info("id为" + secondShowreel.getSecondShowreelId() + "的二级作品集分类列表状态更新为" + secondShowreel.getSecondShowreelName());
            }
            return update;
        }


    /**
     * 根据二集作品集分类ID删除二级作品集
     * @param secondShowreelId
     * @return
     */
    @Override
    public Boolean deleteByPrimaryKey(Integer secondShowreelId) {
        Boolean delete = false;
        int count = secondShowreelMapper.deleteByPrimaryKey(secondShowreelId);
        if (count != 0) {
            delete = true;
            log.info("id为" + secondShowreelId + "的二级作品集分类列表删除" + delete);
        } else {
            log.info("id为" + secondShowreelId + "的二级作品集分类列表删除" + delete);
        }
        return delete;
    }
}
