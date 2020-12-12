package com.ruoyi.project.system.rkjl.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
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
        return rkRkjlMapper.selectRkRkjlList(rkRkjl);
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
        rkRkjl.setRKRQ(new Date());
        rkRkjl.setKDDH(rkRkjl.getKDDH().trim());
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
