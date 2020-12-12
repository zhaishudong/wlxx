package com.ruoyi.project.system.rkjl.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 入库对象 rk_rkjl
 * 
 * @author ruoyi
 * @date 2020-12-05
 */
public class RkRkjl extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 入库序号 */
    private Long RKXH;

    /** 快递种类 */
    @Excel(name = "快递种类")
    private String KDZL;

    /** 快递单号 */
    @Excel(name = "快递单号")
    private String KDDH;

    /** 其他信息 */
    @Excel(name = "其他信息")
    private String QTXX;

    /** 入库日期 */
    @Excel(name = "入库日期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date RKRQ;

    public void setRKXH(Long RKXH)
    {
        this.RKXH = RKXH;
    }

    public Long getRKXH()
    {
        return RKXH;
    }
    public void setKDDH(String KDDH)
    {
        this.KDDH = KDDH;
    }

    public String getKDDH()
    {
        return KDDH;
    }
    public void setQTXX(String QTXX)
    {
        this.QTXX = QTXX;
    }

    public String getQTXX()
    {
        return QTXX;
    }
    public void setRKRQ(Date RKRQ)
    {
        this.RKRQ = RKRQ;
    }

    public Date getRKRQ()
    {
        return RKRQ;
    }

    public String getKDZL() {
        return KDZL;
    }

    public void setKDZL(String KDZL) {
        this.KDZL = KDZL;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("RKXH", getRKXH())
            .append("KDDH", getKDDH())
            .append("QTXX", getQTXX())
            .append("RKRQ", getRKRQ())
            .append("KDZL", getKDZL())
            .toString();
    }
}
