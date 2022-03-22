package com.ruoyi.system.api.notice.api.services;

import com.ruoyi.common.core.constant.ServiceNameConstants;
import com.ruoyi.system.api.notice.api.entity.AppWrite;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author oweson
 * @date 2022/3/22 20:37
 */

@Api(value = "appWrite管理")
@FeignClient(contextId = "app-write-client", name = ServiceNameConstants.SYSTEM_SERVICE)
public interface AppWriteClient {

    /**
     * 查询app记录
     *
     * @param id app记录ID
     * @return app记录
     */
    @ApiOperation(value = "查询app记录")
    @GetMapping("/listAppById")
    public AppWrite selectAppWriteById(@RequestParam("id") Long id);

    /**
     * 查询app记录列表
     *
     * @param appWrite app记录
     * @return app记录集合
     */
    @ApiOperation(value = "查询app记录列表")
    @GetMapping("/listAppWrite")
    public List<AppWrite> selectAppWriteList(AppWrite appWrite);

    /**
     * 新增app记录
     *
     * @param appWrite app记录
     * @return 结果
     */
    @ApiOperation(value = "新增app记录")
    @GetMapping("/insertAppWrite")
    public int insertAppWrite(AppWrite appWrite);

    /**
     * 修改app记录
     *
     * @param appWrite app记录
     * @return 结果
     */
    @ApiOperation(value = "修改app记录")
    @GetMapping("/updateAppWrite")
    public int updateAppWrite(AppWrite appWrite);

    /**
     * 批量删除app记录
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @ApiOperation(value = "批量删除app记录")
    @GetMapping("/deleteAppWriteByIds")
    public int deleteAppWriteByIds(String ids);

    /**
     * 删除app记录信息
     *
     * @param id app记录ID
     * @return 结果
     */
    @ApiOperation(value = "删除app记录信息")
    @GetMapping("/deleteAppWriteById")
    public int deleteAppWriteById(Long id);
}
