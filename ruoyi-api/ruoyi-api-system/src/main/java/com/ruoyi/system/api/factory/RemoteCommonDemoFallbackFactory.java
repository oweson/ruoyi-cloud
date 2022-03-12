package com.ruoyi.system.api.factory;

import com.ruoyi.common.core.domain.R;
import com.ruoyi.system.api.RemoteUserService;
import com.ruoyi.system.api.common.CommonDemoService;
import com.ruoyi.system.api.domain.SysUser;
import com.ruoyi.system.api.model.CommonDemo;
import com.ruoyi.system.api.model.LoginUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户服务降级处理
 *
 * @author ruoyi
 */
@Component
public class RemoteCommonDemoFallbackFactory implements FallbackFactory<CommonDemoService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteCommonDemoFallbackFactory.class);

    @Override
    public CommonDemoService create(Throwable cause) {
        log.error("公共服务调用失败：{}", cause.getMessage());
        return new CommonDemoService() {
            @Override
            public R<List<CommonDemo>> getDemoListInfo(CommonDemo commonDemo) {
                return R.fail("获取公共demo列表失败" + cause.getMessage());
            }

            @Override
            public R<Boolean> getDemoInfo(CommonDemo commonDemo, String source) {
                return R.fail("获得单个公共demo信息失败" + cause.getMessage());
            }
        };
    }
}
