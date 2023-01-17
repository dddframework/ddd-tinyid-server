package com.xiaoju.uemc.tinyid.server.service.impl;

import com.xiaoju.uemc.tinyid.server.dao.TinyIdTokenDAO;
import com.xiaoju.uemc.tinyid.server.dao.entity.TinyIdToken;
import com.xiaoju.uemc.tinyid.server.service.TinyIdTokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author du_imba
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class TinyIdTokenServiceImpl implements TinyIdTokenService {

    private final TinyIdTokenDAO tinyIdTokenDAO;

    private static Map<String, Set<String>> token2bizTypes = new ConcurrentHashMap<>();


    public List<TinyIdToken> queryAll() {
        return tinyIdTokenDAO.selectAll();
    }

    /**
     * 1分钟刷新一次token
     */
    @Scheduled(cron = "0 0/1 * * * ?")
    public void refresh() {
        log.info("refresh token begin");
        init();
    }

    @PostConstruct
    private synchronized void init() {
        log.info("tinyId token init begin");
        List<TinyIdToken> list = queryAll();
        token2bizTypes = converToMap(list);
        log.info("tinyId token init success, token size:{}", list == null ? 0 : list.size());
    }

    @Override
    public boolean canVisit(String bizType, String token) {
        if (StringUtils.isEmpty(bizType) || StringUtils.isEmpty(token)) {
            return false;
        }
        Set<String> bizTypes = token2bizTypes.get(token);
        return (bizTypes != null && bizTypes.contains(bizType));
    }

    public Map<String, Set<String>> converToMap(List<TinyIdToken> list) {
        Map<String, Set<String>> map = new HashMap<>(64);
        if (list != null) {
            for (TinyIdToken tinyIdToken : list) {
                if (!map.containsKey(tinyIdToken.getToken())) {
                    map.put(tinyIdToken.getToken(), new HashSet<>());
                }
                map.get(tinyIdToken.getToken()).add(tinyIdToken.getBizType());
            }
        }
        return map;
    }

}
