package com.xiaoju.uemc.tinyid.base.factory;

import com.xiaoju.uemc.tinyid.base.generator.IdGenerator;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author du_imba
 */
public abstract class AbstractIdGeneratorFactory implements IdGeneratorFactory {

    private static final ConcurrentHashMap<String, IdGenerator> GENERATORS = new ConcurrentHashMap<>();

    @Override
    public IdGenerator getIdGenerator(String bizType) {
        if (GENERATORS.containsKey(bizType)) {
            return GENERATORS.get(bizType);
        }
        synchronized (this) {
            if (GENERATORS.containsKey(bizType)) {
                return GENERATORS.get(bizType);
            }
            IdGenerator idGenerator = createIdGenerator(bizType);
            GENERATORS.put(bizType, idGenerator);
            return idGenerator;
        }
    }

    /**
     * 根据bizType创建id生成器
     *
     * @param bizType
     * @return
     */
    protected abstract IdGenerator createIdGenerator(String bizType);
}
