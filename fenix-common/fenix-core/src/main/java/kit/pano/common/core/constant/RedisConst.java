package kit.pano.common.core.constant;

/**
 * Redis 常用常量类
 *
 * @author pano
 */
public interface RedisConst {

    /**
     * 默认过期时长，单位：秒
     */
    long DEFAULT_EXPIRE = 60 * 60 * 24;

    /**
     * 不设置过期时长
     */
    long NOT_EXPIRE = -1;

    /**
     * redis默认分隔符
     */
    String DELIMITER = ":";

}