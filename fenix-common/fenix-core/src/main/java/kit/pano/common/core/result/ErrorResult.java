package kit.pano.common.core.result;

import lombok.Data;

/**
 * @author pano
 */
@Data
public class ErrorResult {

    private Integer code;

    private String message;

    private Object errors;
}