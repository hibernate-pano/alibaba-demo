package kit.pano.common.core.utils;

import kit.pano.common.core.constant.CommonConst;
import lombok.Builder;
import lombok.Data;

import java.util.Map;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019-04-16
 * Time: 19:47
 *
 * @author Pano
 */
@Data
@Builder
public class PageHelper {

    private long current;

    private long size;

    /**
     * 获取参数中分页信息
     */
    public static PageHelper getPage(Map<String, Object> params) {

        //如无参数，则为默认值
        if (Objects.isNull(params) || params.isEmpty()) {
            return PageHelper.builder().current(CommonConst.CURRENT).size(CommonConst.SIZE).build();
        }

        long current = (long) params.getOrDefault("current", 1);
        long size = (long) params.getOrDefault("size", 10);

        return PageHelper.builder().current(current).size(size).build();
    }
}
