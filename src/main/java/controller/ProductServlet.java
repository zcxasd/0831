package controller;

import controller.pojo.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = new ArrayList<>();
        BigDecimal bigDecimal = new BigDecimal(10);
        productList.add(new Product(1,"phone",bigDecimal));
        productList.add(new Product(2,"oppo",bigDecimal));
        productList.add(new Product(3,"vivo",bigDecimal));

        request.setAttribute("productList",productList);

        request.getRequestDispatcher("product.jsp").forward(request,response);
    }
}
