package com.classdesign.web.action;


import com.classdesign.domain.User;
import com.classdesign.domain.Warning;
import com.classdesign.service.Impl.UserserviceImpl;
import com.classdesign.service.Userservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/abc")
public class Userservlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String methodname=request.getParameter("method");
        if(methodname.equals("login")){
            login(request,response);
        }else if(methodname.equals("signup")){
            signup(request,response);
        }else if(methodname.equals("reset")){
            resetpwd(request,response);
        }
    }

    /***
     * 处理用户登录
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    public void login(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
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
            response.sendRedirect("/homepage?method=findAll");
        }
    }

    /***
     * 处理忘记密码请求
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    public void resetpwd(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
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
    public void signup(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
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