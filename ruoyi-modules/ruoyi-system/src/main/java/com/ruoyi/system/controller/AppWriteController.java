package com.ruoyi.system.controller;

import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.common.security.utils.SecurityUtils;
import com.ruoyi.system.api.model.AppWriteRequest;
import com.ruoyi.system.api.notice.api.entity.AppWrite;
import com.ruoyi.system.api.notice.api.entity.FishBean;
import com.ruoyi.system.api.notice.api.services.AppWriteClient;
import com.ruoyi.system.api.notice.api.services.FishUrlClient;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * app记录Controller
 *
 * @author ruoyi
 * @date 2020-09-13
 */
@RestController
@RequestMapping("/system/write")
public class AppWriteController extends BaseController {
    private String prefix = "system/write";

    @Resource
    private AppWriteClient appWriteService;


    @Resource
    private FishUrlClient fishUrlClientService;


    @PostMapping("/postFish")
    @ApiOperation(value = "查询公告列表")
    public ResponseEntity<FishBean> listNotices(FishBean fishBean) {
        return fishUrlClientService.listNotices(fishBean);
    }

    @RequiresPermissions("system:write:view")
    @GetMapping()
    public String write() {
        return prefix + "/write";
    }

    /**
     * 查询app记录列表
     */
    @RequiresPermissions("system:write:list")
    @PostMapping("/list")
    public TableDataInfo list(AppWrite appWrite) {
        startPage();
        List<AppWrite> list = appWriteService.selectAppWriteList(appWrite);
        return getDataTable(list);
    }


    /**
     * 新增app记录
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存app记录
     */
    @RequiresPermissions("system:write:add")
    @Log(title = "app记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AppWrite appWrite) {
        Long userId = SecurityUtils.getUserId();
        appWrite.setUserId(userId);
        return toAjax(appWriteService.insertAppWrite(appWrite));
    }

    /**
     * 修改app记录
     */
    @GetMapping("/edit/{id}")
    public AjaxResult edit(@PathVariable("id") Long id, ModelMap mmap) {
        AppWrite appWrite = appWriteService.selectAppWriteById(id);
        return AjaxResult.success(appWrite);
    }

    /**
     * 修改保存app记录
     */
    @RequiresPermissions("system:write:edit")
    @Log(title = "app记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AppWrite appWrite) {
        Long userId = SecurityUtils.getUserId();
        appWrite.setUserId(userId);
        return toAjax(appWriteService.updateAppWrite(appWrite));
    }

    /**
     * 删除app记录
     */
    @RequiresPermissions("system:write:remove")
    @Log(title = "app记录", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(appWriteService.deleteAppWriteByIds(ids));
    }


    @GetMapping("/map")
    public Object  map(@RequestParam("map") Map map){
        return appWriteService.map(map);
    }

    @PostMapping("/List")
    public Object  map(@RequestBody List<AppWrite> list){
        AppWriteRequest appWriteRequest = new AppWriteRequest();
        appWriteRequest.setList(list);
        return appWriteService.map(appWriteRequest);
    }
}
