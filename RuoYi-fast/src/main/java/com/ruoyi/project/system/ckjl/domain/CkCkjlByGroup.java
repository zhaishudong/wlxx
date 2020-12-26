package com.ruoyi.project.system.ckjl.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * ckjlFunction对象 ck_ckjl
 * 
 * @author Jimmy
 * @date 2020-12-05
 */
public class CkCkjlByGroup extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 快递种类 */
    @Excel(name = "快递种类")
    private String KDZL;

    /** 出库单号 */
    @Excel(name = "汇总数量")
    private String HZSL;

    public String getKDZL() {
        return KDZL;
    }

    public void setKDZL(String KDZL) {
        this.KDZL = KDZL;
    }

    public String getHZSL() {
        return HZSL;
    }

    public void setHZSL(String HZSL) {
        this.HZSL = HZSL;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("CKXH", getHZSL())
            .append("KDZL", getKDZL())
            .toString();
    }
}
