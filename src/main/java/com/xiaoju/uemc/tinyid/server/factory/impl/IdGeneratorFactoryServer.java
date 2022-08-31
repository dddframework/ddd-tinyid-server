package com.xiaoju.uemc.tinyid.server.factory.impl;

import com.xiaoju.uemc.tinyid.base.factory.AbstractIdGeneratorFactory;
import com.xiaoju.uemc.tinyid.base.generator.IdGenerator;
import com.xiaoju.uemc.tinyid.base.generator.impl.CachedIdGenerator;
import com.xiaoju.uemc.tinyid.base.service.SegmentIdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author du_imba
 */
@Component
@Slf4j
public class IdGeneratorFactoryServer extends AbstractIdGeneratorFactory {

    @Autowired
    private SegmentIdService tinyIdService;

    @Override
    public IdGenerator createIdGenerator(String bizType) {
        log.info("createIdGenerator :{}", bizType);
        return new CachedIdGenerator(bizType, tinyIdService);
    }
}
