package club.hdqyf.encryption.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author houdq
 * @version 1.0
 * @ClassName GlobalExceptionHandler
 * @Description TODO
 * @Company com.yinhai
 * @date 2018/10/19 14:47
 **/
public class GlobalExceptionHandler {
    /**
     * 设置一个 @ControllerAdvice用来监控 Multipart上传的文件大小是否受限，当出现此异常时在前端页面给出提示。利用 @ControllerAdvice可以做很多东西，比如全局的统一异常处理等
     *
     * @param e
     * @param redirectAttributes
     * @return java.lang.String
     * @author houdq
     * @date 2018/10/19 14:47
     */
    @ExceptionHandler(MultipartException.class)
    public String handleError(MultipartException e, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "GarenMorbid友情提示：" + e.getCause().getMessage());
        return "redirect:/upload";
    }
}
