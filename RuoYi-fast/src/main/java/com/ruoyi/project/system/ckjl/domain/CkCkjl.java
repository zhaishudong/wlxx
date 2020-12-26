package com.ruoyi.project.system.ckjl.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * ckjlFunction对象 ck_ckjl
 * 
 * @author Jimmy
 * @date 2020-12-05
 */
public class CkCkjl extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 出库序号 */
//    @Excel(name = "出库序号")
    private Long CKXH;

    /** 快递种类 */
    @Excel(name = "快递种类")
    private String KDZL;

    /** 出库单号 */
    @Excel(name = "出库单号")
    private String CKDH;

    /** 其他信息 */
    @Excel(name = "其他信息")
    private String QTXX;

    /** 出库日期 */
    @Excel(name = "出库日期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date CKRQ;

    /** 出库关联，对应rk_rkjl的rkxh */
    @Excel(name = "出库关联")
    private Long RKGL;

    private String BEGINCKRQ;

    private String ENDCKRQ;

    public void setCKXH(Long CKXH)
    {
        this.CKXH = CKXH;
    }

    public Long getCKXH()
    {
        return CKXH;
    }

    public String getBeginCKRQ() {
        return BEGINCKRQ;
    }

    public void setBeginCKRQ(String beginCKRQ) {
        this.BEGINCKRQ = beginCKRQ;
    }

    public String getEndCKRQ() {
        return ENDCKRQ;
    }

    public void setEndCKRQ(String endCKRQ) {
        this.ENDCKRQ = endCKRQ;
    }

    public void setCKDH(String CKDH)
    {
        this.CKDH = CKDH;
    }

    public String getCKDH()
    {
        return CKDH;
    }
    public void setQTXX(String QTXX)
    {
        this.QTXX = QTXX;
    }

    public String getQTXX()
    {
        return QTXX;
    }
    public void setCKRQ(Date CKRQ)
    {
        this.CKRQ = CKRQ;
    }

    public Date getCKRQ()
    {
        return CKRQ;
    }
    public void setRKGL(Long RKGL)
    {
        this.RKGL = RKGL;
    }

    public Long getRKGL()
    {
        return RKGL;
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
            .append("CKXH", getCKXH())
            .append("CKDH", getCKDH())
            .append("QTXX", getQTXX())
            .append("CKRQ", getCKRQ())
            .append("RKGL", getRKGL())
            .append("KDZL", getKDZL())
            .append("BEGINCKRQ", getBeginCKRQ())
            .append("ENDCKRQ", getEndCKRQ())
            .toString();
    }
}
