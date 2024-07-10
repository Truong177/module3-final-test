package com.example.testfinal.controllers;

import com.example.testfinal.models.Product;
import com.example.testfinal.services.IProductService;
import com.example.testfinal.services.impl.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductController", value = "/product")
public class ProductController extends HttpServlet {
    private final IProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                req.getRequestDispatcher("/view/create.jsp").forward(req, resp);
                break;
            case "top-selling":
                    showTopSellingProducts(req, resp);
                    break;
            default:
                List<Product> products = productService.findAll();
                req.setAttribute("products", products);
                req.getRequestDispatcher("/view/list.jsp").forward(req, resp);
        }
    }

    private void showTopSellingProducts(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/top_selling.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(req, resp);
                break;
        }
    }

    private void createProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String name = req.getParameter("name");
        Long price = Long.valueOf(req.getParameter("price"));
        int discount = Integer.parseInt(req.getParameter("discount"));
        int stock = Integer.parseInt(req.getParameter("stock"));
        if (name != null && price != null && discount > 0 && stock > 0) {
            Product product = new Product(name, price, discount, stock);
            productService.save(product);
            resp.sendRedirect(req.getContextPath() + "/product");
        }else {
            req.setAttribute("message", "Thông tin không hợp lệ. Vui lòng điền đầy đủ các thông tin sản phẩm.");
            req.getRequestDispatcher("/view/create.jsp").forward(req, resp);
        }
    }
}
