package com.xiaoju.uemc.tinyid.server.dao.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author du_imba
 */
@Data
public class TinyIdInfo {
    /**
     * 主键
     */
    private Long id;
    /**
     * 业务类型
     */
    private String bizType;
    /**
     * 开始id，仅记录初始值，无其他含义。初始化时begin_id和max_id应相同
     */
    private Long beginId;
    /**
     * 当前最大id
     */
    private Long maxId;
    /**
     * 步长
     */
    private Integer step;
    /**
     * 每次id增量 默认1
     */
    private Integer delta;
    /**
     * 余数
     */
    private Integer remainder;
    /**
     * 版本号
     */
    private Long version;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
}
