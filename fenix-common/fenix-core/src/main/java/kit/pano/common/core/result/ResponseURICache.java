package kit.pano.common.core.result;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pano
 */
public class ResponseURICache {

    /**
     * 缓存map
     */
    private final Map<String, Boolean> cacheMap = new HashMap<>();

    /**
     * 禁止指令重排优化
     */
    private static volatile ResponseURICache URICACHE;

    private ResponseURICache() {
    }

    public static ResponseURICache getInstance() {
        if (null == URICACHE) {
            synchronized (ResponseURICache.class) {
                if (null == URICACHE) {
                    URICACHE = new ResponseURICache();
                }
            }
        }
        return URICACHE;
    }

    /**
     * 设置缓存值
     */
    public void set(String key, Boolean value) {
        cacheMap.put(key, value);
    }

    /**
     * 获取缓存key的value值
     */
    public Boolean get(String key) {
        if (!cacheMap.containsKey(key)) {
            return null;
        }
        return cacheMap.get(key);
    }
}