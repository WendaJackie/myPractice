package com.itheima.web;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    private BrandService service = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /**
         * 之前第一次的代码
         */
        /*//处理post请求的乱码问题
        request.setCharacterEncoding("utf-8");

        //1.接受表单提交的数据，封装为一个Brand对象
        String brandName = request.getParameter("brandName");
        String companyName = request.getParameter("companyName");
        String ordered = request.getParameter("ordered");
        String description = request.getParameter("description");
        String status = request.getParameter("status");

        //封装为一个Brand对象
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(Integer.parseInt(ordered));
        brand.setDescription(description);
        brand.setStatus(Integer.parseInt(status));

        //2.调用service，完成添加
        service.add(brand);

        //3.转发到查询所有Servlet
        request.getRequestDispatcher("/selectAllServlet").forward(request,response);*/

        /**
         * 第二部分json时的代码
         */
        //1.接收数据,request.getParameter 不能接收json的数据
        /*String brandName = request.getParameter("brandName");
        System.out.println(brandName);*/

        //获取请求体数据
        BufferedReader br = request.getReader();
        String params = br.readLine();

        //将JSON字符串转为JAVA对象
        Brand brand = JSON.parseObject(params, Brand.class);
        System.out.println(brand);

        //2.调用service 添加
        service.add(brand);

        //3.响应成功标识
        response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
