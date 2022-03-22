package com.ruoyi.system.mapper;


import com.ruoyi.system.api.notice.api.entity.AppWrite;

import java.util.List;

/**
 * app记录Mapper接口
 *
 * @author ruoyi
 * @date 2020-09-13
 */
public interface AppWriteMapper {
    /**
     * 查询app记录
     *
     * @param id app记录ID
     * @return app记录
     */
    public AppWrite selectAppWriteById(Long id);

    /**
     * 查询app记录列表
     *
     * @param appWrite app记录
     * @return app记录集合
     */
    public List<AppWrite> selectAppWriteList(AppWrite appWrite);

    /**
     * 新增app记录
     *
     * @param appWrite app记录
     * @return 结果
     */
    public int insertAppWrite(AppWrite appWrite);

    /**
     * 修改app记录
     *
     * @param appWrite app记录
     * @return 结果
     */
    public int updateAppWrite(AppWrite appWrite);

    /**
     * 删除app记录
     *
     * @param id app记录ID
     * @return 结果
     */
    public int deleteAppWriteById(Long id);

    /**
     * 批量删除app记录
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAppWriteByIds(String[] ids);
}
