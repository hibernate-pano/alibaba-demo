package kit.pano.common.core.result;

/**
 * @author pano
 */
public enum ResultCode {
    /**
     * 成功
     */
    SUCCESS(1, "成功"),

    /**
     * 参数错误100-199
     */
    PARAM_IS_INVALID(101, "参数无效"),
    PARAM_IS_BLANK(102, "参数为空"),
    PARAM_TYPE_BIND_ERROR(103, "参数类型错误"),
    PARAM_NOT_COMPLETE(104, "参数缺失"),

    /**
     * 用户错误200-299
     */
    USER_NOT_LOGGED_IN(201, "用户未登录，访问的路径需要验证，请登录"),
    USER_LOGIN_ERROR(202, "账号不存在或密码错误"),
    USER_ACCOUNT_FORBIDDEN(203, "账号已被禁用"),
    USER_NOT_EXIST(204, "用户不存在"),
    USER_HAS_EXISTED(205, "用户已存在");

    private final Integer code;

    private final String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }
}