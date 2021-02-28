package kit.pano.common.core.result;

import lombok.Data;

import java.io.Serializable;

/**
 * @author pano
 */
@Data
public class Result implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer code;

    private String message;

    private Object data;

    public Result() {
    }

    public Result(ResultCode resultCode, Object data) {
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.data = data;
    }

    public static Result success() {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    private void setResultCode(ResultCode resultCode) {
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    public static Result failure(ResultCode resultCode) {
        Result result = new Result();
        result.setResultCode(resultCode);
        return result;
    }

    public static Result failure(ResultCode resultCode, Object data) {
        Result result = new Result();
        result.setResultCode(resultCode);
        result.setData(data);
        return result;
    }

    public static Result failure(Integer code, String message, Object errors) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        result.setData(errors);
        return result;
    }

}