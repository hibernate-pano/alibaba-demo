package kit.pano.common.redis;

/**
 * @author Pano
 */
@FunctionalInterface
public interface JedisExecutor<T, R> {

    /**
     * @param t 执行方法参数
     * @return
     * @throws RedisConnectException
     */
    R excute(T t) throws RedisConnectException;
}
