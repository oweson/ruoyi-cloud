package com.ruoyi.system.controller.services;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.core.utils.DateUtils;
import com.ruoyi.common.core.utils.ServletUtils;
import com.ruoyi.system.api.model.AppWriteRequest;
import com.ruoyi.system.api.notice.api.entity.AppWrite;
import com.ruoyi.system.api.notice.api.entity.FishBean;
import com.ruoyi.system.api.notice.api.services.AppWriteClient;
import com.ruoyi.system.api.notice.api.services.FishUrlClient;
import com.ruoyi.system.mapper.AppWriteMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author oweson
 * @date 2022/3/22 21:02
 */

@RestController
@Transactional(rollbackFor = Throwable.class, value = "transactionManager")
public class AppWriteServiceImpl implements AppWriteClient {

    @Resource
    private AppWriteMapper appWriteMapper;

    /**
     * 查询app记录
     *
     * @param id app记录ID
     * @return app记录
     */
    @Override
    public AppWrite selectAppWriteById(Long id) {
        return appWriteMapper.selectAppWriteById(id);
    }

    /**
     * 查询app记录列表
     *
     * @param appWrite app记录
     * @return app记录
     */
    @Override
    public List<AppWrite> selectAppWriteList(AppWrite appWrite) {
        return appWriteMapper.selectAppWriteList(appWrite);
    }

    /**
     * 新增app记录
     *
     * @param appWrite app记录
     * @return 结果
     */
    @Override
    public int insertAppWrite(AppWrite appWrite) {
        appWrite.setCreateTime(DateUtils.getNowDate());
        return appWriteMapper.insertAppWrite(appWrite);
    }

    /**
     * 修改app记录
     *
     * @param appWrite app记录
     * @return 结果
     */
    @Override
    public int updateAppWrite(AppWrite appWrite) {
        appWrite.setUpdateTime(DateUtils.getNowDate());
        return appWriteMapper.updateAppWrite(appWrite);
    }

    /**
     * 删除app记录对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteAppWriteByIds(String ids) {
        return appWriteMapper.deleteAppWriteByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除app记录信息
     *
     * @param id app记录ID
     * @return 结果
     */
    @Override
    public int deleteAppWriteById(Long id) {
        return appWriteMapper.deleteAppWriteById(id);
    }

    @Override
    public Object map(Map map) {
        System.out.println(map);
        map.put(1,1);
        return map;
    }

    @Override
    public Object map(AppWriteRequest appWriteRequest) {
        List list1  = appWriteRequest.getList();
        System.out.println(list1);
        return list1;
    }

    @Override
    public String demo() {
        String app = ServletUtils.getRequest().getHeader("app");
        return "ok"+app;
    }
}
