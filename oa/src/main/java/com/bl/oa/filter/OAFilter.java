package com.bl.oa.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/12/23 19:26
 */
@Component
@WebFilter("/*")
public class OAFilter implements Filter {

  /**
   * 以以下 uri 开头的 uri 可以直接访问
   */
  private final static String[] ignoreUri = new String[] {
    "/css/",
    "/images/",
    "/js/",
    "/index",
    "/login",
    "/account/login",
    "/account/validateAccount"
  };

  @Override
  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) req;
    final String requestURI = request.getRequestURI();
    // 应该放行的 URI
    for (String url : ignoreUri) {
      if(requestURI.startsWith(url)) {
        chain.doFilter(req, resp);
        return;
      }
    }

    // 如果已登录，放行
    HttpSession session = request.getSession();
    if(session.getAttribute("account") != null) {
      chain.doFilter(req, resp);
      return;
    }

    // 未登录，跳转到登录页
    HttpServletResponse response = (HttpServletResponse) resp;
    response.sendRedirect("/account/login");
  }
}
