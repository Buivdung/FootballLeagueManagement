package fa.training.jdwpractivet01.controlleravie;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(IllegalArgumentException.class)
    public String handleUnwantedException(Exception e, RedirectAttributes ra) {
        ra.addAttribute("message",e.getMessage());
        return e.getMessage();
    }
}
