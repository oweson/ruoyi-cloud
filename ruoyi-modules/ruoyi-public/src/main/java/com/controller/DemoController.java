package com.controller;

import java.util.Date;

import com.google.common.collect.Maps;

import com.entity.CommonDemo;
import com.google.common.collect.Lists;
import com.ruoyi.common.core.domain.R;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author oweson
 * @date 2022/3/12 11:25
 */
@RestController
public class DemoController {
    @RequestMapping("public/list")
    public R<List<CommonDemo>> list(@RequestBody CommonDemo commonDemo) {
        ArrayList<CommonDemo> commonDemos = Lists.newArrayList(new CommonDemo());
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

        return R.ok(commonDemos);
    }
}
