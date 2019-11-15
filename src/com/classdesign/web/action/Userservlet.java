package com.classdesign.web.action;


import com.classdesign.domain.User;
import com.classdesign.service.Impl.UserserviceImpl;
import com.classdesign.service.Userservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/abc")
public class Userservlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        Userservice userservice = new UserserviceImpl();
        User exituser = userservice.login(user);
        if (exituser == null) {
            //密码错误 返回本页面
            request.setAttribute("wrong_warning", "用户名或密码错误！");
            request.getRequestDispatcher("/view/login.jsp").forward(request, response);
        } else {
            //信息正确，保存该用户并进行页面重定向
            request.getSession().setAttribute("exituser", exituser);
            response.sendRedirect("/view/homepage.jsp");
        }
    }
}