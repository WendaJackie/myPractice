package com.itheima.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    private BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /**
         * 以下第一部分是之前学的
         */
        /*//1.调用BrandService完成查询

        List<Brand> brands = service.selectAll();

        //2.存入request域中
        request.setAttribute("brands",brands);

        //3.转发到brand.jsp
        request.getRequestDispatcher("/brand.jsp").forward(request,response);*/



        /**
         * 以下第二部分是JSON部分的代码
         */
        //1.调用Service查询
        List<Brand> brands = service.selectAll();

        //2.将集合转换为JSON数据库   序列化
        //String jsonString = JSON.toJSONString(brands);
        String jsonString = JSON.toJSONString(brands, SerializerFeature.IgnoreNonFieldGetter);

        //3.响应数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
