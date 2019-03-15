package com.tian.service.impl;

import com.tian.dao.FirstShowreelMapper;
import com.tian.model.FirstShowreel;
import com.tian.service.FirstShowreelSrevice;
import com.util.DateTime;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FirstShowreelSreviceImpl implements FirstShowreelSrevice {

    @Resource
    private FirstShowreelMapper firstShowreelMapper;

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(BannerManageServiceImpl.class);

    /**
     * 根据id删除一级作品集
     *
     * @param firstShowreelId
     * @return
     */
    @Override
    public Boolean deleteByPrimaryKey(Integer firstShowreelId) {
        Boolean delete = false;
        log.info("firstShowreelId is "+firstShowreelId);
        FirstShowreel firstShowreel = firstShowreelMapper.selectByPrimaryKey(firstShowreelId);
        int count = 0;
        if (firstShowreel.getSecondShowreelName() == null && firstShowreel.getFirstShowreelState() == 0){
           count = firstShowreelMapper.deleteByPrimaryKey(firstShowreelId);
        }else {
            log.info("无法删除");
        }
        if (count != 0){
            delete = true;
            log.info("id为"+ firstShowreelId +"的一级作品集删除"+delete);
        }else {
            delete = false;
            log.info("id为"+ firstShowreelId +"的一级作品集删除"+delete);
        }
        return delete;
    }

    /**
     * 新增一级作品集
     *
     * @param firstShowreel
     */
    @Override
    public int insertSelective(FirstShowreel firstShowreel){
        firstShowreel.setCreatedAt(DateTime.getTime());
        int a = firstShowreelMapper.selectCount();
        log.info("当前数据库记录条数为"+a);
        if (a < 7){
            log.info("执行新增操作");
            firstShowreelMapper.insertSelective(firstShowreel);
            a = firstShowreelMapper.selectCount();
            log.info("新增后数据库记录条数为"+a);
        }else{
            log.info("超过数量无法新增");
        }


        return 0;
    }



    /**
     * 根据一级作品集作品标题和状态查询作品集信息
     *
     * @param firstShowreel
     * @return
     */
    @Override
    public List<FirstShowreel> selectByNameAndState(FirstShowreel firstShowreel) {
        return  this.firstShowreelMapper.selectByNameAndState(firstShowreel);
    }

    @Override
    public FirstShowreel selectByPrimaryKey(Integer firstShowreelId) {
        return this.firstShowreelMapper.selectByPrimaryKey(firstShowreelId);
    }

    @Override
    public Boolean updateStateByPrimaryKey(FirstShowreel firstShowreel) {
        firstShowreel.setUpdatedAt(DateTime.getTime());
        Boolean update = false;
        firstShowreel = firstShowreelMapper.selectByPrimaryKey(firstShowreel.getFirstShowreelId());

        log.info(""+firstShowreel);
        int count = 0;

        if (firstShowreel.getFirstShowreelState() == 0 && firstShowreel.getSecondShowreelName() == null){
            count = firstShowreelMapper.updateByPrimaryKey(firstShowreel);
        }else {
            log.info(" 作品集当前无法下架");
        }
        if (count != 0){
            update = true;
            log.info("id为"+ firstShowreel.getFirstShowreelId()
                    +"的一级作品集状态更新为"+firstShowreel.getFirstShowreelState());
        }else {
            update = false;
            log.info("id为"+ firstShowreel.getFirstShowreelId()
                    +"的一级作品集状态更新为"+firstShowreel.getFirstShowreelState());
        }
        return update;
    }

    @Override
    public Boolean updateNameByPrimaryKey(FirstShowreel firstShowreel) {
        firstShowreel.setUpdatedAt(DateTime.getTime());
        Boolean update = false;
        int count = firstShowreelMapper.updateByPrimaryKey(firstShowreel);
        if (count != 0){
            update = true;
            log.info("id为"+ firstShowreel.getFirstShowreelId()
                    +"的一级作品集标题更新为"+firstShowreel.getFirstShowreelName());
        }else {
            update = false;
            log.info("id为"+ firstShowreel.getFirstShowreelId()
                    +"的一级作品集标题更新为"+firstShowreel.getFirstShowreelName());
        }
        return update;
    }

    @Override
    public int updateSecondByPrimaryKey(FirstShowreel firstShowreel) {
        return this.firstShowreelMapper.updateByPrimaryKey(firstShowreel);
    }
}
