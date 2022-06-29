package com.ruoyi.system.api.model;

import com.ruoyi.system.api.notice.api.entity.AppWrite;

import java.util.List;

/**
 * @author oweson
 * @date 2022/6/29 16:47
 */


public class AppWriteRequest {
   private List<AppWrite> list;

    public List<AppWrite> getList() {
        return list;
    }

    public void setList(List<AppWrite> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "AppWriteRequest{" +
                "list=" + list +
                '}';
    }
}
