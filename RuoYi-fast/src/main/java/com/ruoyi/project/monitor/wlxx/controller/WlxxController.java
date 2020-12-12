package com.ruoyi.project.monitor.wlxx.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.project.monitor.server.domain.Server;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 服务器监控
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/monitor/wlxx")
public class WlxxController extends BaseController
{
    private String prefix = "monitor/wlxx";

    @RequiresPermissions("monitor:wlxx:view")
    @GetMapping()
    public String server(ModelMap mmap) throws Exception
    {
        Server server = new Server();
        server.copyTo();
        mmap.put("server", server);
        return prefix + "/server";
    }
}
