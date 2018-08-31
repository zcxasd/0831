package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Session")
public class TestSession extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建会话
        /*
         * getSession():如果没有会话，创建会话；有会话，获取会话
         * getSession(false):有会话，获取会话；如果没有会话，不会创建会话
         *
         * */
        // 解决乱码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        HttpSession httpSession = request.getSession();
        String sessionid = httpSession.getId();

        PrintWriter printWriter = response.getWriter();
        if (httpSession.isNew()) {
            printWriter.print("新创建一个会话:");
        }
            //session失效时间测试(秒为单位) --默认失效时间为30分钟=1800秒
            int time = httpSession.getMaxInactiveInterval();
            printWriter.print("JSESSIONID"+sessionid);
            // 设置session失效时间为10秒
            //httpSession.setMaxInactiveInterval(10);
            // session立即失效
            //httpSession.invalidate();
            printWriter.print("session失效时间="+time);
            // session失效方式 1：过期时间 2：调用invalidate()方法；
    }
}
