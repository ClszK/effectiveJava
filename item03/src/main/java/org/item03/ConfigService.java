package org.item03;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 애플리케이션 전역 설정 관리 서비스.
 * ConfigService.getInstance()로 접근하며, 내부 Map은 thread-safe함.
 */
public class ConfigService {

    private static class Holder {
        private static final ConfigService INSTANCE = new ConfigService();
    }
    private final Map<String, String> configs = new ConcurrentHashMap<>();

    private ConfigService() { }

    public static ConfigService getInstance() {
        return Holder.INSTANCE;
    }

    public String getProperty(String key) {
        return configs.getOrDefault(key, "");
    }

    public void setProperty(String key, String value) {
        configs.put(key, value);
    }
}
