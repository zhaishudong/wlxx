package com.ruoyi.project.system.rkjl.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.rkjl.domain.RkRkjl;
import com.ruoyi.project.system.rkjl.service.IRkRkjlService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 入库Controller
 * 
 * @author ruoyi
 * @date 2020-12-05
 */
@Controller
@RequestMapping("/system/rkjl")
public class RkRkjlController extends BaseController
{
    private String prefix = "system/rkjl";

    @Autowired
    private IRkRkjlService rkRkjlService;

    @RequiresPermissions("system:rkjl:view")
    @GetMapping()
    public String rkjl()
    {
        return prefix + "/rkjl";
    }

    /**
     * 查询入库列表
     */
    @RequiresPermissions("system:rkjl:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RkRkjl rkRkjl)
    {
        startPage();
        List<RkRkjl> list = rkRkjlService.selectRkRkjlList(rkRkjl);
        return getDataTable(list);
    }

    /**
     * 导出入库列表
     */
    @RequiresPermissions("system:rkjl:export")
    @Log(title = "入库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RkRkjl rkRkjl)
    {
        List<RkRkjl> list = rkRkjlService.selectRkRkjlList(rkRkjl);
        ExcelUtil<RkRkjl> util = new ExcelUtil<RkRkjl>(RkRkjl.class);
        return util.exportExcel(list, "rkjl");
    }

    /**
     * 新增入库
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存入库
     */
    @RequiresPermissions("system:rkjl:add")
    @Log(title = "入库", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RkRkjl rkRkjl)
    {
        return toAjax(rkRkjlService.insertRkRkjl(rkRkjl));
    }

    /**
     * 修改入库
     */
    @GetMapping("/edit/{RKXH}")
    public String edit(@PathVariable("RKXH") Long RKXH, ModelMap mmap)
    {
        RkRkjl rkRkjl = rkRkjlService.selectRkRkjlById(RKXH);
        mmap.put("rkRkjl", rkRkjl);
        return prefix + "/edit";
    }

    /**
     * 修改保存入库
     */
    @RequiresPermissions("system:rkjl:edit")
    @Log(title = "入库", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RkRkjl rkRkjl)
    {
        return toAjax(rkRkjlService.updateRkRkjl(rkRkjl));
    }

    /**
     * 删除入库
     */
    @RequiresPermissions("system:rkjl:remove")
    @Log(title = "入库", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(rkRkjlService.deleteRkRkjlByIds(ids));
    }
}
