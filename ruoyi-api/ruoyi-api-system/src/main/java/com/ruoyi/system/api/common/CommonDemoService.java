package com.ruoyi.system.api.common;

import com.ruoyi.common.core.constant.SecurityConstants;
import com.ruoyi.common.core.constant.ServiceNameConstants;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.system.api.domain.SysUser;
import com.ruoyi.system.api.factory.RemoteCommonDemoFallbackFactory;
import com.ruoyi.system.api.factory.RemoteUserFallbackFactory;
import com.ruoyi.system.api.model.CommonDemo;
import com.ruoyi.system.api.model.LoginUser;
import feign.QueryMap;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户服务
 *
 * @author ruoyi
 */
@FeignClient(contextId = "commonDemo", value = ServiceNameConstants.PUBLIC_SERVICE, fallbackFactory = RemoteCommonDemoFallbackFactory.class)
public interface CommonDemoService {
    /**
     * 通过用户名查询用户信息
     *
     * @param commonDemo 用户名
     * @return 结果
     */
    @GetMapping("/public/list")
    public R<List<CommonDemo>> getDemoListInfo(@QueryMap CommonDemo commonDemo);

    /**
     * 注册用户信息
     *
     * @param commonDemo 用户信息
     * @param source  请求来源
     * @return 结果
     */
    @PostMapping("/public/insert")
    public R<Boolean> getDemoInfo(@RequestBody CommonDemo commonDemo, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);
}
