package org.example.filter;

import org.example.data.User;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.example.Resources.PAGE_LOGIN;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpSession session = ((HttpServletRequest) request).getSession();
        if ((session.getAttribute("user") == null) && (!request.getParameter("command").equals("login"))) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            httpServletRequest.getRequestDispatcher(PAGE_LOGIN).forward(request, response);
            return;
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
