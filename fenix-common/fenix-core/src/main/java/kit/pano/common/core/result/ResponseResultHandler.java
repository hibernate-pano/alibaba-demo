package kit.pano.common.core.result;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author pano
 */
@Slf4j
@ControllerAdvice
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {

    /**
     * 是否请求包含了包装注解标记，没有就直接返回，不需要重写返回体
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(sra).getRequest();
        //判断请求是否有包装标记
        return ResponseURICache.getInstance().get(request.getRequestURI());
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        //进入返回体重写格式
        if (body instanceof ErrorResult) {
            //返回值异常，作包装处理
            ErrorResult errorResult = (ErrorResult) body;
            return Result.failure(errorResult.getCode(), errorResult.getMessage(), errorResult.getErrors());
        }
        return Result.success(body);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorResult handleRuntimeException(Exception e) {
        ErrorResult errorResult = new ErrorResult();
        errorResult.setCode(500);
        errorResult.setMessage("服务器异常");
        errorResult.setErrors(errorResult.getErrors());
        return errorResult;
    }
}