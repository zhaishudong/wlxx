package com.ruoyi.project.system.rkjl.mapper;

import java.util.List;
import com.ruoyi.project.system.rkjl.domain.RkRkjl;

/**
 * 入库Mapper接口
 * 
 * @author ruoyi
 * @date 2020-12-05
 */
public interface RkRkjlMapper 
{
    /**
     * 查询入库
     * 
     * @param RKXH 入库ID
     * @return 入库
     */
    public RkRkjl selectRkRkjlById(Long RKXH);

    /**
     * 查询入库列表
     * 
     * @param rkRkjl 入库
     * @return 入库集合
     */
    public List<RkRkjl> selectRkRkjlList(RkRkjl rkRkjl);

    /**
     * 新增入库
     * 
     * @param rkRkjl 入库
     * @return 结果
     */
    public int insertRkRkjl(RkRkjl rkRkjl);

    /**
     * 修改入库
     * 
     * @param rkRkjl 入库
     * @return 结果
     */
    public int updateRkRkjl(RkRkjl rkRkjl);

    /**
     * 删除入库
     * 
     * @param RKXH 入库ID
     * @return 结果
     */
    public int deleteRkRkjlById(Long RKXH);

    /**
     * 批量删除入库
     * 
     * @param RKXHs 需要删除的数据ID
     * @return 结果
     */
    public int deleteRkRkjlByIds(String[] RKXHs);
}