package com.classdesign.web.action;

import com.classdesign.domain.User;
import com.classdesign.domain.Warning;
import com.classdesign.service.Impl.UserserviceImpl;
import com.classdesign.service.Userservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/UserservletRegist")
public class UserservletRegist extends HttpServlet {
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String password1=request.getParameter("password1");
        String phone_number=request.getParameter("phone_number");
        if(password.equals(password1)){
            User user=new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setPhone_number(phone_number);
            Userservice userservice=new UserserviceImpl();
            User user1=userservice.ifExitUser(user);
            User user2=userservice.ifExitphone_number(user);
            if(user1==null&&user2==null){
                if(userservice.creatNewUser(user)){
                    request.getSession().setAttribute("user",user);
                    response.sendRedirect("/view/login.jsp");
                }
            }else if(user1!=null){
                Warning username_warning=new Warning();
                username_warning.setMessage("该用户名已存在");
                request.setAttribute("username_warning",username_warning);
                request.getRequestDispatcher("/view/signup.jsp").forward(request,response);
            }else {
                Warning phone_number_warning=new Warning();
                phone_number_warning.setMessage("该手机号已经被注册!");
                request.setAttribute("phone_number_wrong",phone_number_warning);
                request.getRequestDispatcher("/view/signup.jsp").forward(request,response);
            }
        }else{
            Warning password_warning=new Warning();
            password_warning.setMessage("两次密码不一致，请重新输入");
            request.setAttribute("pwd_warning",password_warning);
            request.getRequestDispatcher("/view/signup.jsp").forward(request,response);
        }
    }

}
