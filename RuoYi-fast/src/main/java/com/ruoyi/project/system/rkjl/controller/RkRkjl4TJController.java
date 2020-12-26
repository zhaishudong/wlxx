package com.ruoyi.project.system.rkjl.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.rkjl.domain.RkRkjl;
import com.ruoyi.project.system.rkjl.domain.RkRkjlByGroup;
import com.ruoyi.project.system.rkjl.service.IRkRkjlService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 入库Controller
 * 
 * @author ruoyi
 * @date 2020-12-05
 */
@Controller
@RequestMapping("/kdhz/hzd")
public class RkRkjl4TJController extends BaseController
{
    private String prefix = "kdhz/hzd";

    @Autowired
    private IRkRkjlService rkRkjlService;

    @RequiresPermissions("kdhz:hzd:view")
    @GetMapping()
    public String rkjl()
    {
        return prefix + "/rkjl";
    }

    /**
     * 查询入库列表
     */
    @RequiresPermissions("kdhz:hzd:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RkRkjl rkRkjl)
    {
        startPage();
        List<RkRkjl> list = rkRkjlService.selectRkRkjlList(rkRkjl);
        return getDataTable(list);
    }

    /**
     * 查询入库列表
     */
    @RequiresPermissions("kdhz:hzd:list")
    @PostMapping("/list/group")
    @ResponseBody
    public TableDataInfo listGroup(RkRkjl rkRkjl)
    {
        startPage();
        List<RkRkjlByGroup> list = rkRkjlService.selectRkRkjlListByGroup(rkRkjl);
        return getDataTable(list);
    }

    /**
     * 导出入库列表
     */
    @RequiresPermissions("kdhz:hzd:export")
    @Log(title = "入库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RkRkjl rkRkjl)
    {
        List<RkRkjl> list = rkRkjlService.selectRkRkjlListByReprot(rkRkjl);
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
    @RequiresPermissions("kdhz:hzd:add")
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
    @RequiresPermissions("kdhz:hzd:edit")
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
    @RequiresPermissions("kdhz:hzd:remove")
    @Log(title = "入库", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(rkRkjlService.deleteRkRkjlByIds(ids));
    }
}
