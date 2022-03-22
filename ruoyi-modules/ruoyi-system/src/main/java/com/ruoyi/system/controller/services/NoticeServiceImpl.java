package com.ruoyi.system.controller.services;

import com.ruoyi.system.api.notice.api.entity.SysNoticeMic;
import com.ruoyi.system.api.notice.api.services.NoticeClient;
import com.ruoyi.system.mapper.SysNoticeMapper;
import io.swagger.annotations.Api;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author oweson
 * @date 2022/3/22 20:47
 */

@Transactional(rollbackFor = Throwable.class, value = "transactionManager")
@Api(value = "员工管理", tags = "员工管理")
@RestController
public class NoticeServiceImpl implements NoticeClient {
    @Resource
    private SysNoticeMapper sysNoticeMapper;
    @Override
    public List<SysNoticeMic> listNotices(SysNoticeMic notice) {
        return null;

    }

    @Override
    public SysNoticeMic getById(Long noticeId) {
        return null;
    }
}
