package com.starcor.exception;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(value = {AuthException.class})
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, AuthException e) {
        ModelAndView mv = new ModelAndView();
            /*  使用FastJson提供的FastJsonJsonView视图返回，不需要捕获异常   */
        FastJsonJsonView view = new FastJsonJsonView();
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("code", e.getCode());
        attributes.put("msg", e.getMessage());
        view.setAttributesMap(attributes);
        mv.setView(view);
        return mv;
    }


}
