package com.lanstar.pesaplusdashboard.error;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
class GlobalDefaultExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "login";
    private static final Logger logger = LogManager.getLogger(GlobalDefaultExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public String
    defaultErrorHandler(HttpServletRequest req, Exception e, final  Model mav) throws Exception {
        // If the exception is annotated with @ResponseStatus rethrow it and let
        // the framework handle it - like the OrderNotFoundException example
        // at the start of this post.
        // AnnotationUtils is a Spring Framework utility class.
//        final HttpStatus httpStatus = AnnotationUtils.findAnnotation
//                (e.getClass(), ResponseStatus.class).value();

        if (AnnotationUtils.findAnnotation
                (e.getClass(), ResponseStatus.class) != null)
            throw e;

        // Otherwise setup and send the user to a default error-view.
      //  int httpErrorCode = getErrorCode(req);
//        System.out.println("Status Code:"+httpStatus);
//        mav.addObject("status",httpStatus);
        //mav.addAttribute("message",e.getMessage());
        logger.debug("Debugging log");
        logger.debug(e.getMessage());
        String message="Internal Server Error ";
        String customM=message.replace(" ", "%20");
        mav.addAttribute("server",message);
      //  mav.addAttribute("exception", e);
      //  mav.addAttribute("url", req.getRequestURL());
      //  mav.addAttribute(DEFAULT_ERROR_VIEW);
        return "redirect:/";
    }





}
