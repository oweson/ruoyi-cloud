package com.controller;

import java.util.Date;

import com.google.common.collect.Maps;

import com.entity.CommonDemo;
import com.google.common.collect.Lists;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.system.api.model.AppWriteRequest;
import com.ruoyi.system.api.notice.api.entity.AppWrite;
import com.ruoyi.system.api.notice.api.services.AppWriteClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author oweson
 * @date 2022/3/12 11:25
 */
@RestController
public class DemoController {
    @Autowired
   private AppWriteClient appWriteClient;

    @GetMapping("/map")
    public Object map(@RequestParam("map") Map map) {
        return appWriteClient.map(map);
    }

    @PostMapping("/List/appWrite")
    public Object map(@RequestBody List<AppWrite> list) {
        AppWriteRequest appWriteRequest = new AppWriteRequest();
        appWriteRequest.setList(list);
        return appWriteClient.map(appWriteRequest);
    }

    @RequestMapping("public/list")
    public R<List<CommonDemo>> list(@RequestBody CommonDemo commonDemo) {
        ArrayList<CommonDemo> commonDemos = Lists.newArrayList();
        CommonDemo commonDemo1 = new CommonDemo();
        commonDemo1.setId(0L);
        commonDemo1.setName("tom");
        commonDemo1.setSearchValue("");
        commonDemo1.setCreateBy("");
        commonDemo1.setCreateTime(new Date());
        commonDemo1.setUpdateBy("");
        commonDemo1.setUpdateTime(new Date());
        commonDemo1.setRemark("");
        commonDemo1.setParams(Maps.newHashMap());
        commonDemos.add(commonDemo1);
        Object demo = appWriteClient.demo();
        System.out.println(demo);

        return R.ok(commonDemos);
    }
}
