package com.ruoyi.project.system.ckjl.controller;

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
import com.ruoyi.project.system.ckjl.domain.CkCkjl;
import com.ruoyi.project.system.ckjl.service.ICkCkjlService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * ckjlFunctionController
 * 
 * @author Jimmy
 * @date 2020-12-05
 */
@Controller
@RequestMapping("/ckjl/ckjl")
public class CkCkjlController extends BaseController
{
    private String prefix = "ckjl/ckjl";

    @Autowired
    private ICkCkjlService ckCkjlService;

    @RequiresPermissions("ckjl:ckjl:view")
    @GetMapping()
    public String ckjl()
    {
        return prefix + "/ckjl";
    }

    /**
     * 查询ckjlFunction列表
     */
    @RequiresPermissions("ckjl:ckjl:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CkCkjl ckCkjl)
    {
        startPage();
        List<CkCkjl> list = ckCkjlService.selectCkCkjlList(ckCkjl);
        return getDataTable(list);
    }

    /**
     * 导出ckjlFunction列表
     */
    @RequiresPermissions("ckjl:ckjl:export")
    @Log(title = "ckjlFunction", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CkCkjl ckCkjl)
    {
        List<CkCkjl> list = ckCkjlService.selectCkCkjlList(ckCkjl);
        ExcelUtil<CkCkjl> util = new ExcelUtil<CkCkjl>(CkCkjl.class);
        return util.exportExcel(list, "ckjl");
    }

    /**
     * 新增ckjlFunction
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存ckjlFunction
     */
    @RequiresPermissions("ckjl:ckjl:add")
    @Log(title = "ckjlFunction", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CkCkjl ckCkjl)
    {
        return toAjax(ckCkjlService.insertCkCkjl(ckCkjl));
    }

    /**
     * 修改ckjlFunction
     */
    @GetMapping("/edit/{CKXH}")
    public String edit(@PathVariable("CKXH") Long CKXH, ModelMap mmap)
    {
        CkCkjl ckCkjl = ckCkjlService.selectCkCkjlById(CKXH);
        mmap.put("ckCkjl", ckCkjl);
        return prefix + "/edit";
    }

    /**
     * 修改保存ckjlFunction
     */
    @RequiresPermissions("ckjl:ckjl:edit")
    @Log(title = "ckjlFunction", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CkCkjl ckCkjl)
    {
        return toAjax(ckCkjlService.updateCkCkjl(ckCkjl));
    }

    /**
     * 删除ckjlFunction
     */
    @RequiresPermissions("ckjl:ckjl:remove")
    @Log(title = "ckjlFunction", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(ckCkjlService.deleteCkCkjlByIds(ids));
    }
}
