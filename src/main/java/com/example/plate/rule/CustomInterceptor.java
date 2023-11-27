package com.example.plate.rule;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class CustomInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // Logic to execute before the request is handled by the controller
        System.out.println("Pre-handle logic - Intercepted: " + request.getRequestURI());
        //response.setStatus(HttpServletResponse.SC_FORBIDDEN); // Set an appropriate status code
       // response.getWriter().write("Access Denied");
        return true; // Return true to proceed with the request, false to stop processing
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        // Logic to execute after the request is handled by the controller
        System.out.println("Post-handle logic - Intercepted: " + request.getRequestURI());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) throws Exception {
        // Logic to execute after the view is rendered (after completion)
        System.out.println("After completion - Intercepted: " + request.getRequestURI());
    }
}
