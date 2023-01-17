package com.xiaoju.uemc.tinyid.server.dao;

import com.xiaoju.uemc.tinyid.server.dao.entity.TinyIdInfo;

/**
 * @author du_imba
 */
public interface TinyIdInfoDAO {
    /**
     * 根据bizType获取db中的tinyId对象
     *
     * @param bizType 业务类型
     * @return
     */
    TinyIdInfo queryByBizType(String bizType);

    /**
     * 根据id、oldMaxId、version、bizType更新最新的maxId
     *
     * @param id 主键
     * @param newMaxId 新的最大ID
     * @param oldMaxId 旧的最大ID
     * @param version  版本
     * @param bizType  业务类型
     * @return
     */
    int updateMaxId(Long id, Long newMaxId, Long oldMaxId, Long version, String bizType);
}
