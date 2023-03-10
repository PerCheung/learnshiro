package learn.quickweb.config.exception;

import learn.quickweb.util.ErrorPrintUtil;
import learn.quickweb.util.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ValidationException;
import java.util.Arrays;

import static learn.quickweb.config.constant.Constant.PACKAGE_NAME;

/**
 * 全局异常统一处理
 *
 * @author Peter Cheung
 * @since 2023-02-13 13:56:51
 */
@Slf4j
@ControllerAdvice
@ResponseBody
public class AllExceptionHandle {
    /**
     * 捕捉shiro的异常
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({ShiroException.class, UnauthorizedException.class})
    public R handleShiro(Exception e) {
        return R.unauthorized().data(e(e));
    }

    /**
     * 校验传参
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public R handleBadRequest(Exception e) {
        e(e);
        String[] split = e.getMessage().split(", ");
        StringBuffer errors = new StringBuffer();
        Arrays.stream(split).forEach(s -> {
            String substring = s.substring(s.indexOf(": ") + 2);
            if (errors.length() == 0) {
                errors.append(substring);
            } else {
                errors.append("并且").append(substring);
            }
        });
        return R.badRequest().data(errors);
    }

    /**
     * 全局异常处理
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public R exception(Exception e) {
        return R.exp().data(e(e));
    }

    /**
     * 异常信息处理主体方法
     *
     * @param e 异常对象
     * @return 异常解析信息
     */
    private String e(Exception e) {
        ErrorPrintUtil.print(e);
        //错误信息
        StringBuilder errorMessage = new StringBuilder();
        String error = StringUtils.isNotBlank(e.getMessage()) ? e.getMessage() : e.toString();
        errorMessage.append(error);
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            if (className.startsWith(PACKAGE_NAME)) {
                String errorName = ";" + stackTraceElement.getClassName();
                errorMessage.append(errorName);
                String errorLineNumber = ":" + stackTraceElement.getLineNumber();
                errorMessage.append(errorLineNumber);
                ErrorPrintUtil.print(errorMessage);
                return errorMessage.toString();
            }
        }
        ErrorPrintUtil.print(errorMessage);
        return errorMessage.toString();
    }
}

