package controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Servlet")
public class TestServlet extends HttpServlet {

    public TestServlet(){
        System.out.println("========构造方法==hello servlet========");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("========init==hello servlet========");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("====doPost====");
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("====doGet====");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        System.out.println("username="+username+ " password="+password+" phone="+phone);

        // 请求分派
        // 请求域
        //request.setAttribute("username","admin");
        //request.getRequestDispatcher("login.jsp").forward(request,response);
        // 重定向
        // 会话域
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("username","admin");

        // 统计HelloServlet次数
        // 全局域
        ServletContext application = this.getServletContext();
        Object count = application.getAttribute("count");
        if (count==null){// 第一次访问
            application.setAttribute("count",1);
        } else {
            int _count = (int) count;
            application.setAttribute("count",(++_count));
        }
        System.out.println("访问次数"+application.getAttribute("count"));

        response.sendRedirect("login.jsp");
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
