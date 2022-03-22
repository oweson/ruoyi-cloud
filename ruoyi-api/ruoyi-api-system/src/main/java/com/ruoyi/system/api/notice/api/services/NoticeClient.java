package com.ruoyi.system.api.notice.api.services;

import com.ruoyi.common.core.constant.ServiceNameConstants;
import com.ruoyi.system.api.notice.api.entity.SysNoticeMic;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author oweson
 * @date 2022/3/22 20:37
 */

@Api(value = "公告管理")
@FeignClient(contextId = "notice-client", name = ServiceNameConstants.SYSTEM_SERVICE, fallback = FallbackFactory.Default.class)
public interface NoticeClient {
    /**
     * 查询公告列表
     *
     * @param notice
     * @return
     */
    @ApiOperation(value = "查询公告列表")
    @GetMapping("/listNotice")
    List<SysNoticeMic> listNotices(SysNoticeMic notice);

    /**
     * 根据id查看详情
     *
     * @param noticeId
     * @return
     */
    @ApiOperation(value = "查询公告详情")
    @GetMapping("/listNoticeDetailById")
    SysNoticeMic getById(Long noticeId);
}
