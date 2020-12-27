package com.ruoyi.project.system.ckjl.mapper;

import java.util.List;
import com.ruoyi.project.system.ckjl.domain.CkCkjl;
import com.ruoyi.project.system.ckjl.domain.CkCkjlByGroup;

/**
 * ckjlFunctionMapper接口
 * 
 * @author Jimmy
 * @date 2020-12-05
 */
public interface CkCkjlMapper 
{
    /**
     * 查询ckjlFunction
     * 
     * @param CKXH ckjlFunctionID
     * @return ckjlFunction
     */
    public CkCkjl selectCkCkjlById(Long CKXH);

    /**
     * 查询ckjlFunction列表
     * 
     * @param ckCkjl ckjlFunction
     * @return ckjlFunction集合
     */
    public List<CkCkjl> selectCkCkjlList(CkCkjl ckCkjl);

    /**
     * 查询ckjlFunction列表
     *
     * @param ckCkjl ckjlFunction
     * @return ckjlFunction集合
     */
    public List<CkCkjl> selectCkCkjlListBykddh(CkCkjl ckCkjl);

    /**
     * 查询ckjlFunction列表
     *
     * @param ckCkjl ckjlFunction
     * @return ckjlFunction集合
     */
    public List<CkCkjlByGroup> selectCkCkjlListByGroup(CkCkjl ckCkjl);



    /**
     * 新增ckjlFunction
     * 
     * @param ckCkjl ckjlFunction
     * @return 结果
     */
    public int insertCkCkjl(CkCkjl ckCkjl);

    /**
     * 修改ckjlFunction
     * 
     * @param ckCkjl ckjlFunction
     * @return 结果
     */
    public int updateCkCkjl(CkCkjl ckCkjl);

    /**
     * 删除ckjlFunction
     * 
     * @param CKXH ckjlFunctionID
     * @return 结果
     */
    public int deleteCkCkjlById(Long CKXH);

    /**
     * 批量删除ckjlFunction
     * 
     * @param CKXHs 需要删除的数据ID
     * @return 结果
     */
    public int deleteCkCkjlByIds(String[] CKXHs);

    public List<CkCkjl> selectCkCkjlListlByIds(String[] CKXHs);

}
