package org.example.filter;

import org.example.data.User;
import org.example.data.UserType;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.example.Resources.PAGE_CHAT;

public class AdminFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        if ("show_admin_page".equals(servletRequest.getParameter("command"))) {
            User user = (User) session.getAttribute("user");
            if (user != null && user.getUserType() != UserType.ADMIN) {
                HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
                httpServletRequest.getRequestDispatcher(PAGE_CHAT).forward(servletRequest, servletResponse);
                return;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
