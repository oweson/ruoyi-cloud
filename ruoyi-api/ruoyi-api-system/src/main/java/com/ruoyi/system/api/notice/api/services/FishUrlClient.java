package com.ruoyi.system.api.notice.api.services;

import com.ruoyi.common.core.constant.ServiceNameConstants;
import com.ruoyi.system.api.notice.api.entity.FishBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author oweson
 * @date 2022/3/22 20:37
 */

@Api(value = "fish测试")
@FeignClient(contextId = "fish-client", name = ServiceNameConstants.SYSTEM_SERVICE,url = "127.0.0.1:8080")
public interface FishUrlClient {
    /**
     * 查询公告列表
     *
     * @param fishBean
     * @return
     */
    @ApiOperation(value = "查询公告列表")
    @PostMapping("/demo/postFish")
    ResponseEntity<FishBean> listNotices(@RequestBody FishBean fishBean);

}
