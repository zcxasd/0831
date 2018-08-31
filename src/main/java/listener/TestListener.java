package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

//@WebListener()
/*
* ServletContextListener: 全局域 （ServletContextListener的创建和销毁）
* HttpSessionListener：会话域 （HttpSessionListener的创建和销毁）
* HttpSessionAttributeListener：会话域里边属性的创建，修改，销毁
* */
public class TestListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    // Public constructor is required by servlet spec
    public TestListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
      // 全局域一旦初始化就回调contextInitialized这个方法
      System.out.println("======TestLinstener=====contextInitialized=====");
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
      // 全局域一旦被销毁就回调这个方法contextDestroyed
        System.out.println("======TestLinstener=====contextDestroyed=====");
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
        // 当sessionCreated这个方法创建时就回调这个方法
        System.out.println("======TestLinstener=====sessionCreated=====");
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
        // 当Session失效就会回调sessionDestroyed这个方法（Session有两种失效方法：1-过期时间 2-调用invalidate()方法）
        System.out.println("======TestLinstener=====sessionDestroyed=====");
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
      // 往attributeAdded会话域添加属性时就会回调attributeAdded这个方法
        System.out.println("======TestLinstener=====attributeAdded=====");
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
      // 会话域移除回调这个方法attributeRemoved
        System.out.println("======TestLinstener=====attributeRemoved=====");
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
      // 修改会话域里的属性就会回调attributeReplaced
        System.out.println("======TestLinstener=====attributeReplaced=====");
    }
}
