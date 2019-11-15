package com.classdesign.web.action;

import com.classdesign.domain.User;
import com.classdesign.domain.Warning;
import com.classdesign.service.Impl.UserserviceImpl;
import com.classdesign.service.Userservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/UserservletReset_pwd")
public class UserservletReset_pwd extends HttpServlet{
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        Userservice userservice=new UserserviceImpl();
        if(userservice.ifExitUser(user)!=null){
            if(userservice.reset_pwd(user)){
                request.getSession().setAttribute("user",user);
                response.sendRedirect("/view/coverpage.jsp");
            }else{
                Warning user_warning=new Warning();
                user_warning.setMessage("重置失败！");
                request.setAttribute("user_warning",user_warning);
                request.getRequestDispatcher("/view/resetpassword.jsp").forward(request,response);
            }
        }else{
            Warning user_warning=new Warning();
            user_warning.setMessage("该用户不存在，请先注册!");
            request.setAttribute("user_warning",user_warning);
            request.getRequestDispatcher("/view/resetpassword.jsp").forward(request,response);
        }


    }
}
