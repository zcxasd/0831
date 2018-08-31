package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Cookie")
public class TestCookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("username","admin");
        // cookie会保存7天
        /*
        * >=1:cookie设置多久保存多久
        * =0:cookie立即删除
        * =-1:cookie保存浏览器内存中，浏览器关闭后删除
        * */
        cookie.setMaxAge(7*24*3600);
        response.addCookie(cookie);
        PrintWriter printWriter = response.getWriter();
        // 获取响应头的cookie信息
        Cookie[] cookies = request.getCookies();
        for (Cookie c:cookies){
            String cookie_name = c.getName();
            String cookie_value = c.getValue();
            printWriter.print("name="+cookie_name+" value="+cookie_value);
        }
    }
}
