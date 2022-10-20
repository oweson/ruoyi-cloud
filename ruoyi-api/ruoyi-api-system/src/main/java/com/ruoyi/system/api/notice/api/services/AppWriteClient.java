package com.ruoyi.system.api.notice.api.services;

import com.ruoyi.common.core.constant.ServiceNameConstants;
import com.ruoyi.system.api.model.AppWriteRequest;
import com.ruoyi.system.api.notice.api.entity.AppWrite;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author oweson
 * @date 2022/3/22 20:37
 */

@Api(value = "appWrite管理")
@FeignClient(contextId = "app-write-client", name = ServiceNameConstants.SYSTEM_SERVICE,url = "127.0.0.1:9201")
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
    public List<AppWrite> selectAppWriteList(@SpringQueryMap AppWrite appWrite);

    /**
     * 新增app记录
     *
     * @param appWrite app记录
     * @return 结果
     */
    @ApiOperation(value = "新增app记录")
    @PostMapping("/insertAppWrite")
    public int insertAppWrite(@RequestBody AppWrite appWrite);

    /**
     * 修改app记录
     *
     * @param appWrite app记录
     * @return 结果
     */
    @ApiOperation(value = "修改app记录")
    @PostMapping("/updateAppWrite")
    public int updateAppWrite(@RequestBody AppWrite appWrite);

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
    public int deleteAppWriteById(@RequestParam("id") Long id);


    @GetMapping("/map")
    public Object  map(@RequestParam("map") Map map);

    @PostMapping("/List")
    public Object  map(@RequestBody AppWriteRequest appWriteRequest);
    @PostMapping("/demo")
    public String  demo();
}
