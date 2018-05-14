package test.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet 类
 */
public class MyServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("MyServlet init ......");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("servletConfig .......");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service ......");
        PrintWriter writer = servletResponse.getWriter();
        writer.print("Hello MyServlet!");

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy .....");
    }
}
