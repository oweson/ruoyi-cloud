package com.ruoyi.system.controller.demo;

import com.ruoyi.common.core.utils.ServletUtils;
import com.ruoyi.system.api.notice.api.services.AppWriteClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author oweson
 * @date 2022/6/29 17:04
 */

@RestController
public class DemoTest {
    @Resource
    AppWriteClient appWriteClient;
    @RequestMapping("/demo/list")
    public Object demo(HttpServletRequest request){
        String app1 = request.getHeader("app");
        System.out.println(appWriteClient.demo());
        String app = ServletUtils.getRequest().getHeader("app");
        return ""+app;

    }
}
