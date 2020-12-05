package com.ruoyi.project.system.ckjl.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.ckjl.mapper.CkCkjlMapper;
import com.ruoyi.project.system.ckjl.domain.CkCkjl;
import com.ruoyi.project.system.ckjl.service.ICkCkjlService;
import com.ruoyi.common.utils.text.Convert;

/**
 * ckjlFunctionService业务层处理
 * 
 * @author Jimmy
 * @date 2020-12-05
 */
@Service
public class CkCkjlServiceImpl implements ICkCkjlService 
{
    @Autowired
    private CkCkjlMapper ckCkjlMapper;

    /**
     * 查询ckjlFunction
     * 
     * @param CKXH ckjlFunctionID
     * @return ckjlFunction
     */
    @Override
    public CkCkjl selectCkCkjlById(Long CKXH)
    {
        return ckCkjlMapper.selectCkCkjlById(CKXH);
    }

    /**
     * 查询ckjlFunction列表
     * 
     * @param ckCkjl ckjlFunction
     * @return ckjlFunction
     */
    @Override
    public List<CkCkjl> selectCkCkjlList(CkCkjl ckCkjl)
    {
        return ckCkjlMapper.selectCkCkjlList(ckCkjl);
    }

    /**
     * 新增ckjlFunction
     * 
     * @param ckCkjl ckjlFunction
     * @return 结果
     */
    @Override
    public int insertCkCkjl(CkCkjl ckCkjl)
    {
        return ckCkjlMapper.insertCkCkjl(ckCkjl);
    }

    /**
     * 修改ckjlFunction
     * 
     * @param ckCkjl ckjlFunction
     * @return 结果
     */
    @Override
    public int updateCkCkjl(CkCkjl ckCkjl)
    {
        return ckCkjlMapper.updateCkCkjl(ckCkjl);
    }

    /**
     * 删除ckjlFunction对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCkCkjlByIds(String ids)
    {
        return ckCkjlMapper.deleteCkCkjlByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除ckjlFunction信息
     * 
     * @param CKXH ckjlFunctionID
     * @return 结果
     */
    @Override
    public int deleteCkCkjlById(Long CKXH)
    {
        return ckCkjlMapper.deleteCkCkjlById(CKXH);
    }
}
