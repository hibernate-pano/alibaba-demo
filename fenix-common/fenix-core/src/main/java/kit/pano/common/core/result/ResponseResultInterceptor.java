package kit.pano.common.core.result;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author pano
 */
@Slf4j
@Component
public class ResponseResultInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //请求类型
        if (handler instanceof HandlerMethod) {
            final HandlerMethod handlerMethod = (HandlerMethod) handler;
            final Class<?> clazz = handlerMethod.getBeanType();
            final Method method = handlerMethod.getMethod();
            final String uri = request.getRequestURI();

            if (null == ResponseURICache.getInstance().get(uri)) {
                if (clazz.isAnnotationPresent(ResponseResult.class)) {
                    ResponseURICache.getInstance().set(uri, true);
                } else {
                    ResponseURICache.getInstance().set(uri, method.isAnnotationPresent(ResponseResult.class));
                }
            }
        }
        return true;
    }
}