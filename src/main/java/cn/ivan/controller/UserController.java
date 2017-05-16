package cn.ivan.controller;

import cn.ivan.annotation.LoginCheck;
import cn.ivan.model.base.TUser;
import cn.ivan.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: 仙人球
 * Date: 2017/5/12
 * Time: 13:24
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @LoginCheck(anonymity = true)
    @RequestMapping(value = "/toLoginPage",method = RequestMethod.GET)
    public String toLoginPage(){
        return "login";
    }

    @LoginCheck(anonymity = true)
    @RequestMapping(value = "/toRegisterPage",method = RequestMethod.GET)
    public String toRegisterPage(){
        return "register";
    }

    @LoginCheck(anonymity = true)
    @RequestMapping(value = "/getUserName",method = RequestMethod.GET)
    public void getUserName(String userName, PrintWriter out){
        int flag = userService.getUserName(userName);
        out.print(flag);
    }

    @LoginCheck(anonymity = true)
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(TUser user, HttpServletRequest request){
        int flag = userService.register(user);
        if(flag > 0) {
            request.setAttribute("message","注册成功！");
        }else {
            request.setAttribute("message","注册失败!");
        }
        return "login";
    }

    @LoginCheck(anonymity = true)
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(TUser user,HttpServletRequest request){
        TUser tUser = userService.getUser(user);
        if(tUser == null){
            request.setAttribute("message","用户名密码错误");
            return "login";
        }else {
            request.getSession().setAttribute("user",tUser);
            request.getSession().setAttribute("date",new SimpleDateFormat("YYYY-MM-DD HH:mm:ss").format(new Date()));
            return "redirect:/toWelPage";
        }
    }

    @RequestMapping(value = "/toWelPage")
    public String toWelPage(){
        return "wel";
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "redirect:/toLoginPage";
    }

    @RequestMapping("/userList")
    public String userList(String currentPage,HttpServletRequest request){
        PageInfo<TUser> page = userService.userList(currentPage);
        request.setAttribute("page",page);
        return "userList";
    }

}
