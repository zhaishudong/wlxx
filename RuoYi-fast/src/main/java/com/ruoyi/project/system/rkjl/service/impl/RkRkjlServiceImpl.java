package com.ruoyi.project.system.rkjl.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.text.StrEmpty;
import com.ruoyi.project.common.KdApiOrderDistinguish;
import com.ruoyi.project.system.ckjl.domain.CkCkjlByGroup;
import com.ruoyi.project.system.rkjl.domain.RkRkjlByGroup;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.rkjl.mapper.RkRkjlMapper;
import com.ruoyi.project.system.rkjl.domain.RkRkjl;
import com.ruoyi.project.system.rkjl.service.IRkRkjlService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 入库Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-12-05
 */
@Service
public class RkRkjlServiceImpl implements IRkRkjlService 
{
    @Autowired
    private RkRkjlMapper rkRkjlMapper;

    @Autowired
    private KdApiOrderDistinguish kdApiOrderDistinguish;

    /**
     * 查询入库
     * 
     * @param RKXH 入库ID
     * @return 入库
     */
    @Override
    public RkRkjl selectRkRkjlById(Long RKXH)
    {
        return rkRkjlMapper.selectRkRkjlById(RKXH);
    }

    /**
     * 查询入库列表
     * 
     * @param rkRkjl 入库
     * @return 入库
     */
    @Override
    public List<RkRkjl> selectRkRkjlList(RkRkjl rkRkjl)
    {
        String bgDate = (rkRkjl.getParams().get("beginRKRQ")+"");
        String endDate = (rkRkjl.getParams().get("endRKRQ")+"");
        if (StrEmpty.isNull(bgDate) && StrEmpty.isNull(endDate)){
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            bgDate = sdf.format(date);
            endDate = sdf.format(StrEmpty.dateAddOne(date));
        }
        rkRkjl.setBeginRKRQ(bgDate);
        rkRkjl.setEndRKRQ(endDate);
        String kddh = rkRkjl.getKDDH();
        if (StringUtils.isNotBlank(kddh) && kddh.length()>4){
            return rkRkjlMapper.selectRkRkjlList(rkRkjl);
        }else {
            return rkRkjlMapper.selectRkRkjlListBykddh(rkRkjl);
        }
    }

    /**
     * 查询入库列表
     *
     * @param rkRkjl 入库
     * @return 入库
     */
    @Override
    public List<RkRkjl> selectRkRkjlListAll(RkRkjl rkRkjl)
    {
        String bgDate = (rkRkjl.getParams().get("beginRKRQ")+"");
        String endDate = (rkRkjl.getParams().get("endRKRQ")+"");
        if (StrEmpty.isNull(bgDate) && StrEmpty.isNull(endDate)){
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            bgDate = sdf.format(date);
            endDate = sdf.format(StrEmpty.dateAddOne(date));
        }
        rkRkjl.setBeginRKRQ(bgDate);
        rkRkjl.setEndRKRQ(endDate);
        String kddh = rkRkjl.getKDDH();
        rkRkjl.setCRPB("3");
        if (StringUtils.isNotBlank(kddh) && kddh.length()>4){
            return rkRkjlMapper.selectRkRkjlList(rkRkjl);
        }else {
            return rkRkjlMapper.selectRkRkjlListBykddh(rkRkjl);
        }
    }

    /**
     * 查询入库列表
     *
     * @param rkRkjl 入库
     * @return 入库
     */
    @Override
    public List<RkRkjlByGroup> selectRkRkjlListByGroup(RkRkjl rkRkjl)
    {
        String bgDate = (rkRkjl.getParams().get("beginRKRQ")+"");
        String endDate = (rkRkjl.getParams().get("endRKRQ")+"");
        if (StrEmpty.isNull(bgDate) && StrEmpty.isNull(endDate)){
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            bgDate = sdf.format(date);
            endDate = sdf.format(StrEmpty.dateAddOne(date));
        }
        rkRkjl.setBeginRKRQ(bgDate);
        rkRkjl.setEndRKRQ(endDate);
        return rkRkjlMapper.selectRkRkjlListByGroup(rkRkjl);
    }

    /**
     * 查询入库列表
     *
     * @param rkRkjl 入库
     * @return 入库
     */
    @Override
    public List<RkRkjl> selectRkRkjlListByReprot(RkRkjl rkRkjl)
    {
        String bgDate = (rkRkjl.getParams().get("beginRKRQ")+"");
        String endDate = (rkRkjl.getParams().get("endRKRQ")+"");
        if (StrEmpty.isNull(bgDate) && StrEmpty.isNull(endDate)){
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            bgDate = sdf.format(date);
            endDate = sdf.format(StrEmpty.dateAddOne(date));
        }
        rkRkjl.setBeginRKRQ(bgDate);
        rkRkjl.setEndRKRQ(endDate);
        String kddh = rkRkjl.getKDDH();
        List<RkRkjl> rulest_list = new ArrayList<RkRkjl>();
        //先查询有多少种类快递
        List<RkRkjlByGroup> rkRkjlByGroups = rkRkjlMapper.selectRkRkjlListByGroup(rkRkjl);
        //循环查询每种快递的info
        rkRkjl.setCRPB("3");
        for (int i = 0; i < rkRkjlByGroups.size(); i++) {
            RkRkjlByGroup rkRkjlByGroup = rkRkjlByGroups.get(i);
            rkRkjl.setKDZL(rkRkjlByGroup.getKDZL());
            rulest_list.addAll(rkRkjlMapper.selectRkRkjlList(rkRkjl));
            RkRkjl rkjl_temp = new RkRkjl();
            rkjl_temp.setKDZL(rkRkjlByGroup.getKDZL());
            rkjl_temp.setHZSL(rkRkjlByGroup.getHZSL());
            rulest_list.add(rkjl_temp);
        }
        return rulest_list;
    }



    /**
     * 新增入库
     * 
     * @param rkRkjl 入库
     * @return 结果
     */
    @Override
    public int insertRkRkjl(RkRkjl rkRkjl)
    {


        List<RkRkjl> listrk = rkRkjlMapper.selectRkRkjlList(rkRkjl);
        if (listrk.size() > 0)
        {
            throw new BusinessException("单号重复（"+rkRkjl.getKDDH()+"），请检查是否是同一个快递单号！");
        }
        String KDDH = rkRkjl.getKDDH().trim();
        rkRkjl.setRKRQ(new Date());
        String KDZL = "";
        try {
            KDZL = kdApiOrderDistinguish.getOrderTracesByJson(KDDH);
        } catch (Exception e) {
            throw new BusinessException("快递种类分析失败，请确认是否是有效的快递单号");
        }
        rkRkjl.setKDDH(KDDH);
        rkRkjl.setKDZL(KDZL);
        return rkRkjlMapper.insertRkRkjl(rkRkjl);
    }

    /**
     * 修改入库
     * 
     * @param rkRkjl 入库
     * @return 结果
     */
    @Override
    public int updateRkRkjl(RkRkjl rkRkjl)
    {
        return rkRkjlMapper.updateRkRkjl(rkRkjl);
    }

    /**
     * 删除入库对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRkRkjlByIds(String ids)
    {
        return rkRkjlMapper.deleteRkRkjlByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除入库信息
     * 
     * @param RKXH 入库ID
     * @return 结果
     */
    @Override
    public int deleteRkRkjlById(Long RKXH)
    {
        return rkRkjlMapper.deleteRkRkjlById(RKXH);
    }
}
