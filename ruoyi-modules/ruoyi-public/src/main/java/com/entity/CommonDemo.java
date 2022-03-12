package com.entity;

import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * @author oweson
 * @date 2022/3/12 11:33
 */


public class CommonDemo extends BaseEntity {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
